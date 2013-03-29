package ihmTransport.tables;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelTransport.Horaire;

public class tableHoraire extends AbstractTableModel{
	private ArrayList<Horaire> horaires = new ArrayList<Horaire>();
	private    final String[] entetes = {"    D�part    ","     Arriv�e    ", "   DateHeureD�part   ", "  DateHeureArriv�e ", "DateHeureD�partR�elle ", "DateHeureArriv�eR�elle"};
	public  tableHoraire(final ArrayList<Horaire> horaires) {
		super();
		this.horaires = horaires;
	}
	
	public  tableHoraire() {
		super();
	}

	public int getRowCount() {
		return horaires .size();
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
			return horaires.get(rowIndex).getLieuxDepart().getNom();
		case 1:
			return horaires.get(rowIndex).getLieuxArrivee().getNom();
		case 2:
			return horaires.get(rowIndex).getDate_heure_depart();
		case 3:
			return horaires.get(rowIndex).getDate_heure_arrive();
		case 4:
			return horaires.get(rowIndex).getDate_heure_depart_reelle();
		case 5:
			return horaires.get(rowIndex).getDate_heure_arrivee_reelle();
		default:
			return null; //Ne devrait jamais arriver
		}
	}
	public void setValueAt(Object value, int row, int col) {
		Horaire h =horaires.get(row);	
		if(col==2)
			h.setDate_heure_depart((String) value);
		else if (col==3)
			h.setDate_heure_arrive((String) value);
		else if(col==4)
			h.setDate_heure_depart_reelle((String) value);
		else if (col==5)
			h.setDate_heure_arrivee_reelle((String) value);
		horaires.set(row, h);
	    fireTableCellUpdated(row,col);
	}
	
	public void addHorraire(Horaire horaire) {
		horaires.add(horaire);
		fireTableRowsInserted(horaires.size() -1, horaires.size() -1);
	}
	 public boolean isCellEditable(int row, int column) {
		
		 return (column > 1);
		  }
	

	public ArrayList<Horaire> getHoraires() {
		return horaires;
	}

	public void setHoraires(ArrayList<Horaire> horaires) {
		this.horaires = horaires;
	}

	public Horaire getHorraire(int index){
		return  horaires.get(index);
	}
	public void removeHoraire(int rowIndex) {
		horaires.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	public void removeAllhoraires(){
		for(int i=0;i<horaires.size();i++){
			horaires.remove(i);
	    	fireTableRowsDeleted(i,i);
		}
	}
	
}
