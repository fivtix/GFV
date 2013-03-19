package modelTransport;



import erreur.TransportException;


public class Moyen_Transport {
	// declarer les variable
	private int id_Moyen_Transport;
	private int id_personnel;
	private int id_vehicule;
	
	public Moyen_Transport()
	{

	}
	public Moyen_Transport(int id_moyen, int id_personnel, int id_vehicule) throws TransportException {
	this.setId_Moyen_Transport(id_moyen);
	this.setId_personnel(id_personnel);
	this.setId_vehicule(id_vehicule);
	}
	public int getId_Moyen_Transport() {
		return id_Moyen_Transport;
	}
	public void setId_Moyen_Transport(int id_Moyen_Transport) {
		this.id_Moyen_Transport = id_Moyen_Transport;
	}
	public int getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
	}
	public int getId_vehicule() {
		return id_vehicule;
	}
	public void setId_vehicule(int id_vehicule) {
		this.id_vehicule = id_vehicule;
	}
	

}
