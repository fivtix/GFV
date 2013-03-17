package interTransport;

import java.util.ArrayList;

import modelTransport.Arrete;
import erreur.TransportException;

public interface interArreteDAO {
	public void supprimer(Arrete a)throws TransportException; // supprimer (transport, trajet, Itineraire, adresse...) 
	public int sauvegarde(Arrete adr)throws TransportException;// sauvegarde (transport, trajet, Itineraire, adresse...) 
	public void miseAjour(Arrete adr)throws TransportException;// mise à jour (transport, trajet, Itineraire, adresse...) 
	public Arrete chercher(int id)throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	public ArrayList<Arrete> toutArrete()throws TransportException;//chercher  (transport, trajet, Itineraire, adresse...) 
	}

