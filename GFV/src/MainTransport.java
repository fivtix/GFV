import ihmTransport.ihmTransports;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
public class MainTransport {
	private JFrame mainFenetre;
	//start frames
	private void start() {
		mainFenetre.setVisible(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(100,200);
	}
	private void createAndShowGUI(){
		mainFenetre = new JFrame("Transport");
		mainFenetre.setBounds(32, 32, 1010,680 );
		mainFenetre.setLocationRelativeTo(null);
		mainFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane =  mainFenetre.getContentPane();
		ihmTransports ihmtransport = new ihmTransports();
		contentPane.add(ihmtransport); 
		//  ToolBarDessiner toolbardessiner = new  ToolBarDessiner(f1, editeurgraphique);
		//   toolbardessiner.setUndecorated(true);
		//     toolbardessiner.pack();
		//   toolbardessiner.setLocation((int)f1.getLocation().getX()-252,(int)f1.getLocation().getY());
		//   toolbardessiner.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainTransport mt = new MainTransport();
		mt.createAndShowGUI();
		mt.start();
	}

}
