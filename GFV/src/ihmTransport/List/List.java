package ihmTransport.List;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelTransport.Item;

public class List extends JPanel{
	private  DefaultListModel model;
	private JList jlist;
	private JScrollPane scrollPane;
	public List(){
		model = new DefaultListModel();
		jlist = new JList(model);
		scrollPane = new JScrollPane(jlist);
		init();
	}
	public void init(){
		setLayout(new BorderLayout());
		ListCellRenderer renderer = new FocusedTitleListCellRenderer();
		jlist.setCellRenderer(renderer);
		add(scrollPane,BorderLayout.NORTH);
	}
	public void setPreferredSize(int w,int h){
		scrollPane.setPreferredSize(new Dimension(w,h));
	}
	public JList getJlist() {
		return jlist;
	}
	public void setJlist(JList jlist) {
		this.jlist = jlist;
	}
	public void ajouterLigne(Item item){
		model.addElement(item);
	
	}
	public DefaultListModel getModel() {
		return model;
	}
	public void setModel(DefaultListModel model) {
		this.model = model;
	}
	public void removeElement(int index){
		model.remove(index);
	}
}

class FocusedTitleListCellRenderer implements ListCellRenderer {
	protected static Border noFocusBorder = new EmptyBorder(2, 2, 2, 2);
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	public Component getListCellRendererComponent(JList list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
				isSelected, cellHasFocus);
		renderer.setBorder(cellHasFocus ? BorderFactory.createEtchedBorder() : noFocusBorder);
		return renderer;
	}

}
