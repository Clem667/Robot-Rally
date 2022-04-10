package Jeu;

public class MapMedium extends Map {
	
	private final static String[][] mapMedium = {
			{"# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# "}, 
			{"# ", "V ", "! ", "# ", "# ", "V ", "# ", "# ", "# ", "! "},
			{"V ", "# ", "# ", "# ", "! ", "# ", "# ", "! ", "# ", "# "},
			{"! ", "# ", "! ", "! ", "# ", "# ", "# ", "# ", "! ", "V "},
			{"# ", "# ", "# ", "V ", "# ", "# ", "! ", "V ", "1 ", "# "},
			{"# ", "! ", "# ", "# ", "# ", "! ", "V ", "# ", "# ", "! "},
			{"# ", "V ", "2 ", "! ", "V ", "# ", "# ", "! ", "# ", "# "},
			{"! ", "! ", "# ", "! ", "# ", "# ", "# ", "# ", "# ", "# "},
			{"# ", "# ", "V ", "# ", "# ", "! ", "V ", "! ", "! ", "# "},
			{"# ", "! ", "# ", "# ", "3 ", "# ", "! ", "# ", "V ", "# "}}; 

	public MapMedium() {
		SetNiveau(2);
		tab = mapMedium;
		System.out.println("Bienvenue sur la map normal !");
	}

	public static String[][] getMap() {
		return mapMedium;
	}
	
}
