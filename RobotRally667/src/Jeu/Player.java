package Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Player implements Comparable<Player> {
	
	
	public Player() {
		this.num = numero + 1;
		numero++;
		listeJoueur.add(this);
	}
	
	
	public static ArrayList<Player> listeJoueur = new ArrayList<Player>(4);// les joueurs seront stocké dans cette liste s'ils ne sont pas hors tension
	private ArrayList<Carte> main = new ArrayList<Carte>(9);// seront stockés les 9 cartes du joueur.
	private int choix;// correspond au choix de la carte
	private static int numero = 0;
	private int num = numero + 1;// correspond au numéro d'un joueur
	private String nom = "R" + num;
	private int PV = 3;// 3 points de vie
	private int drapeau = 0;
	private boolean horsTension = false;
	private int j = 4 + numero;
	private int i = 0;
	private int g = 0;// position dans le tableau des orientations et qui determinera directionPiont
	private final String [] directionPiont = {"S","O","N","E"};// (Sud, Ouest,...)
	
	
	public int getChoix() {// retourne le choix de la carte
		return choix;
	}
	
	public void setChoix() {// choix de la carte
		if(!isHorsTension() && main.size()>=4) {
			Scanner sc = new Scanner(System.in);
			System.out.println(nom + " choisissez une carte :");
			for(int i = 0; i < main.size(); i++) {
				System.out.println(i + " : " + main.get(i).toString());
			}
			int choix = sc.nextInt();
			if(choix >= 0 && choix < main.size()) {
				this.choix = choix;
			}
			else {
				System.out.println("Le choix doit etre compris entre 0 et " + main.size() + " inclus");
			}
		}
		else
			System.err.println(getNom() + " est hors tension");
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
			System.out.println(nom + " a pris un piege !");
			Degat();
		}
		else if(Map.getMap()[getI()][getJ()].equals("V ")) {
			Map.getMap()[getI()][getJ()] = "R" + String.valueOf(num);
			System.out.println(nom + " gagne un point de vie");
			Gain();
		}
		else if(Map.getMap()[getI()][getJ()].equals("R" + String.valueOf(num))) {
			//le joueur se trouve bien sur son emplacement
		}
		else if(Map.getMap()[getI()][getJ()].equals("1 ") || Map.getMap()[getI()][getJ()].equals("2 ") || Map.getMap()[getI()][getJ()].equals("3 ")) {
			gainDrapeau();
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
		int indice;
		if(a.getAvance() > 0) {
			indice = a.getAvance();
			if(directionPiont[g].equals("S")) {
				for(int i = 0; i < indice; i++) {
					SetI(1);
				}
			}
			else if(directionPiont[g].equals("N")) {
				for(int i = 0; i < indice; i++) {
					SetI(-1);
				}
			}
			else if(directionPiont[g].equals("E")) {
				for(int i = 0; i < indice; i++) {
					SetJ(1);
				}
			}
			else {
				for(int i = 0; i < indice; i++) {
					SetJ(-1);
				}
			}
		}
		else {
			indice = a.getAvance();
			if(directionPiont[g].equals("S")) {
				SetI(-1);
			}
			else if(directionPiont[g].equals("N")) {
				SetI(1);
			}
			else if(directionPiont[g].equals("E")) {
				SetJ(-1);
			}
			else {
				SetJ(1);
			}
		}
		
	}
	
	public String getDirectionPiont() {
		return directionPiont[g];
	}
	
	
	public int getPV() {
		return PV;
	}
	
	private boolean enVie() {
		if(PV <= 0) {
			setHorsTension(1);
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
		if(PV > 0)// exception ?
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
			cartes += i + " : " + mainJeu.toString();
		}
		return cartes;
	}
	
	public int carteMain() {
		return main.size();
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
			if(listeJoueur.contains(this)) {
				listeJoueur.remove(this);
			}
		}
		else if(i == 2) {
			this.horsTension = false;
			if(!listeJoueur.contains(this)) {
				listeJoueur.add(this);
			}
		}
	}
	
	public String toString() {
		return nom + " a " + getPV() + " PV et " + drapeau + " drapeau\n"
				+ emplacement();
	}
	
	public static void ordrePassage() {
		for(int i = 0; i < listeJoueur.size(); i++) {
			if(listeJoueur.get(i) != null)
				listeJoueur.get(i).utilisation(listeJoueur.get(i).getMain(listeJoueur.get(i).getChoix()));
		}
	}

	@Override
	public int compareTo(Player o) {// comparateur de joueur
		if(o != null || o.getMain(o.getChoix()).getPoints() > getMain(getChoix()).getPoints()) {
			return -1;
		}
		else if(o.getMain(o.getChoix()).getPoints() == getMain(getChoix()).getPoints()) {
			return 0;
		}
		else
			return 1;
	}
	
	
	public static String checkPoint() {
		String affiche = "";
		for(int i = 0; i < listeJoueur.size(); i++) {
			affiche += listeJoueur.get(i).toString() + "\n";
		}
		return affiche;
	}
	
}
