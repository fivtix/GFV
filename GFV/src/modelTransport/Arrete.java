package modelTransport;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

public class Arrete {
	private int id;
	private Lieux depart;
	private Lieux arrive;
	private int distance;
	public Arrete()
	{
	}
	public Arrete(int id,Lieux depart,Lieux arrive,int distance)
	{
		this.depart=depart;
		this.arrive=arrive;
		this.distance=distance;
		this.id=id;
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
