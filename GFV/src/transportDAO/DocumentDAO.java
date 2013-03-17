package transportDAO;

import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelTransport.Adresse;
import modelTransport.ClientFTP;
import modelTransport.Document;
import modelTransport.Infos_Personnelles;
import erreur.TransportException;
import interTransport.Transport;
//import interTransport.GestionTransport;
//import interTransport.Vehicule;
import interTransport.interDocumentDAO;

public class DocumentDAO implements interDocumentDAO{

	private JdbcTools jdbctool;
	private ClientFTP client;
	
	public DocumentDAO()
	{
		
	}
	
	public DocumentDAO(String pilote, String url, String utilisateur, String motdepass) throws TransportException
	{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
			jdbctool.init();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
		
		client = new ClientFTP();
	}
	
	@Override
	public void sendToBDD(Document doc) throws TransportException
	{
		try {
			jdbctool.executeUpdate("insert into Document(nom,emplacement) values(?,?)",doc.getNom(),doc.getEmplacement());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}
	
	@Override
	public boolean sendToFTP(Document doc, String adresseServeur, String login,	String pwd, boolean connexionSecurise, boolean BinaryOrTextFile) 
	{
		// TODO Auto-generated method stub
		boolean retour = false;
		
		client.setHostname(adresseServeur);
		client.setLogin(login);
		client.setPassword(pwd);
		
		if(!connexionSecurise)
		{
			retour = client.connexion();
		}
		else
		{
			retour = client.connexionSecurise();
		}
		
		if(client.isConnected())
		{
			retour = client.envoyerFichier(doc, BinaryOrTextFile);
			client.deconnexion();
		}

		return retour;
	}
	
	@Override
	public ArrayList<String> telechargerListeNomDoc() throws TransportException
	{
		ArrayList<String> listeDoc = new ArrayList<String>();
		
		String querySql = "select nom from Document";
		
		Statement st = null;
		ResultSet set = null;
		Connection connection = null;
		
		try{
		connection = jdbctool.newConnection();
		st = (Statement) connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			// crÃ©er une connexion
			// connection = newConnection();
			// prÃ©parer l'instruction
			//st = connection.prepareStatement(query);

			// exÃ©cuter l'instruction
			set = st.executeQuery(querySql);
			//set = st.getResultSet();
			
			while(set.next()){
				listeDoc.add(set.getString(1));
			}

		} catch (SQLException e) {
			// renvoyer cette exception

		} finally {
			// fermer la connexion
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				jdbctool.quietClose(connection);
			} catch (TransportException e) {
				// TODO Auto-generated catch block
				throw new TransportException(e.getMessage());
			}
		}
		
		return listeDoc;
	}

	@Override
	public ArrayList<Document> telechargerListeDoc() throws TransportException {
		// TODO Auto-generated method stub
		ArrayList<Document> listeDoc = new ArrayList<Document>();

		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Document");
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				Document doc = new Document();
				doc.setId_document(rst.getInt(1));
				doc.setNom(rst.getString(2));
				doc.setEmplacement(rst.getString(3));
				//doc.setVille(rst.getString(4));
				listeDoc.add(doc);
			}

		} catch (SQLException e) {
			throw new TransportException(e.getErrorCode(),e.getMessage());
			// 5. construire l'exception DAO
			// 6. renvoyer cette exception
		} finally {
			// fermer PreparedStatement 
			if(rst!=null)
				try {
					rst.close();
					// 7. fermer la connexion
					jdbctool.quietClose(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getErrorCode(),e.getMessage());
				}
		}
		
		return listeDoc;
	}

	@Override
	public void modifierDocBDD(Document origine, Document modifie) throws TransportException 
	{
		// TODO Auto-generated method stub
		
		try {
			jdbctool.executeUpdate("update Document set nom=?, emplacement=? where id_document=?", modifie.getNom(), modifie.getEmplacement(), origine.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
	}
	
	public void supprimerDocBDD(Document doc) throws TransportException
	{
		try {
			jdbctool.executeUpdate("delete from Document where id_documents=?",doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}

	@Override
	public void ajouterDocumentPersonnel(Document doc, Infos_Personnelles infos) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("insert into Document_Personne(id_personnel,id_documents) values(?,?)",infos.getId(),doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}

	@Override
	public void supprimerDocumentPersonnel(Document doc, Infos_Personnelles infos) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Document_Personne where id_personnel=? and id_documents=?",infos.getId(),doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}


	
	@Override
	public void ajouterDocumentGestion(Document doc, GestionTransport gestion)throws TransportException
	{
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("insert into Document_Gestion(id_gestion_transports,id_documents) values(?,?)",gestion.getId(), doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}

	@Override
	public void supprimerDocumentGestion(Document doc, GestionTransport gestion) throws TransportException{
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Document_Gestion where id_gestion_transports=? and id_documents=?",gestion.getId(),doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}

	@Override
	public void ajouterDocumentVehicule(Document doc, Vehicule vehicule) throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("insert into Document_Vehicule(id_vehicule,id_documents) values(?,?)",vehicule.getId(), doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}

	@Override
	public void supprimerDocumentVehicule(Document doc, Vehicule vehicule) throws TransportException{
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Document_Vehicule where id_vehicule=? and id_documents=?",vehicule.getId(),doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}
	
	@Override
	public void ajouterDocumentTransport(Document doc, Transport transport)throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("insert into Document_Transport(id_transport,id_documents) values(?,?)",transport.getId(), doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}

	@Override
	public void supprimerDocumentTransport(Document doc, Transport transport)throws TransportException {
		// TODO Auto-generated method stub
		try {
			jdbctool.executeUpdate("delete from Document_Transport where id_transport=? and id_documents=?",transport.getId(),doc.getId_document());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());			
		}
	}

	@Override
	public Document chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		Document doc  = null;
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		String sql="select * from Document where id_documents=?";
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1,id);
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				doc = new Document();
				doc.setId_document(rst.getInt(1));
				doc.setNom(rst.getString(2));
				doc.setEmplacement(rst.getString(3));
				//doc.setDonnee(rst.getString(4));
			}
		} catch (SQLException e) {
			throw new TransportException(e.getErrorCode(),e.getMessage());
			// 5. construire l'exception DAO
			// 6. renvoyer cette exception
		} finally {
			// fermer PreparedStatement 
			if(rst!=null)
				try {
					rst.close();
					// 7. fermer la connexion
					jdbctool.quietClose(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getErrorCode(),e.getMessage());
				}
		}
		
		return doc;
	}
}
