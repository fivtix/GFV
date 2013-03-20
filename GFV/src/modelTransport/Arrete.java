package modelTransport;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

public class Arrete {
	private int id;
	private Lieux depart;
	private Lieux arrive;
	private int distance;
	private ArrayList<Itineraire> itineraires;
	private String carte;
	public Arrete()
	{
		itineraires = new  ArrayList<Itineraire>();
	}
	public Arrete(int id,Lieux depart,Lieux arrive,int distance,String carte)
	{
		this.depart=depart;
		this.arrive=arrive;
		this.distance=distance;
		itineraires = new  ArrayList<Itineraire>();
		this.id=id;
		this.carte=carte;
		
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
	public ArrayList<Itineraire> getItineraire() {
		return itineraires;
	}
	public void setItineraire(ArrayList<Itineraire> itineraires) {
		this.itineraires = itineraires;
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
	public void ajouterItineraire(Itineraire i){
		itineraires.add(i);
	}
	
}
