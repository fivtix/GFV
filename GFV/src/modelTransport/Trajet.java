package modelTransport;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

public  class Trajet {
	private String nom;
	private int id;
	private Double distance;
	private BufferedImage carte;
	private ArrayList<Arrete> arretes;

	public Trajet(){  
		arretes= new ArrayList<Arrete>();
	}
	public Trajet(int id,String nom,Double distance,BufferedImage carte){
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
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public BufferedImage getCarte() {
		return carte;
	}
	public void setCarte(BufferedImage carte) {
		this.carte = carte;
	}
	
	
	
}
