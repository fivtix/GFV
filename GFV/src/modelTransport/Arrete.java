package modelTransport;

import java.awt.Image;
import java.util.Vector;

public class Arrete {
	private int id;
	private Lieux depart;
	private Lieux arrive;
	private int distance;
	private Vector<Itineraire> itineraire;
	private String carte,nom;
	public Arrete()
	{
		itineraire = new  Vector<Itineraire>();
	}
	public Arrete(int id,Lieux depart,Lieux arrive,String nom,int distance,String carte)
	{
		this.depart=depart;
		this.arrive=arrive;
		this.distance=distance;
		itineraire = new  Vector<Itineraire>();
		this.id=id;
		this.carte=carte;
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCarte() {
		return carte;
	}
	public void setCarte(String carte) {
		this.carte = carte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vector<Itineraire> getItineraire() {
		return itineraire;
	}
	public void setItineraire(Vector<Itineraire> itineraire) {
		this.itineraire = itineraire;
	}
	public Lieux getDepart() {
		return depart;
	}
	public void setDepart(Lieux depart) {
		this.depart = depart;
	}
	public Lieux getArrive() {
		return arrive;
	}
	public void setArrive(Lieux arrive) {
		this.arrive = arrive;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
