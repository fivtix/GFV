package interTransport;

import java.util.ArrayList;

import modelTransport.Document;
import modelTransport.Infos_Personnelles;
import erreur.TransportException;

/**
 * interface pour la gestion des documents avec la DAO
 */
public interface interDocumentDAO {

	public void sendToBDD(Document doc) throws TransportException; //permet d'envoyer � la base de donn�es les informations sur le document
	public boolean sendToFTP(Document doc, String adresseServeur, String login, String pwd, boolean connexionSecurise, boolean BinaryOrTextFile); //permet d'envoyer le document sur le serveur FTP. demande les informations de connexion
	public ArrayList<String> telechargerListeNomDoc() throws TransportException; //permet de t�l�charger depuis la BDD la liste des noms des documents pr�sents
	public ArrayList<Document> telechargerListeDoc() throws TransportException; // permet de t�l�charger depuis la BDD la liste des documents pr�sents
	public void modifierDocBDD(Document origine, Document modifie) throws TransportException; //permet de modidier un ancien document (origine) par un nouveau document modifi�
	public void supprimerDocBDD(Document doc) throws TransportException;
	public Document chercher(int id) throws TransportException ;
	
	public void ajouterDocumentPersonnel(Document doc, Infos_Personnelles infos);
	public void supprimerDocumentPersonnel(Document doc, Infos_Personnelles infos);
	//public void modifierDocumentPersonnel(Document doc, Infos_Personnelles infos);
	
	//public void ajouterDocumentGestion(Document doc, GestionTransport gestion);
	//public void supprimerDocumentGestion(Document doc, GestionTransport gestion);
	//public void modifierDocumentGestion(Document doc, GestionTransport gestion);
	
	//public void ajouterDocumentVehicule(Document doc, Vehicule vehicule);
	//public void supprimerDocumentVehicule(Document doc, Vehicule vehicule);
	//public void modifierDocumentVehicule(Document doc, Vehicule vehicule);
}