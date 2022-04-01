package Jeu;

import java.util.ArrayList;
import java.util.List;

public class Carte {
	private int points;
	private static ArrayList<Carte> pioche = new ArrayList<Carte>();
	private static List<Carte> defausse = new ArrayList<Carte>();

	public Carte(int points) {
		if(points < 0) {
			System.err.println("pas de carte négative");
		}
		else
			this.points = points;
	}
	
	public static void setPioche(ArrayList<Carte> jeuDeCartes) {
		pioche = jeuDeCartes;
	}
	
	public static ArrayList<Carte> getPioche(){
		return pioche;
	}
	
	public int getPoints() {
		return points;
	}
	
	private static void removeAll(List<Carte> Pioche) {
		Pioche.removeAll(Pioche);
	}
	
	public static void melange() {
		ArrayList<Carte> pioche2 = new ArrayList<Carte>();
		for(int i = 0; i<pioche.size(); i++)
			pioche2.add(pioche.get(i));
		removeAll(pioche);
		int iteration = pioche2.size();
		for(int i = 0; i < iteration; i++) {
			int a = ((int) (Math.random()*(pioche2.size()-1)));
			pioche.add(pioche2.get(a));
			pioche2.remove(a);
		}
		
	}

	
}
