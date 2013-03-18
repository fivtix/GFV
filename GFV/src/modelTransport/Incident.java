package modelTransport;

public class Incident {
  public int idIncident;
	public int idGest;
	public String  typeIncid;
	public String description;
	/**constructeurs*/
	public Incident(){}
	public Incident(int idIncident, int idGest, String typeIncid,
			String description) {
		super();
		this.idIncident = idIncident;
		this.idGest = idGest;
		this.typeIncid = typeIncid;
		this.description = description;
	}
	/**Getters et setters*/

	public int getIdGest() {
		return idGest;
	}
	public int getIdIncident() {
		return idIncident;
	}
	public void setIdIncident(int idIncident) {
		this.idIncident = idIncident;
	}
	public void setIdGest(int idGest) {
		this.idGest = idGest;
	}
	public String getTypeIncid() {
		return typeIncid;
	}
	public void setTypeIncid(String typeIncid) {
		this.typeIncid = typeIncid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
