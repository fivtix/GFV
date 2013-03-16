package modelTransport;

import java.sql.Date;

/**Cette classe permet de construire un transport*/
public class Transport {

  
public int id;
public int estimation_cout;
public Date date_depart_prevue;
public Date date_arrivee_prevue;
public int lieu_depart;
public int lieu_arrivee;
public int idEntreprise;
public String typeVeh;
public String idMarchandise;
public int idNatMarch;

/**constructeurs*/
public Transport() {}

public Transport(int id, int estimation_cout, Date date_depart_prevue,
Date date_arrivee_prevue, int lieu_depart, int lieu_arrivee,
int idEntreprise, String typeVeh, String idMarchandise,
int idNatMarch) {
super();
this.id = id;
this.estimation_cout = estimation_cout;
this.date_depart_prevue = date_depart_prevue;
this.date_arrivee_prevue = date_arrivee_prevue;
this.lieu_depart = lieu_depart;
this.lieu_arrivee = lieu_arrivee;
this.idEntreprise = idEntreprise;
this.typeVeh = typeVeh;
this.idMarchandise = idMarchandise;
this.idNatMarch = idNatMarch;
}


/**Getters et Setters*/
public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public int getEstimation_cout() {
return estimation_cout;
}

public void setEstimation_cout(int estimation_cout) {
this.estimation_cout = estimation_cout;
}

public java.sql.Date getDate_depart_prevue() {
return date_depart_prevue;
}

public void setDate_depart_prevue(java.sql.Date date_depart_prevue) {
this.date_depart_prevue = date_depart_prevue;
}

public java.sql.Date getDate_arrivee_prevue() {
return date_arrivee_prevue;
}

public void setDate_arrivee_prevue(java.sql.Date date_arrivee_prevue) {
this.date_arrivee_prevue = date_arrivee_prevue;
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

public int getIdEntreprise() {
return idEntreprise;
}

public void setIdEntreprise(int idEntreprise) {
this.idEntreprise = idEntreprise;
}

public String getTypeVeh() {
return typeVeh;
}

public void setTypeVeh(String typeVeh) {
this.typeVeh = typeVeh;
}

public String getIdMarchandise() {
return idMarchandise;
}

public void setIdMarchandise(String idMarchandise) {
this.idMarchandise = idMarchandise;
}

public int getIdNatMarch() {
return idNatMarch;
}

public void setIdNatMarch(int idNatMarch) {
this.idNatMarch = idNatMarch;
}

 
}
