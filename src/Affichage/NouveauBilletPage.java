package Affichage;

import javax.swing.*;
import java.awt.GridLayout;

import Gestion.Billet;

public class NouveauBilletPage extends JPanel {
	private Billet billet;
	private Fenetre mainFen;
	
	private String[] Jours;
	private String[] Mois;
	private String[] Annees;
	private String[] Heures;
	private String[] Minutes;
	
	private JComboBox cb1;
	private JComboBox cb2;
	private JComboBox cb3;
	private JComboBox cb4;
	private JComboBox cb5;
	
	private JTextField text1;
	private JTextField text2;

	public NouveauBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		this.setLayout(new GridLayout(4,6));
		
		Jours = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		Mois = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
		Annees = {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
		Heures = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		Minutes = {"00","05","10","15","20","25","30","35","40","45","50","55")};
		
		JLabel label1 = new JLabel("Jour :");
		JLabel label2 = new JLabel("Mois :");
		JLabel label3 = new JLabel("Annee :");
		JLabel label4 = new JLabel("Heure :");
		JLabel label5 = new JLabel("Minute :");
		JLabel label6 = new JLabel("Depart :");
		JLabel label7 = new JLabel("Arrivee :");
		JRadioButton bus = new JRadioButton("Bus");
		JRadioButton train = new JRadioButton("Train");
		JComboBox cb1 = new JComboBox(Jours);
		JComboBox cb2 = new JComboBox(Mois);
		JComboBox cb3 = new JComboBox(Annees);
		JComboBox cb4 = new JComboBox(Heures);
		JComboBox cb5 = new JComboBox(Minutes);
		text1 = new JTextField("<Saisir la ville de depart>");
		text2 = new JTextField("<Saisir la ville d'arrivee>");
		JButton confirm = new JButton("Confirmer");
		JButton quit = new JButton("Annuler");
		
		confirm.addActionListener(new actionConfirm());
		quit.addActionListener(new actionQuit());
		
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
		this.add(confirm);
		this.add(quit);	
	}
	
	public void initBillet(Billets billet){
		this.billet = billet;
	}
	
	class actionConfirm implements ActionListener {
		public void actionConfirm(ActionEvent e){
			
			Random r = new Random();
			
			int jour = Jours.getSelectedIndex()+1;
			int mois = Mois.getSelectedIndex()+1;
			int annee = Annees.getSelectedIndex()+2015;
			int heure = Heures.getSelectedIndex();
			int minute = Minutes.getSelectedIndex()*5;
			int minute2 = minute;
			int heure2 = heure+r.nextInt(24);
			int jour2;
			int mois2;
			int annee2;
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
			
			Itineraire ET = new Itineraire();
			Et.ajouterEtape(etape1);
			
			billet = new Billet(10+r.nextInt(500), ET);
		}
	}
	
	class actionQuit implements ActionListener {
		public void actionQuit(ActionEvent e){
			mainFen.switchPage("GestionBilletPage");
		}
	}
}

























