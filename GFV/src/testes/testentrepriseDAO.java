package testes;

import junit.framework.Assert;
import modelTransport.Adresse;
import modelTransport.Lieux;

import org.junit.Before;
import org.junit.Test;

import transportDAO.JdbcTools;
import transportDAO.adresseDAO;
import transportDAO.lieuxDAO;
import erreur.TransportException;

public class testentrepriseDAO {
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private adresseDAO adrDAO;
	private Adresse adresse;
	private lieuxDAO lDAO;
	private JdbcTools jdbctool;
	@Before
	public void init() throws TransportException
	{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		jdbctool.init();
		adrDAO  = new adresseDAO(jdbctool);
		adresse  = new  Adresse(0,74, "Stanislas Torrent","Marseille", "13006","France");
		lDAO=new lieuxDAO(jdbctool,adrDAO);
	}

//	@Test(expected =TransportException.class)  // test erreur de connection avec serveur mysql 
	public void testSauvegarde() throws TransportException{
		Lieux l=new Lieux(0,adresse,"nguyen","nguyen hoang lily");
		lDAO.sauvegarde(l);
	}
	
	@Test
	public void testMisajour() throws TransportException{
		String exp="nguyen van khue";
		Lieux l=lDAO.chercher(1);
        l.setNom("nguyen van khue");
		lDAO.miseAjour(l);
		Assert.assertEquals(exp,lDAO.chercher(1).getNom());
	}
//	@Test
	public void testListe() throws TransportException{
		int exp =1;
		Assert.assertEquals(exp,lDAO.toutLieux().size());
	}
	@Test
	public void testSupprimer() throws TransportException{
		int exp =0;
		lDAO.supprimer(lDAO.chercher(1));
		Assert.assertEquals(exp,lDAO.toutLieux().size());
	}

}
