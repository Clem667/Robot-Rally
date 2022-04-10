package Jeu;

public class MapEasy extends Map {

	private final static String[][] mapEasy = { 
			{"# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# "}, 
			{"# ", "# ", "! ", "# ", "# ", "# ", "# ", "# ", "V ", "# "},
			{"# ", "V ", "V ", "# ", "! ", "# ", "# ", "! ", "# ", "# "},
			{"V ", "# ", "# ", "! ", "# ", "# ", "# ", "V ", "# ", "# "},
			{"# ", "# ", "# ", "# ", "V ", "V ", "! ", "# ", "1 ", "# "},
			{"# ", "! ", "# ", "V ", "# ", "# ", "V ", "# ", "# ", "! "},
			{"V ", "# ", "2 ", "! ", "V ", "# ", "# ", "! ", "# ", "V "},
			{"# ", "! ", "# ", "# ", "# ", "V ", "# ", "# ", "# ", "# "},
			{"# ", "# ", "V ", "V ", "# ", "! ", "# ", "V ", "! ", "# "},
			{"# ", "V ", "# ", "# ", "3 ", "# ", "# ", "# ", "# ", "# "}}; 	
	
	public MapEasy() {
		SetNiveau(1);
		tab = mapEasy;
		System.out.println("Bienvenue sur la map facile !");
	}

	public static String[][] getMap() {
		return tab;
	}
	
}
