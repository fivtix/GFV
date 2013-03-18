package transportDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelTransport.Adresse;
import modelTransport.Arrete;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import erreur.TransportException;

public class parcoursDAO {

	private JdbcTools jdbctool;
	private arreteDAO aDAO;
	public parcoursDAO(){

	}
	public parcoursDAO(JdbcTools jdbctool,arreteDAO aDAO){
		this.jdbctool=jdbctool;
		this.aDAO=aDAO;
	}
	public void sauvegarde(int idTrajet,int idArrete) throws TransportException{
		try {
			jdbctool.executeUpdate("insert into Parcours(id_trajet,id_arrete) values(?,?)",idTrajet,idArrete);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}
	public void supprimer(int idTrajet) throws TransportException{
		// TODO Auto-generated method stub
				try {
					jdbctool.executeUpdate("delete from Parcours where id_trajet=?",idTrajet);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					throw new TransportException(ex.getErrorCode(),ex.getMessage());
				}
	}
	
	public ArrayList<Arrete> chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		ArrayList<Arrete> arretes=new ArrayList<Arrete>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from Parcours where id_trajet=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				arretes.add(aDAO.chercher(rst.getInt(2)));
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
		return arretes;
	}

	

}
