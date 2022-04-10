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
		
	public MapHard() {
		// map difficile predefinie
	}
	
	//rajouter les vies
	
	public MapHard() {
		SetNiveau(3);
		tab = mapHard;
	}

	public static String[][] getMap() {
		return mapHard;
	}
	
}
