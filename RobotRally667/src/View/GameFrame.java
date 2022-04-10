package View;

import javax.swing.*;

import Controller.ControlGame;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Panel;
//import java.awt.Label;
import java.awt.Toolkit;

//classe de la frame principal du jeu
//on y ajoutera les plateaux en fonction du niveau

public class GameFrame extends JFrame {
	
	private ControlGame control;

	public GameFrame(ControlGame control) {
		this.control = control;

		PlateauEasy easyPlateau = new PlateauEasy();
//		PlateauMedium mediumPlateau = new PlateauMedium();
//		PlateauHard hardPlateau = new PlateauHard();
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameFrame.class.getResource("/ImageRessources/icon image.png")));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("RoboRally");
		this.setSize(1000,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);

		//plateau.setBounds(0, 0, 500, 500);
		//plateau.setLayout(null);
		//plateau.setBackground(Color.black);
		
		//boucle if, en fonction du niveau choisi
		this.add(easyPlateau);

		this.setVisible(true);

	}
}

