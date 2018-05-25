/**
 * 
 */

/**
 * @author hugo
 *
 */
public class Date {

	private int heure;
	private int jour;
	private int mois;
	private int annee;
	private int seconde;
	private int minute;
	/**
	 * 
	 */
	public Date(int jour,int mois,int annee,int heure,int minute,int seconde) {
		
	}
	/**
	 * Afficher la date
	 */
	public void Afficher() {
		System.out.println("Bonjour je suis le "+this.jour+"/"+this.mois+"/"+this.annee+" à "+this.heure+"h"+this.minute+":"+this.seconde);
	}
	/**
	 * @return the heure
	 */
	public int getHeure() {
		return heure;
	}
	/**
	 * @param heure the heure to set
	 */
	public void setHeure(int heure) {
		this.heure = heure;
	}
	/**
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}
	/**
	 * @param jour the jour to set
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}
	/**
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}
	/**
	 * @param mois the mois to set
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}
	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}
	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	/**
	 * @return the seconde
	 */
	public int getSeconde() {
		return seconde;
	}
	/**
	 * @param seconde the seconde to set
	 */
	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}
	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}
	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

}
