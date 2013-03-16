package transportDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Formatter;

import com.mysql.jdbc.PreparedStatement;

import erreur.TransportException;

import modelTransport.Adresse;
import modelTransport.Transport;
import interTransport.interTransportDAO;

public class TransportDAO implements interTransportDAO{

  
	private static JdbcTools jdbctool;
	public TransportDAO(){

	}
	/**Constructeurs et methodes */
	public JdbcTools getJdbctool() {
		return jdbctool;
	}
	public void setJdbctool(JdbcTools jdbctool) {
		this.jdbctool = jdbctool;
	}
	public TransportDAO(JdbcTools jdbctool)throws TransportException{
		this.jdbctool=jdbctool;
	}
	public TransportDAO(String pilote, String url, String utilisateur, String motdepass) throws TransportException{
		jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
		try {
			jdbctool.init();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getMessage());
		}
	}
		
	/**Methode permettant d'enregister un transport
	 * @throws TransportException */
	@Override
	public void saveTransport(Transport t) throws TransportException {
		// TODO Auto-generated method stub
           try {
        	 	
            String query= "INSERT INTO transport(estimation_cout,date_depart,date_arrivee,depart, arrive,id_entreprise,type_vehicule,id_Marchandises,id_NatureMarchandises)" +
			 		"VALUES("+                     
				            "'" +t.estimation_cout+"',"+    
				            "'" +t.date_depart_prevue+"',"+
				            "'" +t.date_arrivee_prevue+"',"+
				            "'" +t.lieu_depart+"',"+
							"'" +t.lieu_arrivee+"',"+ 
				            "'" +t.idEntreprise+"',"+ 
				            "'" +t.typeVeh+"',"+ 
							"'" +t.idMarchandise+"',"+ 
							"'"  +t.idNatMarch+ "')"; 
			jdbctool.executeUpdate(query);
			
		         } catch (SQLException e) {
			   // TODO Auto-generated catch block
			    throw new TransportException(e.getErrorCode(),e.getMessage());
		    } 
		
		
	    }

	
	 /**Methode permettant de trouver un transport grace à son id*/
	
				@Override
				public Transport findTransport(int id) throws SQLException, TransportException {
					Transport t  = null;
					com.mysql.jdbc.Connection conn = null;
					PreparedStatement st  = null;	
					ResultSet result =null;
					String query="select * from transport where id_transport="+id;
					try {
						conn = jdbctool.newConnection();
						st = (PreparedStatement) conn.prepareStatement(query);
						
						result = st.executeQuery();
						
						while(result.next()){
							t = new Transport();
							t.setId(result.getInt(1));
							t.setEstimation_cout(result.getInt(2));
							t.setDate_depart_prevue(result.getDate(3));
							t.setDate_arrivee_prevue(result.getDate(4));
							t.setLieu_depart(result.getInt(5));
							t.setLieu_arrivee(result.getInt(6));
							t.setTypeVeh(result.getString(7));
							t.setIdEntreprise(result.getInt(8));
							t.setIdMarchandise(result.getString(9));
							t.setIdNatMarch(result.getInt(10));
						} 
						
						return t;
					
					  }catch (SQLException e){
						    throw new TransportException(e.getErrorCode(),e.getMessage()); 
						  }
					      finally {
							if(result!=null)
								try {
									result.close();
									jdbctool.quietClose(conn);
								    } catch (SQLException e) {
									// TODO Auto-generated catch block
									throw new TransportException(e.getErrorCode(),e.getMessage());
								   }
						        }
					
				  }
				

	/**Methode permettant d'afficher la liste de tous les transports enregistrés dans la base de données*/
	@Override
	public ArrayList<Transport> TransportListing() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Transport> listTransport = new ArrayList<Transport>();
		Connection conn = null;
		Statement stat  = null;	
		ResultSet rst =null;
		conn = jdbctool.newConnection();
        stat = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        String query ="SELECT * FROM transport ";
        ResultSet elementListe = stat.executeQuery(query);
        while (elementListe.next()) {
        	
			Transport TransFound =  new Transport (elementListe.getInt(1),
					                               elementListe.getInt(2),
					                               elementListe.getDate(3),
					                               elementListe.getDate(4),
					                               elementListe.getInt(5),
					                               elementListe.getInt(6),
					                               elementListe.getInt(7),
					                               elementListe.getString(8),
					                               elementListe.getString(9),
					                               elementListe.getInt(10));
        				
			listTransport.add(TransFound);
        };
		return listTransport;
		
	
	}
 /**Methode permettant de mettre à jour un transport*/
	@Override
	public void updateTransport(Transport t) throws SQLException, TransportException {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							                                   
				try {
					jdbctool.executeUpdate("update transport set estimation_cout=?, date_depart=?,date_arrivee=?,depart=?,arrivee=?,id_entreprise=?,type_vehicule=?,id_Marchandises=?,id=NatureMarchandises=? where id_transport=?",
							t.getEstimation_cout(),
							valueOf(formatter.format(t.getDate_depart_prevue())),
							//t.getDate_depart_prevue(),
							valueOf(formatter.format(t.getDate_depart_prevue())),
							//t.getDate_arrivee_prevue(),
							t.getLieu_depart(),
							t.getLieu_arrivee(),
							t.getIdEntreprise(),
						    t.getTypeVeh(),
							t.getIdMarchandise(),
							t.getIdNatMarch());
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getErrorCode(),e.getMessage());
				    }
			}

	
   /**Methode permettant de supprimmer tous les enregitrements de la table transport*/
	@Override
	public void DeleteAllTransports()throws SQLException, TransportException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM transport "; 
		jdbctool.executeUpdate(query);
		
	}
	/**Methode permettant de supprimmer un  enregitrement de la table transport en foction de l'id*/
	@Override
	public void DeleteOneTransport(Transport t) throws SQLException, TransportException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM transport WHERE id_transport=?";
		
		try {
			jdbctool.executeUpdate(query,t.getId());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			throw new TransportException(ex.getErrorCode(),ex.getMessage());
		}
		
	}
	 /**Methode de conversion d'une chaine de caractère au format yyyy-MM-dd  javaSqlDate */
	   private static java.sql.Date valueOf(String string) {
		// TODO Auto-generated method stub
		
		java.sql.Date javaSqlDate = java.sql.Date.valueOf(string);
		return javaSqlDate;
	      }
}
