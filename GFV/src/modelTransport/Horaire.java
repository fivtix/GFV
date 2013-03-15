package modelTransport;

public class Horaire {
	private Arrete arrete;
	private Trajet trajet;
	private Gestion_Transport gestion_des_transports;
	public Arrete getArrete() {
		return arrete;
	}

	public void setArrete(Arrete arrete) {
		this.arrete = arrete;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public Gestion_Transport getGestion_des_transports() {
		return gestion_des_transports;
	}

	public void setGestion_des_transports(Gestion_Transport gestion_des_transports) {
		this.gestion_des_transports = gestion_des_transports;
	}

	public String getDate_heure_depart() {
		return date_heure_depart;
	}

	public void setDate_heure_depart(String date_heure_depart) {
		this.date_heure_depart = date_heure_depart;
	}

	public String getDate_heure_arrive() {
		return date_heure_arrive;
	}

	public void setDate_heure_arrive(String date_heure_arrive) {
		this.date_heure_arrive = date_heure_arrive;
	}

	public String getDate_heure_depart_reelle() {
		return date_heure_depart_reelle;
	}

	public void setDate_heure_depart_reelle(String date_heure_depart_reelle) {
		this.date_heure_depart_reelle = date_heure_depart_reelle;
	}

	public String getDate_heure_arrivee_reelle() {
		return date_heure_arrivee_reelle;
	}

	public void setDate_heure_arrivee_reelle(String date_heure_arrivee_reelle) {
		this.date_heure_arrivee_reelle = date_heure_arrivee_reelle;
	}

	private String date_heure_depart;
	private String date_heure_arrive;
	private String date_heure_depart_reelle;
	private String date_heure_arrivee_reelle;
	
	public Horaire(){
		
	}

}
