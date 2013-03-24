package modelTransport;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

public class Parcours {
	private Lieux depart;
	private Lieux arrive;
	public Parcours()
	{
	}
	public Parcours(Lieux depart,Lieux arrive)
	{
		this.depart=depart;
		this.arrive=arrive;
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
	
	
	
}
