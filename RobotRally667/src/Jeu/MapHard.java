package Jeu;

public class MapHard extends Map {
	
	private final static String[][] mapHard = { 
			{"# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# "}, 
			{"# ", "# ", "! ", "# ", "V ", "! ", "# ", "# ", "# ", "! "},
			{"# ", "! ", "# ", "# ", "! ", "# ", "# ", "! ", "# ", "# "},
			{"! ", "# ", "! ", "! ", "# ", "# ", "! ", "# ", "! ", "V "},
			{"# ", "# ", "! ", "# ", "# ", "! ", "! ", "# ", "1 ", "# "},
			{"V ", "! ", "# ", "V ", "! ", "! ", "V ", "# ", "! ", "! "},
			{"# ", "# ", "2 ", "! ", "# ", "V ", "# ", "! ", "# ", "# "},
			{"! ", "! ", "# ", "! ", "V ", "# ", "! ", "# ", "V ", "# "},
			{"# ", "# ", "# ", "# ", "! ", "! ", "# ", "! ", "! ", "# "},
			{"# ", "! ", "# ", "! ", "3 ", "# ", "! ", "# ", "# ", "! "}}; 
<<<<<<< HEAD
		
	public MapHard() { // map difficile predefinie
=======
	
	//rajouter les vies
	
	public MapHard() {
>>>>>>> branch 'master' of https://github.com/Clem667/Robot-Rally.git
		SetNiveau(3);
		tab = mapHard;
	}

	public static String[][] getMap() {
		return mapHard;
	}
	
}
