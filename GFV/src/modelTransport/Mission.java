package modelTransport;

public class Mission {

	private Infos_Personnelles person;
	private  Vehicule vehicule;
	private String dateHeuredebut;
	private String dateHeureterminal;
	
	public Mission() {
		// TODO Auto-generated constructor stub
	}
	public Infos_Personnelles getPerson() {
		return person;
	}

	public void setPerson(Infos_Personnelles person) {
		this.person = person;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}


	public String getDateHeuredebut() {
		return dateHeuredebut;
	}

	public void setDateHeuredebut(String dateHeuredebut) {
		this.dateHeuredebut = dateHeuredebut;
	}

	public String getDateHeureterminal() {
		return dateHeureterminal;
	}

	public void setDateHeureterminal(String dateHeureterminal) {
		this.dateHeureterminal = dateHeureterminal;
	}
	

}
