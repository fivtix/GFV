package transportDAO;
import interTransport.interUserDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Entreprise;
import modelTransport.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import erreur.TransportException;

public class UserDAO implements interUserDAO {

	private JdbcTools jdbctool;
	private InfosPersonnellesDAO infop;

	
	
	public UserDAO(){

	}

	public UserDAO( String pilote, String url, String utilisateur, String motdepass, InfosPersonnellesDAO infop) throws TransportException{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
			jdbctool.init();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
		this.infop=infop;
	}



	public JdbcTools getJdbctool() {
		return jdbctool;
	}

	public void setJdbctool(JdbcTools jdbctool) {
		this.jdbctool = jdbctool;
	}


	public InfosPersonnellesDAO getInfop() {
		return infop;
	}

	public void setInfop(InfosPersonnellesDAO infop) {
		this.infop = infop;
	}


	public void supprimer(User u) throws TransportException {
		// TODO Auto-generated method stub
		
		try {
			jdbctool.executeUpdate("delete from User where id_User=?",u.getId_User());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}



	}

	@Override
	public void sauvegarde(User u) throws TransportException {
		try {
			jdbctool.executeUpdate("insert into User(id_User,InfosPersonnelles,date,tel,mail) values(?,?,?,?,?)",u.getId_User(),u.getInfop().getId(),u.getNom(),u.getPrenom(),u.getDate(),u.getTel(),u.getMail());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}

	@Override
	public void miseAjour(User u) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("update User set InfosPersonnelles_id_Personnel=?, date=?,tel=?,mail=? where id_User=?",u.getInfop().getId(),u.getDate(),u.getTel(),u.getMail(),u.getId_User());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}

	public User chercher(String id) throws TransportException {
		User u  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from User where id_User=?";
		try {
			// 1. cr�er une connexion
			conn = jdbctool.newConnection();
			// 2. pr�parer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1,id);
			rst = st.executeQuery();
			// 4. lire le r�sultat
			while(rst.next()){
				u = new User();
				u.setId_User(rst.getString(1));
				u.setInfop(infop.chercher(rst.getString(2)));
				u.setDate(rst.getDate(3));
				u.setTel(rst.getString(4));
				u.setMail(rst.getString(5));
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
		return u;
	}

	@Override
	public Collection<User> toutUser() throws TransportException {
		ArrayList<User> users = new ArrayList<User>();
		User u = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. cr�er une connexion
			conn = jdbctool.newConnection();
			// 2. pr�parer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Entreprise");
			rst = st.executeQuery();
			// 4. lire le r�sultat
			while(rst.next()){
				u = new User();
				u.setId_User(rst.getString(1));
				u.setInfop(infop.chercher(rst.getString(2)));
				u.setDate(rst.getDate(3));
				u.setTel(rst.getString(4));
				u.setMail(rst.getString(5));
				users.add(u);
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
