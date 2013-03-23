package transportDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelTransport.Parcours;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import erreur.TransportException;

public class parcoursDAO {

	private JdbcTools jdbctool;
	private lieuxDAO lDAO;
	public parcoursDAO(){

	}
	public parcoursDAO(JdbcTools jdbctool,lieuxDAO lDAO){
		this.jdbctool=jdbctool;
		this.lDAO=lDAO;
	}
	public void sauvegarde(int idTrajet,int idDepart,int idArrive) throws TransportException{
		try {
			jdbctool.executeUpdate("insert into Parcours(id_trajet,depart,arrive) values(?,?,?)",idTrajet,idDepart,idArrive);
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
	
	public ArrayList<Parcours> chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		ArrayList<Parcours> parcours=new ArrayList<Parcours>();
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
				 parcours.add(new Parcours(lDAO.chercher(rst.getInt(2)),lDAO.chercher(rst.getInt(3))));
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
		return parcours;
	}

	

}
