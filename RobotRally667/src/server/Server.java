package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
	private int nbClients;
	private List<Socket> listSocket = new ArrayList<Socket>();
	private List<Connection> listConnection = new ArrayList<Connection>();

	@Override
	public void run() {
		try {

			// Cr?ation Serveur Socket
			/* >>>>>>> branch 'master' of https://github.com/Clem667/Robot-Rally.git */
			ServerSocket ss = new ServerSocket(4242, 4);
			System.out.println("Demarrage du server");
			
			
			
			// Boucle d'attente de connexion
			while (nbClients < 4) {
				// Creation Socket client / ServeurSocket attend connexion
				Socket s = ss.accept();
				listSocket.add(s);

				nbClients++;
				
				
				// Cr?ation (connexion) de la conversation prend en parametre un Socket(Client)
				Connection connection = new Connection(s, nbClients);
				connection.start();
				listConnection.add(connection);
			}
			System.out.println("Waiting for players...");
			while (true) {
				Thread.sleep(2000);
				if (this.isStartGame(listConnection)) {
					this.messageToClients("[start]");
					System.out.println("Starting game...");
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	public static void main(String[] args) {
		new Server().start();
	}

	public boolean isStartGame(List<Connection> listConnection) {
		boolean start = true;

		for (Connection connection : listConnection) {
			if (connection.isReady() == false) {
				start = false;
			}
		}

		return start;
	}

	public void messageToClients(String message) {
		for (Socket s : listSocket) {
			try {
				PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				pw.println(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void messageClientToClient(String message, Socket source) {
		for (Socket s : listSocket) {
			try {
				if (s != source) {
					PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
					pw.println(message);
					pw.flush();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void booleanClientToClient(boolean bool, Socket source) {
		for (Socket s : listSocket) {
			try {
				if (s != source) {
					PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
					pw.println(bool);
					pw.flush();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Creation class Connection extends Thread
	class Connection extends Thread {
		private Socket socket;
		private int numeroClient;
		private boolean ready = false;

		public Connection(Socket socket, int num) {
			super();
			this.socket = socket;
			this.numeroClient = num;
		}

		// Code de la connection
		@Override
		public void run() {
			try {
				// Lecture
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				// Envoie
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				pw.flush();
				// adresse ip du client
				String ip = socket.getRemoteSocketAddress().toString();

				System.out.println("Connexion du client numero " + numeroClient + "IP = " + ip);

				while (true) {
					String requete = br.readLine();
					System.out.println(ip + " a envoye " + requete);
					if (requete.equals("[start]")) {
						setReady(true);
					}
					break;
				}
				while (true) {
					Thread.sleep(2000);
					System.out.println("Waiting for nicknames...");
					String pseudo = br.readLine();
					System.out.println("IP=" + ip + " ; Pseudo = " + pseudo);
					messageClientToClient(pseudo, socket);
					break;
				}
				while (true) {
					System.out.println("Starting round...");
					}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public boolean isReady() {
			return ready;
		}

		public void setReady(boolean ready) {
			this.ready = ready;
		}

	}

}
