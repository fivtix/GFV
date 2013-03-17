package modelTransport;
public class Lieux {
	private int id;
	private Adresse adr;
	private String nom;
	private String coordonnees;

	public Lieux()
	{

	}
	public Lieux(int id,Adresse adr, String nom, String coordonnees) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}

}
