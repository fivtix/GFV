package transportDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import modelTransport.Adresse;
import modelTransport.Arrete;
import modelTransport.Itineraire;
import erreur.TransportException;
import interTransport.interArreteDAO;

public class arreteDAO implements interArreteDAO{

	
	private lieuxDAO lDAO;
	private itineraireDAO iDAO;
	private JdbcTools jdbctool;
	public arreteDAO(){
		
	}
	public arreteDAO(JdbcTools jdbctool,lieuxDAO lDAO,itineraireDAO iDAO){
		this.jdbctool=jdbctool;
		this.lDAO=lDAO;
		this.iDAO=iDAO;
	}
	@Override
	public void supprimer(Arrete a) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Arretes where id_arrete=?",a.getId());
			iDAO.supprimer(a.getId());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}
	@Override
	public int sauvegarde(Arrete a) throws TransportException {
		int lastId;
		try {
			int idDepart,idArrive;
			File file=new File(a.getCarte());
			if(a.getDepart().getId()==0)
			idDepart=lDAO.sauvegarde(a.getDepart());
			else
				idDepart=a.getDepart().getId();
			if(a.getArrive().getId()==0)
			idArrive=lDAO.sauvegarde(a.getArrive());
			else
				idArrive=a.getArrive().getId();
			lastId=(int) jdbctool.executeUpdate("insert into Arretes(depart,arrive,distance,carte) values(?,?,?,?)",idDepart,idArrive,a.getDistance(),file);
		    ArrayList<Itineraire> itineraires=a.getItineraire();
		    int size=itineraires.size();
		    for(int i=0;i<size;i++)
		    	iDAO.sauvegarde(itineraires.get(i),lastId);
		    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		return lastId;
	}
	@Override
	public void miseAjour(Arrete a) throws TransportException {
		// TODO Auto-generated method stub
		try {
			lDAO.miseAjour(a.getDepart());
			lDAO.miseAjour(a.getArrive());
			jdbctool.executeUpdate("update Arretes set depart=?,arrive=?,distance=?,carte=? where id_arrete=?",a.getDepart().getId(),a.getArrive().getId(),a.getDistance(),new File(a.getCarte()),a.getId());
			  ArrayList<Itineraire> itineraires=a.getItineraire();
			    int size=itineraires.size();
			    if(size>0)
			    iDAO.supprimer(a.getId());
			    for(int i=0;i<size;i++)
			    	iDAO.sauvegarde(itineraires.get(i),a.getId());	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}
	@Override
	public Arrete chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
        Arrete a  = null;
 		Connection conn = null;
 		PreparedStatement st  = null;	
 		ResultSet rst =null;
 		String sql="select * from Arretes where id_arrete=?";
 		try {
 			// 1. créer une connexion
 			conn = jdbctool.newConnection();
 			// 2. préparer l'instruction
 			st = (PreparedStatement) conn.prepareStatement(sql);
 			st.setInt(1,id);
 			rst = st.executeQuery();
 			// 4. lire le résultat
 			while(rst.next()){
 				a = new Arrete();
 				a.setId(rst.getInt(1));
 				a.setDepart(lDAO.chercher(rst.getInt(2)));
 				a.setArrive(lDAO.chercher(rst.getInt(3)));
 				a.setDistance(rst.getInt(4));
 				InputStream carte = rst.getBinaryStream(6);
 				File image = new File(a.getId()+".carte.png");
                try {
					FileOutputStream fos = new FileOutputStream(image);
					byte[] buffer = new byte[256];
					 try {
						while (carte.read(buffer) > 0) {
						        fos.write(buffer);
						    }
						  fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						throw new TransportException(e.getMessage());
					}
		              
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getMessage());
				}
                a.setCarte(image.getName());
               				
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
 	
		return a;
	}
	@Override
	public ArrayList<Arrete> toutArrete() throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
       ArrayList<Arrete> arretes  = new ArrayList<Arrete>() ;
 		Connection conn = null;
 		PreparedStatement st  = null;	
 		ResultSet rst =null;
 		String sql="select * from Arretes";
 		try {
 			// 1. créer une connexion
 			conn = jdbctool.newConnection();
 			// 2. préparer l'instruction
 			st = (PreparedStatement) conn.prepareStatement(sql);
 			rst = st.executeQuery();
 			// 4. lire le résultat
 			while(rst.next()){
 				Arrete a = new Arrete();
 				a.setId(rst.getInt(1));
 				a.setDepart(lDAO.chercher(rst.getInt(2)));
 				a.setArrive(lDAO.chercher(rst.getInt(3)));
 				a.setDistance(rst.getInt(4));
 				InputStream carte = rst.getBinaryStream(6);
 				File image = new File(a.getId()+".cart.png");
                try {
					FileOutputStream fos = new FileOutputStream(image);
					byte[] buffer = new byte[256];
					 try {
						while (carte.read(buffer) > 0) {
						        fos.write(buffer);
						    }
						  fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						throw new TransportException(e.getMessage());
					}
		              
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getMessage());
				}
                a.setCarte(image.getName());
                arretes.add(a);			
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
	
	public itineraireDAO getiDAO() {
		return iDAO;
	}
	public void setiDAO(itineraireDAO iDAO) {
		this.iDAO = iDAO;
	}
	public lieuxDAO getlDAO() {
		return lDAO;
	}
	public void setlDAO(lieuxDAO lDAO) {
		this.lDAO = lDAO;
	}
	public JdbcTools getJdbctool() {
		return jdbctool;
	}
	public void setJdbctool(JdbcTools jdbctool) {
		this.jdbctool = jdbctool;
	}
	

}
