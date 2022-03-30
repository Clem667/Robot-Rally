package Jeu;

public class Avancer extends Carte {
	
	private int avance;
	
	public Avancer (int points, int avance) {
		super(points);
		if(avance < 0) {
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
