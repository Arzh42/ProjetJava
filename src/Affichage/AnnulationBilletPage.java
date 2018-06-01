package Affichage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Affichage.ConsultationBilletPage.chercherBillet;
import Gestion.BilletException;
import Gestion.Billets;
/**
 * AnnulationBilletPage gere l'affichage et le fonctionnement de la page d'annulation de billet
 */
public class AnnulationBilletPage extends JPanel {
	// Variables utiles pour gerer l'affichage
	private JTextField field;
	private Fenetre mainFen;

	// Construit la fenetre qui gere la suppression d'un billet
	public AnnulationBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		
		this.setLayout(new FlowLayout());
		
		JLabel text = new JLabel("Numero du billet : ");
		field = new JTextField("Numero du billet");
		
		JButton action = new JButton("Annuler le billet");
		action.addActionListener(new annulerBillet());
		
		this.add(text);
		this.add(field);
		this.add(action);
	}
	/**
	 * ActionListener du bouton d'annulation de billet
	 */
	class annulerBillet implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			supprimerBillet(Integer.parseInt(field.getText()));
		}
		
	}
	/**
	 * Fonction permettant de supprimer un billet selon le numero donne et d'afficher les messages de sortie a l'utilisateur
	 * @param numero
	 */
	public void supprimerBillet(int numero) {
		// On recupere la liste des billets deja crees
		Billets billets = this.mainFen.getBillets();

		try {
			billets.supprime(numero);
			// On affiche le message de resultat
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "Le billet "+numero+" a bien �t� annul�", "Annulation", JOptionPane.DEFAULT_OPTION);

			// On change de page pour revenir a la gestion de billet
			mainFen.switchPage("GestionBilletPage");

		// Si on ne peut pas supprimer le billet, on envoie un message pour dire que la suppression n'est pas effectuee
		} catch (BilletException e) {
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
