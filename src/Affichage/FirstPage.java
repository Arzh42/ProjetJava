/**
 * 
 */
package Affichage;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author hugo
 *
 */
public class FirstPage extends JPanel {

	private Fenetre mainFen;
	/**
	 * 
	 */
	public FirstPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(2, 1));
		JButton button1 = new JButton("Gestion de Billet");
		JButton button2 = new JButton("Fucking bitch Stat");
		button1.addActionListener(new actionGestionBilletPage());
		this.add(button1);
		this.add(button2);
	}
	class actionGestionBilletPage implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Coucou");
			mainFen.switchToGestionBillet();
			
		}
	}
	
	


}
