package Gestion;
import java.util.*;
/**
 * 
 * @author hugo
 * G�re les Rendez-vous
 * Main et Commentaire � faire
 */
public class RendezVous {
	private Date date;
	private Ville ville;
	/**
	 * Permet de creer un Rendez-vous a partir de parametres
	 */
	public RendezVous(Date date,Ville ville) {
		this.setDate(date);
		this.setVille(ville);
	}

	/**
	 * Permet de creer une ville a partir d'une saisie clavier
	 */
	public RendezVous(Scanner s) {
		this.keyboardEntry(s);
	}
	public void keyboardEntry(Scanner s) {
		this.setDate(new Date(s));
		this.setVille(new Ville(s));
	}
	/**
	 * Afficher un Rendez-vous
	 */
	public void afficher(){
		System.out.print("Je me rend a "+this.ville.getName()+" et ");
		this.date.afficher();
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the ville
	 */
	public Ville getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Ville ville = new Ville(s);
		Date date = new Date(s);
		RendezVous rdv = new RendezVous(date, ville);
		rdv.afficher();
		s.close();
	}

}
