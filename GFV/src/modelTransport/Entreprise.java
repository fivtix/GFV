package modelTransport;


//
//  @ Project : pfe
//  @ File Name : Entreprise.java
//  @ Date : 11/03/2013
//  @ Author : Faten,Tania,Van,Idan,Xavier
//
//
public class Entreprise {
	public String id_entreprise;
	public String nom;
	public Adresse adresse;
	public Entreprise(){
		
	}
	public Entreprise(String id_entreprise,  Adresse adresse,String nom) {
		super();
		this.id_entreprise = id_entreprise;
		this.nom = nom;
		this.adresse = adresse;
	}	public String getId_entreprise() {
		return id_entreprise;
	}
	public void setId_entreprise(String id_entreprise) {
		this.id_entreprise = id_entreprise;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
