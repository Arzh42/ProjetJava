import java.util.Scanner;

public class Ville {
	private String name;
	public Ville(String name) {
		this.setName(name);
	}
	public Ville() {
		this.keyboardEntry();
	}
	public void keyboardEntry() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter city name : ");
		this.name = s.next();
		s.close();
	}
	public void afficher() {
		System.out.println("Bonjour je suis une ville et je m'appelle "+this.name);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
