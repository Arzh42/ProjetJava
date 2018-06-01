package Gestion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Classe qui gere un itineraire
 */
public class Itineraire {
	// On stocke un itineraire dans un hashSet d'Etapes
	private HashSet<Etape> EtapeSet;

	/**
	 * Constructeur d'un itineraire
	 */
	public Itineraire() {
		this.EtapeSet = new HashSet<Etape>();
	}

	/**
	 * Permet de rajouter une Etape a la suite des autres
	 * @param etape
	 */
	public void ajouterEtape(Etape etape) {
		this.EtapeSet.add(etape);
	}

	/**
	 * Methode pour creer un itineraire avec une saisie clavier
	 */
	public void saisieItineraire() {
		Scanner s = new Scanner(System.in);
		boolean test = true;
		while(test) {
			this.ajouterEtape(new Etape(s));
			System.out.println("Voulez-vous rajouter une etape ? (y/n)");
			if (s.next()!="y") {
				test = false;
			}
		}
	}

	/**
	 * Retourne le nombre d'Etape d'un itineraire
	 * @return compteur
	 */
	public int nombreEtape() {
		int compteur = 0;
		Iterator<Etape> it = this.EtapeSet.iterator();
		while(it.hasNext()) {
			it.next();
			compteur ++;
		}
		return compteur;
	}

	/**
	 * Affiche un itineraire mais ne fonctionne pas ici
 	 */
	public void affichageEtape() {
		Iterator<Etape> it = this.EtapeSet.iterator();
		while(it.hasNext()) {
			it.next().afficher();
		}
	}

	/**
	 * Permet de transformer un Itineraire en String
	 * @return affichage of the Itineraire
	 * @throws ItineraireException
	 */
	public String getAffichage() throws ItineraireException {
		Iterator<Etape> it = this.EtapeSet.iterator();

		if (it.hasNext()) {
			Etape first = it.next();
			Etape last = first;
			while(it.hasNext()) {
				last = it.next();
			}
			return "Itineraire de "+first.getRd1().getVille().getName()+" a "+last.getRd2().getVille().getName();
		}
		else {
			throw new ItineraireException("Pas d'etape dans l'itineraire");
		}
	}

	/**
	 * Permet d'acceder a la date de depart
	 * @return dateDepart
	 * @throws ItineraireException
	 */
	public Date dateDepart() throws ItineraireException {
		Iterator<Etape> it = this.EtapeSet.iterator();
		if (it.hasNext()) {
			return it.next().getRd1().getDate();
		}
		else {
			throw new ItineraireException("Pas d'element");
		}
	}

	/**
	 * Permet d'acceder a la date d'arrivee
	 * @return dateArrivee
	 * @throws ItineraireException
	 */
	public Date dateArrivee() throws ItineraireException {
		Iterator<Etape> it = this.EtapeSet.iterator();
		if (it.hasNext()) {
			Date tmp = it.next().getRd1().getDate();
			while(it.hasNext()) {
				tmp = it.next().getRd1().getDate();
			}
			return tmp;	
		}
		else {
			throw new ItineraireException("Pas d'�l�ment");

		}
	}

	/**
	 * Permet d'acceder a la liste des villes traversees
	 * @return tabVille
	 * @throws ItineraireException
	 */
	public ArrayList<Ville> tabVille() throws ItineraireException {
		ArrayList<Ville> tabVille = new ArrayList<Ville>();
		Iterator<Etape> it = this.EtapeSet.iterator();
		Etape tmp = null;
		if (it.hasNext()) {                                     
			while(it.hasNext()) {
				tmp = it.next();
				tabVille.add(tmp.getRd1().getVille());
			}
			tabVille.add(tmp.getRd2().getVille());
			return tabVille;
		}
		else {
			throw new ItineraireException("Pas d'element");
		}
	}

	/**
	 * Permet d'avoir acces a une Etape
	 * @param position
	 * @return tmp
	 * @throws ItineraireException
	 */
	public Etape getEtape(int position) throws ItineraireException {
		Iterator<Etape> it = this.EtapeSet.iterator();
		boolean find = false;
		Etape tmp = null;
		int i = 0;
		if (it.hasNext()) {
			tmp = it.next();
			while(it.hasNext()&&i<position) {
				tmp = it.next();
				i ++;
			}
			if (i<position) {
				throw new ItineraireException("El�ment pas trouv�");
			}
			return tmp;
		}
		else {
			throw new ItineraireException("Pas d'�l�ment");
		}
	}

	/**
	 * Permet de modifier une Etape
	 * @param e
	 * @param newEtape
	 * @throws ItineraireException
	 */
	public void modifEtape(Etape e,Etape newEtape) throws ItineraireException {
		Iterator<Etape> it = this.EtapeSet.iterator();
		boolean find = false;
		Etape tmp = null;
		if (it.hasNext()) {
			while(it.hasNext()) {
				tmp = it.next();
				if (e==tmp) {
					tmp.setRd1(newEtape.getRd1());
					tmp.setRd2(newEtape.getRd2());
					find = true;
				}
			}
			if (!find) {
				throw new ItineraireException("El�ment pas trouv�");
			}
		}
		else {
			throw new ItineraireException("Pas d'�l�ment");
		}
	}

	/**
	 * Permet de tester si deux Itineraires sont egaux
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static boolean equals(Itineraire i1,Itineraire i2) {
		boolean test = true;
		Iterator<Etape> it1 = i1.EtapeSet.iterator();
		Iterator<Etape> it2 = i2.EtapeSet.iterator();
		while(it1.hasNext()&&test) {
			if (it2.hasNext()) {
				if (it1.next()!=it2.next()) {
					test = false;
				}
			}
			else {
				test = false;
			}
		}
		if (it2.hasNext()) {
			test = false;
		}
		return test;
	}

	/**
	 * @return the etapeSet
	 */
	public HashSet<Etape> getEtapeSet() {
		return EtapeSet;
	}

	/**
	 * @param etapeSet the etapeSet to set
	 */
	public void setEtapeSet(HashSet<Etape> etapeSet) {
		this.EtapeSet = etapeSet;
	}
}
