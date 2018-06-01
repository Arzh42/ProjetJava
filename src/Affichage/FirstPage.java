package Affichage;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Gere l'affichage de la page de choix entre Stat et Gestion
 */
public class FirstPage extends JPanel {

	private Fenetre mainFen;
	/**
	 * Constructeur de la premiere page
	 */
	public FirstPage(Fenetre mainFen) {
		// Mise en place de la mise en page
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(2, 1));

		// Creation des elements graphiques
		JButton button1 = new JButton("Gestion de Billet");
		button1.addActionListener(new actionGestionBilletPage());
		
		JButton button2 = new JButton("Statistiques");
		button2.addActionListener(new actionStatPage());
		
		// Mise en page
		this.add(button1);
		this.add(button2);
	}

	/**
	 * ActionListener pour le bouton de Gestion des billets
	 */
	class actionGestionBilletPage implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("GestionBilletPage");
		}
	}

	/**
	 * ActionListener pour le pour le bouton Statistiques
	 */
	class actionStatPage implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("StatPage");
		}
	}
	
	


}
