import java.util.Scanner;

/**
 * @author hugo
 * Tout est à faire
 */
public class Etape {
	private RendezVous rd1;
	private RendezVous rd2;
	public Etape(RendezVous debut,RendezVous fin) {
		this.setRd1(debut);
		this.setRd2(fin);
	}
	public Etape(Scanner s) {
		this.setRd1(new RendezVous(s));
		this.setRd2(new RendezVous(s));
	}
	public void affichage() {
		
	}
	/**
	 * @return the rd1
	 */
	public RendezVous getRd1() {
		return rd1;
	}
	/**
	 * @param rd1 the rd1 to set
	 */
	public void setRd1(RendezVous rd1) {
		this.rd1 = rd1;
	}
	/**
	 * @return the rd2
	 */
	public RendezVous getRd2() {
		return rd2;
	}
	/**
	 * @param rd2 the rd2 to set
	 */
	public void setRd2(RendezVous rd2) {
		this.rd2 = rd2;
	}

}
