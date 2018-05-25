import java.util.HashSet;
import java.util.Iterator;

public class Itineraire {
	private HashSet<Etape> EtapeSet;
	public Itineraire() {
		this.EtapeSet = new HashSet<Etape>();
	}
	public void ajouterEtape(Etape etape) {
		this.EtapeSet.add(etape);
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
			it.next().affichage();
		}
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
