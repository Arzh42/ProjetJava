package Gestion;

public abstract class Billet {
	private static int compteur;
	private int numero;
	private int prix;
	private Itineraire itineraire;
	public Billet(int prix,Itineraire it) {
		Billet.compteur ++;
		this.setNumero(Billet.compteur);
		this.prix = prix;
		this.itineraire = it;
	}
	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}
	/**
	 * @return the itineraire
	 */
	public Itineraire getItineraire() {
		return itineraire;
	}
	/**
	 * @param itineraire the itineraire to set
	 */
	public void setItineraire(Itineraire itineraire) {
		this.itineraire = itineraire;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
