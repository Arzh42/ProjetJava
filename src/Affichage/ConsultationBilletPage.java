package Affichage;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gestion.Billet;
import Gestion.BilletBus;
import Gestion.BilletException;
import Gestion.BilletTrain;
import Gestion.Billets;
import Gestion.ItineraireException;

public class ConsultationBilletPage extends JPanel {
	private Fenetre mainFen;
	private CardLayout layout;
	private JTextField field;
	private JLabel numero;
	private JLabel prix;
	private JLabel option1;
	private JLabel option2;
	private JLabel itineraire;
	private JLabel empty;
	private JLabel option1Text;
	private JLabel option2Text;
	/**
	 * Gère l'affichage de la page de consultation des billets
	 * @param mainFen
	 */
	public ConsultationBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		
		//La page est séparé en deux pages : une pour rechercher le billet l'autre pour afficher le résultat
		layout = new CardLayout();
		this.setLayout(layout);
		
		//askNumero est la page de saisie du numéro du billet à consulter
		JPanel askNumero = new JPanel();
		
		JLabel text = new JLabel("Numero du billet : ");
		field = new JTextField("Numéro du billet"); 
		JButton action = new JButton("Chercher");
		action.addActionListener(new chercherBillet());
		
		askNumero.setLayout(new FlowLayout());
		askNumero.add(text);
		askNumero.add(field);
		askNumero.add(action);
		
		//affNumero va afficher les informations du billet
		JPanel affNumero = new JPanel();
		affNumero.setLayout(new GridLayout(5,2));
		
		
		JLabel text1 = new JLabel("Numero : ");
		numero = new JLabel();
		JLabel text2 = new JLabel("Prix : ");
		prix = new JLabel();
		option1Text = new JLabel("Sens : ");
		option1 = new JLabel();
		option2Text = new JLabel("Classe : ");
		option2 = new JLabel();
		JLabel text3 = new JLabel("Itinéraire : ");
		itineraire = new JLabel();
		
		
		affNumero.add(text1);
		affNumero.add(numero);
		affNumero.add(text2);
		affNumero.add(prix);
		affNumero.add(option1Text);
		affNumero.add(option1);
		affNumero.add(option2Text);
		affNumero.add(option2);
		affNumero.add(text3);
		affNumero.add(itineraire);
		
		this.add(askNumero,"ask");
		this.add(affNumero, "aff");
	}
	/**
	 * Cherche un billet et appelle la fonction afficherBillet(bus ou train) avec ce billet
	 * @param numero
	 * Correspond au numéro du billet à rechercher
	 */
	public void rechercherBillet(int numero) {
		Billets billets = this.mainFen.getBillets();
		try {
			//On appelle la fonction getBillet de Billets et on gère les exceptions qu'elle peut lever
			Billet bill = billets.getBillet(numero);
			if (bill.getClass().equals(BilletTrain.class)) {
				this.afficherBilletTrain((BilletTrain) bill);
			}
			else {
				this.afficherBilletBus((BilletBus) bill);
			}
			//On change la page à afficher
			this.layout.show(this,"aff");
			
		}
		catch(BilletException e) {
			//En cas d'erreur on affiche une boite de dialogue qui donne l'erreur
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Permet d'afficher un billet de train
	 * @param billet
	 * Instance de BilletTrain représentant le billet
	 */
	public void afficherBilletTrain(BilletTrain billet) {
		numero.setText(""+billet.getNumero());
		prix.setText(""+billet.getPrix());
		option1.setText(""+billet.getSens());
		option2.setText(billet.getClasse());
		option1Text.setText("Sens : ");
		option2Text.setText("Classe : ");
		
		try {
			itineraire.setText(billet.getItineraire().getAffichage());
		} catch (ItineraireException e) {
			itineraire.setText(e.getMessage());
		}
	}
	/**
	 * Permet d'afficher un billet de bus
	 * @param billet
	 * Instance de BilletBus représentant le billet
	 */
	public void afficherBilletBus(BilletBus billet) {
		numero.setText(""+billet.getNumero());
		prix.setText(""+billet.getPrix());
		option1.setText(billet.getConfort());
		option1Text.setText("Confort : ");
		option2Text.setText("");
		try {
			itineraire.setText(billet.getItineraire().getAffichage());
		} catch (ItineraireException e) {
			itineraire.setText(e.getMessage());
		}
	}
	/**
	 * ActionListener du bouton de recherche de billet
	 */
	class chercherBillet implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			rechercherBillet(Integer.parseInt(field.getText()));
		}
	}
}
