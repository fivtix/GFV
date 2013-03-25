package modelTransport;
public class Transport {
	private int id;
	private int  estimationCout;
	private String dateDepart;
	private String dateArrivee;
	private Lieux depart;
	private Lieux arrivee;
	private Entreprise ent;
	private String typeVehicule;
	private String march;
	private String Nat_March;
    public Transport() {
    	depart = new Lieux();
    	arrivee = new Lieux();
    	ent= new Entreprise();
    }
    public Transport(Entreprise entreprise,Lieux depart,Lieux arrivee,String datedepart,String datearrive,String typevehicule,String marchandise,String naturemarchandise,int cout){
    	estimationCout=cout;
    	dateDepart = datedepart;
    	dateArrivee=datearrive;
    	ent=entreprise;
    	typeVehicule = typevehicule;
    	march=marchandise;
    	Nat_March=naturemarchandise;
    	this.depart=depart;
    	this.arrivee=arrivee;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEstimationCout() {
		return estimationCout;
	}
	public void setEstimationCout(int estimationCout) {
		this.estimationCout = estimationCout;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public Lieux getDepart() {
		return depart;
	}
	public void setDepart(Lieux depart) {
		this.depart = depart;
	}
	public Lieux getArrivee() {
		return arrivee;
	}
	public void setArrivee(Lieux arrivee) {
		this.arrivee = arrivee;
	}
	public Entreprise getEnt() {
		return ent;
	}
	public void setEnt(Entreprise ent) {
		this.ent = ent;
	}
	public String getTypeVehicule() {
		return typeVehicule;
	}
	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	public String getMarch() {
		return march;
	}
	public void setMarch(String march) {
		this.march = march;
	}
	public String getNat_March() {
		return Nat_March;
	}
	public void setNat_March(String nat_March) {
		Nat_March = nat_March;
	}
    
	
}
