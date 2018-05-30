package Affichage;


import java.awt.CardLayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Gestion.*;
public class Fenetre extends JFrame {
	JPanel mainPanel;
	CardLayout cards;
	StatPage StatPage = new StatPage(this);
	JPanel FirstPage = new FirstPage(this);
	JPanel GestionBilletPage = new GestionBilletPage(this);
	JPanel NouveauBilletPage = new NouveauBilletPage(this);
	JPanel ConsultationBilletPage = new ConsultationBilletPage(this);
	JPanel ModifBillet = new ModifBilletPage(this);
	JPanel AnnulationBilletPage = new AnnulationBilletPage(this);
	Billets billets = new Billets();
	public Fenetre() {
		this.billets = new Billets();
		Itineraire it = new Itineraire();
		RendezVous rd1 = new RendezVous(new Date(10, 10, 2015,10,10,0),new Ville("Brest"));
		RendezVous rd2 = new RendezVous(new Date(10, 10, 2015,10,10,0),new Ville("Mushroom kingdom"));
		it.ajouterEtape(new Etape(rd1,rd2));
		this.billets.ajouterBillet(new BilletBus(10,it,"confort"));
		this.billets.ajouterBillet(new BilletTrain(10,it,"Business",true));
		this.setTitle("Ultra Gestionnator of Train and Bus Billet");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.cards = new CardLayout();
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(this.cards);
		this.mainPanel.add(FirstPage, "FirstPage");
		this.mainPanel.add(GestionBilletPage, "GestionBilletPage");
		this.mainPanel.add(StatPage,"StatPage");
		this.mainPanel.add(NouveauBilletPage, "NouveauBilletPage");
		this.mainPanel.add(ConsultationBilletPage, "ConsultationBilletPage");
		this.mainPanel.add(ModifBillet, "ModifBilletPage");
		this.mainPanel.add(AnnulationBilletPage,"AnnulationBilletPage" );
		this.setContentPane(this.mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
	}
	public void switchPage(String page) {
		this.cards.show(this.mainPanel,page);
		switch(page) {
		case "StatPage":
			this.StatPage.reload(this.billets);
		}
	}
	public Billets getBillets() {
		return this.billets;
	}
}
