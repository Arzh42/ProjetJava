package Gestion;

public class DateException extends Exception {

	public DateException() {
		super("Une erreur dans la date est apparue");
	}

	public DateException(String arg0) {
		super(arg0);
	}
}
