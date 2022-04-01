package Jeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	public static ArrayList<Carte> lectureCarte(File fichier) throws IOException{
		ArrayList<Carte> packet = new ArrayList<Carte>();
		BufferedReader is = new BufferedReader(new FileReader(fichier));
		String texte;
		while((texte = is.readLine()) != null) {
			String carte[] = texte.split(" ");
			int i = Integer.parseInt(carte[0]);
			if(carte[1].equals("avance")) { 
				int avance = Integer.parseInt(carte[2]);
				Avancer av1 = new Avancer(i, avance);
				packet.add(av1);
			}
			else {
				Direction d = new Direction(i, carte[1]);
				packet.add(d);
			}
		}
		
		is.close();
		return packet; // faut changer
		
		
	}
	
	public boolean controle(ArrayList<Player> joueurs) {
		 
	}
	
	
	
	public static void main(String[] args) throws IOException {
		File fichier = new File("C:\\Users\\cleme\\git\\Robot-Rally\\RobotRally667\\src\\Jeu\\carte2.txt");
		Carte.setPioche(lectureCarte(fichier));
		Carte.melange();
		Scanner sc = new Scanner(System.in); //demande de choisir un niv de difficultee entre a et 8
	    System.out.print("Veuillez choisir un niveau de difficultee entre 1 et 8 :");
	    int i = sc.nextInt();
		Map map1 = new Map(i);
		System.out.println(map1);
		sc.close();
		
		Player player1 = new Player("joueur1");
		Player player2 = new Player("joueur2");
		
		while(true) {
			while(player1.carteMain() != 9 && player2.carteMain() != 9) {
				Carte.distribution(player1.getMain());
				Carte.distribution(player2.getMain());
				
				System.out.println(player1.getMain());
				System.out.println(player2.getMain());
			}
		}
			
		
		
		
	}
}
