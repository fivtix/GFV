package interTransport;



import java.util.Collection;

import modelTransport.Moyen_Transport;
import erreur.TransportException;

public interface interMoyen_transportDAO {


	public void supprimer(Moyen_Transport p)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public void sauvegarde(Moyen_Transport p)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Moyen_Transport p)throws TransportException;// mise � jour (transport, trajet, Itineraire, adresse...) 
	public Moyen_Transport chercher(int id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public Collection<Moyen_Transport> toutMoyen_Transport()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 

}
