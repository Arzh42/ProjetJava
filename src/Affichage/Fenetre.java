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
		System.out.println("coucou");
		this.billets = new Billets();
		System.out.println(billets);
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
		System.out.println(this.billets);
		return this.billets;
	}
}
