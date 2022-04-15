package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import Jeu.MapMedium;
import java.awt.GridLayout;

public class PlateauMedium extends JPanel {
	
	static final int SCREEN_WIDTH = 500;
	static final int SCREEN_HEIGHT = 500;
	static final int UNIT_SIZE = 50;
	boolean running = false;
	
	//pour l'image de la map
	JLabel map = new JLabel();
	public PlateauMedium() {
		
		this.setBounds(0, 0, 500, 500);
		this.setBackground(Color.black);
		
		map.setIcon(new ImageIcon(PlateauMedium.class.getResource("/ImageRessources/map medium.png")));
		map.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		this.add(map);
		
		startGame();
	}
	
	public void startGame() {
		running = true;
	}
	
	public void draw(Graphics g) {
		if(running) {
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void newMap() {
		MapMedium mMap = new MapMedium();
	}
}
