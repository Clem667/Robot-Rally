package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import Jeu.MapEasy;

public class PlateauEasy extends JPanel {
	static final int SCREEN_WIDTH = 500;
	static final int SCREEN_HEIGHT = 500;
	static final int UNIT_SIZE = 50;
	boolean running = false;
	
	//pour l'image de la map
	JLabel map = new JLabel();
	public PlateauEasy() {
		
		this.setBounds(0, 0, 500, 500);
		this.setBackground(Color.black);
		
		map.setIcon(new ImageIcon(PlateauEasy.class.getResource("/ImageRessources/map easy.png")));
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
		MapEasy eMap = new MapEasy();
	}

}
