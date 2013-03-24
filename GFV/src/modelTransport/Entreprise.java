package modelTransport;


//
//  @ Project : pfe
//  @ File Name : Entreprise.java
//  @ Date : 11/03/2013
//  @ Author : Faten,Tania,Van,Idan,Xavier
//
//
public class Entreprise {
	private int id;
	private String nom;
	private Adresse adresse;
	public Entreprise(){
		adresse = new Adresse();
	}
	public Entreprise(int id, Adresse adresse,String nom) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
