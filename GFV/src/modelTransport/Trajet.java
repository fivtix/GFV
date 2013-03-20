package modelTransport;

import java.util.ArrayList;
import java.util.Vector;

public  class Trajet {
	private String nom;
	private int id;
	private int distance;
	private String carte;
	private ArrayList<Arrete> arretes;

	public Trajet(){  
		arretes= new ArrayList<Arrete>();
	}
	public Trajet(int id,String nom,int distance,String carte){
		this.id=id;
		this.nom=nom;
		this.distance=distance;
		this.carte=carte;
		arretes= new ArrayList<Arrete>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Arrete> getArretes() {
		return arretes;
	}
	public void setArretes(ArrayList<Arrete> arretes) {
		this.arretes = arretes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Trajet(String id, String nom){

	}
	public void ajouterArrete(Arrete a){
		arretes.add(a);
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getCarte() {
		return carte;
	}
	public void setCarte(String carte) {
		this.carte = carte;
	}
	
}
