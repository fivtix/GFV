package interTransport;

import java.util.Collection;

import modelTransport.Adresse;

import erreur.TransportException;

public interface interAdresseDAO<interAdresseDAO> {
	public void supprimer(Adresse adr)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public int sauvegarde(Adresse adr)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Adresse adr)throws TransportException;// mise � jour (transport, trajet, Itineraire, adresse...) 
	public Adresse chercher(int id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public Collection<Adresse> toutAdresse()throws TransportException; // chercher  (transport, trajet, Itineraire, adresse...) 

}

