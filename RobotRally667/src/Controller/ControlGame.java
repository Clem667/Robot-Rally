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
	public MapEasy selectMapEasy(String level) {
		if(level == "easy") {
			MapEasy easyMap = new MapEasy();
			return easyMap;
		}
		return null;
	}
	
	public MapMedium selectMapMedium(String level) {
		if(level == "medium") {
			MapMedium mediumMap = new MapMedium();
			return mediumMap;
		}
		return null;
	}
	
	public MapHard selectMapHard(String level) {
		if(level == "medium") {
			MapHard hardMap = new MapHard();
			return hardMap;
		}
		return null;
	}
}
