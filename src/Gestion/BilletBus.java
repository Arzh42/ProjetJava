package Gestion;

/**
 * @author hugo
 * Permet de Creer un billet de bus, qui est un billet spécifique
 */
public class BilletBus extends Billet {
	// La seule variable que prend en compte un billet de bus et qu'un billet de train ne prend pas en compte
	private String confort;

	/**
	 * Contructeur d'un billet de bus
	 * @param prix
	 * @param it
	 */
	public BilletBus(int prix, Itineraire it,String confort) {
		super(prix, it);
		this.setConfort(confort);
	}

	/**
	 * @return the confort
	 */
	public String getConfort() {
		return confort;
	}

	/**
	 * @param confort the confort to set
	 */
	public void setConfort(String confort) {
		this.confort = confort;
	}

}
