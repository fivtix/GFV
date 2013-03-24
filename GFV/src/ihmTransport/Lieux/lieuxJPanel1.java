package ihmTransport.Lieux;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelTransport.Lieux;

import ihmTransport.Adresse.adresseJPanel;
import ihmTransport.Lieux.lieuxJpanel.ActionsControls;

public class lieuxJPanel1 extends JPanel{
 	private adresseJPanel adresseJPanel;
 	private JTextField nom;
 	private JTextArea coordonneestext;
 	private Insets insets = new Insets(2, 2, 2, 2);	
 	private JPanel controlButton;
 	private Lieux lieux;
	public  lieuxJPanel1(){
	    setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
	    setLayout(new BorderLayout());
		adresseJPanel = new adresseJPanel();
		lieux= new Lieux();
		nom = new JTextField(20);
		coordonneestext = new JTextArea();
		add(lieuxJPanel(),BorderLayout.NORTH);
		add(adresseJPanel,BorderLayout.CENTER);
		controlButton= new JPanel();
		controlButton.setLayout(new BorderLayout());
		add(controlButton,BorderLayout.SOUTH);
	}
	public JPanel lieuxJPanel(){
		JPanel lieuxJPanel = new JPanel();
		lieuxJPanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		lieuxJPanel.setLayout(new GridBagLayout());
		addComponent(lieuxJPanel,new JLabel("Nom: "), 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel,nom, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		coordonneestext.setPreferredSize(new Dimension(510,100));
		addComponent(lieuxJPanel,new JLabel("Coordonnees"), 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel, coordonneestext , 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		//addComponent(lieuxJPanel, new JLabel(""), 2, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);
		return lieuxJPanel;
	}
	public void init(){
		coordonneestext.setText("");
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
	public Lieux getLieux() {
		lieux.setNom(nom.getText());
		lieux.setCoordonnees(coordonneestext.getText());
		lieux.setAdr(adresseJPanel.getAdresse());
		return lieux;
	}
	public void setLieux(Lieux lieux) {
		this.lieux = lieux;
		nom.setText(lieux.getNom());
		coordonneestext.setText(lieux.getCoordonnees());
		adresseJPanel.setAdresse(lieux.getAdr());
	}
	

}
