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
	private Billets billets;
	private Fenetre mainFen;
	
	private String[] Jours = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String[] Mois = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
	private String[] Annees = {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
	private String[] Heures = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	private String[] Minutes = {"00","05","10","15","20","25","30","35","40","45","50","55"};
	
	private JComboBox cb1;
	private JComboBox cb2;
	private JComboBox cb3;
	private JComboBox cb4;
	private JComboBox cb5;
	
	private JTextField text1;
	private JTextField text2;
	
	private JPanel pane1;
	private JPanel pane2;
	private String confort;
	private String classe;
	private boolean sens;
	private JComboBox Sens;
	private JComboBox Clas;
	private JComboBox Conf;
	
	private boolean BT;
	private JPanel mainPane;
	private CardLayout cards;
	private Itineraire it;

	public NouveauBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(5,4));
		
		it = new Itineraire();

		this.pane1 = new JPanel();
		this.cards = new CardLayout();
		this.mainPane = new JPanel();
		this.mainPane.setLayout(this.cards);
		
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
		
		this.pane1.add(label8);
		String[] confortTab = {"Faible","Moyen","Haut"};
		Conf = new JComboBox<Object>(confortTab);
		this.pane1.add(Conf);
		
		this.pane2 = new JPanel();
		String[] klasse = {"1","2","Business"};
		String[] cens = {"Vers l'avant","Vers l'arriere"};
		Clas = new JComboBox(klasse);
		Sens = new JComboBox(cens);
		this.pane2.add(label9);
		this.pane2.add(Clas);
		this.pane2.add(label10);
		this.pane2.add(Sens);
		
		this.mainPane.add(pane1, "Bus");
		this.mainPane.add(pane2, "Train");
		
			
		JRadioButton bus = new JRadioButton("Bus");
		JRadioButton train = new JRadioButton("Train");
		cb1 = new JComboBox(Jours);
		cb2 = new JComboBox(Mois);
		cb3 = new JComboBox(Annees);
		cb4 = new JComboBox(Heures);
		cb5 = new JComboBox(Minutes);
		text1 = new JTextField("<Saisir la ville de depart>");
		text2 = new JTextField("<Saisir la ville d'arrivee>");
		JButton confirm = new JButton("Confirmer");
		JButton quit = new JButton("Annuler");
		JButton addEtape = new JButton("Ajouter l'etape");
		
		addEtape.addActionListener(new actionEtape());
		confirm.addActionListener(new actionConfirm());
		quit.addActionListener(new actionQuit());
		bus.addActionListener(new actionBus());
		train.addActionListener(new actionTrain());
		
		ButtonGroup choix = new ButtonGroup();
		choix.add(bus);
		choix.add(train);
		
		this.add(label1);
		this.add(cb1);
		this.add(label2);
		this.add(cb2);
		this.add(label3);
		this.add(cb3);
		this.add(label4);
		this.add(cb4);
		this.add(label5);
		this.add(cb5);
		this.add(label6);
		this.add(text1);
		this.add(label7);
		this.add(text2);
		this.add(bus);
		this.add(train);
		this.add(mainPane);
		this.add(addEtape);
		this.add(confirm);
		this.add(quit);	
	}
	
	public void initBillet(Billets billets){
		this.billets = billets;
	}
	
	class actionEtape implements ActionListener {
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
			
			cb1.setSelectedIndex(jour2-1);	
			cb2.setSelectedIndex(mois2-1);
			cb3.setSelectedIndex(annee2-2015);
			cb4.setSelectedIndex(heure2);
			cb5.setSelectedIndex(minute2/5);
			text1.setText(ville2.getName());
			text2.setText("<Entrez la ville d'arrivee>");
		}
	}
	
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
		
			if(BT){
				classe = Clas.getSelectedItem().toString();
				if(Sens.getSelectedIndex() == 0){
					sens = true;
				} else {
					sens = false;
				}
				BilletTrain newBillet = new BilletTrain(60 + r.nextInt(500), it, classe, sens);
				billets.ajouterBillet(newBillet);
				
				JOptionPane Validation = new JOptionPane();
				jop.showMessageDialog(null,"Billet de train valide","Billet n° "+newBillet.getNumero().toString(),JOptionPane.DEFAULT_OPTION);
			} else {
				confort = Conf.getSelectedItem().toString();
				BilletBus newBillet = new BilletBus(10 + r.nextInt(120), it, confort);
				billets.ajouterBillet(newBillet);
				
				JOptionPane Validation = new JOptionPane();
				jop.showMessageDialog(null,"Billet de bus valide","Billet n° "+newBillet.getNumero().toString(),JOptionPane.DEFAULT_OPTION);
			}
		}
	}
	
	class actionQuit implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mainFen.switchPage("GestionBilletPage");
			
		}
	}
	
	class actionBus implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			cards.show(mainPane, "Bus");
			BT = false;
		}
	}
	
	class actionTrain implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			cards.show(mainPane, "Train");
			BT = true;
		}
	}
}

























