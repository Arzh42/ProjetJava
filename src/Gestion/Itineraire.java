package Gestion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Itineraire {
	private HashSet<Etape> EtapeSet;
	public Itineraire() {
		this.EtapeSet = new HashSet<Etape>();
	}
	public void ajouterEtape(Etape etape) {
		this.EtapeSet.add(etape);
	}
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
	public int nombreEtape() {
		int compteur = 0;
		Iterator<Etape> it = this.EtapeSet.iterator();
		while(it.hasNext()) {
			it.next();
			compteur ++;
		}
		return compteur;
	}
	
	public void affichageEtape() {
		Iterator<Etape> it = this.EtapeSet.iterator();
		while(it.hasNext()) {
			it.next().afficher();
		}
	}
	public String getAffichage() throws ItineraireException {
		Iterator<Etape> it = this.EtapeSet.iterator();
		if (it.hasNext()) {
			Etape first = it.next();
			Etape last = first;
			while(it.hasNext()) {
				last = it.next();
			}
			return "Itinéraire de "+first.getRd1().getVille().getName()+" à "+last.getRd2().getVille().getName();
		}
		else {
			throw new ItineraireException("Pas d'étape dans l'itinéraire");
		}
		
	}
	public Date dateDepart() throws ItineraireException {
		Iterator<Etape> it = this.EtapeSet.iterator();
		if (it.hasNext()) {
			return it.next().getRd1().getDate();
		}
		else {
			throw new ItineraireException("Pas d'élément");
		}
	}
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
			throw new ItineraireException("Pas d'élément");

		}
	}
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
			throw new ItineraireException("Pas d'élément");

		}
	}
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
				throw new ItineraireException("Elément pas trouvé");
			}
		}
		else {
			throw new ItineraireException("Pas d'élément");

		}
	}
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
