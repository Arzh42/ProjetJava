import java.io.*;

public class Ville {
	private String name;
	public Ville(String name) {
		this.setName(name);
	}
	public Ville() {
		this.keyboardEntry();
	}
	public void keyboardEntry() {
		InputStreamReader isr = new InputStreamReader(System.in);
      	BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter city name : ");
		this.name = br.readLine();
	}
	public void Afficher() {
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
