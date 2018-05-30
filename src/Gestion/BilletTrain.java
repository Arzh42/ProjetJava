package Gestion;


/**
 *Repr�sente un billet de train
 */
public class BilletTrain extends Billet {
	private String classe;
	private boolean sens;

	/**
	 * 
	 */
	public BilletTrain(int prix,Itineraire it,String classe,boolean sens) {
		super(prix,it);
		this.setClasse(classe);
		this.setSens(sens);
	}

	/**
	 * @return the classe
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * @return the sens
	 */
	public Boolean getSens() {
		return sens;
	}

	/**
	 * @param sens the sens to set
	 */
	public void setSens(Boolean sens) {
		this.sens = sens;
	}

}
