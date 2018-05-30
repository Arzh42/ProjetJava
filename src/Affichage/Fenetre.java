package Affichage;


import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Gestion.*;
/**
 * Gère l'affichage global du système de gestion de billet
 */
public class Fenetre extends JFrame {
	JPanel mainPanel;
	CardLayout cards;
	StatPage StatPage = new StatPage(this);
	FirstPage FirstPage = new FirstPage(this);
	GestionBilletPage GestionBilletPage = new GestionBilletPage(this);
	NouveauBilletPage NouveauBilletPage = new NouveauBilletPage(this);
	ConsultationBilletPage ConsultationBilletPage = new ConsultationBilletPage(this);
	ModifBilletPage ModifBillet = new ModifBilletPage(this);
	AnnulationBilletPage AnnulationBilletPage = new AnnulationBilletPage(this);
	Billets billets = new Billets();

	public Fenetre() {
		//On créé une barre de menu
		JMenuBar menuBar = new JMenuBar();
		
		JButton gestionBut = new JButton("GestionBillet");
		gestionBut.addActionListener(new retourGestion());
		
		JButton statBut = new JButton("Statistique");
		statBut.addActionListener(new retourStat());
		
		JLabel credit = new JLabel("Créé par Hugo Chataigner et Loulou Piton");
		
		menuBar.add(statBut);
		menuBar.add(gestionBut);
		menuBar.add(credit);
		
		//Mise en place des premiers billets
		this.billets = new Billets();
		Itineraire it = new Itineraire();
		RendezVous rd1 = new RendezVous(new Date(10, 10, 2015,10,10,0),new Ville("Brest"));
		RendezVous rd2 = new RendezVous(new Date(10, 10, 2015,10,10,0),new Ville("Mushroom kingdom"));
		it.ajouterEtape(new Etape(rd1,rd2));
		this.billets.ajouterBillet(new BilletBus(10,it,"confort"));
		this.billets.ajouterBillet(new BilletTrain(10,it,"Business",true));
		
		//Configuration de la fenêtre
		this.setTitle("Ultra Gestionnator of Train and Bus Billet");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		
		//On prend un CardLayout car il y a plusieurs page à afficher
		this.cards = new CardLayout();
		
		//Mise en place du conteneur principal
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(this.cards);
		
		//Création des différentes pages du système
		this.mainPanel.add(FirstPage, "FirstPage");
		this.mainPanel.add(GestionBilletPage, "GestionBilletPage");
		this.mainPanel.add(StatPage,"StatPage");
		this.mainPanel.add(NouveauBilletPage, "NouveauBilletPage");
		this.mainPanel.add(ConsultationBilletPage, "ConsultationBilletPage");
		this.mainPanel.add(ModifBillet, "ModifBilletPage");
		this.mainPanel.add(AnnulationBilletPage,"AnnulationBilletPage" );
		
		//Mise en place du menu et du conteneur principal
		this.getContentPane().add(menuBar,BorderLayout.NORTH);
		this.getContentPane().add(this.mainPanel,BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
	}
	/**
	 * Permet de passer de page en page en donnant le nom de la page
	 * @param page
	 */
	public void switchPage(String page) {
		this.cards.show(this.mainPanel,page);
		switch(page) {
		case "StatPage":
			this.StatPage.reload(this.billets);
			break;
		case "ConsultationBilletPage":
			this.ConsultationBilletPage.reload();
			break;
		}
	}
	
	/**
	 * Renvoie l'instance de Billets
	 * @return
	 */
	public Billets getBillets() {
		return this.billets;
	}
	/**
	 * ActionListener pour le bouton de retour à la page de gestion 
	 *
	 */
	class retourGestion implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			switchPage("GestionBilletPage");
		}
		
	}
	/**
	 * ActionListener pour le bouton de retour à la page de statistique
	 *
	 */
	class retourStat implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			switchPage("StatPage");
		}
		
	}
}
