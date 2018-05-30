package Affichage;

import javax.swing.*;
import java.awt.GridLayout;

import Gestion.Billet;

public class NouveauBilletPage extends JPanel {
	private Billet billet;
	private Fenetre mainFen;
	
	public NouveauBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(4,6));
		JLabel label1 = new JLabel("Jour :");
		JLabel label2 = new JLabel("Mois :");
		JLabel label3 = new JLabel("Annee :");
		JLabel label4 = new JLabel("Heure :");
		JLabel label5 = new JLabel("Minute :");
		JLabel label6 = new JLabel("Depart :");
		JLabel label7 = new JLabel("Arrivee :");
		JRadioButton bus = new JRadioButton("Bus");
		JRadioButton train = new JRadioButton("Train");
		JTextField text1 = new JTextField("<Saisir le jour>");
		JTextField text2 = new JTextField("<Saisir le mois>");
		JTextField text3 = new JTextField("<Saisir l'annee>");
		JTextField text4 = new JTextField("<Saisir l'heure>");
		JTextField text5 = new JTextField("<Saisir la minute>");
		JTextField text6 = new JTextField("<Saisir la ville de depart>");
		JTextField text7 = new JTextField("<Saisir la ville d'arrivee>");
		JButton confirm = new JButton("Confirmer");
		JButton quit = new JButton("Annuler");
		
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(label3);
		this.add(text3);
		this.add(label4);
		this.add(text4);
		this.add(label5);
		this.add(text5);
		this.add(label6);
		this.add(text6);
		this.add(label7);
		this.add(text7);
		this.add(bus);
		this.add(train);
		this.add(confirm);
		this.add(quit);
		
		
	}
}
