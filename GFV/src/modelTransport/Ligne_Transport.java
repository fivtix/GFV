package modelTransport;

public class Ligne_Transport {
private Transport transport;
private Lieux depart , arrivee;
	public Ligne_Transport(){
		
	}
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
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
	
	
}

