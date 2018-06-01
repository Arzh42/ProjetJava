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
 * Gere l'affichage de la page de gestion des billets
 */
public class GestionBilletPage extends JPanel {
	private Fenetre mainFen;
	/**
	 * Constructeur du gestionnaire de billets
	 * @param mainFen
	 */
	public GestionBilletPage(Fenetre mainFen) {
		// Variables principales de la fenetre
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(2, 2));

		// Creation des elements de l'interface
		JButton button1 = new JButton("Nouveau Billet");
		JButton button2 = new JButton("Consultation Billet");
		JButton button3 = new JButton("Modification Billet");
		JButton button4 = new JButton("Annulation Billet");
		// Creation des Ecouteurs pour les boutons
		button1.addActionListener(new actionNouveauBilletPage());
		button2.addActionListener(new actionConsultationBillet());
		button3.addActionListener(new actionModifBillet());
		button4.addActionListener(new actionAnnulationBillet());

		// Mise en page
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
	}

	/**
	 * Permet de changer de page pour aller vers la creation de billet
	 */
	class actionNouveauBilletPage implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("NouveauBilletPage");
		}
	}

	/**
	 * Permet de changer de page pour aller vers la consultation de billet
	 */
	class actionConsultationBillet implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("ConsultationBilletPage");
		}
	}

	/**
	 * Permet de changer de page pour aller vers la modification de billet
	 */
	class actionModifBillet implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("ModifBilletPage");
		}
	}

	/**
	 * Permet de changer de page pour aller vers l'annulation de billet
	 */
	class actionAnnulationBillet implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("AnnulationBilletPage");
		}
	}
}
