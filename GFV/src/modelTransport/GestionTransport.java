package modelTransport;

import java.util.ArrayList;

public class GestionTransport {
private Trajet trajet;
private ArrayList<Ligne_Transport> lignetransports;
private ArrayList<Horaire> horraires;
private Vehicule vehicule;
private Infos_Personnelles personnelle;
private Incident incidents;

	public GestionTransport() {
		// TODO Auto-generated constructor stub
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
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

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Infos_Personnelles getPersonnelle() {
		return personnelle;
	}

	public void setPersonnelle(Infos_Personnelles personnelle) {
		this.personnelle = personnelle;
	}

	public Incident getIncidents() {
		return incidents;
	}

	public void setIncidents(Incident incidents) {
		this.incidents = incidents;
	}


}
