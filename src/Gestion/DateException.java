package Gestion;

/**
 * Classe qui gere les exceptions generees par la date
 */
public class DateException extends Exception {

	public DateException() {
		super("Une erreur dans la date est apparue");
	}

	public DateException(String arg0) {
		super(arg0);
	}
}
