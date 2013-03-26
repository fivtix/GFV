package modelTransport;

public class Horaire {
	
	private int idTrajet;
	private int idgestionTransport;
	private Lieux lieuxDepart;
	private Lieux lieuxArrivee;
	private String date_heure_depart;
	private String date_heure_arrive;
	private String date_heure_depart_reelle;
	private String date_heure_arrivee_reelle;
	
	public Horaire(){
		
	}
	
	public int getIdTrajet() {
		return idTrajet;
	}

	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}

	public int getIdgestionTransport() {
		return idgestionTransport;
	}

	public void setIdgestionTransport(int idgestionTransport) {
		this.idgestionTransport = idgestionTransport;
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

	public Lieux getLieuxDepart() {
		return lieuxDepart;
	}

	public void setLieuxDepart(Lieux lieuxDepart) {
		this.lieuxDepart = lieuxDepart;
	}

	public Lieux getLieuxArrivee() {
		return lieuxArrivee;
	}

	public void setLieuxArrivee(Lieux lieuxArrivee) {
		this.lieuxArrivee = lieuxArrivee;
	}
	


}
