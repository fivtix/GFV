package ihmTransport.tables;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelTransport.Transport;

public class modeltableTransports extends AbstractTableModel{
	private ArrayList<Transport> transports = new ArrayList<Transport>();
	private    final String[] entetes = {"id","Etreprise", "Lieuxdépart", "Arrivée", "Datedépart", "Datearrivée"};
	public  modeltableTransports(final ArrayList<Transport> transports) {
		super();
		this.transports = transports;
	}

	public  modeltableTransports() {
		super();
	}

	public int getRowCount() {
		return transports .size();
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
			return transports.get(rowIndex).getId();
		case 1:
			return transports.get(rowIndex).getEnt().getNom();
		case 2:
			return transports.get(rowIndex).getDepart().getNom();
		case 3:
			return transports.get(rowIndex).getArrivee().getNom();
		case 4:
			return transports.get(rowIndex).getDateDepart();
		case 5:
			return transports.get(rowIndex).getDateArrivee();
		default:
			return null; //Ne devrait jamais arriver
		}
	}

	public void addTransport(Transport transport) {
		transports.add(transport);
		fireTableRowsInserted(transports.size() -1, transports.size() -1);
	}
	public Transport getTransport(int index){
		return  transports.get(index);
	}
	public void removeTransport(int rowIndex) {
		transports.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}


}
