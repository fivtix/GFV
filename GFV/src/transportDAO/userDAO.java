package transportDAO;

import java.sql.SQLException;
import java.util.Collection;

import modelTransport.User;
import erreur.TransportException;
import interTransport.interInfos_Personnelles;
import interTransport.interUserDAO;

public class userDAO implements interUserDAO  {

	private JdbcTools jdbctool;
	private interInfos_Personnelles pDAO;
	@Override
	public void supprimer(User p) throws TransportException {
		// TODO Auto-generated method stub

	}
	@Override
	public int sauvegarde(User p) throws TransportException {
		int lastId;
		try {
			int idPersonnel=0;
			if(p.getInfop().getId()==0)
				idPersonnel=pDAO.sauvegarde(p.getInfop());
			else
				idPersonnel=p.getInfop().getId();
			lastId=jdbctool.executeUpdate("insert into Users(id_Personnel,id_users,motdepass) values(?,?,?)",idPersonnel,p.getId_users(),p.getMotdepass());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new TransportException(e.getErrorCode(),e.getMessage());
		}
		return lastId;
	}
	@Override
	public void miseAjour(User p) throws TransportException {
		// TODO Auto-generated method stub

	}
	@Override
	public User chercher(String id) throws TransportException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<User> toutUser() throws TransportException {
		// TODO Auto-generated method stub
		return null;
	}






}
