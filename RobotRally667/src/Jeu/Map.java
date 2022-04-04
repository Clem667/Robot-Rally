package Jeu;

public class Map {
	private static final int tailleLigne = 10;//pas besoin de modifier a chaque fois (cote pratique)
	private static final int tailleColonne = 10;
	private static String[][] tab = new String[tailleLigne][tailleColonne];
	private String nomMap;
	private int niveau;
	
	private void SetNiveau(int niveau) {
		if(niveau <= 8 && niveau > 1) {
			this.niveau = niveau;
			SetNomMap(niveau);
		}
		else
			System.err.println("doit etre compris entre 0 et 3");
	}

	private void SetNomMap(int niveau) {// privee !
		this.nomMap = "Map de niveau " + niveau;
	}
	
	
	public Map(int niveau) {
		SetNiveau(niveau);
		System.out.println("Bienvenue sur la " + nomMap);
		for(int i = 0; i < tailleLigne; i++) {
            for(int j = 0; j < tailleColonne; j++) {
                tab[i][j]="# "; //creation de cases normales (vides)
            }
        }
        for(int i = 0; i < niveau; i++) {// pour l'instant le niveau de la map se base sur le nombre de piege
            for(int j = 0; j < 3; j++) {// piege a partir de la ligne 2
            	int a = 2 + i;
            	int b = (int) (Math.random()*(10));
                if(getMap()[a][b].equals("# ")) {
                	tab[a][b]="! "; // pieges
                 }
            }
        }
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) { // vie a partir de 3 ou 4
            	int a = 3 + i*3;
            	int b = (int) (Math.random()*(10));
                if(getMap()[a][b].equals("# ")) {
                	tab[a][b]="V "; //points de vie
                }
            }
        }
        
        for(int i = 0; i<=2; i++) {
        	int a = 3+i*3; // Les drapeaux doivent etre places a la ligne 3 minimum
        	int b = (int) (Math.random()*(10));
        	if(getMap()[a][b] != "# ") { // ne doit pas remplacer des cases speciales
        		i = i - 1;
        	}
        	else
        		tab[a][b] = (i+1) + " ";
        	
        }
 
	}

    public static String[][] getMap() {
        return tab;
    }

    public String toString() {
        String r = "";
        for (int i = 0; i < tailleLigne; i++) {
            for(int j = 0; j < tailleColonne; j++) {
                r += tab[i][j];
            }
            r+="\n";
        }
        return r;
    }
}
	

