package Affichage;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Gestion.BilletException;
import Gestion.Billets;
import Gestion.ItineraireException;

/**
 * Gere l'affichage de la page de Statistique
 */
public class StatPage extends JPanel {
	// Variable de la page
	private Fenetre mainFen;

	// Cree toutes les variables qui peuvent chager en fonction du temps
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;

	/**
	 * Constructeur de l'interface Statistiques
	 * @param mainFen
	 */
	public StatPage(Fenetre mainFen) {
		this.mainFen = mainFen;

		// Mise en place de la mise en page
		this.setLayout(new GridLayout(6, 1));

		// Mise en place de tous les elements graphiques
		lbl1 = new JLabel("Nombre de billets vendus : ");
		lbl2 = new JLabel("Nombre d'itin�raires diff�rents vendus : ");
		lbl3 = new JLabel("L'itin�raire le plus vendu : ");
		lbl4 = new JLabel("Recettes totales : ");
		lbl5 = new JLabel("Recettes des billets de train : ");
		lbl6 = new JLabel("Recettes des billets de bus : ");
		
		// Mise en page
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
		this.add(lbl5);
		this.add(lbl6);
	}

	/**
	 * Recharge l'affichage avec les nouvelles donnees
	 * @param billets
	 */
	public void reload(Billets billets) {
		// Remplace les donnees obsoletes par les nouvelles donnees
		this.lbl1.setText("Nombre de billets vendus : "+billets.nbBillet());
		this.lbl2.setText("Nombre d'itineraire differents vendus : "+billets.itineraireDiff());
		try {
			try {
				this.lbl3.setText("L'itineraire le plus vendu : "+billets.plusVendu().getAffichage());
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
