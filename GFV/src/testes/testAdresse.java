package testes;

import junit.framework.Assert;
import modelTransport.Adresse;

import org.junit.Before;
import org.junit.Test;

import transportDAO.JdbcTools;
import transportDAO.adresseDAO;
import erreur.TransportException;

public class testAdresse {
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private adresseDAO adrDAO;
	private Adresse adresse;
	private JdbcTools jdbctool;
	@Before
	public void init() throws TransportException
	{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		jdbctool.init();
		adrDAO  = new adresseDAO(jdbctool);
		adresse  = new  Adresse(0,74, "Stanislas Torrent","Marseille", "13006","France");
	}

	//@Test(expected =TransportException.class)  // test erreur de connection avec serveur mysql 
	public void testSauvegarde() throws TransportException{
		adrDAO.sauvegarde(adresse);

	}
	
	//@Test
	public void testMisajour() throws TransportException{
		String exp="nguyen van khue";
		Adresse adr=adrDAO.chercher(1);
		adr.setNom_rue(exp);
		adrDAO.miseAjour(adr);
		Assert.assertEquals(exp,adrDAO.chercher(1).getNom_rue() );
	}
	//@Test
	public void testListe() throws TransportException{
		int exp =1;
		Assert.assertEquals(exp,adrDAO.toutAdresse().size());
	}
	@Test
	public void testSupprimer() throws TransportException{
		int exp =0;
		adrDAO.supprimer(adrDAO.chercher(1));
		Assert.assertEquals(exp,adrDAO.toutAdresse().size());
	}
	
	

	





}
