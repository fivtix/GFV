package ihmTransport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWin {

	private JFrame frmGestionnaireDeVhicule;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frmGestionnaireDeVhicule.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionnaireDeVhicule = new JFrame();
		frmGestionnaireDeVhicule.setTitle("Gestionnaire de v\u00E9hicule");
		frmGestionnaireDeVhicule.setBounds(100, 100, 900, 640);
		frmGestionnaireDeVhicule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionnaireDeVhicule.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Planification", new PlanificationPanel());
		tabbedPane.addTab("Dépôts", new Map());
		tabbedPane.addTab("Suivi", new Suivi());
		tabbedPane.addTab("Documents", new Documents());
		tabbedPane.addTab("Administration", new Administration());
		frmGestionnaireDeVhicule.getContentPane().add(tabbedPane);
		
		JMenuBar menuBar = new JMenuBar();
		frmGestionnaireDeVhicule.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmOuvrir = new JMenuItem("Ouvrir");
		mnFichier.add(mntmOuvrir);
		
		JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
		mnFichier.add(mntmEnregistrer);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnFichier.add(mntmQuitter);
		
		JMenu mnCryptage = new JMenu("Cryptage");
		menuBar.add(mnCryptage);
		
		JMenuItem mntmDsactiverCryptage = new JMenuItem("Param\u00E8tres du Cryptage");
		mntmDsactiverCryptage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Cryptage();
			}
		});
		mnCryptage.add(mntmDsactiverCryptage);
	}

}
