package Jeu;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	public Player(String nom) {
		this.nom = nom;
	}
	
	private List<Carte> main = new ArrayList<Carte>();
	private String name;
	
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private String nom;
	private int PV = 3;
	private int drapeau = 0;
	private boolean horsTension = false; //??
	private int pointDegat; //??
	public int j = 4;
	public int i = 8;
	private int g = 0;// position dans la liste des orientations et qui d�terminera directionPiont
	private int j = 4;
	private int i = 0;
	private int g = 0;// position dans la liste des orientations et qui d�terminera directionPiont
	private final String [] directionPiont = {"S","O","N","E"};
	
	
	public String getNom() {
		return nom;
	}
	
	public ArrayList<Carte> getMain(){
		return main;
	}
	
	public Carte getMain(int i) {
		return main.get(i);
	}
	
	public void placementJoueur() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(Map.getMap()[i][j] == "R " && (i != getI() || j != getJ())) {
					Map.getMap()[i][j] = "# ";
				}
			}
		}
		if(Map.getMap()[getI()][getJ()] == "# ")
			Map.getMap()[getI()][getJ()] = "R ";
		else if(Map.getMap()[getI()][getJ()] == "! ") {
			Map.getMap()[getI()][getJ()] = "R ";
			System.out.println(nom + " a pris un pi�ge !");
			Degat();
		}
		else if(Map.getMap()[getI()][getJ()] == "V ") {
			Map.getMap()[getI()][getJ()] = "R ";
			System.out.println(nom + " perd un point de vie");
			Gain();
		}
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
	
	public void utilisationD(Direction d) {
		if(d.getDirection().equals("droite")) {
			if(g == 3) 
				g = 0;
			else 
				g += 1;
		}
		else if(d.getDirection().equals("gauche")) {
			if(g == 0) 
				g = 3;
			else
				g -= 1;
		}
		else {
			if(g < 2)
				g += 2;
			else if(g == 2)
				g = 0;
			else
				g = 1;
		}
	}
	
	
	public void utilisation(Carte c) {
		if(c instanceof Direction)
			utilisationD((Direction) c);
		else
			utilisationA((Avancer) c);
		Carte.defausse.add(c);
		main.remove(c);
	}
	public void utilisationA(Avancer a) {
		if(directionPiont[g].equals("S"))
			SetI(a.getAvance());
		else if(directionPiont[g].equals("N"))
			SetI(-a.getAvance());
		else if(directionPiont[g].equals("E")) {
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
			setHorsTension(true);
			return false;
		}
		else
			return true;
	}
	
	private boolean priseDrapeau() { // sert pour la methode gainDrapeau donc private car nous en aurons pas besoin dans les autres classes
		if(drapeau == 3) {
			System.out.println(nom + " a gagne la partie");
			return false;
		}
		else
			return true;
	}
	
	public boolean controleJoueur() {//savoir si le joueur est en vie ou a gagner
		return enVie() && priseDrapeau();
	}
	
	public void gainDrapeau() {
		if(priseDrapeau())
			System.out.println(nom + " s'est empare des trois drapeaux !"); 
		else {
			if(drapeau == 0) {
				if(Map.getMap()[getI()][getJ()] == "1 ") {
					drapeau = 1;
				}
			}
			else if(drapeau == 1) {
				if(Map.getMap()[getI()][getJ()] == "2 ") {
					drapeau = 2;
				}
			}
			else
				if(Map.getMap()[getI()][getJ()] == "3 ") { //je crois qu'il manque un else
					drapeau = 3;
				}
		}
			
	}
	
	public void Degat() {
		if(PV <= 0)// exception ?
			PV = PV - 1;
		if(!enVie()) {
			System.out.println(nom + " n'a plus de points de vie");
		}
	}
	
	public void Gain() {
		if(PV < 3) {
			PV += 1;
			System.out.println(nom + " a maintenant : " + getPV() + "points de vie");
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
	
	
	public void ajoutMain(Carte carte) {
		if(carteMain()>=9 || carte == null)
			System.err.println("Nombre de cartes maximums atteintes");
		else
			main.add(carte);
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
