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
	
	
	
	public static void main(String[] args) throws IOException {
		File fichier = new File("C:\\Users\\cleme\\git\\Robot-Rally\\RobotRally667\\src\\Jeu\\carte2.txt");
		//File fichier = new File("/Users/axel/git/Robot-Rally/RobotRally667/src/Jeu/carte2.txt");
		Carte.setPioche(lectureCarte(fichier));
		Carte.melange();
		Scanner sc = new Scanner(System.in); //demande de choisir un niv de difficultee entre 1 et 8
	    System.out.print("Veuillez choisir un niveau de difficultee entre 1 et 3 :");
	    int i = sc.nextInt();
	    Map map1;
	    if(i == 1) {
	    	map1 = new MapEasy();
	    }
	    else if(i == 2) {
	    	map1 = new MapMedium();
	    }
	    else
	    	map1 = new MapHard();
	    System.out.println(map1);

		
		Player player1 = new Player();
		Player player2 = new Player();
		
		while(player1.controleJoueur() && player2.controleJoueur()) {
			while(player1.getMain().size() != 9 && player2.getMain().size() != 9) {
				
				Carte.distribution(player1.getMain());
				Carte.distribution(player2.getMain());
				
			}
				
			while(player1.controleJoueur() && player2.controleJoueur() && (player1.getMain().size() >= 4 && player2.getMain().size() >= 4)) {
				for(int tour = 0; tour<5; tour++) {
					player1.placementJoueur();
					player1.gainDrapeau();
					player1.emplacement();
					player1.getPV();
					System.out.println(player1.getNom() + " voulez-vous vous mettre hors tension :\n1 : oui\n2 : non");
					int reponse1 = sc.nextInt();
					player1.setHorsTension(reponse1);
					player2.placementJoueur();
					player2.gainDrapeau();
					player2.emplacement();
					player2.getPV();
					System.out.println(player2.getNom() + " voulez-vous vous mettre hors tension :");
					int reponse2 = sc.nextInt();
					player2.setHorsTension(reponse2);
					System.out.println(map1);
					
					player1.setChoix();
					player2.setChoix();
					
					Player.ordrePassage();
					
					System.out.println("Fin du tour !");
					tour++;
				
				}
				
				
				
			}
			sc.close();
		}
			
		
		
		
	}
}

