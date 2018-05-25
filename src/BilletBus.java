/**
 * 
 */

/**
 * @author hugo
 *
 */
public class BilletBus extends Billet {

	private String confort;

	/**
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
