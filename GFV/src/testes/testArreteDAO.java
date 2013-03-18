package testes;

import junit.framework.Assert;
import modelTransport.Adresse;
import modelTransport.Arrete;
import modelTransport.Itineraire;
import modelTransport.Lieux;

import org.junit.Before;
import org.junit.Test;

import transportDAO.JdbcTools;
import transportDAO.adresseDAO;
import transportDAO.arreteDAO;
import transportDAO.itineraireDAO;
import transportDAO.lieuxDAO;
import erreur.TransportException;

public class testArreteDAO {
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private adresseDAO adrDAO;
	private Adresse adresse1,adresse2;
	private lieuxDAO lDAO;
	private arreteDAO aDAO;
	private JdbcTools jdbctool;
	private itineraireDAO iDAO;
	@Before
	public void init() throws TransportException
	{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		jdbctool.init();
		adrDAO  = new adresseDAO(jdbctool);
		adresse1  = new  Adresse(0,74, "Stanislas Torrent","Marseille", "13006","France");
		adresse2  = new  Adresse(0,74, "Gare st charles","Marseille", "13006","France");
		lDAO=new lieuxDAO(jdbctool,adrDAO);
		iDAO = new itineraireDAO(jdbctool,adrDAO);
		aDAO= new arreteDAO(jdbctool,lDAO,iDAO);
	}

	//@Test(expected =TransportException.class)  // test erreur de connection avec serveur mysql 
	public void testSauvegarde() throws TransportException{
		Lieux l1=new Lieux(0,adresse1,"nguyen","nguyen hoang lily");
		Lieux l2=new Lieux(0,adresse2,"nguyen","lyon");
		Arrete a= new Arrete(0,l1,l2,"Paris/lyon",150,"capture.png");
		aDAO.sauvegarde(a);
	}
	
//	@Test
	public void testMisajour() throws TransportException{
		String exp="nguyen van khue";
		Arrete a=aDAO.chercher(3);
		a.setNom(exp);
		a.ajouterItineraire(new Itineraire(adresse1,adresse2,25,"thu thut uth ut uttuht tu"));
		aDAO.miseAjour(a);
		Assert.assertEquals(exp,aDAO.chercher(3).getNom());
	}
	@Test
	public void testListe() throws TransportException{
		int exp =0;
		Assert.assertEquals(exp,aDAO.toutArrete().size());
	}
   @Test
	public void testSupprimer() throws TransportException{
		int exp =0;
		aDAO.supprimer(aDAO.chercher(3));
		Assert.assertEquals(exp,aDAO.toutArrete().size());
	}

}
