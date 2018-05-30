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
			System.out.println("Voulez-vous rajoutez une �tape ?(y/n)");
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
			it.next().Afficher();
		}
	}
	public Date dateDepart() throws Exception {
		Iterator<Etape> it = this.EtapeSet.iterator();
		if (it.hasNext()) {
			return it.next().getRd1().getDate();
		}
		else {
			throw new Exception("Pas d'�l�ment");
		}
	}
	public Date dateArrivee() throws Exception {
		Iterator<Etape> it = this.EtapeSet.iterator();
		if (it.hasNext()) {
			Date tmp = it.next().getRd1().getDate();
			while(it.hasNext()) {
				tmp = it.next().getRd1().getDate();
			}
			return tmp;	
		}
		else {
			throw new Exception("Pas d'�l�ment");
		}
	}
	public ArrayList<Ville> tabVille() throws Exception {
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
			throw new Exception("Pas d'�l�ment");
		}
	}
	public void modifEtape(Etape e,Etape newEtape) throws Exception {
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
				throw new Exception("El�ment pas trouv�");
			}
		}
		else {
			throw new Exception("Pas d'�l�ment");
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
