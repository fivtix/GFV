package ihmTransport.tables;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelTransport.Horaire;
import modelTransport.Ligne_Transport;

public class tableLigneTransport extends AbstractTableModel{
	private ArrayList< Ligne_Transport>lignetransports= new ArrayList<Ligne_Transport>();
	private    final String[] entetes = {" IdTransport ","Nom l'entreprise","      Départ      ","     Arrivée    "};
	public  tableLigneTransport(final ArrayList<Ligne_Transport> lignesTransports) {
		super();
		this.lignetransports = lignesTransports;
	}
	
	public  tableLigneTransport() {
		super();
	}

	public int getRowCount() {
		return lignetransports .size();
	}


	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return lignetransports.get(rowIndex).getTransport().getId();
		case 1:
			return lignetransports.get(rowIndex).getTransport().getEnt().getNom();
		case 2:
			return lignetransports.get(rowIndex).getTransport().getDepart().getNom();
		case 3:
			return lignetransports.get(rowIndex).getTransport().getArrivee().getNom();
		default:
			return null; //Ne devrait jamais arriver
		}
	}

	public void addTransport(Ligne_Transport lignetransport) {
		lignetransports.add( lignetransport);
		fireTableRowsInserted(lignetransports.size() -1, lignetransports.size() -1);
	}
	public Ligne_Transport getTransport(int index){
		return  lignetransports.get(index);
	}
	public void removeLigne_Transport(int rowIndex) {
		lignetransports.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	public void removeAllLigne_Transport(){
		for(int i=0;i<lignetransports.size();i++){
			lignetransports.remove(i);
	    	fireTableRowsDeleted(i,i);
		}
	}


}
