package modelTransport;

import java.awt.Image;
import java.util.Vector;

public class Arrete {
	private String id;
	private Lieux depart;
	private Lieux arrive;
	private int distance;
	private Vector<Itineraire> itineraire;
	public String getCarte() {
		return carte;
	}
	public void setCarte(String carte) {
		this.carte = carte;
	}
	private String carte;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Arrete()
	{

	}
	public Arrete(Lieux depart,Lieux arrive,int distance)
	{
		this.depart=depart;
		this.arrive=arrive;
		this.distance=distance;
		itineraire = new  Vector<Itineraire>();
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
