package modelTransport;

import java.util.ArrayList;

public class GestionTransport {
private int id;
private ArrayList<Ligne_Transport> lignetransports;
private ArrayList<Horaire> horraires;
private Mission mission;
private Incident incedens ;
private Trajet trajet;
private String nom;
	public GestionTransport() {
		// TODO Auto-generated constructor stub
		 incedens = new Incident();
		 horraires = new  ArrayList<Horaire>();
		 lignetransports =new ArrayList<Ligne_Transport>();
		 trajet =new Trajet();
		 mission = new Mission();
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
	public Incident getIncedens() {
		return incedens;
	}
	public void setIncedens(Incident incedens) {
		this.incedens = incedens;
	}
	public Trajet getTrajet() {
		return trajet;
	}
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	


}
