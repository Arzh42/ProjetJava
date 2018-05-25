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

import Affichage.FirstPage.actionGestionBilletPage;

/**
 * @author hugo
 *
 */
public class GestionBilletPage extends JPanel {
	private Fenetre mainFen;
	/**
	 * 
	 */
	public GestionBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(2, 2));
		JButton button1 = new JButton("Nouveau Billet");
		JButton button2 = new JButton("Consultation Billet");
		JButton button3 = new JButton("Modification Billet");
		JButton button4 = new JButton("Annulation Billet");
		button1.addActionListener(new actionNouveauBilletPage());
		button1.addActionListener(new actionConsultationBillet());
		button1.addActionListener(new actionModifBillet());
		button1.addActionListener(new actionAnnulationBillet());

		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
	}
	
	class actionNouveauBilletPage implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("NouveauBilletPage");
		}
	}
	class actionConsultationBillet implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("ConsultationBilletPage");
		}
	}
	class actionModifBillet implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("ModifBilletPage");
		}
	}
	class actionAnnulationBillet implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("AnnulationBilletPage");
		}
	}
}
