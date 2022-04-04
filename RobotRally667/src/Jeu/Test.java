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
		File fichier = new File(/*"C:\\Users\\cleme\\git\\Robot-Rally\\RobotRally667\\src\\Jeu\\carte2.txt"); */ "/Users/axel/git/Robot-Rally/RobotRally667/src/Jeu/carte2.txt");
		Carte.setPioche(lectureCarte(fichier));
		Carte.melange();
		Scanner sc = new Scanner(System.in); //demande de choisir un niv de difficultee entre 1 et 8
	    System.out.print("Veuillez choisir un niveau de difficultee entre 1 et 8 :");
	    int i = sc.nextInt();
		Map map1 = new Map(i);
		System.out.println(map1);

		
		Player player1 = new Player("joueur1");
		Player player2 = new Player("joueur2");
		
		while(player1.controleJoueur() && player2.controleJoueur()) {
			while(player1.getMain().size() != 9 && player2.getMain().size() != 9) {
				
				Carte.distribution(player1.getMain());
				Carte.distribution(player2.getMain());
				
				
			}
				
			while((player1.controleJoueur() && player2.controleJoueur()) && (player1.getMain().size() > 0 && player2.getMain().size() > 0)) {
				for(int tour = 0; tour<5; tour++) {
					player1.placementJoueur();
					player1.emplacement();
					player2.placementJoueur();
					player2.emplacement();
					System.out.println(map1);
					System.out.println(player1.getNom() + " choisissez votre carte : ");
					for(int a = 0; a < player1.getMain().size(); a++) {
						System.out.print(a + " : " + player1.getMain(a).toString());
					}
					int choix1 = sc.nextInt();
					System.out.println(player2.getNom() + " choisissez votre carte : ");
					for(int a = 0; a < player2.getMain().size(); a++) {
						System.out.print(a + " : " + player2.getMain(a).toString());
					}
					int choix2 = sc.nextInt();
					
					if(player1.getMain(choix1).getPoints() > player2.getMain(choix2).getPoints()) {
						player1.utilisation(player1.getMain(choix1));
						player2.utilisation(player2.getMain(choix2));

					}
					else {
						player2.utilisation(player2.getMain(choix2));
						player1.utilisation(player1.getMain(choix1));
					}
						
					System.out.println("Fin du tour !");
				}
				
				}
				
				
				
			}
			sc.close();
		}
			
		
		
		
	}

