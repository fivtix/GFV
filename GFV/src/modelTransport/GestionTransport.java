package modelTransport;

import java.util.ArrayList;

public class GestionTransport {
private int id;
private ArrayList<Ligne_Transport> lignetransports;
private ArrayList<Horaire> horraires;
private Mission mission;
private ArrayList<Incident> incedens ;

	public GestionTransport() {
		// TODO Auto-generated constructor stub
		 incedens = new ArrayList<Incident>();
		 horraires = new  ArrayList<Horaire>();
		 lignetransports =new ArrayList<Ligne_Transport>();
	}
	public ArrayList<Ligne_Transport> getLignetransports() {
		return lignetransports;
	}

	public void setLignetransports(ArrayList<Ligne_Transport> lignetransports) {
		this.lignetransports = lignetransports;
	}

	public ArrayList<Horaire> getHorraires() {
		return horraires;
	}

	public void setHorraires(ArrayList<Horaire> horraires) {
		this.horraires = horraires;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public ArrayList<Incident> getIncedens() {
		return incedens;
	}
	public void setIncedens(ArrayList<Incident> incedens) {
		this.incedens = incedens;
	}
	
	


}
