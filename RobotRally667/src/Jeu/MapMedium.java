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
<<<<<<< HEAD
			{"# ", "# ", "V ", "# ", "# ", "! ", "V ", "! ", "! ", "# "},
			{"# ", "! ", "# ", "# ", "3 ", "# ", "! ", "# ", "V ", "# "}}; 
		
	public MapMedium() { // map normal
=======
			{"# ", "# ", "# ", "# ", "# ", "! ", "# ", "! ", "! ", "# "},
			{"# ", "! ", "# ", "# ", "3 ", "# ", "! ", "# ", "# ", "# "}}; 
	
	//rajouter les vies
	
	public MapMedium() {
>>>>>>> branch 'master' of https://github.com/Clem667/Robot-Rally.git
		SetNiveau(2);
		tab = mapMedium;
	}

	public static String[][] getMap() {
		return mapMedium;
	}
	
}
