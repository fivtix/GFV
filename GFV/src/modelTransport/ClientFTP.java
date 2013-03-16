package modelTransport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

import erreur.TransportException;

import transportDAO.DocumentDAO;



public class ClientFTP {

	private FTPClient ftp = null;
	private String hostname = "";
	private String login = "";
	private String password = "";
	
	public ClientFTP(){}
	
	public ClientFTP(String _hostname, String _login, String _password)
	{
		hostname = _hostname;
		login = _login;
		password = _password;
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean connexion()
	{
		boolean retour = false;
		
		ftp = new FTPClient();
		
		try {
			System.out.println("hostname : "+hostname);
			ftp.connect(hostname);
			retour = ftp.login(login,password);
			
			System.out.println("Connected to " + hostname + ".");
			System.out.print(ftp.getReplyString());

			int reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) 
			{
		        ftp.disconnect();
		        System.err.println("FTP server refused connection.");
		        retour = false;
		    }

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retour = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retour = false;
		}
		
		return retour;
	}
	
	/**diagramme de connexion securisee
	 *               Client                                 Server
     control          data                   data               control
   ====================================================================

                                                                socket()
                                                                bind()
     socket()
     connect()  ----------------------------------------------> accept()
               <----------------------------------------------  220
     AUTH TLS   ---------------------------------------------->
               <----------------------------------------------  234
     TLSneg()  <----------------------------------------------> TLSneg()
     PBSZ 0     ---------------------------------------------->
               <----------------------------------------------  200
     PROT P     ---------------------------------------------->
               <----------------------------------------------  200
     USER fred  ---------------------------------------------->
               <----------------------------------------------  331
     PASS pass  ---------------------------------------------->
               <----------------------------------------------  230

	 * @return
	 */
	public boolean connexionSecurise()
	{
		boolean retour = false;
		
		ftp = new FTPSClient("TLS",true);
		
		try {
			ftp.connect(hostname);
						
			System.out.println("Connected to " + hostname + ".");
			System.out.print(ftp.getReplyString());

			int reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) 
			{
		        ftp.disconnect();
		        System.err.println("FTP server refused connection.");
		        retour = false;
		    }
			else
			{
				//ftp.setAuthValue(auth);
				reply = ((FTPSClient) ftp).execAUTH("TLS-PARM");
				System.out.print(ftp.getReplyString());
				
				/**
				 * todo ! si le serveur est deja configuré en tls il renvoit alors le code 534 donc différent de
				 * isPositiveCompletion (2xx), et donc ça va disconnect :/
				 */
				/*if(!FTPReply.isPositiveCompletion(reply)) 
				{
			        ftp.disconnect();
			        System.err.println("FTP server refused connection : AUTH fail");
			        retour = false;
			    }
				else*/
				{
					((FTPSClient) ftp).execPBSZ(0);
					reply = ftp.getReplyCode();
					System.out.println(reply);
					
					if(!FTPReply.isPositiveCompletion(reply)) 
					{
						ftp.disconnect();
				        System.err.println("FTP server refused connection : PBSZ 0 fail");
				        retour = false;
					}
					else
					{
						((FTPSClient) ftp).execPROT("P");
						reply = ftp.getReplyCode();
						System.out.println(reply);
						
						if(!FTPReply.isPositiveCompletion(reply)) 
						{
							ftp.disconnect();
					        System.err.println("FTP server refused connection : PROT P fail");
					        retour = false;
						}
						else
						{
							retour = ftp.login(login, password);
						}
					}
				}
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retour = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retour = false;
		}
		
		return retour;
	}
	
	public boolean isConnected()
	{
		return ftp.isConnected();
	}
	
	public boolean deconnexion()
	{
		boolean b = false;
		
		try {
			b = ftp.logout();
			ftp.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	public boolean envoyerFichier(Document doc, boolean BinaryOrTextFile)
	{
		boolean retour = false;
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(doc.getEmplacement());
			//in = new FileInputStream("D:\\Downloads\\GitHubSetup.exe");
			if(BinaryOrTextFile) ftp.setFileType(FTPSClient.BINARY_FILE_TYPE);
			else ftp.setFileType(FTPSClient.ASCII_FILE_TYPE);
			
			//retour = ftp.storeFile(doc.getNom(), in);
			retour = ftp.storeFile("fichier_test", in);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retour = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retour = false;
		}

		return retour;
	}
	
	/*public Document recupererFichier(String nom)
	{
		public InputStream retrieveFileStream(String remote) throws IOException
	}*/
}
