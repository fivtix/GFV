package transportDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Ligne_Transport;
import erreur.TransportException;
import interTransport.interLigne_TransportDAO;

public class Ligne_TransportDAO implements interLigne_TransportDAO {
	
	private JdbcTools jdbctool;
	private transportDAO transportDAO;
	private Gestion_TransportsDAO gestion_transportDAO;
	private arreteDAO arreteDAO;
	
	public Ligne_TransportDAO(){

	}
	public Ligne_TransportDAO(transportDAO transportDAO,Gestion_TransportsDAO gestion_transportDAO,arreteDAO arreteDAO,String pilote, String url, String utilisateur, String motdepass) throws TransportException{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
			jdbctool.init();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
		this.transportDAO = transportDAO;
		this.gestion_TransportsDAO= gestion_TransporsDAO;
		this.arreteDAO= arreteDAO;
	}


	public JdbcTools getJdbctool() {
		return jdbctool;
	}
	public void setJdbctool(JdbcTools jdbctool) {
		this.jdbctool = jdbctool;
	}
	public transportDAO getTransportDAO() {
		return transportDAO;
	}
	public void setTransportDAO(transportDAO transportDAO) {
		this.transportDAO = transportDAO;
	}
	public Gestion_TransportsDAO getGestion_transportDAO() {
		return gestion_transportDAO;
	}
	public void setGestion_transportDAO(Gestion_TransportsDAO gestion_transportDAO) {
		this.gestion_transportDAO = gestion_transportDAO;
	}
	public arreteDAO getArreteDAO() {
		return arreteDAO;
	}
	public void setArreteDAO(arreteDAO arreteDAO) {
		this.arreteDAO = arreteDAO;
	}
	
	
	
	
	@Override
	public void supprimer(Ligne_Transport Ligne_transport) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Ligne_Transport where id_transport=? and id_gestion_transports=? and id_arrete=?",Ligne_transport.getId_transport(),Ligne_transport.getId_gestion_transports(),Ligne_transport.getId_arrete());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		
	}

	@Override
	public void sauvegarde(Ligne_Transport Ligne_transport) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("insert into Ligne_Transport(id_transport,id_gestion_transports,id_arrete) values(?,?,?)",Ligne_transport.getId_transport(),Ligne_transport.getId_gestion_transports(),Ligne_transport.getId_arrete());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}

/*
	@Override
	public void miseAjour(Ligne_Transport Ligne_transport) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("update Ligne_Transport set id_transport=?, id_gestion_transports=?,id_arrete=? where id_transport=? and id_gestion_transports=? and id_arrete=?",Ligne_transport.getId_transport(),Ligne_transport.getId_personnel(),Ligne_transport.getId_vehicule());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		
	}*/

	public Ligne_Transport  chercher(int id_transport,int id_gestion_transports, int id_arrete) throws TransportException {
		// TODO Auto-generated method stub
		Ligne_Transport Ligne_transport  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from  Ligne_Transport where id_transport=? and id_gestion_transports=? and id_arrete=?";
		try {
			// 1. creer une connexion
			conn = jdbctool.newConnection();
			// 2. preparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql,id_transport,id_gestion_transports,id_arrete);
			//st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le resultat
			while(rst.next()){
				Ligne_transport = new Ligne_Transport();
				Ligne_transport.setId_transport(rst.getInt(1));
				Ligne_transport.setId_gestion_transports(rst.getInt(2));
				Ligne_transport.setId_arrete(rst.getInt(3));
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
		return Ligne_transport;
		
	}


	@Override
	public Collection<Ligne_Transport> toutLigne_Transport()
			throws TransportException {
		// TODO Auto-generated method stub
		ArrayList<Ligne_Transport> Lignes = new ArrayList<Ligne_Transport>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. cr�er une connexion
			conn = jdbctool.newConnection();
			// 2. pr�parer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Ligne_Transport");
			rst = st.executeQuery();
			// 4. lire le r�sultat
			while(rst.next()){
				Ligne_Transport Ligne_transport = new Ligne_Transport();
				Ligne_transport.setId_transport(rst.getInt(1));
				Ligne_transport.setId_gestion_transports(rst.getInt(2));
				Ligne_transport.setId_arrete(rst.getInt(3));
		
				Lignes.add(Ligne_transport);
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
		return Lignes;
		
		
	}


	

}

