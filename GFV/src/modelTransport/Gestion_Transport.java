package modelTransport;

public class Gestion_Transport {
	Integer id_gestion_des_transport;
	
	String nom;
	Infos_Personnelles personnel;
	Trajet trajet;
	public Gestion_Transport(Integer id_gestion_des_transport, String nom,Infos_Personnelles personnel,  Trajet trajet) {
		super();
		this.id_gestion_des_transport = id_gestion_des_transport;
		this.nom = nom;
		this.personnel = personnel;
	
		this.trajet = trajet;
	}
	public Gestion_Transport() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId_gestion_des_transport() {
		return id_gestion_des_transport;
	}
	public void setId_gestion_des_transport(Integer id_gestion_des_transport) {
		this.id_gestion_des_transport = id_gestion_des_transport;
	}
	
	public Infos_Personnelles getInfosP(){
	
	return personnel;
	}
	
	public String getNom(){
		return nom;
	}
	

	public Trajet gettrajet()
	{return trajet;}
	
	public Moyen_Transport getmoyenT()
	{
		return moyenT;
	}
	
	
	
	public void setInfosP (Infos_Personnelles infop){
		this.personnel=infop;
	}
	
	public void setTrajet(Trajet trajet){
		this.trajet=trajet;
	}
	
	public void setMoyenT(Moyen_Transport moyent){
	this.moyenT=moyent;
	}
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		this.nom=nom;
	}
	}
	

	

