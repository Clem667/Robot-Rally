package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main (String [] args) throws UnknownHostException, IOException {
		
		//création d'un socket
		Socket client = new Socket ("127.0.0.1", 1026); //(adresse ip, port sup a 1023)
		//on veut recup le com du client
		System.out.println("Nom client");
		Scanner sc = new Scanner(System.in); 
		String nomClient = sc.next(); 
		// on envoie la donnée au serveur et on définit un flux de sortie 
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		//on utilise la methode write 
		out.writeUTF(nomClient); 
		// on récupere la donnée envoyée par le serveur
		//pour notifier que la connection s'est bien passee
		DataInputStream in = new DataInputStream(client.getInputStream()); 
		String s1 = in.readUTF(); 
		System.out.println(s1);
		
	}

}
