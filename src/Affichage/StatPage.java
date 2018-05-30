package Affichage;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatPage extends JPanel {
	private Fenetre mainFen;
	public StatPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(2, 3));
		JLabel lbl1 = new JLabel("Nombre de billets vendus : ");
		JLabel lbl2 = new JLabel("Nombre d'itineraires differents vendus : ");
		JLabel lbl3 = new JLabel("L'itineraire le plus vendu : ");
		JLabel lbl4 = new JLabel("Recettes totales : ");
		JLabel lbl5 = new JLabel("Recettes des billets de train : ");
		JLabel lbl6 = new JLabel("Recettes des billets de bus : ");
	}
	
}
