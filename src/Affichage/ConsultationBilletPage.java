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
	public ConsultationBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		layout = new CardLayout();
		this.setLayout(layout);
		JPanel askNumero = new JPanel();
		askNumero.setLayout(new FlowLayout());
		JLabel text = new JLabel("Numero du billet : ");
		askNumero.add(text);
		field = new JTextField("Numéro du billet"); 
		askNumero.add(field);
		JButton action = new JButton("Chercher");
		action.addActionListener(new chercherBillet());
		askNumero.add(action);
		this.add(askNumero,"ask");
		
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
		this.add(affNumero, "aff");
	}
	public void rechercherBillet(int numero) {
		Billets billets = this.mainFen.getBillets();
		try {
			Billet bill = billets.getBillet(numero);
			if (bill.getClass().equals(BilletTrain.class)) {
				this.afficherBilletTrain((BilletTrain) bill);
			}
			else {
				this.afficherBilletBus((BilletBus) bill);
			}
			this.layout.show(this,"aff");
			
		}
		catch(BilletException e) {
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
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
	class chercherBillet implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			rechercherBillet(Integer.parseInt(field.getText()));
		}
	}
}
