package transportDAO;
import interTransport.interEntrepriseDAO;
import interTransport.interLieuxDAO;
import interTransport.interTransportDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelTransport.Transport;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import erreur.TransportException;

public class transportDAO implements interTransportDAO {

	private JdbcTools jdbctool;
	private interLieuxDAO lDAO;
	private interEntrepriseDAO entDAO;
	public transportDAO(JdbcTools jdbctool,interEntrepriseDAO entDAO,interLieuxDAO lieuxDAO) {
		super();
		this.jdbctool = jdbctool;
		this.lDAO = lieuxDAO;
		this.entDAO = entDAO;
	}

	@Override
	public int sauvegarde(Transport transport) throws TransportException {
		DateFormat formatter = new SimpleDateFormat("yyyy/dd/MM");
		int lastId;
		try {
			lastId= Integer.parseInt(jdbctool.executeUpdate("insert into Transport(id_entreprise,depart,arrive,date_depart,date_arrivee,type_vehicule,id_Marchandises,id_NatureMarchandises,estimation_cout) values(?,?,?,?,?,?,?,?,?)",transport.getEnt().getId(),transport.getDepart().getId(),transport.getArrivee().getId(), formatter.format(new Date(transport.getDateDepart())),formatter.format(new Date(transport.getDateArrivee())),transport.getTypeVehicule(),transport.getMarch(),transport.getNat_March(),transport.getEstimationCout()));
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		return lastId;
	}

	@Override
	public ArrayList<Transport> toutTransport() throws TransportException {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Transport> transports = new ArrayList<Transport>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Transport");
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				Transport transport = new Transport();
				transport.setId(rst.getInt(1));
				transport.setEnt(entDAO.chercher(rst.getInt(2)));
				transport.setDepart(lDAO.chercher(rst.getInt(3)));
				transport.setArrivee(lDAO.chercher(rst.getInt(4)));
				transport.setDateDepart(formatter.format(rst.getDate(5)));
				transport.setDateArrivee(formatter.format(rst.getDate(6)));
				transport.setTypeVehicule(rst.getString(7));
				transport.setMarch(rst.getString(8));
				transport.setNat_March(rst.getString(9));
				transport.setEstimationCout(rst.getInt(10));
				transports.add(transport);
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
		

		return transports;
	}

	@Override
	public Transport chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Transport transport =null;
				Connection conn = null;
				PreparedStatement st  = null;	
				ResultSet rst =null;
				try {
					// 1. créer une connexion
					conn = jdbctool.newConnection();
					// 2. préparer l'instruction
					st = (PreparedStatement) conn.prepareStatement("select * from Transport where id_transport=?");
					st.setInt(1,id); 
					rst = st.executeQuery();
					// 4. lire le résultat
					while(rst.next()){
						transport = new Transport();
						transport.setId(rst.getInt(1));
						transport.setEnt(entDAO.chercher(rst.getInt(2)));
						transport.setDepart(lDAO.chercher(rst.getInt(3)));
						transport.setArrivee(lDAO.chercher(rst.getInt(4)));
						transport.setDateDepart(formatter.format(rst.getDate(5)));
						transport.setDateArrivee(formatter.format(rst.getDate(6)));
						transport.setTypeVehicule(rst.getString(7));
						transport.setMarch(rst.getString(8));
						transport.setNat_March(rst.getString(9));
						transport.setEstimationCout(rst.getInt(10));
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
				

				return transport;
	}

	@Override
	public void miseAjour(Transport transport) throws TransportException {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("yyyy/dd/MM");
		try {
			 Integer.parseInt(jdbctool.executeUpdate("update Transport set id_entreprise=?,depart=?,arrive=?,date_depart=?,date_arrivee=?,type_vehicule=?,id_Marchandises=?,id_NatureMarchandises=?,estimation_cout=?,where id_transport=?",transport.getEnt().getId(),transport.getDepart().getId(),transport.getArrivee().getId(), formatter.format(new Date(transport.getDateDepart())),formatter.format(new Date(transport.getDateArrivee())),transport.getTypeVehicule(),transport.getMarch(),transport.getNat_March(),transport.getEstimationCout(),transport.getId()));
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}

	@Override
	public void supprimer(int id) throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					jdbctool.executeUpdate("delete from Transport where id_transport=?",id);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					throw new TransportException(ex.getErrorCode(),ex.getMessage());
				}
	}
	
}
