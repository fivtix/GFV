package transportDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import modelTransport.Marchandise;
import modelTransport.Transport;
import erreur.TransportException;
import interTransport.interMarchandiseDAO;

public class marchandiseDAO implements interMarchandiseDAO {
  
	
	
	
	private static JdbcTools jdbctool;
	static ArrayList<Marchandise> listMarchandise = new ArrayList<Marchandise>();
	public marchandiseDAO(){

	}
	/**Constructeurs et methodes */
			public JdbcTools getJdbctool() {
				return jdbctool;
			}
			public void setJdbctool(JdbcTools jdbctool) {
				this.jdbctool = jdbctool;
			}
			public marchandiseDAO(JdbcTools jdbctool)throws TransportException{
				this.jdbctool=jdbctool;
			}
			public marchandiseDAO(String pilote, String url, String utilisateur, String motdepass) throws TransportException{
				jdbctool = new  JdbcTools(pilote,url,utilisateur,motdepass);
				try {
					jdbctool.init();
				} catch (TransportException e) {
					// TODO Auto-generated catch block
					throw new TransportException(e.getMessage());
				}
			}
		
  /**Enregistre un Marchandise dans la base de données*/
		@Override
		public void saveMarchandise(Marchandise a) throws SQLException, TransportException {
			// TODO Auto-generated method stub
			
			 try {
		        	 	    	
					jdbctool.executeUpdate("INSERT INTO Marchandises (id_Marchandises) VALUES('"+ a.getId_Marchandise()+"')");
			         } catch (SQLException e) {
				   // TODO Auto-generated catch block
				    throw new TransportException(e.getErrorCode(),e.getMessage());
			    } 
	     }
		
	 /**Renvoie la liste des tous les Marchandises de la base*/

				@Override
				public ArrayList<Marchandise> MarchandiseListing() throws SQLException,TransportException {
					
					Connection conn = null;
					Statement stat  = null;	
					ResultSet rst =null;
					conn = jdbctool.newConnection();
			        stat = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			        String query ="SELECT * FROM Marchandises ";
			        ResultSet elementListe = stat.executeQuery(query);
			        while (elementListe.next()) {
			        	
			        	Marchandise ArtFound =  new Marchandise (elementListe.getInt(1));
			        				
			        	listMarchandise.add(ArtFound);
			        };
					return listMarchandise;
					
					
				}
  
	/**Renvoie un Marchandise selon son id */
				@Override
				public Marchandise findMarchandise(int id) throws SQLException, TransportException {
					// TODO Auto-generated method stub
					Marchandise a  = null;
					com.mysql.jdbc.Connection conn = null;
					PreparedStatement st  = null;	
					ResultSet result =null;
					String query="select * from Marchandises where id_Marchandises="+id;
					try {
						conn = jdbctool.newConnection();
						st = (PreparedStatement) conn.prepareStatement(query);
						
						result = st.executeQuery();
						
						while(result.next()){
							a = new Marchandise();
							a.setId_Marchandise(result.getInt(1));
						} 
						
						return a;
					
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
					
					
	/**Met a jour les champs d' un Marchandise */
				@Override
				public void updateMarchandise(Marchandise a, int a2) throws SQLException,TransportException {
					// TODO Auto-generated method stub
					try {
						jdbctool.executeUpdate("update Marchandises set id_Marchandises=?",
								a2);
					    } 
					catch (SQLException e) {
						// TODO Auto-generated catch block
						throw new TransportException(e.getErrorCode(),e.getMessage());
					    }
				    }
					
	

    /**Supprime tous les Marchandises de la base*/
					@Override
					public void DeleteAllMarchandises() throws SQLException, TransportException {
						// TODO Auto-generated method stub
						
							// TODO Auto-generated method stub
							String query = "DELETE FROM Marchandises "; 
							jdbctool.executeUpdate(query);	
						}
						
					
     /**Supprime un Marchandises de la base*/
					@Override
					public void DeleteOneMarchandise(Marchandise a) throws SQLException,TransportException {
						// TODO Auto-generated method stub
						
							// TODO Auto-generated method stub
							String query = "DELETE FROM Marchandises WHERE id_Marchandises=?";
							
							try {
								jdbctool.executeUpdate(query,a.getId_Marchandise());
							} catch (SQLException ex) {
								// TODO Auto-generated catch block
								throw new TransportException(ex.getErrorCode(),ex.getMessage());
							}
							
						}
}
