package transportDAO;

import interTransport.interTrajetDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Adresse;
import modelTransport.Arrete;
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
		try {
			lastId=(int) jdbctool.executeUpdate("insert into Trajet(nom) values(?)",t.getNom());
			ArrayList<Arrete> arretes=t.getArretes();
			int size=arretes.size();
			for(int i=0;i<size;i++){
				pDAO.sauvegarde(lastId,arretes.get(i).getId());
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		return lastId;
		
	}

	@Override
	public void miseAjour(Trajet t) throws TransportException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("update Trajet set nom=? where id_trajet=?",t.getNom(),t.getId());
			pDAO.supprimer(t.getId());
			ArrayList<Arrete> arretes=t.getArretes();
			int size=arretes.size();
			for(int i=0;i<size;i++)
				pDAO.sauvegarde(t.getId(),arretes.get(i).getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
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
				t.setArretes(pDAO.chercher(t.getId()));
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
						t.setArretes(pDAO.chercher(t.getId()));
						trajets.add(t);
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
				return trajets;
	}

}
