package ihmTransport.Lieux;

import ihmTransport.Trajet.creerTrajet;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import erreur.TransportException;

import modelTransport.Lieux;

public class lieuxJpanel extends JPanel  {
	private JPanel lieuxJPanel;
	private JPanel buttonJPanel;
	private Insets insets = new Insets(2, 2, 2, 2);
	private creerTrajet creerTrajetJpanel;
	private Lieux lieux;
	private JTextField nomtext,nrue,rue,codepostal,ville,pays;
	private JTextArea coordonneestext;
	public lieuxJpanel(creerTrajet creerTrajetJpanel){
		lieuxJPanel = new JPanel();
		buttonJPanel= new JPanel();
		lieux = new Lieux();
		this.creerTrajetJpanel = creerTrajetJpanel;
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder());
		lieuxJPanel();
		ButtonControl();
		add(lieuxJPanel,BorderLayout.NORTH);
		add(buttonJPanel,BorderLayout.SOUTH);
	}
	public void init(){
		nomtext.setText("");
		coordonneestext.setText("")	;
		nrue.setText("0")	;
		rue.setText("");
		codepostal.setText("");
		ville.setText("");
		pays.setText("");
		lieux = new Lieux();
	}
	public void lieuxJPanel(){
		lieuxJPanel.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		lieuxJPanel.setLayout(new GridBagLayout());
		JLabel nomJLabel = new JLabel("Nom: ");
		JLabel coordonneesJLabel = new JLabel("Coordonnées: ");
		nomtext = new JTextField();
		nomtext.setPreferredSize(new Dimension(150,20));
		coordonneestext = new JTextArea();
		coordonneestext.setPreferredSize(new Dimension(300,100));
		addComponent(lieuxJPanel,nomJLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel, nomtext, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel, new JLabel(""), 2, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel, coordonneesJLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel, coordonneestext , 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponent(lieuxJPanel, new JLabel(""), 2, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH);

		JLabel nRueJLabel = new JLabel("No Rue :");
		JLabel rueJLabel = new JLabel("Rue :");
		JLabel postalJLabel = new JLabel("Code postal:");
		JLabel villeJLabel = new JLabel("Ville :");
		JLabel paysJLabel = new JLabel("Pays :"); 

		addComponent(lieuxJPanel,nRueJLabel, 0, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel,rueJLabel, 0, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel,postalJLabel, 0, 5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel,villeJLabel, 0, 6, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel,paysJLabel , 0, 7, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);

		nrue = new JTextField();
		nrue.setPreferredSize(new Dimension(80,20))	;
		rue = new JTextField();
		codepostal= new JTextField();
		codepostal.setPreferredSize(new Dimension(80,20));
		ville = new JTextField();
		ville.setPreferredSize(new Dimension(170,20))	;
		pays = new JTextField();
		pays.setPreferredSize(new Dimension(170,20));

		addComponent(lieuxJPanel, nrue, 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel,rue, 1, 4, 1, 1, GridBagConstraints.WEST,GridBagConstraints.BOTH);
		addComponent(lieuxJPanel, codepostal, 1, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel, ville, 1, 6, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		addComponent(lieuxJPanel, pays, 1, 7, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
	}
	public void ButtonControl(){
		buttonJPanel.setBorder(BorderFactory.createEtchedBorder());
		buttonJPanel.setLayout(new GridBagLayout());
		JButton annuler = new JButton(" Annuler ");
		annuler.addActionListener(new ActionsControls("annuler"));
		addComponent(buttonJPanel,annuler, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.VERTICAL);
		JButton enregistrer = new JButton(" Enregistrer ");
		enregistrer.addActionListener(new  ActionsControls("engeristrer"));
		addComponent(buttonJPanel,enregistrer, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.VERTICAL);
	}

	private  void addComponent(Container container, Component component, int gridx, int gridy,
			int gridwidth, int gridheight, int anchor, int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
				anchor, fill, insets, 0, 0);
		container.add(component, gbc);
	}
	public Lieux getLieux() {
		return lieux;
	}
	public void setLieux(Lieux lieux) {
		nomtext.setText(lieux.getNom());
		coordonneestext.setText(lieux.getCoordonnees())	;
		nrue.setText(""+lieux.getAdr().getNumero_rue())	;
		rue.setText(lieux.getAdr().getNom_rue());
		codepostal.setText(lieux.getAdr().getCode_postal());
		ville.setText(lieux.getAdr().getVille());
		pays.setText(lieux.getAdr().getPays());
		this.lieux = lieux;
	}
	class  ActionsControls implements ActionListener{
		private String nom;
		
		public ActionsControls(String nomAction){
			nom=nomAction;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(nom.equals("annuler")){
				init();
				creerTrajetJpanel.CreerTrajet();
			}
			else if(nom.equals("engeristrer")){
				lieux.setNom(nomtext.getText());
				lieux.setCoordonnees(coordonneestext.getText());
				lieux.getAdr().setNumero_rue(Integer.parseInt(nrue.getText().trim()));
				lieux.getAdr().setNom_rue(rue.getText());
				lieux.getAdr().setCode_postal(codepostal.getText().trim());
				lieux.getAdr().setVille(ville.getText());
				lieux.getAdr().setPays(pays.getText());
				try {
					creerTrajetJpanel.setLieux(lieux);
				} catch (TransportException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				creerTrajetJpanel.CreerTrajet();
				
			}
				
				
		}

	}
}

