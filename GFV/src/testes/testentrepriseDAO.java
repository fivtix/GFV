package testes;

import junit.framework.Assert;
import modelTransport.Adresse;
import modelTransport.Entreprise;
import modelTransport.Lieux;

import org.junit.Before;
import org.junit.Test;

import transportDAO.JdbcTools;
import transportDAO.adresseDAO;
import transportDAO.entrepriseDAO;
import transportDAO.lieuxDAO;
import erreur.TransportException;

public class testentrepriseDAO {
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private adresseDAO adrDAO;
	private entrepriseDAO entDAO;
	private Adresse adresse;
	private JdbcTools jdbctool;
	@Before
	public void init() throws TransportException
	{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		jdbctool.init();
		adrDAO  = new adresseDAO(jdbctool);
		adresse  = new  Adresse(0,74, "Stanislas Torrent","Marseille", "13006","France");
		entDAO= new entrepriseDAO(jdbctool,adrDAO);
	}

	//@Test(expected =TransportException.class)  // test erreur de connection avec serveur mysql 
	public void testSauvegarde() throws TransportException{
		entDAO.sauvegarde(new Entreprise(0,adresse,"FTP"));
	}
	
	//@Test
	public void testMisajour() throws TransportException{
		Entreprise ent=entDAO.chercher(1);
		ent.setNom("nguyen hoang lily");
		entDAO.miseAjour(ent);
		Assert.assertEquals("nguyen hoang lily",entDAO.chercher(1).getNom());
	}
	@Test
	public void testListe() throws TransportException{
		int exp =1;
		Assert.assertEquals(exp,entDAO.toutEntreprise().size());
	}
	@Test
	public void testSupprimer() throws TransportException{
		int exp =0;
		entDAO.supprimer(entDAO.chercher(1));
		Assert.assertEquals(exp,entDAO.toutEntreprise().size());
	}

}
