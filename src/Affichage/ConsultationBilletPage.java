package Affichage;

import java.awt.CardLayout;
import java.awt.Component;
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
import Gestion.Date;
import Gestion.Itineraire;
import Gestion.ItineraireException;

/**
 * Gère la page de consulation des billets
 */
public class ConsultationBilletPage extends JPanel {
	private Fenetre mainFen;
	int positionEtape = 0;
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
	private JButton buttonAvant;
	private JButton buttonApres;
	private JLabel lblDateArrivee;
	private JLabel lblDateDepart;
	private JLabel lblDepart;
	private JLabel lblArrivee;
	private Billet billet;
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
		affNumero.setLayout(new GridLayout(4,2));
		
		
		JLabel text1 = new JLabel("Numero : ");
		numero = new JLabel();
		JLabel text2 = new JLabel("Prix : ");
		prix = new JLabel();
		option1Text = new JLabel("Sens : ");
		option1 = new JLabel();
		option2Text = new JLabel("Classe : ");
		option2 = new JLabel();
		JLabel text3 = new JLabel("Itinéraire : ");
		JLabel empty = new JLabel();
		itineraire = new JLabel();
		buttonAvant = new JButton("Etape précédente");
		buttonAvant.addActionListener(new actionPrec());
		buttonApres = new JButton("Etape suivante");
		buttonApres.addActionListener(new actionSuiv());
		lblDateArrivee = new JLabel();
		lblDateDepart = new JLabel();
		lblDepart = new JLabel();
		lblArrivee = new JLabel();
		affNumero.add(text1);
		affNumero.add(numero);
		affNumero.add(text2);
		affNumero.add(prix);
		affNumero.add(option1Text);
		affNumero.add(option1);
		affNumero.add(option2Text);
		affNumero.add(option2);
		affNumero.add(text3);
		affNumero.add(buttonAvant);
		affNumero.add(empty);
		affNumero.add(buttonApres);
		affNumero.add(lblDateArrivee);
		affNumero.add(lblDateDepart);
		affNumero.add(lblDepart);
		affNumero.add(lblArrivee);
		
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
			this.billet = bill;
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
	public void reload() {
		this.layout.show(this, "ask");
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
		
		afficherEtape();
	}
	/**
	 * Remplie la partie Etape de l'affichage
	 * @param billet
	 */
	public void afficherEtape() {
		Itineraire it = billet.getItineraire();
		int i = this.positionEtape%it.nombreEtape();
		try {
			Date da = it.getEtape(i).getRd1().getDate();
			lblDateDepart.setText("Départ le "+da.getJour()+"/"+da.getMois()+"/"+da.getAnnee()+" à "+da.getHeure()+"h"+da.getMinute());
			Date dd = it.getEtape(i).getRd2().getDate();
			lblDateArrivee.setText("Arrivée le "+dd.getJour()+"/"+dd.getMois()+"/"+dd.getAnnee()+" à "+dd.getHeure()+"h"+dd.getMinute());
			lblDepart.setText(it.getEtape(i).getRd1().getVille().getName());
			lblArrivee.setText(it.getEtape(i).getRd2().getVille().getName());
			
		} catch (ItineraireException e) {
			
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
		afficherEtape();
	}
	/**
	 * ActionListener du bouton de recherche de billet
	 */
	class chercherBillet implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			rechercherBillet(Integer.parseInt(field.getText()));
		}
	}
	class actionSuiv implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			positionEtape ++;
			afficherEtape();
		}
	}
	class actionPrec implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			positionEtape --;
			afficherEtape();
		}
	}
}
