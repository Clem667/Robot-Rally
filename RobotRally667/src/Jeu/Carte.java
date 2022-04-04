package Jeu;

import java.util.ArrayList;
import java.util.List;

public class Carte {
	private int points;
	private static ArrayList<Carte> pioche = new ArrayList<Carte>();
	public static List<Carte> defausse = new ArrayList<Carte>();

	public Carte(int points) {
		if(points < 0) {
			System.err.println("pas de carte a points negatifs");
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
	
	public static void distribution(ArrayList<Carte> main) {
		while(pioche.size() > 18) {
			if(main.size() < 9) {
			int i = ((int) (Math.random())*(pioche.size()));
			main.add(pioche.get(i));
			pioche.remove(i);
			}
		}
		if(pioche.size() <= 18) {
			pioche.addAll(defausse);
			melange();
			System.out.println("Pioche melangee !");
		}
		
	}

	
}
