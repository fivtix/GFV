package modelTransport;

import java.util.ArrayList;
import java.util.Vector;

public  class Trajet {
	private String nom;
	private int id;
	private ArrayList<Arrete> arretes;

	public Trajet(){  
		arretes= new ArrayList<Arrete>();
	}
	public Trajet(int id,String nom){
		this.id=id;
		this.nom=nom;
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
}
