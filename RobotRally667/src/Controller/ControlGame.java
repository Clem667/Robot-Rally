package Controller;

import Jeu.MapEasy;
import Jeu.MapHard;
import Jeu.MapMedium;
import View.HomePage;

public class ControlGame {
	
	private HomePage homePage;
	
	public static void main(String[] args) {
		new ControlGame();
	}
	
	//Constructeur
	public ControlGame() {
		homePage = new HomePage(this);
		homePage.setVisible(true);
	}
	
	//choix du niveau de la map
	public void selectMapView(String level) {
		if(level == "easy") {
			MapEasy easyMap = new MapEasy();
		}
		
		if(level == "medium") {
			MapMedium mediumMap = new MapMedium();
		}
		
		if(level == "hard") {
			MapHard hardMap = new MapHard();
			
		}
	}
}
