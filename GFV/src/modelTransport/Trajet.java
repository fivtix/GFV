package modelTransport;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

public  class Trajet {
	private String nom;
	private int id;
	private Double distance;
	private BufferedImage carte;
	private ArrayList<Parcours> parcours;

	public Trajet(){  
		 parcours= new ArrayList<Parcours>();
		distance=0.0;
	}
	public Trajet(int id,String nom,Double distance,BufferedImage carte){
		this.id=id;
		this.nom=nom;
		this.distance=distance;
		this.carte=carte;
		 parcours= new ArrayList<Parcours>();
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
	public Trajet(String id, String nom){

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
	public ArrayList<Parcours> getParcours() {
		return parcours;
	}
	public void setParcours(ArrayList<Parcours> parcours) {
		this.parcours = parcours;
	}
	
	
	
	
}
