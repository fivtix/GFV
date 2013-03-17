package transportDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import modelTransport.Infos_Personnelles;
import interTransport.interAdresseDAO;
import interTransport.interEntrepriseDAO;
import interTransport.interInfos_Personnelles;
import erreur.TransportException;

public class InfosPersonnellesDAO implements interInfos_Personnelles {

	private JdbcTools jdbctool;
	private interAdresseDAO adrDAO;
	private interEntrepriseDAO entDAO;
	public InfosPersonnellesDAO(){

	}
	public InfosPersonnellesDAO(JdbcTools jdbctool, interEntrepriseDAO entDAO ,interAdresseDAO adrDAO){
		this.jdbctool=jdbctool;
		this.adrDAO=adrDAO;
		this.entDAO=entDAO;
	}
	public InfosPersonnellesDAO(entrepriseDAO entDAO,adresseDAO adrDAO,String pilote, String url, String utilisateur, String motdepass) throws TransportException{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
			jdbctool.init();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
		this.entDAO=entDAO;
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
	public interEntrepriseDAO getEntDAO() {
		return entDAO;
	}
	public void setEntDAO(interEntrepriseDAO entDAO) {
		this.entDAO = entDAO;
	}
	public void supprimer(Infos_Personnelles p) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Infos_Personnelles where id_personnel=?",p.getId());
			adrDAO.supprimer(p.getAdresse());
			if(p.getEntreprise()!=null)
				entDAO.supprimer(p.getEntreprise());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}

	}

	@Override
	public int sauvegarde(Infos_Personnelles infop) throws TransportException {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("yyyy/dd/MM");
		int lastId;
		try {
			int idAdr=adrDAO.sauvegarde(infop.getAdresse());
			int idEnt = 0;
			if(infop.getEntreprise()!=null)
				if(infop.getEntreprise().getId()==0)
					idEnt=entDAO.sauvegarde(infop.getEntreprise());
				else
					idEnt=infop.getEntreprise().getId();
			lastId=jdbctool.executeUpdate("insert into Infos_Personnelles(id_entreprise,id_adresse,nom,prenom,date_naissance,travail,tel,email,siteweb) values(?,?,?,?,?,?,?,?,?)",idEnt,idAdr,infop.getNom(),infop.getPrenom(),formatter.format(new Date(infop.getDateNaissance())),infop.getTravail(),infop.getTel(),infop.getAdresseE(),infop.getSiteWEB());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		return lastId;
	}


	@Override
	public void miseAjour(Infos_Personnelles infop) throws TransportException {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("yyyy/dd/MM");
		try {
			adrDAO.miseAjour(infop.getAdresse());
			int idEnt=0;
			if(infop.getEntreprise()!=null){
				entDAO.miseAjour(infop.getEntreprise());
				 idEnt=infop.getEntreprise().getId();
			}
			jdbctool.executeUpdate("update Infos_Personnelles set id_entreprise=?, id_adresse=?,nom=?,prenom=?,date_naissance=?,travail=?,tel=?,email=?,siteweb=? where id_personnel=?",idEnt,infop.getAdresse().getId(),infop.getNom(),infop.getPrenom(),formatter.format(new Date(infop.getDateNaissance())),infop.getTravail(),infop.getTel(),infop.getAdresseE(),infop.getSiteWEB(),infop.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		
	}

	public Infos_Personnelles  chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Infos_Personnelles infop  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from  Infos_Personnelles where id_personnel=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				infop = new Infos_Personnelles();
				infop.setId(rst.getInt(1));
				infop.setEntreprise(entDAO.chercher(rst.getInt(2)));
				infop.setAdresse(adrDAO.chercher(rst.getInt(3)));
				infop.setNom(rst.getString(4));
				infop.setPrenom(rst.getString(5));
				infop.setDateNaissance(formatter.format(rst.getDate((6))));
				infop.setTravail(rst.getString(7));
				infop.setTel(rst.getString(8));
				infop.setAdresseE(rst.getString(9));
				infop.setSiteWEB(rst.getString(10));
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
		return infop;
		
	}


	@Override
	public Collection<Infos_Personnelles> toutInfos_Personnelles()
			throws TransportException {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Infos_Personnelles> infosp = new ArrayList<Infos_Personnelles>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Infos_Personnelles");
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				Infos_Personnelles infop = new Infos_Personnelles();
				infop.setId(rst.getInt(1));
				infop.setEntreprise(entDAO.chercher(rst.getInt(2)));
				infop.setAdresse(adrDAO.chercher(rst.getInt(3)));
				infop.setNom(rst.getString(4));
				infop.setPrenom(rst.getString(5));
				infop.setDateNaissance(formatter.format(rst.getDate(6)));
				infop.setTravail(rst.getString(7));
				infop.setTel(rst.getString(8));
				infop.setAdresseE(rst.getString(9));
				infop.setSiteWEB(rst.getString(10));
				infosp.add(infop);
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
		return infosp;
		
		
	}
	
	

	

}
