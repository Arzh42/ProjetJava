import java.util.*;

public class RendezVous {
	private Date date;
	private Ville ville;
	public RendezVous(Date date,Ville ville) {
		this.setDate(date);
		this.setVille(ville);
	}
	
	public RendezVous(){
		Scanner s = new Scanner(System.in);
		this.date = new Date();
		System.out.println("Pour aller à :");
		this.ville = new Ville();
		s.close();
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
		RendezVous rdv = new RendezVous();
		rdv.Afficher();
		RendezVous rdv2 = new RendezVous(rdv.getDate(), rdv.getVille());
		rdv2.Afficher();
	}

}
