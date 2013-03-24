import ihmTransport.ihmTransports;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Test extends JFrame {
  JDialog d = new JDialog(this, "Dialog title", true);

  public Test() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    d.getContentPane().add(new JLabel("Click the OK button"), BorderLayout.CENTER);
    JButton closeIt = new JButton("OK");
    closeIt.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Closing dialog");
        d.dispose();
      }
    });
    d.getContentPane().add(closeIt, BorderLayout.SOUTH);
    d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    d.pack();
    getContentPane().add(new ihmTransports());
    pack();
    setSize(200, 200);
    setVisible(true);
    d.setVisible(true);
    pack();
    d.pack();
  }

  public static void main(String[] args) {
    new Test();
  }
}