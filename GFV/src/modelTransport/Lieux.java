package modelTransport;
public class Lieux {
	private String id_lieu;
	private Adresse adr;
	private String nom;
	private String coordonnees;
	
	public Lieux()
	{
		
	}
	public Lieux(String id,Adresse adr, String nom, String coordonnees) {
		super();
		this.id_lieu = id;
		this.coordonnees = coordonnees;
		this.adr=adr;
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}

	public String getId_lieu() {
		return id_lieu;
	}

	public void setId_lieu(String id_lieu) {
		this.id_lieu = id_lieu;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
	
}
