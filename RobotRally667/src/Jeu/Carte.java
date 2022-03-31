package Jeu;

import java.util.ArrayList;
import java.util.List;

public class Carte {
	public Carte(int points) {
		if(points < 0) {
			System.err.println("pas de carte négative");
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
	
	private int taillePioche(List<Carte> Pioche) {
		return Pioche.size();
	}
	
	private Carte get(int i) {
		return get(i);
	}
	
	private void remove(List<Carte> Pioche,int i) {
		Pioche.remove(i);
	}
	
	private void removeAll(List<Carte> Pioche) {
		Pioche.removeAll(Pioche);
	}
	
	private void add(List<Carte> Pioche, int i) {
		Pioche.add(get(i));
	}
	
	public void melange() {
		List<Carte> pioche2 = pioche;
		removeAll(pioche);
		for(int i = 0; i < taillePioche(pioche2); i++) {
			int a = ((int) Math.random())*(taillePioche(pioche2)-1);
			add(pioche, a);
			remove(pioche2, a);
		}
	}

	
}
