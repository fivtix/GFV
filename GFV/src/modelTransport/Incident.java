package modelTransport;

public class Incident {
  public int id;
	public int idGest;
	public String  typeAccident;
	public String description;
	/**constructeurs*/
	public Incident(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdGest() {
		return idGest;
	}
	public void setIdGest(int idGest) {
		this.idGest = idGest;
	}
	
	public String getTypeAccident() {
		return typeAccident;
	}

	public void setTypeAccident(String typeAccident) {
		this.typeAccident = typeAccident;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
