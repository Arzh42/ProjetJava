package Affichage;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	JPanel FirstPage = new FirstPage(this);
	JPanel GestionBilletPage = new GestionBilletPage(this);
	public Fenetre() {
		this.setTitle("Ultra Gestionnator of Train and Bus Billet");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(this.FirstPage);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
	}
	public void switchToGestionBillet() {
		this.getContentPane().removeAll();
		this.getContentPane().add(this.GestionBilletPage);
	}
}
