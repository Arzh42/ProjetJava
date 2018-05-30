package Gestion;
/**
 * 
 */
import java.util.*;
/**
 * @author hugo
 *	G�re des dates
 *	Fini
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
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.heure = heure;
		this.minute = minute;
		this.seconde = seconde;
	}
	
	/**
	 *
	 */
	public Date(Scanner s){
		keyboardEntry(s);
	}
	public void keyboardEntry (Scanner sc) {
		try {
			try {
				System.out.println("Veuillez rentrer le jour de depart :");
				this.setJour(sc.nextInt());
				System.out.println("Veuillez preciser le mois de depart :");
				this.setMois(sc.nextInt());
				System.out.println("Veuillez preciser l'annee du depart :");
				this.setAnnee(sc.nextInt());
				System.out.println("L'heure du depart voulu :");
				this.setHeure(sc.nextInt());
				System.out.println("Les minutes du depart voulu :");
				this.setMinute(sc.nextInt());
				System.out.println("Les secondes du depart voulu :");
				this.setSeconde(sc.nextInt());
			}
			catch(DateException e) {
				System.out.print(e.getMessage());
				System.out.println(", Recommencer");
				this.keyboardEntry(sc);
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Ceci n'est pas un chiffre, recommencer");
			this.keyboardEntry(sc);
		}	
	}
	/**
	 * Afficher la date
	 */
	public void Afficher() {
		System.out.println("le "+this.jour+"/"+this.mois+"/"+this.annee+" a "+this.heure+"h"+this.minute+":"+this.seconde);
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
	public void setHeure(int heure) throws DateException {
		if (heure<0||heure>=23) {
			throw new DateException("L'heure doit �tre comprise entre 0 et 23");
		}
		else {
			this.heure = heure;
		}
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
	public void setJour(int jour)  throws DateException  {
		if (jour<1||jour>=31) {
			throw new DateException("Le jour doit �tre compris entre 1 et 31");
		}
		else {
			this.jour = jour;
		}
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
	public void setMois(int mois) throws DateException  {
		if (mois<1||mois>12) {
			throw new DateException("Le mois doit �tre compris entre 1 et 12");
		}
		else {
			this.mois = mois;
		}
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
	public void setAnnee(int annee) throws DateException  {
		if (annee<1950||annee>=3000) {
			throw new DateException("L'ann�e doit �tre comprise entre 1950 et 3000");
		}
		else {
			this.annee = annee;
		}
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
	public void setSeconde(int seconde) throws DateException  {
		if (seconde<0||seconde>=60) {
			throw new DateException("Le nombre de seconde doit �tre compris entre 0 et 59");
		}
		else {
			this.seconde = seconde;
		}
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
	public void setMinute(int minute) throws DateException  {
		if (minute<0||minute>=60) {
			throw new DateException("Le nombre de minute doit �tre compris entre 0 et 59");
		}
		else {
			this.minute = minute;
		}
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Date date = new Date(s);
		date.Afficher();
		Date date2 = new Date(date.getJour(), date.getMois(), date.getAnnee(), date.getHeure(), date.getMinute(), date.getSeconde());
		date2.Afficher();
		s.close();
	}

}
