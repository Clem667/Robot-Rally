package Jeu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static ArrayList<Carte> lecturecarte(String fichier) throws IOException{
		ArrayList<Carte> packet = new ArrayList<Carte>();
		BufferedReader inputStream = new BufferedReader(new FileReader(fichier));
		String texte;
		while((texte = inputStream.readLine()) != null) {
			String carte[] = texte.split(" ");
			int i = Integer.parseInt(carte[0]);
			if(carte[1].equals("avance")) { 
				int avance = Integer.parseInt(carte[2]);
				Avancer av1 = new Avancer(i, avance);
			}
			else if(carte[1].equals("droite")) {
				Direction d = new Direction(i, "droite");
			}
			else if(carte[1].equals("gauche")) {
				Direction d = new Direction(i, "gauche");
			}
			else if(carte[1].equals("demi-tour")){
				Direction d = new Direction(i, "demi-tour");
			}
			else
				System.err.println("carte incorrecte dans carte.txt");
			
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		Map map1 = new Map(8);
		System.out.println(map1);
	}
}
