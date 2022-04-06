package Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Player {
	public Player() {
		this.num = numero+1;
		numero++;
		listeJoueur.add(this);
	}
	private static ArrayList<Player> listeJoueur = new ArrayList<Player>();
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private int choix;
	private static int numero = 0;
	private int num = numero + 1;
	private String nom = "R" + num;
	private int PV = 3;
	private int drapeau = 0;
	private boolean horsTension = false; //??
	private int pointDegat; //??
	private int j = 4 + numero;
	private int i = 0;
	private int g = 0;// position dans la liste des orientations et qui déterminera directionPiont
	private final String [] directionPiont = {"S","O","N","E"};
	
	
	public int getChoix() {// retourne le choix de la carte
		return choix;
	}
	
	
	public void setChoix() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez un chiffre entre 0 et 9 inclus");
		int choix = sc.nextInt();
		if(choix >= 0 && choix < 10)
			this.choix = choix;
		else {
			System.out.println("Le choix doit être compris entre 0 et 9 inclus");
			this.choix = (Integer) null;
		}
	}
	
	
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
				if(Map.getMap()[i][j].equals("R" + String.valueOf(num))) {
					Map.getMap()[i][j] = "# ";
				}
			}
		}
		
		if(Map.getMap()[getI()][getJ()].equals("# ")) {
			Map.getMap()[getI()][getJ()] = "R" + String.valueOf(num);
		}
		else if(Map.getMap()[getI()][getJ()].equals("! ")) {
			Map.getMap()[getI()][getJ()] = "R" + String.valueOf(num);
			System.out.println(nom + " a pris un piège !");
			Degat();
		}
		else if(Map.getMap()[getI()][getJ()].equals("V ")) {
			Map.getMap()[getI()][getJ()] = "R" + String.valueOf(num);
			System.out.println(nom + " gagne un point de vie");
			Gain();
		}
		else if(Map.getMap()[getI()][getJ()].equals("R" + String.valueOf(num))) {
			
		}
		else {
			String st = Map.getMap()[getI()][getJ()];
			String st2 = st.substring(st.length());
			System.out.println("Colision");
			listeJoueur.get(Integer.parseInt(st2) - 1).Degat();
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
		placementJoueur();
	}
	
	private void SetJ(int a) {
		if((j + a) > 10)
			j = 10;
		else if((j + a) < 0)
			j = 0;
		else
			j = j + a;
		placementJoueur();
	}
	
	public String emplacement() {
		return nom + " est en : " + i + " " + j + " " + directionPiont[g];
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
		if(directionPiont[g].equals("S")) {
			for(int i = 0; i < a.getAvance(); i++) {
				SetI(1);
			}
		}
		else if(directionPiont[g].equals("N"))
			SetI(-a.getAvance());
		else if(directionPiont[g].equals("E")) {
			for(int i = 0; i < a.getAvance(); i++) {
				SetJ(1);
			}
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
			System.out.println(nom + " a gagne la partie");
			return true;
		}
		else
			return false;
	}
	
	public boolean controleJoueur() {//savoir si le joueur est en vie ou a gagner
		return enVie() && !priseDrapeau();
	}
	
	public void gainDrapeau() {
		if(priseDrapeau())
			System.out.println(nom + " s'est empare des trois drapeaux !"); 
		else {
			if(drapeau == 0) {
				if(Map.getMap()[getI()][getJ()].equals("1 ")) {
					drapeau = 1;
				}
			}
			else if(drapeau == 1) {
				if(Map.getMap()[getI()][getJ()].equals("2 ")) {
					drapeau = 2;
				}
			}
			else
				if(Map.getMap()[getI()][getJ()].equals("3 ")) {
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


	public boolean isHorsTension() {
		return horsTension;
	}

	public void setHorsTension(int i) {
		if(horsTension) {
			Gain();
		}
		if(i == 1) {
			this.horsTension = true;
			choix = (Integer) null;
		}
		else if(i == 2) {
			this.horsTension = false;
		}
	}
	

	public int getPointDegat() {
		return pointDegat;
	}

	public void setPointDegat(int pointDegat) {
		this.pointDegat = pointDegat;
	}
	
	public String toString() {
		return nom + " a " + getPV() + " PV et " + drapeau + " drapeau\n"
				+ emplacement();
	}
	
	
}
