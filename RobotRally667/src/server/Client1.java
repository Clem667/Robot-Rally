package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import Jeu.Carte;
import Jeu.Player;
import Jeu.Map;
import View.GameFrame;

public class Client1 {

	public static void main(String[] args) throws UnknownHostException, IOException {

		// création d'un socket
		Socket client = new Socket("127.0.0.1", 4242); // (adresse ip, port sup a 1023)
		// on veut recup le com du client
		System.out.println("Nom client");
		Scanner sc = new Scanner(System.in);
		String nomClient = sc.next();
		// on envoie la donnée au serveur et on définit un flux de sortie
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		// on utilise la methode write
		out.writeUTF(nomClient);
		// on récupere la donnée envoyée par le serveur
		// pour notifier que la connection s'est bien passee
		DataInputStream in = new DataInputStream(client.getInputStream());
		String s1 = in.readUTF();
		System.out.println(s1);

	}
}
