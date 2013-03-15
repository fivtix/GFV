package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;

import modelTransport.Adresse;

import org.junit.Before;
import org.junit.Test;

import erreur.TransportException;

import transportDAO.adresseDAO;

public class testjdbctool {
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private adresseDAO adrDAO;
	private Adresse adresse;
	@Before
	public void init() throws TransportException
	{
		adrDAO  = new adresseDAO(pilote,url,utilisateur,motdepass);
		adresse  = new  Adresse("",74, "Stanislas Torrent","Marseille", "13006","France");
	}
	
	//@Test(expected =TransportException.class)  // test erreur de connection avec serveur mysql 
	public void testSauvegardeAdresse() throws TransportException{
		adrDAO.sauvegarde(adresse);
	}
	@Test
	public void testChercherAdresse() throws TransportException{
		String exp ="2";
		Assert.assertEquals(exp,adrDAO.chercher("2").getId_adr());
	}
	@Test
	public void testMisajourAdresse() throws TransportException{
		int exp =15;
		adresse.setId_adr("2");
		adresse.setNumero_rue(15);
		adrDAO.miseAjour(adresse);
		Assert.assertEquals(exp,adrDAO.chercher("2").getNumero_rue());
	}
	
	@Test
	public void testListeAdrese() throws TransportException{
		int exp =1;
		Assert.assertEquals(exp,adrDAO.toutAdresse().size());
	}
	
	

}
