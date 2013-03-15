package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;

import modelTransport.Adresse;
import modelTransport.Entreprise;
import modelTransport.Lieux;

import org.junit.Before;
import org.junit.Test;

import erreur.TransportException;

import transportDAO.JdbcTools;
import transportDAO.LieuxDAO;
import transportDAO.adresseDAO;
import transportDAO.entrepriseDAO;

public class testjdbctool {
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private adresseDAO adrDAO;
	private Adresse adresse;
	private JdbcTools jdbctool;
	private entrepriseDAO entDAO;
	private LieuxDAO lieuxDAO;
	@Before
	public void init() throws TransportException
	{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		jdbctool.init();
		adrDAO  = new adresseDAO(jdbctool);
		adresse  = new  Adresse("",74, "Stanislas Torrent","Marseille", "13006","France");
		entDAO= new entrepriseDAO(jdbctool,adrDAO );
		lieuxDAO  =new LieuxDAO(jdbctool,adrDAO );
	}
		
	//@Test(expected =TransportException.class)  // test erreur de connection avec serveur mysql 
	public void testSauvegardeAdresse() throws TransportException{
		adrDAO.sauvegarde(adresse);
		
	}
	//@Test
	public void testChercherAdresse() throws TransportException{
		String exp ="2";
		Assert.assertEquals(exp,adrDAO.chercher("2").getId_adr());
	}
	//@Test
	public void testMisajourAdresse() throws TransportException{
		int exp =15;
		adresse.setId_adr("2");
		adresse.setNumero_rue(15);
		adresse.setPays("France");
		adrDAO.miseAjour(adresse);
		//System.out.print(adrDAO.chercher("2").getNumero_rue());
	}
	
	//@Test
	public void testListeAdrese() throws TransportException{
		int exp =2;
		Assert.assertEquals(exp,adrDAO.toutAdresse().size());
	}
	
	// @Test(expected =TransportException.class)
	public void testSauvegardeEntreprise() throws TransportException{
		adrDAO.sauvegarde(adresse);
		adresse.setId_adr(""+adrDAO.getLastId());
		Entreprise ent = new Entreprise("",adresse,"GFV");
		entDAO.sauvegarde(ent);
		
	}
	//@Test
	public void testChercherEntreprise() throws TransportException{
		String exp ="1";
		Entreprise ent = entDAO.chercher("1");
		Assert.assertEquals(exp,ent.getId_entreprise());
		
	}
//	@Test
	public void testUdateEntreprise() throws TransportException{
		String exp ="nguyen";
		Entreprise ent = entDAO.chercher("1");
		ent.setNom("nguyen");
		Assert.assertEquals(exp,ent.getNom());
	}
	//@Test
	public void testListEntreprise() throws TransportException{
		int exp =1;
		Assert.assertEquals(exp, entDAO.toutEntreprise().size());
	}
	
	// etst de lieux
	
	    @Test(expected =TransportException.class)
		public void testSauvegardeLieux() throws TransportException{
			adrDAO.sauvegarde(adresse);
			adresse.setId_adr(""+adrDAO.getLastId());
			Lieux l = new Lieux("",adresse,"nguyen","nguyen2");
			lieuxDAO.sauvegarde(l);
		}
	//	@Test
		public void testChercherLieux() throws TransportException{
			String exp ="1";
			Lieux l = lieuxDAO.chercher("1");
			Assert.assertEquals(exp,l.getId_lieu());
		}
	
//	@Test
	public void testUdateLieux() throws TransportException{
		String exp ="nguyen van";
		Lieux l = lieuxDAO.chercher("1");
		l.setNom("nguyen van");
		Assert.assertEquals(exp,l.getNom());
	}
	//@Test
	public void testListLieux() throws TransportException{
		int exp =2;
		Assert.assertEquals(exp, lieuxDAO.toutLieux().size());
	}
	
	
	
	

}
