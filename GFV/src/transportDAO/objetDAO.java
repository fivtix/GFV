package transportDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import modelTransport.Adresse;
import modelTransport.Nature_Marchandise;
import erreur.TransportException;
import interTransport.interNatMarchDAO;

public class objetDAO {
 private JdbcTools jdbctool;
 public objetDAO(JdbcTools jdbctool){
	 this.jdbctool=jdbctool;
 }
	public void supprimer(Nature_Marchandise e) throws TransportException {
		// TODO Auto-generated method stub
		
	}
	public int sauvegarde(String marchandise) throws TransportException {
		// TODO Auto-generated method stub
		int lastId;
		try {
			lastId= Integer.parseInt(jdbctool.executeUpdate("insert into Marchandises(id_Marchandises) values(?)",marchandise));
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		return lastId;
	}
	public void miseAjour(Nature_Marchandise e) throws TransportException {
		// TODO Auto-generated method stub
		
	}
	public  Nature_Marchandise chercher(int id) throws TransportException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> toutMarchandise()  throws TransportException{
	ArrayList<String> marchandise = new ArrayList<String>();
	Connection conn = null;
	PreparedStatement st  = null;	
	ResultSet rst =null;
	try {
		// 1. créer une connexion
		conn = jdbctool.newConnection();
		// 2. préparer l'instruction
		st = (PreparedStatement) conn.prepareStatement("select * from Marchandises");
		rst = st.executeQuery();
		// 4. lire le résultat
		while(rst.next()){
			
			marchandise.add(rst.getString(1));
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
	return marchandise;
}
	public Collection<String> toutNatureMarchandise()throws TransportException{
	ArrayList<String> Naturemarchandise = new ArrayList<String>();
	Connection conn = null;
	PreparedStatement st  = null;	
	ResultSet rst =null;
	try {
		// 1. créer une connexion
		conn = jdbctool.newConnection();
		// 2. préparer l'instruction
		st = (PreparedStatement) conn.prepareStatement("select * from NatureMarchandises");
		rst = st.executeQuery();
		// 4. lire le résultat
		while(rst.next()){
			
			Naturemarchandise.add(rst.getString(1));
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
	return  Naturemarchandise;
}
	public Collection<String> toutTypevehicule()throws TransportException{
		ArrayList<String> type_vehicule = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement st  = null;	
		ResultSet rst =null;
		try {
			// 1. créer une connexion
			conn = jdbctool.newConnection();
			// 2. préparer l'instruction
			st = (PreparedStatement) conn.prepareStatement("select * from Type_vehicule");
			rst = st.executeQuery();
			// 4. lire le résultat
			while(rst.next()){
				
				type_vehicule.add(rst.getString(1));
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
		return  type_vehicule;
	}


}
