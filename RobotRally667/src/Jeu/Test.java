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
			//if(carte[0] == "avance")
				//Avancer a = new Avancer(((int)))
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		Map map1 = new Map(8);
		System.out.println(map1);
	}
}
