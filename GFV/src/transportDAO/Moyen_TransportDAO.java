package transportDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import modelTransport.Moyen_Transport;

import interTransport.interMoyen_transportDAO;
import erreur.TransportException;

public class Moyen_TransportDAO implements interMoyen_transportDAO{

	private JdbcTools jdbctool;
	//private Moyen_TransportDAO moyen_transportDAO;
	private InfosPersonnellesDAO info_persoDAO;
	private VehiculeDAO vehiculeDAO;
	
	public Moyen_TransportDAO(){

	}
	public Moyen_TransportDAO(Moyen_TransportDAO moyen_transportDAO,InfosPersonnellesDAO info_persoDAO,VehiculeDAO vehiculeDAO,String pilote, String url, String utilisateur, String motdepass) throws TransportException{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
			jdbctool.init();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
		//this.moyen_transportDAO = moyen_transportDAO;
		this.info_persoDAO= info_persoDAO;
		this.vehiculeDAO= vehiculeDAO;
	}


	public JdbcTools getJdbctool() {
		return jdbctool;
	}
	public void setJdbctool(JdbcTools jdbctool) {
		this.jdbctool = jdbctool;
	}

	public InfosPersonnellesDAO getmoyen_transportDAO() {
		return info_persoDAO;
	}
	public void setmoyen_transportDAO(InfosPersonnellesDAO info_persoDAO) {
		this.info_persoDAO = info_persoDAO;
	}
	public VehiculeDAO getVehiculeDAO() {
		return vehiculeDAO;
	}
	public void setVehiculeDAO(VehiculeDAO vehiculeDAO) {
		this.vehiculeDAO = vehiculeDAO;
	}
	
	@Override
	public void supprimer(Moyen_Transport moyen_transport) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Moyen_Transport where id_moyen_transport=?",moyen_transport.getId_Moyen_Transport());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		
	}


	@Override
	public void sauvegarde(Moyen_Transport moyen_transport) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("insert into Moyen_Transport(id_moyen_transport,id_personnel,id_vehicule) values(?,?,?)",moyen_transport.getId_Moyen_Transport(),moyen_transport.getId_personnel(),moyen_transport.getId_vehicule());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}


	@Override
	public void miseAjour(Moyen_Transport moyen_transport) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("update Moyen_Transport set id_personnel=?,id_vehicule=? where id_moyen_transport= ?",moyen_transport.getId_personnel(),moyen_transport.getId_vehicule(),moyen_transport.getId_Moyen_Transport());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		
	}

	public Moyen_Transport  chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		Moyen_Transport moyen_transport  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from  Moyen_Transport where id_moyen_transport=?";
		try {
			// 1. cr�er une connexion
			conn = jdbctool.newConnection();
			// 2. pr�parer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le r�sultat
			while(rst.next()){
				moyen_transport = new Moyen_Transport();
				moyen_transport.setId_Moyen_Transport(rst.getInt(1));
				moyen_transport.setId_personnel(rst.getInt(2));
				moyen_transport.setId_vehicule(rst.getInt(3));
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
		return moyen_transport;
		
	}


	@Override
	public Collection<Moyen_Transport> toutMoyen_Transport()
			throws TransportException {
		// TODO Auto-generated method stub
		ArrayList<Moyen_Transport> moyens = new ArrayList<Moyen_Transport>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. cr�er une connexion
			conn = jdbctool.newConnection();
			// 2. pr�parer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Moyen_Transport");
			rst = st.executeQuery();
			// 4. lire le r�sultat
			while(rst.next()){
				Moyen_Transport moyen_transport = new Moyen_Transport();
				moyen_transport.setId_Moyen_Transport(rst.getInt(1));
				moyen_transport.setId_personnel(rst.getInt(2));
				moyen_transport.setId_vehicule(rst.getInt(3));
		
				moyens.add(moyen_transport);
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
		return moyens;
		
		
	}
	
	
	

	

}
