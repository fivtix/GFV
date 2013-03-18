package transportDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import modelTransport.Adresse;
import modelTransport.Itineraire;
import erreur.TransportException;
import interTransport.interItineraireDAO;

public class itineraireDAO implements interItineraireDAO{
	private JdbcTools jdbctool;
	private adresseDAO adrDAO;
	public itineraireDAO(JdbcTools jdbctool,adresseDAO adrDAO){
		this.jdbctool=jdbctool;
		this.adrDAO=adrDAO;
	}
	public itineraireDAO(){

	}

	public JdbcTools getJdbctool() {
		return jdbctool;
	}
	public void setJdbctool(JdbcTools jdbctool) {
		this.jdbctool = jdbctool;
	}
	public adresseDAO getAdrADO() {
		return adrDAO;
	}
	public void setAdrADO(adresseDAO adrADO) {
		this.adrDAO = adrADO;
	}

	@Override
	public void sauvegarde(Itineraire i, int idarrete)	throws TransportException {

		try {
			int idDepart,idArrive;
			idDepart=adrDAO.sauvegarde(i.getDepart());
			idArrive=adrDAO.sauvegarde(i.getArrive());
			jdbctool.executeUpdate("insert into Itineraires(id_arrete,depart,arrive,distance,intro) values(?,?,?,?,?)",idarrete,idDepart,idArrive,i.getDistance(),i.getIntro());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}

	public void supprimer(Itineraire i,int idArrete) throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Itineraires where id_arrete=? and depart=?",idArrete,i.getDepart().getId());
			adrDAO.supprimer(i.getDepart());
			adrDAO.supprimer(i.getArrive());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}
	public void supprimer(int idArrete) throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			ArrayList<Itineraire> itineraires=chercher(idArrete);
			jdbctool.executeUpdate("delete from Itineraires where id_arrete=?",idArrete);
			int size=itineraires.size();
			for(int i=0;i<size;i++){
				adrDAO.supprimer(itineraires.get(i).getDepart());
				adrDAO.supprimer(itineraires.get(i).getArrive());
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}
	@Override
	public ArrayList<Itineraire> chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<Itineraire> itineraires=new  ArrayList<Itineraire>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from Itineraires where id_arrete=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				Itineraire iti=new Itineraire();
				iti.setDepart(adrDAO.chercher(rst.getInt(2)));
				iti.setArrive(adrDAO.chercher(rst.getInt(3)));
				iti.setDistance(rst.getInt(4));
				iti.setIntro(rst.getString(5));
				itineraires.add(iti);
			}

		} catch (SQLException e) {
			throw new TransportException(e.getErrorCode(),e.getMessage());
			// 5. construire l'exception DAO
			// 6. renvoyer cette exception
		} finally {
			// fermer PreparedStatement 
			if(rst!=null)
				try {
					rst.close();
					// 7. fermer la connexion
					jdbctool.quietClose(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getErrorCode(),e.getMessage());
				}
		}
		return itineraires;
	}


}
