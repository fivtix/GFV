package testes;

import junit.framework.Assert;
import modelTransport.Adresse;
import modelTransport.Entreprise;
import modelTransport.Infos_Personnelles;
import modelTransport.Lieux;

import org.junit.Before;
import org.junit.Test;

import transportDAO.InfosPersonnellesDAO;
import transportDAO.JdbcTools;
import transportDAO.adresseDAO;
import transportDAO.entrepriseDAO;
import transportDAO.lieuxDAO;
import erreur.TransportException;

public class testPersonnelDAO {
	private String url = "jdbc:mysql://127.0.0.1/n20404039";
	private String utilisateur = "n20404039";
	private String motdepass = "CQcc.W";
	private String pilote = "com.mysql.jdbc.Driver";
	private adresseDAO adrDAO;
	private entrepriseDAO entDAO;
	private Adresse adresse;
	private JdbcTools jdbctool;
	private InfosPersonnellesDAO personDAO;
	
	@Before
	public void init() throws TransportException
	{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		jdbctool.init();
		adrDAO  = new adresseDAO(jdbctool);
		adresse  = new  Adresse(0,74, "Stanislas Torrent","Marseille", "13006","France");
		entDAO= new entrepriseDAO(jdbctool,adrDAO);
		personDAO  =  new InfosPersonnellesDAO(jdbctool,entDAO,adrDAO);
	}

	//@Test(expected =TransportException.class)  // test erreur de connection avec serveur mysql 
	public void testSauvegarde() throws TransportException{
		Entreprise ent = null;
		 Infos_Personnelles p = new Infos_Personnelles(1,ent,adresse, "nguyen", "van khue", "08/06/1977","etudiant","0610886617", "khuek@yahoo.com", "www.ee.com");
		 personDAO.sauvegarde(p);
	}
	
	@Test
	public void testMisajour() throws TransportException{
		Infos_Personnelles p=personDAO.chercher(2);
		p.setNom("thu update");
		p.getAdresse().setNom_rue("nguyev van lkhue");
		personDAO.miseAjour(p);
		Assert.assertEquals("thu update",personDAO.chercher(2).getNom());
		Assert.assertEquals("nguyev van lkhue",personDAO.chercher(2).getAdresse().getNom_rue());
	}
	@Test
	public void testListe() throws TransportException{
		int exp =1;
		Assert.assertEquals(exp,personDAO.toutInfos_Personnelles());
	}
//	@Test
	public void testSupprimer() throws TransportException{
		int exp =1;
		personDAO.supprimer(personDAO.chercher(1));
		Assert.assertEquals(exp,personDAO.toutInfos_Personnelles().size());
	}

}
