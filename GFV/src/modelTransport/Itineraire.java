package modelTransport;
public class Itineraire {
	private int distance;
	private Adresse depart,arrive;
	private String intro;
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Adresse getDepart() {
		return depart;
	}
	public void setDepart(Adresse depart) {
		this.depart = depart;
	}
	public Adresse getArrive() {
		return arrive;
	}
	public void setArrive(Adresse arrive) {
		this.arrive = arrive;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
}
