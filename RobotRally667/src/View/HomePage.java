package View;

import javax.swing.*;
import Controller.ControlGame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//page d'acceuil du jeu
public class HomePage extends JFrame implements ActionListener {
	
	private ControlGame control;
	
	//creation de bouton pour lancer la partie
	private JButton solo = new JButton("Solo player");
	private JButton multi = new JButton("Multiplayers");

	public HomePage(ControlGame control){
		this.control = control;

		//configuration du bouton solo player
		solo.setBounds(200,280,300,100);
		solo.addActionListener(this);
		solo.setFocusable(false);
		solo.setIcon(new ImageIcon(HomePage.class.getResource("/ImageRessources/singlee.png")));
		this.add(solo);

		//configuration du bouton multiplayer
		multi.setBounds(515,280,300,100);
		multi.addActionListener(this);
		multi.setFocusable(false);
		multi.setIcon(new ImageIcon(HomePage.class.getResource("/ImageRessources/multiplayer.png")));
		this.add(multi);

		//affichage du fond d'ecran
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/ImageRessources/icon image.png")));

		this.setTitle("RoboRally"); //titre de la page
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //la page se ferme totalement
		this.setResizable(false); //on ne peut pas changer la taille de la frame
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		//this.setVisible(true); //la frame apparait

		//mise en place du fond a partir d'une image
		JLabel fond = new JLabel();
		fond.setIcon(new ImageIcon(HomePage.class.getResource("/ImageRessources/bg.png")));
		fond.setOpaque(true);
		this.add(fond);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==solo) {
			StartSoloGame soloPlay = new StartSoloGame(control);
		}
		if(e.getSource()==multi) {
			StartSoloGame multiPlay = new StartSoloGame(control);
		}
		
	}

}
