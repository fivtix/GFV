package modelTransport;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import erreur.TransportException;


public class  Infos_Personnelles {
	// déclarer les variable
	private String id="";// chaque perchon n'a que un numéro de id
	private String nom, prenom,dateNaissance,tel,adresseE, siteWEB,travail; // mp est mot de pass
	private Adresse adresse;
	private Entreprise entreprise;
	
	public Infos_Personnelles(String id,Entreprise entreprise,Adresse adresse, String nom, String prenom, String dateNaissance,String travail,String tel, String adresseE, String siteWEB) throws TransportException {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
		this.travail = travail;
		this.tel= tel;
		this.adresseE=adresseE;
		this.siteWEB=siteWEB;
		this.adresse=adresse;
		this.entreprise=entreprise;
		
		
	}
	
 public Infos_Personnelles(){
	 
 }
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresseE() {
		return adresseE;
	}

	public void setAdresseE(String adresseE) {
		this.adresseE = adresseE;
	}

	public String getSiteWEB() {
		return siteWEB;
	}

	public void setSiteWEB(String siteWEB) {
		this.siteWEB = siteWEB;
	}

	public String getTravail() {
		return travail;
	}

	public void setTravail(String travail) {
		this.travail = travail;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	


}
