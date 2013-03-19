package modelTransport;

public class Ligne_Transport {
private int id_transport;
private int id_gestion_transports;
private int id_arrete;

public Ligne_Transport(){}

public Ligne_Transport(int id_transport,int id_gestion_transports,int id_arrete){
	this.id_transport=id_transport;
	this.id_gestion_transports=id_gestion_transports;
	this.id_arrete=id_arrete;
}

public int getId_transport() {
	return id_transport;
}

public void setId_transport(int id_transport) {
	this.id_transport = id_transport;
}

public int getId_gestion_transports() {
	return id_gestion_transports;
}

public void setId_gestion_transports(int id_gestion_transports) {
	this.id_gestion_transports = id_gestion_transports;
}

public int getId_arrete() {
	return id_arrete;
}

public void setId_arrete(int id_arrete) {
	this.id_arrete = id_arrete;
}
}
