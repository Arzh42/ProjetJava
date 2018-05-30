package Gestion;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author hugo
 *
 */
public class Billets {
	private ArrayList<Billet> BilletList;
	/**
	 * 
	 */
	public Billets() {
		this.BilletList = new ArrayList<Billet>();
	}
	public void ajouterBillet(Billet NewBillet) {
		this.BilletList.add(NewBillet);
	}
	public void supprime(int numero) {
		Billet ele;
		boolean test = true;
		int i = 0;
		while(i<this.BilletList.size()&&test) {
			ele = this.BilletList.get(i);
			if (ele.getNumero()==numero) {
				this.BilletList.remove(i);
				test = false;
			}
			i ++;
		}
	}
	public Billet getBillet(int numero) {
		Iterator<Billet> it = this.BilletList.iterator();
		Billet ele = this.BilletList.get(0);
		boolean test = true;
		while(it.hasNext()&&test) {
			ele = it.next();
			if (ele.getNumero()==numero) {
				test = false;
			}
		}
		return ele;
	}
	public int nbBillet() {
		return this.BilletList.size();
	}
	public int itineraireDiff() {
		ArrayList<Itineraire> ItList = new <Itineraire>ArrayList();
		ArrayList<Integer> nbList = new <Integer>ArrayList();
		Iterator<Billet> it = this.BilletList.iterator();
		if (this.BilletList.size()>0) {
			Billet ele = this.BilletList.get(0);
			while(it.hasNext()) {
				ele = it.next();
				if (ItList.contains(ele.getItineraire())) {
					int i = ItList.indexOf(ele.getItineraire());
					nbList.set(i,nbList.get(i) + 1);
				}
				else {
					ItList.add(ele.getItineraire());
					nbList.add(1);
				}
			}
			return ItList.size();
		}
		else {
			return 0;
		}
	}
	public Itineraire plusVendu() throws BilletException {
		ArrayList<Itineraire> ItList = new ArrayList<Itineraire>();
		ArrayList<Integer> nbList = new ArrayList<Integer>();
		Iterator<Billet> it = this.BilletList.iterator();
		if (this.BilletList.size()>0) {
			Billet ele = this.BilletList.get(0);
			while(it.hasNext()) {
				ele = it.next();
				if (ItList.contains(ele.getItineraire())) {
					int i = ItList.indexOf(ele.getItineraire());
					nbList.set(i,nbList.get(i) + 1);
				}
				else {
					ItList.add(ele.getItineraire());
					nbList.add(1);
				}
			}
			int max = 0;
			int idMax = 0;
			for (int i=0;i<nbList.size();i++) {
				if (nbList.get(i)>max) {
					max = nbList.get(i);
					idMax = i;
				}
			}
			return ItList.get(idMax);
		}
		else {
			throw new BilletException("Aucun Itineraire");
		}
	}
	public int recette() {
		Iterator<Billet> it = this.BilletList.iterator();
		int somme = 0;
		while(it.hasNext()) {
			somme += it.next().getPrix();
		}
		return somme;
	}
	public int recetteTrain() {
		Iterator<Billet> it = this.BilletList.iterator();
		int somme = 0;
		Billet ele = null;
		while(it.hasNext()) {
			ele = it.next();
			if (ele.getClass().equals(BilletTrain.class)) {
				somme += it.next().getPrix();		
			}
		}
		return somme;
	}
	public int recetteBus() {
		Iterator<Billet> it = this.BilletList.iterator();
		int somme = 0;
		Billet ele = null;
		while(it.hasNext()) {
			ele = it.next();
			if (ele.getClass().equals(BilletBus.class)) {
				somme += ele.getPrix();		
			}
		}
		return somme;
	}
	public static void main(String[] args) {
		Billets bill = new Billets();
		bill.ajouterBillet(new BilletBus(10,new Itineraire(),"confort"));
		System.out.println(bill);
	}
}
