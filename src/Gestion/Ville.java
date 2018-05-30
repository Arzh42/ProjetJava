package Gestion;

import java.util.Scanner;
/**
 * @author hugo
 * G�re les villes
 * Fini sauf commentaires
 */
public class Ville {
	private String name;
	public Ville(String name) {
		this.setName(name);
	}
	public Ville(Scanner s) {
		this.keyboardEntry(s);
	}

	public void keyboardEntry(Scanner s) {
		System.out.println("Enter city name : ");
		this.name = s.nextLine();
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
