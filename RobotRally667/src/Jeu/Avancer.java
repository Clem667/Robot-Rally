package Jeu;

public class Avancer extends Carte { //il faut prendre en argument la direction 
	
	private int avance;//si cette variable est negative, elle correspond a une carte reculer
	
	public Avancer (int points, int avance) {
		super(points);
		if(avance < 0) { //pourquoi 0 vu que ca peut etre -1 ?
			System.err.println("Carte non valide");
		}
		else
			this.avance = avance;
	}

	public int getAvance() {
		return avance;
	}
	
	public String toString() {
		String carte = "";
		carte += "" + getPoints() + " points\n";
		carte += "avance de : "+ getAvance();
	
		return carte;
	}
	
}
