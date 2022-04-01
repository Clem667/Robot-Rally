package Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {
	public Player(String nom) {
		this.nom = nom;
	}
	
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private String nom;
	private int PV = 3;
	private int drapeau = 0;
	private boolean horsTension = false; //??
	private int pointDegat; //??
	private int j = 4;
	private int i = 0;
	private int g = 0;// position dans la liste des orientations et qui déterminera directionPiont
	private final String [] directionPiont = {"S","O","N","E"};
	
	public ArrayList<Carte> getMain(){
		return main;
	}

	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
	
	
	private void SetI(int a) {
		if((i + a) > 10)
			i = 10;
		else if((i + a) < 0)
			i = 0;
		else
			i = i + a;
	}
	
	private void SetJ(int a) {
		if((j + a) > 10)
			j = 10;
		else if((j + a) < 0)
			j = 0;
		else
			j = j + a;
	}
	
	public void emplacement() {
		System.out.println(nom + " est en : " + i + " " + j + " " + directionPiont[g]);
	}
	
	public void add(Carte c) {
		if(c != null && main.size() < 9)
			main.add(c);
		else
			System.err.println(nom + "ne peut pas ajouter : " + c.toString());
	}
	
	public void utilisation(Direction d) {
		if(d.getDirection() == "droite")
			if(g == 3)
				g = 0;
			else
				g += 1;
		else if(d.getDirection() == "gauche")
			if(g == 0) {
				g = 3;
			}
			else
				g -= 1;
		else
			if(g < 2)
				g += 2;
			else if(g == 2)
				g = 0;
			else
				g = 1;
	}
	
	public void utilisation(Avancer a) {
		if(directionPiont[g] == "S")
			SetI(a.getAvance());
		else if(directionPiont[g] == "N")
			SetI(-a.getAvance());
		else if(directionPiont[g] == "E") {
			SetJ(a.getAvance());
		}
		else
			SetJ(-a.getAvance());
	}
	
	public String getDirectionPiont() {
		return directionPiont[g];
	}
	
	
	public int getPV() {
		return PV;
	}
	
	private boolean enVie() {
		if(PV <= 0) {
			return false;
		}
		else
			return true;
	}
	
	private boolean priseDrapeau() { // sert pour la methode gainDrapeau donc private car nous en aurons pas besoin dans les autres classes
		if(drapeau == 3) {
			return true;
		}
		else
			return false;
	}
	
	public boolean controleJoueur() {//savoir si le joueur est en vie ou a gagner
		return enVie() && priseDrapeau() && JeuVide();
	}
	
	public void gainDrapeau() {
		if(priseDrapeau())
			System.out.println(nom + " s'est emparï¿½ des trois drapeaux !"); 
		else
			drapeau += 1;
	}
	
	public void Degat() {
		if(PV <= 0)// exception ?
			PV = PV - 1;
		if(!enVie()) {
			System.out.println(nom + " n'a plus de point de vie");
		}
	}
	
	public String jeu() {
		Iterator<Carte> mainJeu = main.iterator(); //affiche les cartes dans la main du joueur (Arraylist main)
		String cartes = "Votre jeu : ";
		int i = 0;
		while(mainJeu.hasNext()) {
			i++;
			cartes += i + " : " + mainJeu.toString() + "\n";
		}
		return cartes;
	}
	
	public int carteMain() {
		return main.size();
	}
	
	private boolean JeuVide() {
		if(carteMain()<=0)
			return false;
		else
			return true;
	}
	
	public void ajoutMain(Carte carte) {
		if(carteMain()>=9 || carte == null)
			System.err.println("Nombre de cartes maximums atteintes");
		else
			main.add(carte);
	}
	
	private Carte get(int i) { 
		return main.get(i);
	}


	public boolean isHorsTension() { //getter et setter hors tension pas besoin
		return horsTension;
	}

	public void setHorsTension(boolean horsTension) {
		this.horsTension = horsTension;
	}

	public int getPointDegat() { //getter et setteur hors tension mais pas besoin pour l'instant
		return pointDegat;
	}

	public void setPointDegat(int pointDegat) {
		this.pointDegat = pointDegat;
	}
	
	
}
