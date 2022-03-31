package Jeu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

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
		Scanner sc =new Scanner(System.in); //demande de choisir un niv de difficultee
	    System.out.print("Veuillez choisir un niveau de difficultee entre 1 et 9 :");
	    int i = sc.nextInt();
		Map map1 = new Map(i);
		System.out.println(map1);
	}
}
