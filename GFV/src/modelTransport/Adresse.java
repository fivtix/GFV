package modelTransport;
public class Adresse {
	
	private int id;
	private String nom_rue;
	private int numero_rue;
	private String ville;
	private String code_postal;
	private String pays;
	
	public Adresse()
	{
	}
	public Adresse(int id_adresse, int numero_rue,String nom_rue,String code_postal,String ville,  String pays) {
		super();
		this.id = id_adresse;
		this.nom_rue = nom_rue;
		this.numero_rue = numero_rue;
		this.ville = ville;
		this.code_postal = code_postal;
		this.pays = pays;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_rue() {
		return nom_rue;
	}
	public void setNom_rue(String nom_rue) {
		this.nom_rue = nom_rue;
	}
	public int getNumero_rue() {
		return numero_rue;
	}
	public void setNumero_rue(int numero_rue) {
		this.numero_rue = numero_rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
