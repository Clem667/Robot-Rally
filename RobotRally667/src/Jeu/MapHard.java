package Jeu;

public class MapHard extends Map {
	
	private final static String[][] mapHard = { 
			{"# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# "}, 
			{"# ", "# ", "! ", "# ", "# ", "! ", "# ", "# ", "# ", "! "},
			{"# ", "! ", "# ", "# ", "! ", "# ", "# ", "! ", "# ", "# "},
			{"! ", "# ", "! ", "! ", "# ", "# ", "! ", "# ", "! ", "# "},
			{"# ", "# ", "! ", "# ", "# ", "! ", "! ", "# ", "1 ", "# "},
			{"# ", "! ", "# ", "# ", "! ", "! ", "# ", "# ", "! ", "! "},
			{"# ", "# ", "2 ", "! ", "# ", "# ", "# ", "! ", "# ", "# "},
			{"! ", "! ", "# ", "! ", "# ", "# ", "! ", "# ", "# ", "# "},
			{"# ", "# ", "# ", "# ", "! ", "! ", "# ", "! ", "! ", "# "},
			{"# ", "! ", "# ", "! ", "3 ", "# ", "! ", "# ", "# ", "! "}}; 
	
	//rajouter les vies
	
	public MapHard() {
		SetNiveau(3);
		tab = mapHard;
	}

	public static String[][] getMap() {
		return mapHard;
	}
	
}
