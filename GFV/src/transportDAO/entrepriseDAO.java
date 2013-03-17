package transportDAO;
import interTransport.interAdresseDAO;
import interTransport.interEntrepriseDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelTransport.Entreprise;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import erreur.TransportException;

public class entrepriseDAO implements interEntrepriseDAO {

	private JdbcTools jdbctool;
	private interAdresseDAO adrDAO;
	public entrepriseDAO(){

	}

	public entrepriseDAO(JdbcTools jdbctool,interAdresseDAO adrDAO){
		this.jdbctool=jdbctool;
		this.adrDAO=adrDAO;
	}


	public entrepriseDAO(adresseDAO adrDAO, String pilote, String url, String utilisateur, String motdepass) throws TransportException{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
			jdbctool.init();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
		this.adrDAO=adrDAO;
	}



	public JdbcTools getJdbctool() {
		return jdbctool;
	}

	public void setJdbctool(JdbcTools jdbctool) {

		this.jdbctool = jdbctool;
	}

	public interAdresseDAO getAdrDAO() {
		return adrDAO;
	}

	public void setAdrDAO(interAdresseDAO adrDAO) {
		this.adrDAO = adrDAO;
	}

	public void supprimer(Entreprise ent) throws TransportException {
		// TODO Auto-generated method stub

		try {
			jdbctool.executeUpdate("delete from Entreprise where id_entreprise=?",ent.getId());
			adrDAO.supprimer(ent.getAdresse());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
	}

	@Override
	public int sauvegarde(Entreprise e) throws TransportException {
		int lastId;
		try {
			int idAdr=adrDAO.sauvegarde(e.getAdresse());
			lastId=jdbctool.executeUpdate("insert into Entreprise(id_adresse,nom) values(?,?)", idAdr,e.getNom());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
		return lastId;
	}

	@Override
	public void miseAjour(Entreprise e) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("update Entreprise set id_adresse=?,nom=? where id_entreprise=?",e.getAdresse().getId(),e.getNom(),e.getId());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
	}

	public Entreprise chercher(int id) throws TransportException {
		Entreprise ent  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from Entreprise where id_entreprise=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				ent = new Entreprise();
				ent.setId(rst.getInt(1));
				ent.setAdresse(adrDAO.chercher(rst.getInt(2)));
				ent.setNom(rst.getString(3));

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
		return ent;
	}

	@Override
	public Collection<Entreprise> toutEntreprise() throws TransportException {
		ArrayList<Entreprise> entreprises = new ArrayList<Entreprise>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Entreprise");
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				Entreprise ent = new Entreprise();
				ent.setId(rst.getInt(1));
				ent.setAdresse(adrDAO.chercher(rst.getInt(2)));
				ent.setNom(rst.getString(3));
				entreprises.add(ent);
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
		return entreprises;

	}

}
