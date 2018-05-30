
public class Etape {
	private RendezVous rd1;
	private RendezVous rd2;
	public Etape(RendezVous debut,RendezVous fin) {
		this.setRd1(debut);
		this.setRd2(fin);
	}
	public void Afficher() {
		System.out.print("Départ: "+rd1.getVille().getName()+" ");
		rd1.getDate().Afficher();
		System.out.print("Arrivee: "+rd2.getVille().getName()+" ");
		rd2.getDate().Afficher();
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
