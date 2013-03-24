package ihmTransport.Adresse;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelTransport.Adresse;

public class adresseJPanel extends JPanel {
private Adresse adresse;
private JTextField nomtext,nrue,rue,codepostal,ville,pays;
private Insets insets = new Insets(2, 2, 2, 2);	
public  adresseJPanel(){
	setBorder(BorderFactory.createEtchedBorder());
	setLayout(new BorderLayout());
	adresse = new Adresse();
	nomtext = new JTextField(35);
	nrue = new JTextField(10);
	rue = new JTextField(45);
	codepostal = new JTextField(10);
	ville =new JTextField(25);
	pays = new JTextField(25);
	add(adressejpanel(),BorderLayout.NORTH);
}
public void init(){
	nrue.setText("0");
	rue.setText("");
	codepostal.setText("");
	ville.setText("");
	pays.setText("");
	adresse = new Adresse();
}
public JPanel adressejpanel(){
	JPanel adressejpanel= new JPanel();
	adressejpanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
	adressejpanel.setLayout(new GridBagLayout());
	addComponent(adressejpanel, new JLabel("No rue: "),0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	addComponent(adressejpanel,nrue,1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	
	addComponent(adressejpanel,new JLabel("Rue: "),0,1, 1, 1, GridBagConstraints.WEST,GridBagConstraints.VERTICAL);
	addComponent(adressejpanel,rue,1,1, 1, 1, GridBagConstraints.WEST,GridBagConstraints.BOTH);
	
	addComponent(adressejpanel,new JLabel("Codepostal: "),0,2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	addComponent(adressejpanel, codepostal, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	
	addComponent(adressejpanel,new JLabel("Ville: "),0,3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	addComponent(adressejpanel, ville, 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	
	addComponent(adressejpanel,new JLabel("Pays: "),0,4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	addComponent(adressejpanel, pays, 1, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	return adressejpanel;
}
private  void addComponent(Container container, Component component, int gridx, int gridy,
		int gridwidth, int gridheight, int anchor, int fill) {
	GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
			anchor, fill, insets, 0, 0);
	container.add(component, gbc);
}
public Adresse getAdresse() {
	adresse.setCode_postal(codepostal.getText());
	adresse.setNom_rue(rue.getText());
	if(nrue.getText().equals(""))
		nrue.setText("0");
	adresse.setNumero_rue(Integer.parseInt(nrue.getText()));
	adresse.setVille(ville.getText());
	adresse.setPays(pays.getText());
	return adresse;
}
public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
	nrue.setText(""+adresse.getNumero_rue());
	rue.setText(adresse.getNom_rue());
	codepostal.setText(adresse.getCode_postal());
	ville.setText(adresse.getVille());
	pays.setText(adresse.getPays());
}



}
