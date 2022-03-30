package Jeu;

import java.util.ArrayList;
import java.util.List;

public class Carte {
	public Carte(int points) {
		if(points < 0) {
			System.err.println("Carte non valide");
		}
		else
			this.points = points;
	}

	private int points;
	private static List<Carte> pioche = new ArrayList<Carte>();
	private static List<Carte> defausse = new ArrayList<Carte>();
	
	public int getPoints() {
		return points;
	}

	
}
