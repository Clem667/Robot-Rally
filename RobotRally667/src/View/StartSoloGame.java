package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Toolkit;
import Controller.ControlGame;

import java.awt.Color;
import java.awt.Font;

//classe qui est lance lorsque que le joueur choisi de faire une
//partie seul

public class StartSoloGame extends JFrame implements ActionListener {
	
	private ControlGame control;
	
	private JButton start = new JButton(); //bouton pour demarrer la partie
	private JLabel fond2 = new JLabel(); //label pour le fond de la page
	private JLabel title = new JLabel();
	
	//creation de bouton pour choisir son niveau
	private JToggleButton easy = new JToggleButton();
	private JToggleButton medium = new JToggleButton();
	private JToggleButton hard = new JToggleButton();
	
	StartSoloGame(ControlGame control){
		this.control = control;
		
		//changement de l'icon
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartSoloGame.class.getResource("/ImageRessources/icon image.png")));
		
		this.setTitle("Solo Game");

		//configuration de l'affichage de la page 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setResizable(false);

		start.setBounds(100, 300, 300, 100);
		start.setIcon(new ImageIcon(StartSoloGame.class.getResource("/ImageRessources/startbutton.png")));
		start.addActionListener(this);
		getContentPane().add(start);
		
		easy.setBounds(50, 100, 90, 90);
		easy.setIcon(new ImageIcon(StartSoloGame.class.getResource("/ImageRessources/easy.png")));
		getContentPane().add(easy);
		
		medium.setBounds(190, 100, 90, 90);
		medium.setIcon(new ImageIcon(StartSoloGame.class.getResource("/ImageRessources/medium.png")));
		getContentPane().add(medium);
		
		hard.setBounds(330, 100, 90, 90);
		hard.setIcon(new ImageIcon(StartSoloGame.class.getResource("/ImageRessources/hard.png")));
		getContentPane().add(hard);
		
		title.setText("Choose your level");
		title.setFont(new Font("MV Boli", Font.ITALIC, 35));
		title.setForeground(Color.MAGENTA);
		title.setBounds(100, 30, 300, 45);
		getContentPane().add(title);
		
		fond2.setLocation(0, 0);
		fond2.setSize(494, 471);
		fond2.setIcon(new ImageIcon(HomePage.class.getResource("/ImageRessources/fond2.png")));
		fond2.setOpaque(true);
		getContentPane().add(fond2);
		
		this.setVisible(true); //afficher la frame
		
		//fin de la configuration de la page
	}
	
	//bouton niveau easy
	public void selectMapEasy() {
		control.selectMapEasy("easy");
	}
	
	//bouton niveau medium
	public void selectMapMedium() {
		control.selectMapMedium("medium");
	}
	
	//bouton niveau hard
	public void selectMapHard() {
		control.selectMapHard("hard");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == start){
			this.dispose();
			GameFrame newGame = new GameFrame(null);
		}
	}

}
