package server;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import Jeu.Player;


public class SetupClass1 implements Runnable{
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private Thread t;
	public static Player player1;
	public static Player player2;
	public static Player player3;
	public static Player player4;
	public static boolean start = false;
	
	public SetupClass1(String title) {
		try {
			Socket s = new Socket("LocalHost", 61734);
			bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			printWriter = new PrintWriter(s.getOutputStream(), true);
			t = new Thread(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
