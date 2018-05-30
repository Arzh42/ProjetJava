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
	public RendezVous(Date date,Ville ville) {
		this.setDate(date);
		this.setVille(ville);
	}

	public RendezVous(Scanner s) {
		this.keyboardEntry(s);
	}
	public void keyboardEntry(Scanner s) {
		this.setDate(new Date(s));
		this.setVille(new Ville(s));
	}
	/**
	 *
	 */
	public void Afficher(){
		System.out.print("Je me rend a "+this.ville.getName()+" et ");
		this.date.Afficher();
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
		rdv.Afficher();
		s.close();
	}

}
