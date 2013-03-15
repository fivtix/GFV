package modelTransport;

import java.sql.Date;

/**Cette classe permet de construire un transport*/
public class Transport {

  
  public int id;
  public int estimation_cout;
  public java.util.Date date_depart_prevue;
  public java.util.Date date_arrivee_prevue;
  public int lieu_depart;
  public int lieu_arrivee;
  public int idVeh;
  public int idEntreprise;
  public int idArt;
  
  /**constructeurs*/
   public Transport() {}
  
  
  	  public Transport(int id, int estimation_cout, Date date_depart_prevue,
  		Date date_arrivee_prevue, int lieu_depart, int lieu_arrivee,
  		int idVeh, int idEntreprise, int idArt) {
  	super();
  	this.id = id;
  	this.estimation_cout = estimation_cout;
  	this.date_depart_prevue = date_depart_prevue;
  	this.date_arrivee_prevue = date_arrivee_prevue;
  	this.lieu_depart = lieu_depart;
  	this.lieu_arrivee = lieu_arrivee;
  	this.idVeh = idVeh;
  	this.idEntreprise = idEntreprise;
  	this.idArt = idArt;
  }


  	/**Getters et Setters*/
  	public int getId() {
  		return id;
  	}

  	public void setId(int id) {
  		this.id = id;
  	}

  	public float getEstimation_cout() {
  		return estimation_cout;
  	}

  	public void setEstimation_cout(int estimation_cout) {
  		this.estimation_cout = estimation_cout;
  	}

  	public int getLieu_depart() {
  		return lieu_depart;
  	}

  	public void setLieu_depart(int lieu_depart) {
  		this.lieu_depart = lieu_depart;
  	}

  	public int getLieu_arrivee() {
  		return lieu_arrivee;
  	}

  	public void setLieu_arrivee(int lieu_arrivee) {
  		this.lieu_arrivee = lieu_arrivee;
  	}

  	public Date getDate_depart_prevue() {
  		return (Date)  date_depart_prevue;
  	}

  	public void setDate_depart_prevue(java.util.Date date_depart) {
  		this.date_depart_prevue = date_depart;
  	}

  	public Date getDate_arrivee_prevue() {
  		return (Date) date_arrivee_prevue;
  	}

  	public void setDate_arrivee_prevue(java.util.Date date_arrivee) {
  		this.date_arrivee_prevue = date_arrivee;
  	}

  	public int getIdVeh() {
  		return idVeh;
  	}

  	public void setIdVeh(int idVeh) {
  		this.idVeh = idVeh;
  	}

  	public int getIdEntreprise() {
  		return idEntreprise;
  	}

  	public void setIdEntreprise(int idEntreprise) {
  		this.idEntreprise = idEntreprise;
  	}

  	public int getIdArt() {
  		return idArt;
  	}

  	public void setIdArt(int idArt) {
  		this.idArt = idArt;
  	}
  	
 
}
