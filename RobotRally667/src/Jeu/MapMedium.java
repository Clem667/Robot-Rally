package Jeu;

public class MapMedium extends Map {
	
	private final static String[][] mapMedium = {
			{"# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# ", "# "}, 
			{"# ", "# ", "! ", "# ", "# ", "# ", "# ", "# ", "# ", "! "},
			{"# ", "# ", "# ", "# ", "! ", "# ", "# ", "! ", "# ", "# "},
			{"! ", "# ", "! ", "! ", "# ", "# ", "# ", "# ", "! ", "# "},
			{"# ", "# ", "# ", "# ", "# ", "# ", "! ", "# ", "1 ", "# "},
			{"# ", "! ", "# ", "# ", "# ", "! ", "# ", "# ", "# ", "! "},
			{"# ", "# ", "2 ", "! ", "# ", "# ", "# ", "! ", "# ", "# "},
			{"! ", "! ", "# ", "! ", "# ", "# ", "# ", "# ", "# ", "# "},
			{"# ", "# ", "# ", "# ", "# ", "! ", "# ", "! ", "! ", "# "},
			{"# ", "! ", "# ", "# ", "3 ", "# ", "! ", "# ", "# ", "# "}}; 
	
	//rajouter les vies
	
	public MapMedium() { // map normal
		SetNiveau(2);
		this.tab = mapMedium;
	}

	public static String[][] getMap() {
		return mapMedium;
	}
	
}
