package modelTransport;

public class Ligne_Transport {
private Lieux lieuxDepart,lieuxArrivee;
private Transport transport;
	public Ligne_Transport(){
		
	}
	public Lieux getLieuxDepart() {
		return lieuxDepart;
	}
	public void setLieuxDepart(Lieux lieuxDepart) {
		this.lieuxDepart = lieuxDepart;
	}
	public Lieux getLieuxArrivee() {
		return lieuxArrivee;
	}
	public void setLieuxArrivee(Lieux lieuxArrivee) {
		this.lieuxArrivee = lieuxArrivee;
	}
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	
	
}

