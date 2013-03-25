package ihmTransport.Entreprise;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelTransport.Entreprise;
import modelTransport.Lieux;
import ihmTransport.Adresse.adresseJPanel;

public class EntrepriseJPanel extends JPanel{
 	private adresseJPanel adresseJPanel;
 	private JTextField nom;
 	private Insets insets = new Insets(2, 2, 2, 2);	
 	private JPanel controlButton;
 	private Entreprise ent;
	public EntrepriseJPanel(){
	    setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
	    setLayout(new BorderLayout());
		adresseJPanel = new adresseJPanel();
		ent=  new Entreprise();
		nom = new JTextField(20);
		add(entJPanel(),BorderLayout.NORTH);
		add(adresseJPanel,BorderLayout.CENTER);
		controlButton= new JPanel();
		controlButton.setLayout(new BorderLayout());
		add(controlButton,BorderLayout.SOUTH);
	}
	public JPanel entJPanel(){
		JPanel entJPanel = new JPanel();
		//entJPanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		entJPanel.setLayout(new GridBagLayout());
		JPanel nomjpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nomjpanel.setPreferredSize(new Dimension(350,25));
		nomjpanel.add(new JLabel(" Nom:             "));
		nomjpanel.add(nom);
		addComponent(entJPanel,nomjpanel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		return entJPanel;
	}
	public void init(){
		nom.setText("");
		adresseJPanel.init(); 
	}
	public void ajouterControlButton(Component comp){
		controlButton.removeAll();
		controlButton.add(comp,BorderLayout.NORTH);
		controlButton.validate();
		controlButton.revalidate();
	}
	private  void addComponent(Container container, Component component, int gridx, int gridy,
			int gridwidth, int gridheight, int anchor, int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
				anchor, fill, insets, 0, 0);
		container.add(component, gbc);
	}
	public Entreprise getEnt() {
		ent.setNom(nom.getText());
		ent.setAdresse(adresseJPanel.getAdresse());
		return ent;
	}
	public void setEnt(Entreprise ent) {
		this.ent = ent;
		nom.setText(ent.getNom());
		adresseJPanel.setAdresse(ent.getAdresse());
	}
	
	
	

}
