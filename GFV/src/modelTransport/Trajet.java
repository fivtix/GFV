package modelTransport;

import java.util.Vector;

public  class Trajet {
	private String id, nom;
	private Vector<Arrete> arretes;
	
    public Trajet(){  
    	arretes= new Vector<Arrete>();
    }
    public String getId() {
		return id;
	}
	public void setId(String id,String nom) {
		this.id = id;
		this.nom=nom;
		arretes= new Vector<Arrete>();
	}
	public Vector<Arrete> getArretes() {
		return arretes;
	}
	public void setArretes(Vector<Arrete> arretes) {
		this.arretes = arretes;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Trajet(String id, String nom){
    	
    }
}
