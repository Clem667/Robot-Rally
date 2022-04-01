package Jeu;

public class Direction extends Carte {
	
	private String direction;
	
	public Direction(int points, String direction) {
		super(points);
		if(direction.equals("droite") || direction.equals("gauche") || direction.equals("demi-tour")) {
			this.direction = direction;
		}
		else
			System.err.println("Erreur dans class Direction");
	}
	
	public String getDirection() {
		return direction;
	}
	
	public String toString() {
		return "direction vers " + direction + " " + getPoints() + " points\n";
	}
	
}
