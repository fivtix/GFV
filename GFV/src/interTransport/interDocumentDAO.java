package interTransport;

import java.util.ArrayList;

import modelTransport.Document;
import modelTransport.Infos_Personnelles;
import erreur.TransportException;

public interface interDocumentDAO {

	public void sendToBDD(Document doc) throws TransportException; //permet d'envoyer à la base de données les informations sur le document
	public boolean sendToFTP(Document doc, String adresseServeur, String login, String pwd, boolean connexionSecurise, boolean BinaryOrTextFile); //permet d'envoyer le document sur le serveur FTP. demande les informations de connexion
	public ArrayList<String> telechargerListeNomDoc() throws TransportException; //permet de télécharger depuis la BDD la liste des noms des documents présents
	public ArrayList<Document> telechargerListeDoc() throws TransportException; // permet de télécharger depuis la BDD la liste des documents présents
	public void modifierDocBDD(Document origine, Document modifie) throws TransportException; //permet de modidier un ancien document (origine) par un nouveau document modifié
	public void supprimerDocBDD(Document doc) throws TransportException;
	public Document chercher(int id) throws TransportException ;
	
	public void ajouterDocumentPersonnel(Document doc, Infos_Personnelles infos)throws TransportException;
	public void supprimerDocumentPersonnel(Document doc, Infos_Personnelles infos)throws TransportException;
	
	public void ajouterDocumentGestion(Document doc, GestionTransport gestion)throws TransportException;
	public void supprimerDocumentGestion(Document doc, GestionTransport gestion)throws TransportException;
	
	public void ajouterDocumentVehicule(Document doc, Vehicule vehicule)throws TransportException;
	public void supprimerDocumentVehicule(Document doc, Vehicule vehicule)throws TransportException;
	
	public void ajouterDocumentTransport(Document doc, Transport transport)throws TransportException;
	public void supprimerDocumentTransport(Document doc, Transport transport)throws TransportException;
}