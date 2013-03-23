package transportDAO;

import interTransport.interTrajetDAO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import modelTransport.Parcours;
import modelTransport.Trajet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import erreur.TransportException;


public class trajetDAO implements interTrajetDAO  {

	private JdbcTools jdbctool;
	private parcoursDAO pDAO;
	public trajetDAO(){

	}
	public trajetDAO( JdbcTools jdbctool, parcoursDAO pDAO){
		this.jdbctool=jdbctool;
		this.pDAO=pDAO;
	}

	@Override
	public void supprimer(int id) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Trajet where id_trajet=?",id);
			pDAO.supprimer(id);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}

	@Override
	public int sauvegarde(Trajet t) throws TransportException {
		// TODO Auto-generated method stub
		int lastId;
		File file =null;
		try {
			BufferedImage bimage=t.getCarte();
			file = new File("temp.png");
			try {
				ImageIO.write(bimage,"png",file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lastId=Integer.parseInt(jdbctool.executeUpdate("insert into Trajet(nom,distance,carte) values(?,?,?)",t.getNom(),t.getDistance(),file));
			ArrayList<Parcours> parcours=t.getParcours();
			int size= parcours.size();
			for(int i=0;i<size;i++){
				pDAO.sauvegarde(lastId, parcours.get(i).getDepart().getId(), parcours.get(i).getArrive().getId());
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
			
		}
		if(file!=null)
			file.delete();
		return lastId;
		
	}

	@Override
	public void miseAjour(Trajet t) throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		File file =null;
		try {
			BufferedImage bimage=t.getCarte();
			file = new File("temp.jpg");
			ImageIO.write(bimage,"jpg",file);
			jdbctool.executeUpdate("update Trajet set nom=?,distance=?,carte=? where id_trajet=?",t.getNom(),t.getDistance(),file,t.getId());
			pDAO.supprimer(t.getId());
			ArrayList<Parcours> parcours=t.getParcours();
			int size=parcours.size();
			for(int i=0;i<size;i++){
				pDAO.sauvegarde(t.getId(),parcours.get(i).getDepart().getId(),parcours.get(i).getArrive().getId());
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
		if(file!=null)
			file.delete();
	}

	@Override
	public Trajet chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		Trajet t  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from Trajet where id_trajet=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				t  = new Trajet();
				t.setId(rst.getInt(1));
				t.setNom(rst.getString(2));
				t.setDistance(rst.getDouble(3));
				InputStream carte = rst.getBinaryStream(4);
				BufferedImage imag=ImageIO.read(carte);
				t.setCarte(imag);
				t.setParcours(pDAO.chercher(t.getId()));
			}
			
		} catch (SQLException | IOException e) {
			throw new TransportException(e.getMessage());
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
		return t;
	}
	@Override
	public Collection<Trajet> toutTrajet() throws TransportException {
		// TODO Auto-generated method stub
				ArrayList<Trajet> trajets  = new ArrayList<Trajet>();
				Connection conn = null;
				PreparedStatement st  = null;	
				ResultSet rst =null;
				String sql="select * from Trajet";
				try {
					// 1. créer une connexion
					conn = jdbctool.newConnection();
					// 2. préparer l'instruction
					st = (PreparedStatement) conn.prepareStatement(sql);
					rst = st.executeQuery();
					// 4. lire le résultat
					while(rst.next()){
						Trajet t  = new Trajet();
						t.setId(rst.getInt(1));
						t.setNom(rst.getString(2));
						t.setDistance(rst.getDouble(3));
						InputStream carte = rst.getBinaryStream(4);
						BufferedImage imag=ImageIO.read(carte);
						t.setCarte(imag );
						t.setParcours(pDAO.chercher(t.getId()));
						trajets.add(t);
					}
					
				} catch (SQLException | IOException e) {
					throw new TransportException(e.getMessage());
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
				return trajets;
	}

}
