
public class RendezVous {
	private Date date;
	private Ville ville;
	public RendezVous(Date date,Ville ville) {
		this.setDate(date);
		this.setVille(ville);
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

}
