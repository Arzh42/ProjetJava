package Affichage;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Affichage.ConsultationBilletPage.chercherBillet;
import Affichage.NouveauBilletPage.actionBus;
import Affichage.NouveauBilletPage.actionConfirm;
import Affichage.NouveauBilletPage.actionQuit;
import Affichage.NouveauBilletPage.actionTrain;
import Gestion.Billet;
import Gestion.BilletBus;
import Gestion.BilletException;
import Gestion.BilletTrain;
import Gestion.Billets;
import Gestion.Date;
import Gestion.Etape;
import Gestion.Itineraire;
import Gestion.ItineraireException;
import Gestion.RendezVous;
import Gestion.Ville;

/**
 * Gere la page de modification d'un billet
 */
public class ModifBilletPage extends JPanel {
	private Billets billets;
	private Fenetre mainFen;
	
	private BilletBus billetBus;
	private BilletTrain billetTrain;
	
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
	private JPanel modifPan;
	private CardLayout cards;
	private CardLayout layout;
	private JTextField field;
	private int positionEtape = 0;
	private int numero;
	
	public ModifBilletPage(Fenetre mainFen) {
		this.mainFen = mainFen;
		
		this.layout = new CardLayout();
		this.setLayout(this.layout);

		this.modifPan = new JPanel();
		this.modifPan.setLayout(new GridLayout(5,4));

		JPanel askNumero = new JPanel();
		
		JLabel text = new JLabel("Numero du billet : ");
		field = new JTextField("Num�ro du billet"); 
		JButton action = new JButton("Chercher");
		action.addActionListener(new chercherBillet());
		
		askNumero.setLayout(new FlowLayout());
		askNumero.add(text);
		askNumero.add(field);
		askNumero.add(action);
		
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
		
		String[] confortTab = {"Faible","Moyen","Haut"};
		Conf = new JComboBox<Object>(confortTab);
		this.pane1.add(Conf);
		
		this.pane2 = new JPanel();
		String[] klasse = {"1","2","Business"};
		String[] cens = {"Vers l'avant","Vers l'arriere"};
		Clas = new JComboBox(klasse);
		Sens = new JComboBox(cens);
		this.pane2.add(Clas);
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
		JButton ModifEtape = new JButton("Modifier");
		JButton confirm = new JButton("Confirmer");
		JButton quit = new JButton("Annuler");
		
		confirm.addActionListener(new actionConfirm());
		quit.addActionListener(new actionQuit());
		bus.addActionListener(new actionBus());
		train.addActionListener(new actionTrain());
		
		ButtonGroup choix = new ButtonGroup();
		choix.add(bus);
		choix.add(train);

		this.modifPan.add(label1);
		this.modifPan.add(cb1);
		this.modifPan.add(new JLabel());
		this.modifPan.add(ModifEtape);
		this.modifPan.add(confirm);

		this.modifPan.add(label2);
		this.modifPan.add(cb2);
		this.modifPan.add(bus);
		this.modifPan.add(new JLabel());
		this.modifPan.add(quit);

		this.modifPan.add(label3);
		this.modifPan.add(cb3);
		this.modifPan.add(train);
		this.modifPan.add(mainPane);
		this.modifPan.add(new JLabel());

		this.modifPan.add(label4);
		this.modifPan.add(cb4);
		this.modifPan.add(label6);
		this.modifPan.add(text1);
		this.modifPan.add(new JLabel());

		this.modifPan.add(label5);
		this.modifPan.add(cb5);
		this.modifPan.add(label7);
		this.modifPan.add(text2);
		this.modifPan.add(new JLabel());
		
		this.add(askNumero, "ask");
		this.add(modifPan,"modif");
	}

	class change implements ActionListener {
		public void actionPerformed(ActionEvent e){

		}
	}

	public void initBillet(Billets billets){
		this.billets = billets;
	}
	
	class actionConfirm implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
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
			
			Itineraire it = new Itineraire();
			it.ajouterEtape(etape1);
			initBillet(billets);

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
	 * Cherche un billet et appelle la fonction afficherBillet(bus ou train) avec ce billet
	 * @param numero
	 * Correspond au num�ro du billet � rechercher
	 */
	public void rechercherBillet(int numero) {
		Billets billets = this.mainFen.getBillets();
		try {
			//On appelle la fonction getBillet de Billets et on g�re les exceptions qu'elle peut lever
			Billet bill = billets.getBillet(numero);
			if (bill.getClass().equals(BilletTrain.class)) {
				this.billetTrain = (BilletTrain) bill;
				this.afficherBilletTrain((BilletTrain) bill);
			}
			else {
				this.billetBus = (BilletBus) bill;
				this.afficherBilletBus((BilletBus) bill);
			}
			//On change la page � afficher
			this.layout.show(this,"aff");
			
		}
		catch(BilletException e) {
			//En cas d'erreur on affiche une boite de dialogue qui donne l'erreur
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void reload() {
		this.layout.show(this, "ask");
	}
	
	public int indexOf(String[] tab,String val) {
		int i = 0;
		while(i<tab.length && tab[i]!=val) {
			i ++;
		}
		return i;
	}
	/**
	 * Permet d'afficher un billet de train
	 * @param billet
	 * Instance de BilletTrain repr�sentant le billet
	 */
	public void afficherBilletTrain(BilletTrain billet) {
		try {
			cb1.setSelectedIndex(billet.getItineraire().dateDepart().getJour());
			cb2.setSelectedIndex(billet.getItineraire().dateDepart().getMois());
			cb3.setSelectedIndex(billet.getItineraire().dateDepart().getAnnee()-2015);
			cb4.setSelectedIndex(billet.getItineraire().dateDepart().getHeure());
			cb5.setSelectedIndex(billet.getItineraire().dateDepart().getMinute());
			layout.show(this, "modif");
		} catch (ItineraireException e) {
			//En cas d'erreur on affiche une boite de dialogue qui donne l'erreur
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Permet d'afficher un billet de bus
	 * @param billet
	 * Instance de BilletBus repr�sentant le billet
	 */
	public void afficherBilletBus(BilletBus billet) {
		try {

			cb1.setSelectedIndex(billet.getItineraire().dateDepart().getJour());
			cb2.setSelectedIndex(billet.getItineraire().dateDepart().getMois());
			cb3.setSelectedIndex(billet.getItineraire().dateDepart().getAnnee()-2015);
			cb4.setSelectedIndex(billet.getItineraire().dateDepart().getHeure());
			cb5.setSelectedIndex(billet.getItineraire().dateDepart().getMinute());
			layout.show(this, "modif");
		} catch (ItineraireException e) {
			//En cas d'erreur on affiche une boite de dialogue qui donne l'erreur
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * ActionListener du bouton de recherche de billet
	 */
	class chercherBillet implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			rechercherBillet(Integer.parseInt(field.getText()));
			numero = Integer.parseInt(field.getText());
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
