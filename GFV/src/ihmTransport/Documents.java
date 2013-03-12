package ihmTransport;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Dimension;

public class Documents extends JPanel {

	/**
	 * Create the panel.
	 */
	public Documents() {
		setPreferredSize(new Dimension(700, 300));
		setMinimumSize(new Dimension(700, 300));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_lblImprimerLeDocument.insets = new Insets(0, 0, 5, 0);
		gbc_lblImprimerLeDocument.gridx = 6;
		gbc_lblImprimerLeDocument.gridy = 1;
		add(lblImprimerLeDocument, gbc_lblImprimerLeDocument);
		
		JButton btnImprimer = new JButton("Imprimer");
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.anchor = GridBagConstraints.EAST;
		gbc_btnImprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnImprimer.gridx = 6;
		gbc_btnImprimer.gridy = 2;
		add(btnImprimer, gbc_btnImprimer);
		
		JList listDoc = new JList();
		GridBagConstraints gbc_listDoc = new GridBagConstraints();
		gbc_listDoc.gridheight = 4;
		gbc_listDoc.insets = new Insets(0, 0, 0, 5);
		gbc_listDoc.gridwidth = 4;
		gbc_listDoc.fill = GridBagConstraints.BOTH;
		gbc_listDoc.gridx = 1;
		gbc_listDoc.gridy = 3;
		add(listDoc, gbc_listDoc);
		
		JLabel lblNumriserUnDocument = new JLabel("Num\u00E9riser un document :");
		GridBagConstraints gbc_lblNumriserUnDocument = new GridBagConstraints();
		gbc_lblNumriserUnDocument.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumriserUnDocument.anchor = GridBagConstraints.EAST;
		gbc_lblNumriserUnDocument.gridx = 6;
		gbc_lblNumriserUnDocument.gridy = 4;
		add(lblNumriserUnDocument, gbc_lblNumriserUnDocument);
		
		JButton btnNumriser = new JButton("Num\u00E9riser");
		GridBagConstraints gbc_btnNumriser = new GridBagConstraints();
		gbc_btnNumriser.anchor = GridBagConstraints.EAST;
		gbc_btnNumriser.gridx = 6;
		gbc_btnNumriser.gridy = 5;
		add(btnNumriser, gbc_btnNumriser);

	}

}
