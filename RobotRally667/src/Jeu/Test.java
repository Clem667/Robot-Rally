package Jeu;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
				packet.add(av1);
			}
			else {
				Direction d = new Direction(i, carte[1]);
				packet.add(d);
			}
		}
		
		inputStream.close();
		return packet; // faut changer
		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Carte.pioche = lecturecarte("carte2.txt");
		Scanner sc =new Scanner(System.in); //demande de choisir un niv de difficultee entre a  et 8
	    System.out.print("Veuillez choisir un niveau de difficultee entre 1 et 8 :");
	    int i = sc.nextInt();
		Map map1 = new Map(i);
		System.out.println(map1);
		sc.close();
	}
}
