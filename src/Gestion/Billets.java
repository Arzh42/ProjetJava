package Gestion;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * G�re les diff�rents billets
 */
public class Billets {
	private ArrayList<Billet> BilletList;
	public Billets() {
		this.BilletList = new ArrayList<Billet>();
	}
	/**
	 * Permet d'ajouter un billet
	 * @param NewBillet
	 */
	public void ajouterBillet(Billet NewBillet) {
		this.BilletList.add(NewBillet);
	}
	/**
	 * Permet de supprimer le billet dont le numero est donn�
	 * @param numero
	 * @throws BilletException
	 */
	public void supprime(int numero) throws BilletException {
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
		if (test) {
			throw new BilletException("Le billet  "+numero+" n'existe pas");
		}
	}
	/**
	 * Retourne le billet dont le num�ro est donn�
	 * @param numero
	 * @return
	 * @throws BilletException
	 */
	public Billet getBillet(int numero) throws BilletException {
		Iterator<Billet> it = this.BilletList.iterator();
		if (this.BilletList.size()>0) {
			Billet ele = null;
			boolean test = true;
			while(it.hasNext()&&test) {
				ele = it.next();
				if (ele.getNumero()==numero) {
					test = false;
				}
			}
			if (test) {
				throw new BilletException("Le billet n'existe pas");
			}
			else {
				return ele;
			}
		}
		else {
			throw new BilletException("Pas de billet enregistre");
		}
	}
	/**
	 * Renvoie le nombre de billet
	 * @return
	 */
	public int nbBillet() {
		return this.BilletList.size();
	}
	/**
	 * Renvoie le nombre d'itin�raire diff�rents
	 * @return
	 */
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
	/**
	 * Renvoie l'itin�raire le plus vendu
	 * @return
	 * @throws BilletException
	 */
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
	/**
	 * Renvoie la recette effectu�e
	 * @return
	 */
	public int recette() {
		Iterator<Billet> it = this.BilletList.iterator();
		int somme = 0;
		while(it.hasNext()) {
			somme += it.next().getPrix();
		}
		return somme;
	}
	/**
	 * Renvoie la recette effectu�e par les trains
	 * @return
	 */
	public int recetteTrain() {
		Iterator<Billet> it = this.BilletList.iterator();
		int somme = 0;
		Billet ele = null;
		while(it.hasNext()) {
			ele = it.next();
			if (ele.getClass().equals(BilletTrain.class)) {
				somme += ele.getPrix();		
			}
		}
		return somme;
	}
	/**
	 * Renvoie la recette effectu�e par les bus
	 * @return
	 */
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
