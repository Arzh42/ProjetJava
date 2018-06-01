package Affichage;

import javax.swing.*;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Gestion.Billet;
import Gestion.BilletBus;
import Gestion.BilletTrain;
import Gestion.Billets;
import Gestion.Date;
import Gestion.Etape;
import Gestion.Itineraire;
import Gestion.RendezVous;
import Gestion.Ville;

public class NouveauBilletPage extends JPanel {
	// Declaration des variables utiles
	private Billets billets;
	private Fenetre mainFen;
	
	// Declaration de tableau de string pour faciliter l'interface pour l'utilisateur
	private String[] Jours = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String[] Mois = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
	private String[] Annees = {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
	private String[] Heures = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	private String[] Minutes = {"00","05","10","15","20","25","30","35","40","45","50","55"};
	
	// Declaration des ComboBox utiles pour la mise en place d'un nouveau billet
	private JComboBox cb1;
	private JComboBox cb2;
	private JComboBox cb3;
	private JComboBox cb4;
	private JComboBox cb5;
	
	// Declaration des interfaces pour rentrer les villes 
	private JTextField text1;
	private JTextField text2;
	
	// Variables utiles dans differentes sous-classes
	private JPanel pane1;
	private JPanel pane2;
	private String confort;
	private String classe;
	private boolean sens;
	private JComboBox Sens;
	private JComboBox Clas;
	private JComboBox Conf;
	
	// Variables pour les chois principaux des utilisateurs
	private boolean BT;
	private JPanel mainPane;
	private CardLayout cards;
	private Itineraire it;



	/**
	 * Contructeur de Billet
	 */
	public NouveauBilletPage(Fenetre mainFen) {
		// Pour rester sur la meme fenetre
		this.mainFen = mainFen;
		// Utile pour l'interface utilisateur
		this.setLayout(new GridLayout(5,5));
		
		// Initialise l'itineraire prit par l'utilisateur
		it = new Itineraire();

		// Utile pour cacher l'interface Bus ou Train selon le choix de l'utilisateur
		this.cards = new CardLayout();
		this.mainPane = new JPanel();
		this.mainPane.setLayout(this.cards);
		
		// Tous les labels utiles pour l'interface
		JLabel label1 = new JLabel("Jour :");
		JLabel label2 = new JLabel("Mois :");
		JLabel label3 = new JLabel("Annee :");
		JLabel label4 = new JLabel("Heure :");
		JLabel label5 = new JLabel("Minute :");
		JLabel label6 = new JLabel("Depart :");
		JLabel label7 = new JLabel("Arrivee :");
		JLabel label8 = new JLabel("Confort :");
		JLabel label9 = new JLabel("Classe :");
		JLabel label10 = new JLabel("Sens :");
		
		// Initialisation de l'interface specifique Bus
		this.pane1 = new JPanel();
		String[] confortTab = {"Faible","Moyen","Haut"};
		Conf = new JComboBox<Object>(confortTab);
		this.pane1.add(label8);
		this.pane1.add(Conf);
		
		// Initialisation de l'interface specifique Train
		this.pane2 = new JPanel();
		String[] klasse = {"1","2","Business"};
		String[] cens = {"Vers l'avant","Vers l'arriere"};
		Clas = new JComboBox(klasse);
		Sens = new JComboBox(cens);
		this.pane2.add(label9);
		this.pane2.add(Clas);
		this.pane2.add(label10);
		this.pane2.add(Sens);
		
		// Ajout dans le Panel que l'on montre/cache
		this.mainPane.add(pane1, "Bus");
		this.mainPane.add(pane2, "Train");
		
			
		// Initialisation des Boutons, des champs de saisie et des ComboBoxs 
		JRadioButton bus = new JRadioButton("Bus");
		JRadioButton train = new JRadioButton("Train");
		cb1 = new JComboBox(Jours);
		cb2 = new JComboBox(Mois);
		cb3 = new JComboBox(Annees);
		cb4 = new JComboBox(Heures);
		cb5 = new JComboBox(Minutes);
		text1 = new JTextField("<Saisir la ville de depart>");
		text2 = new JTextField("<Saisir la ville d'arrivee>");
		// Pour confirmer un voyage avec la derniere etape
		JButton confirm = new JButton("Confirmer");
		// Pour revenir a la gestion de billet
		JButton quit = new JButton("Annuler");
		// Pour ajouter une etape a l'itineraire de l'utilisateur
		JButton addEtape = new JButton("Ajouter l'etape");
		
		// On met des Ecouteurs sur les boutons pour qu'ils aient l'action definie par le bouton
		addEtape.addActionListener(new actionEtape());
		confirm.addActionListener(new actionConfirm());
		quit.addActionListener(new actionQuit());
		bus.addActionListener(new actionBus());
		train.addActionListener(new actionTrain());
		
		// On fait un groupe de bouton pour eviter que Bus et Train soient coches en meme temps 
		ButtonGroup choix = new ButtonGroup();
		choix.add(bus);
		choix.add(train);
		
		// On travaille ici par colonne, La premiere et deuxieme sont destinees a la saisie de la date
		// La troisieme et la quatrieme sont partagees entre la saisie des villes de depart et d'arrivee, et le chois entre train et bus
		// La derniere colonne est elle reservee pour les boutons principaux.
		this.add(label1);
		this.add(cb1);
		this.add(new JLabel());
		this.add(addEtape);
		this.add(confirm);
		
		this.add(label2);
		this.add(cb2);
		this.add(bus);
		this.add(new JLabel());
		this.add(quit);
		
		this.add(label3);
		this.add(cb3);
		this.add(train);
		this.add(mainPane);
		this.add(new JLabel());
		
		this.add(label4);
		this.add(cb4);
		this.add(label6);
		this.add(text1);
		this.add(new JLabel());
		
		this.add(label5);
		this.add(cb5);
		this.add(label7);
		this.add(text2);
		this.add(new JLabel());
	}
	
	public void initBillet(Billets billets){
		this.billets = billets;
	}
	
	/**
	 * Ajoute une etape a l'itineraire commence
	 */
	class actionEtape implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			// Permet de remplir la date d'arrivee aleatoirement, ainsi qu'un prix aleatoire
			Random r = new Random();
			
			// Reception des informations pour creer une nouvelle etape sur le parcours
			int jour = cb1.getSelectedIndex()+1;
			int mois = cb2.getSelectedIndex()+1;
			int annee = cb3.getSelectedIndex()+2015;
			int heure = cb4.getSelectedIndex();
			int minute = cb5.getSelectedIndex()*5;
			// Rentree automatique de la date d'arrivee
			int minute2 = minute;
			int heure2 = heure+r.nextInt(24);
			int jour2 = 0;
			int mois2 = 0;
			int annee2 = 0;
			// Pour eviter qu'on se retrouve avec des mois de plus de 31 jours
			if(heure2 >= 24){
				heure2 = heure2 % 24;
				jour2 = jour + 1 + r.nextInt(2);
				if(jour2 >= 32){
					jour2 = jour2 % 32;
					mois2 = mois + 1;
					if(mois2 >= 13){
						mois2 = 1;
						annee2 = annee + 1;
					}
				} else {
					mois2 = mois;
					annee2 = annee;
				}
			} else {
				jour2 = jour + r.nextInt(2);
				if(jour2 >= 32){
					mois2 = mois + 1;
					jour2 = jour2 % 32;
					if(mois2 >= 13){
						mois2 = 1;
						annee2 = annee + 1;
					}
				} else {
					mois2 = mois;
					annee2 = annee;
				}
			}
			
			// Reception des donnees pour les villes et rentree des donnees pour la date
			Date date1 = new Date(jour, mois, annee, heure, minute, 0);
			Ville ville1 = new Ville(text1.getText());
			Date date2 = new Date(jour2, mois2, annee2, heure2, minute2, 0);
			Ville ville2 = new Ville(text2.getText());
			
			// On rentre les rendez-vous crees par ces informations
			RendezVous rd1 = new RendezVous(date1,ville1);
			RendezVous rd2 = new RendezVous(date2,ville2);
			// On ajoute l'etape a l'itineraire en cours
			Etape etape1 = new Etape(rd1,rd2);
			it.ajouterEtape(etape1);
			
			// On preconfigure le depart de la prochaine etape, pour faciliter la rentree d'un itineraire long
			cb1.setSelectedIndex(jour2-1);	
			cb2.setSelectedIndex(mois2-1);
			cb3.setSelectedIndex(annee2-2015);
			cb4.setSelectedIndex(heure2);
			cb5.setSelectedIndex(minute2/5);
			text1.setText(ville2.getName());
			text2.setText("<Entrez la ville d'arrivee>");
			
			// Permet de s'assurer de la rentree d'une etape
			JOptionPane Validation = new JOptionPane();
			Validation.showMessageDialog(null,"Etape ajoutee au voyage !","Validation etape",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	/** 
	 * Permet de confirmer un itineraire pour recevoir le billet
	 */
	class actionConfirm implements ActionListener {
		public void actionPerformed(ActionEvent arg0){

			Random r = new Random();
			
			int jour = cb1.getSelectedIndex()+1;
			int mois = cb2.getSelectedIndex()+1;
			int annee = cb3.getSelectedIndex()+2015;
			int heure = cb4.getSelectedIndex();
			int minute = cb5.getSelectedIndex()*5;
			int minute2 = minute;
			int heure2 = heure+r.nextInt(24);
			int jour2 = 0;
			int mois2 = 0;
			int annee2 = 0;
			if(heure2 >= 24){
				heure2 = heure2 % 24;
				jour2 = jour + 1 + r.nextInt(2);
				if(jour2 >= 32){
					mois2 = mois + 1;
					if(mois2 >= 13){
						mois2 = 1;
						annee2 = annee + 1;
					}
				} else {
					mois2 = mois;
					annee2 = annee;
				}
			} else {
				jour2 = jour + r.nextInt(2);
				if(jour2 >= 32){
					mois2 = mois + 1;
					if(mois2 >= 13){
						mois2 = 1;
						annee2 = annee + 1;
					}
				} else {
					mois2 = mois;
					annee2 = annee;
				}
			}
			
			Date date1 = new Date(jour, mois, annee, heure, minute, 0);
			Ville ville1 = new Ville(text1.getText());
			Date date2 = new Date(jour2, mois2, annee2, heure2, minute2, 0);
			Ville ville2 = new Ville(text2.getText());
			
			RendezVous rd1 = new RendezVous(date1,ville1);
			RendezVous rd2 = new RendezVous(date2,ville2);
			Etape etape1 = new Etape(rd1,rd2);
			it.ajouterEtape(etape1);

			
			// On teste si l'utilisateur veut un billet de train ou de bus
			if(BT){
				// Recuperation des informations relatives au train
				classe = Clas.getSelectedItem().toString();
				if(Sens.getSelectedIndex() == 0){
					sens = true;
				} else {
					sens = false;
				}
				// On ajoute un nouveau billet de train avec prix aleatoire
				BilletTrain newBillet = new BilletTrain(60 + r.nextInt(it.nombreEtape()*50), it, classe, sens);
				billets.ajouterBillet(newBillet);
				
				// Pour etre sur de la validation du billet, une fenetre apparait avec le numero dans le titre de la fenetre pour pouvoir aller le consulter
				JOptionPane Validation = new JOptionPane();
				Validation.showMessageDialog(null,"Billet de train valide","Billet num : "+Integer.toString(newBillet.getNumero()),JOptionPane.DEFAULT_OPTION);
				
				// On revient sur la page de gestion des billets 
				mainFen.switchPage("GestionBilletPage");
			} else {
				// Recuperation des informations relatives au bus
				confort = Conf.getSelectedItem().toString();
				// On ajoute un nouveau billet de bus avec prix aleatoire
				BilletBus newBillet = new BilletBus(10 + r.nextInt(it.nombreEtape()*20), it, confort);
				billets.ajouterBillet(newBillet);
				
				// Pour etre sur de la validation du billet, une fenetre apparait avec le numero dans le titre de la fenetre pour pouvoir aller le consulter
				JOptionPane Validation = new JOptionPane();
				Validation.showMessageDialog(null,"Billet de bus valide","Billet n° "+Integer.toString(newBillet.getNumero()),JOptionPane.DEFAULT_OPTION);
				
				// On revient sur la page de gestion des billets 
				mainFen.switchPage("GestionBilletPage");
			}
		}
	}
	
	/** 
	 * Ecouteur qui permet de revenir sur la page principale
	 */ 
	class actionQuit implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("GestionBilletPage");
		}
	}
	
	/** 
	 * Ecouteur pour savoir si le bus a ete choisi et afficher l'interface voulue
	 */
	class actionBus implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			cards.show(mainPane, "Bus");
			BT = false;
		}
	}
	
	/**
	 * Ecouteur pour savoir si le train a ete choisi et afficher l'interface voulue
	 */
	class actionTrain implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			cards.show(mainPane, "Train");
			BT = true;
		}
	}
}

























