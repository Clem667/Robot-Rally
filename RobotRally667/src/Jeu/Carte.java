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
	private static ArrayList<Carte> pioche = new ArrayList<Carte>();
	private static List<Carte> defausse = new ArrayList<Carte>();
	
	public static void setPioche(ArrayList<Carte> jeuDeCartes) {
		pioche = jeuDeCartes;
	}
	
	public static ArrayList<Carte> getPioche(){
		return pioche;
	}
	
	public int getPoints() {
		return points;
	}
	
	private static int taillePioche(List<Carte> Pioche) {
		return Pioche.size();
	}
	
	private static Carte get(int i) {
		return get(i);
	}
	
	private static void remove(List<Carte> Pioche,int i) {
		Pioche.remove(i);
	}
	
	private static void removeAll(List<Carte> Pioche) {
		Pioche.removeAll(Pioche);
	}
	
	private static void add(List<Carte> Pioche, int i) {
		Pioche.add(get(i));
	}
	
	public static void melange() {
		ArrayList<Carte> pioche2 = pioche;
		System.out.println(pioche2.size());
		removeAll(pioche);
		System.out.println("passage melange()");
		int iteration = pioche2.size();
		System.out.println(iteration);
		for(int i = 0; i < iteration; i++) {
			int a = ((int) Math.random())*(taillePioche(pioche2)-1);
			add(pioche, a);
			System.out.println("passage melange()");
			remove(pioche2, a);
		}
		
	}

	
}
