package transportDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelTransport.Adresse;
import modelTransport.Arrete;
import modelTransport.Role;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import erreur.TransportException;

public class roleUsersDAO {

	private JdbcTools jdbctool;
	private roleDAO rDAO;
	public roleUsersDAO(){

	}
	public roleUsersDAO(JdbcTools jdbctool,roleDAO rDAO){
		this.jdbctool=jdbctool;
		this.rDAO=rDAO;
	}
	public void sauvegarde(String idUser,String idRole) throws TransportException{
		try {
			jdbctool.executeUpdate("insert into Roles_Users(id_user,id_role) values(?,?)",idUser,idRole);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}
	public void supprimer(String idUser) throws TransportException{
		// TODO Auto-generated method stub
				try {
					jdbctool.executeUpdate("delete from Roles_Users where id_user=?",idUser);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					throw new TransportException(ex.getErrorCode(),ex.getMessage());
				}
	}
	public ArrayList<Role> chercher(String id) throws TransportException {
		// TODO Auto-generated method stub
		ArrayList<Role> roles=new ArrayList<Role>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from Roles_Users where id_user=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1,id);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				roles.add(rDAO.chercher(rst.getInt(2)));
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
		return roles;
	}

	

}
