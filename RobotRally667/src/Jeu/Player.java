package Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player extends Thread{
	public Player() {
	}
	
	private List<Carte> main = new ArrayList<Carte>();
	private String name;
	private int numero;
	private int PV = 3;
	private int drapeau = 0;
	private boolean horsTension = false;
	private int pointDegat; //??
	private int j;
	private int i;
	
	public String emplacement() {
		return numero + " est en : " + i + " " + j;
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
	
	private boolean priseDrapeau() { // sert pour la méthode gainDrapeau donc private car nous en aurons pas besoin dans les autres classes
		if(drapeau == 3) {
			return true;
		}
		else
			return false;
	}
	
	public boolean controleJoueur() {//savoir si le joueur est en vie ou a gagner
		return enVie() && priseDrapeau() && leftCard();
	}
	
	public void gainDrapeau() {
		if(priseDrapeau())
			System.out.println(name + " s'est emparé des trois drapeaux !"); 
		else
			drapeau += 1;
	}
	
	public void Degat() {
		if(PV <= 0)// exception ?
			PV = PV - 1;
		if(!enVie()) {
			System.out.println(name + " n'a plus de point de vie");
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
	
	private int carteMain() {
		return main.size();
	}
	
	private boolean leftCard() {
		if(carteMain()<=0)
			return false;
		else
			return true;
	}
	
	public void ajoutMain(Carte carte) {
		if(carteMain()>=9 || carte == null)
			System.err.println("Nombre de cartes déplacées");
		else
			main.add(carte);
	}
	
	//private Carte get(int i) {
	//	return 
	//}
	
	//public void utilisation(main.get(i)) {
		
	//}
	
	
}
