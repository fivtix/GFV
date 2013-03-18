package transportDAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import modelTransport.Adresse;
import modelTransport.Role;
import modelTransport.User;
import erreur.TransportException;
import interTransport.interInfos_Personnelles;
import interTransport.interUserDAO;

public class userDAO implements interUserDAO  {

	private JdbcTools jdbctool;
	private interInfos_Personnelles pDAO;
	private roleUsersDAO roleuserDAO;
	@Override
	public void supprimer(String idUser) throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Users where id_user=?",idUser);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}
	@Override
	public String sauvegarde(User user) throws TransportException {
		String  lastId;
		try {
			int idPersonnel=0;
			if(user.getInfop().getId()==0)
				idPersonnel=pDAO.sauvegarde(user.getInfop());
			else
				idPersonnel=user.getInfop().getId();
			lastId=(String) jdbctool.executeUpdate("insert into Users(id_user,motdepass,id_Personnel) values(?,?,?)",user.getId_users(),user.getMotdepass(),idPersonnel);
			ArrayList<Role> roles = user.getRoles();
			for(int i=0;i<roles.size();i++)
				roleuserDAO.sauvegarde(lastId,roles.get(i).getRole());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		return lastId;
	}
	@Override
	public void miseAjourRole(User user) throws TransportException {
		// TODO Auto-generated method stub
		roleuserDAO.supprimer(user.getId_users());
		ArrayList<Role> roles = user.getRoles();
		for(int i=0;i<roles.size();i++)
			roleuserDAO.sauvegarde(user.getId_users(),roles.get(i).getRole());

	}
	@Override
	public User chercher(String idUser) throws TransportException {
		// TODO Auto-generated method stub
		User user  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from Users where id_user=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1,idUser);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				user=new User(rst.getString(1),rst.getString(2),pDAO.chercher(rst.getInt(3)));
				user.setRoles(roleuserDAO.chercher(user.getId_users()));
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
		return user;
	}
	@Override
	public Collection<User> toutUser() throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ArrayList<User> users  = new ArrayList<User>();
				Connection conn = null;
				PreparedStatement st  = null;	
				ResultSet rst =null;
				String sql="select * from Users";
				try {
					// 1. créer une connexion
					conn = jdbctool.newConnection();
					// 2. préparer l'instruction
					st = (PreparedStatement) conn.prepareStatement(sql);
					rst = st.executeQuery();
					// 4. lire le résultat
					while(rst.next()){
						User user=new User(rst.getString(1),rst.getString(2),pDAO.chercher(rst.getInt(3)));
						user.setRoles(roleuserDAO.chercher(user.getId_users()));
						users.add(user);
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
				
		return users;
	}






}
