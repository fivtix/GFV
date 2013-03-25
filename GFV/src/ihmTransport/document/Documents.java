package ihmTransport.document;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JButton;

import modelTransport.Document;
import modelTransport.Transport;

import erreur.TransportException;

import transportDAO.DocumentDAO;
import transportDAO.JdbcTools;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Documents extends JPanel {

	private JList listDoc = null;
	private DefaultListModel dlm = null;
	private DocumentDAO docDAO = null;
	
	private JLabel lblNewLabel = null;
	
	/**
	 * Create the panel.
	 */
	public Documents(JdbcTools jdbctool) {
		try {
			docDAO = new DocumentDAO(jdbctool);
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setPreferredSize(new Dimension(700, 360));
		setMinimumSize(new Dimension(700, 300));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {30, 0, 0, 30, 0, 0, 30, 30, 0, 30, 0, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblGestionDesDocuments = new JLabel("Gestion des documents :");
		GridBagConstraints gbc_lblGestionDesDocuments = new GridBagConstraints();
		gbc_lblGestionDesDocuments.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionDesDocuments.gridx = 1;
		gbc_lblGestionDesDocuments.gridy = 1;
		add(lblGestionDesDocuments, gbc_lblGestionDesDocuments);
		
		JLabel lblImprimerLeDocument = new JLabel("Imprimer le document s\u00E9lectionn\u00E9 :");
		GridBagConstraints gbc_lblImprimerLeDocument = new GridBagConstraints();
		gbc_lblImprimerLeDocument.anchor = GridBagConstraints.EAST;
		gbc_lblImprimerLeDocument.insets = new Insets(0, 0, 5, 5);
		gbc_lblImprimerLeDocument.gridx = 6;
		gbc_lblImprimerLeDocument.gridy = 1;
		add(lblImprimerLeDocument, gbc_lblImprimerLeDocument);
		/*****************/
		lblNewLabel = new JLabel("Pas d'op\u00E9rations en cours");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 8;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnImprimer = new JButton("Imprimer");
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.anchor = GridBagConstraints.EAST;
		gbc_btnImprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnImprimer.gridx = 6;
		gbc_btnImprimer.gridy = 2;
		add(btnImprimer, gbc_btnImprimer);
		
		dlm = new DefaultListModel();
		listDoc = new JList(dlm);
		GridBagConstraints gbc_listDoc = new GridBagConstraints();
		gbc_listDoc.gridheight = 6;
		gbc_listDoc.insets = new Insets(0, 0, 5, 5);
		gbc_listDoc.gridwidth = 4;
		gbc_listDoc.fill = GridBagConstraints.BOTH;
		gbc_listDoc.gridx = 1;
		gbc_listDoc.gridy = 3;
		add(listDoc, gbc_listDoc);
		
		JLabel lblNumriserUnDocument = new JLabel("Num\u00E9riser et envoyer un document :");
		GridBagConstraints gbc_lblNumriserUnDocument = new GridBagConstraints();
		gbc_lblNumriserUnDocument.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumriserUnDocument.anchor = GridBagConstraints.EAST;
		gbc_lblNumriserUnDocument.gridx = 6;
		gbc_lblNumriserUnDocument.gridy = 4;
		add(lblNumriserUnDocument, gbc_lblNumriserUnDocument);
		
		JButton btnNumriser = new JButton("Num\u00E9riser");
		GridBagConstraints gbc_btnNumriser = new GridBagConstraints();
		gbc_btnNumriser.insets = new Insets(0, 0, 5, 5);
		gbc_btnNumriser.anchor = GridBagConstraints.EAST;
		gbc_btnNumriser.gridx = 6;
		gbc_btnNumriser.gridy = 5;
		add(btnNumriser, gbc_btnNumriser);
		/*****************/
		JButton btnMiseJour = new JButton("Mise \u00E0 jour de la liste");
		btnMiseJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miseAJourListeDocument();
			}
		});
		/*****************/
		JLabel lblEnvoyerUnDocument = new JLabel("Envoyer un document :");
		GridBagConstraints gbc_lblEnvoyerUnDocument = new GridBagConstraints();
		gbc_lblEnvoyerUnDocument.anchor = GridBagConstraints.WEST;
		gbc_lblEnvoyerUnDocument.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnvoyerUnDocument.gridx = 6;
		gbc_lblEnvoyerUnDocument.gridy = 7;
		add(lblEnvoyerUnDocument, gbc_lblEnvoyerUnDocument);
		/*****************/
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				envoyerFichier();
			}
		});
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.anchor = GridBagConstraints.EAST;
		gbc_btnEnvoyer.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnvoyer.gridx = 6;
		gbc_btnEnvoyer.gridy = 8;
		add(btnEnvoyer, gbc_btnEnvoyer);
		GridBagConstraints gbc_btnMiseJour = new GridBagConstraints();
		gbc_btnMiseJour.gridwidth = 4;
		gbc_btnMiseJour.insets = new Insets(0, 0, 5, 5);
		gbc_btnMiseJour.gridx = 1;
		gbc_btnMiseJour.gridy = 10;
		add(btnMiseJour, gbc_btnMiseJour);
		/*****************/
		JButton btnTlchargerLeDocument = new JButton("T\u00E9l\u00E9charger le document");
		btnTlchargerLeDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telechargerDocument();
			}
		});
		GridBagConstraints gbc_btnTlchargerLeDocument = new GridBagConstraints();
		gbc_btnTlchargerLeDocument.insets = new Insets(0, 0, 5, 5);
		gbc_btnTlchargerLeDocument.gridx = 6;
		gbc_btnTlchargerLeDocument.gridy = 10;
		add(btnTlchargerLeDocument, gbc_btnTlchargerLeDocument);
	}
	
	/**
	 * fonction appelée lors de la demande de rafraichissement de la liste des documents
	 */
	public void miseAJourListeDocument()
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				System.out.println("mise a jour document gui");
				lblNewLabel.setText("mise a jour de la liste des documents en cours ...");
				
				if(docDAO != null)
				{
					ArrayList<Document> lDoc;
					try {
						lDoc = (ArrayList<Document>) docDAO.telechargerListeDoc();
						dlm.clear();
						
						for(Document i : lDoc) 
						{
							dlm.addElement((String)(Integer.toString(i.getId_document()) +": " +i.getNom()));
						}
						
						System.out.println("mise a jour liste document gui ok");
						lblNewLabel.setText("mise a jour de la liste des documents effectuée");
					} catch (TransportException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}).start(); 
	}
	
	/**
	 * méthode appelée lors du clique sur le bouton envoyer.
	 * elle permet d'enregistrer un document deja présent localement dans la bdd et de l'envoyer sur le serveur ftp
	 */
	public void envoyerFichier()
	{
		JFileChooser fc = new JFileChooser();
		Document doc = new Document();
		FileInputStream fis = null;
		
		fc.setDialogTitle("Sélectionnez un fichier à envoyer");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setMultiSelectionEnabled(false);
		
		int returnVal = fc.showDialog(this, "Envoyer");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	try {
				fis = new FileInputStream(fc.getSelectedFile());
				doc.setDonnee(fis);
				doc.setEmplacement(fc.getSelectedFile().getAbsolutePath());
				doc.setNom(fc.getSelectedFile().getName());
			
				docDAO.sendToBDD(doc);
				//docDAO.sendToFTP(...);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	/**
	 * 
	 */
	public void telechargerDocument()
	{
		int id_doc = Integer.parseInt(((String)listDoc.getSelectedValue()).split(":")[0]);
		
		JFileChooser fc = new JFileChooser();
		Document doc = new Document();
		
		fc.setDialogTitle("Sélectionnez un emplacement où enregistrer le fichier");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setMultiSelectionEnabled(false);
		
		int returnVal = fc.showDialog(this, "Enregistrer");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	try {
				Document d = docDAO.chercher(id_doc);
				/*byte[] tabByte = new byte[doc.getDonnee().available()];
				doc.getDonnee().read(tabByte);
				File f = fc.getSelectedFile();
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(tabByte);
				doc.getDonnee().close();
				fos.close();*/
			} catch (TransportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
