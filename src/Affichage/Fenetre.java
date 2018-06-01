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
 * Gere l'affichage global du systeme de gestion de billet
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
	Billets billets;

	/**
	 * Constructeur de la classe fenetre
	 */
	public Fenetre() {
		//On cree une barre de menu
		JMenuBar menuBar = new JMenuBar();
		JButton gestionBut = new JButton("GestionBillet");
		gestionBut.addActionListener(new retourGestion());
		JButton statBut = new JButton("Statistique");
		statBut.addActionListener(new retourStat());
		
		JLabel credit = new JLabel("Cree par Hugo Chataigner et Louis-Maxime Piton");
		
		menuBar.add(statBut);
		menuBar.add(gestionBut);
		menuBar.add(credit);
		
		//Mise en place des premiers billets
		this.billets = new Billets();
		Itineraire it = new Itineraire();
		RendezVous rd1 = new RendezVous(new Date(10, 10, 2015,10,10,0),new Ville("Brest"));
		RendezVous rd2 = new RendezVous(new Date(10, 10, 2015,10,10,0),new Ville("Troyes"));
		it.ajouterEtape(new Etape(rd1,rd2));
		this.billets.ajouterBillet(new BilletBus(10,it,"Faible"));
		this.billets.ajouterBillet(new BilletTrain(10,it,"Business",true));
		
		//Configuration de la fenetre
		this.setTitle("Gestionnaire de billets de train et de bus");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		//On prend un CardLayout car il y a plusieurs page a afficher
		this.cards = new CardLayout();
		
		//Mise en place du conteneur principal
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(this.cards);
		
		//Creation des differentes pages du systeme
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
		
		// Mettre la configuration de base
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
		case "NouveauBilletPage":
			this.NouveauBilletPage.initBillet(this.billets);
			break;
		}
	}
	
	/**
	 * Renvoie l'instance de Billets
	 * @return billets
	 */
	public Billets getBillets() {
		return this.billets;
	}

	/**
	 * ActionListener pour le bouton de retour a la page de gestion
	 */
	class retourGestion implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			switchPage("GestionBilletPage");
		}
	}

	/**
	 * ActionListener pour le bouton de retour a la page de statistique
	 *
	 */
	class retourStat implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			switchPage("StatPage");
		}
		
	}
}
