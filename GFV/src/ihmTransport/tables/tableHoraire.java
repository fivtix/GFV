package ihmTransport.tables;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelTransport.Horaire;

public class tableHoraire extends AbstractTableModel{
	private ArrayList<Horaire> horaires = new ArrayList<Horaire>();
	private    final String[] entetes = {"    Départ    ","     Arrivée    ", "   DateHeureDépart   ", "  DateHeureArrivée ", "DateHeureDépartRéelle ", "DateHeureArrivéeRéelle"};
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

	public void addTransport(Horaire horaire) {
		horaires.add(horaire);
		fireTableRowsInserted(horaires.size() -1, horaires.size() -1);
	}
	public Horaire getTransport(int index){
		return  horaires.get(index);
	}
	public void removeTransport(int rowIndex) {
		horaires.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}


}
