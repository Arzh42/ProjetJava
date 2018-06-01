package Gestion;

import java.util.Scanner;

/**
 * @author hugo
 * Gere les villes
 */
public class Ville {
	private String name;

	/**
	 * Permet de creer une ville a partir de parametres
	 */
	public Ville(String name) {
		this.setName(name);
	}
	
	/**
	 * Permet de creer une ville a partir d'une lecture clavier
	 */
	public Ville(Scanner s) {
		this.keyboardEntry(s);
	}

	/**
	 * Permet de faire une saisie clavier
	 * @param s
	 */
	public void keyboardEntry(Scanner s) {
		System.out.println("Enter city name : ");
		this.name = s.nextLine();
	}
	
	/**
	 * Permet d'afficher une ville
	 */
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
