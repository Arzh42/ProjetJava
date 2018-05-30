package Affichage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Affichage.ConsultationBilletPage.chercherBillet;
import Gestion.Billets;

public class AnnulationBilletPage extends JPanel {
	private JTextField field;
	private Fenetre mainFen;
	public AnnulationBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		this.setLayout(new FlowLayout());
		JLabel text = new JLabel("Numero du billet : ");
		this.add(text);
		field = new JTextField("Numéro du billet"); 
		this.add(field);
		JButton action = new JButton("Annuler");
		action.addActionListener(new annulerBillet());
		this.add(action);
	}
	class annulerBillet implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			supprimerBillet(Integer.parseInt(field.getText()));
		}
		
	}
	public void supprimerBillet(int numero) {
		Billets billets = this.mainFen.getBillets();
		billets.supprime(numero);
	}
	
}
