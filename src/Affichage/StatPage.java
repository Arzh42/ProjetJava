package Affichage;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Gestion.BilletException;
import Gestion.Billets;
import Gestion.ItineraireException;

public class StatPage extends JPanel {
	private Fenetre mainFen;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	public StatPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		Billets billets = this.mainFen.getBillets();
		System.out.println(billets);
		this.setLayout(new GridLayout(3, 2));
		lbl1 = new JLabel("Nombre de billets vendus : ");
		lbl2 = new JLabel("Nombre d'itinéraires différents vendus : ");
		lbl3 = new JLabel("L'itinéraire le plus vendu : ");
		lbl4 = new JLabel("Recettes totales : ");
		lbl5 = new JLabel("Recettes des billets de train : ");
		lbl6 = new JLabel("Recettes des billets de bus : ");
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
		this.add(lbl5);
		this.add(lbl6);
	}
	public void reload(Billets billets) {
		this.lbl1.setText("Nombre de billets vendus : "+billets.nbBillet());
		this.lbl2.setText("Nombre d'itinéraire différents vendus : "+billets.itineraireDiff());
		try {
			try {
				this.lbl3.setText("L'itinéraire le plus vendu : "+billets.plusVendu().getAffichage());
			}
			catch(BilletException e) {
				this.lbl3.setText(e.getMessage());
			}
		}
		catch(ItineraireException e) {
			this.lbl3.setText(e.getMessage());
		}
		this.lbl4.setText("Recettes totales : "+billets.recette());
		this.lbl5.setText("Recettes des billets de train : "+billets.recetteTrain());
		this.lbl6.setText("Recette des billets de bus : "+billets.recetteBus());
	}
}
