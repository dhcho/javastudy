package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientThread extends Thread {
	Socket socket = null;
	Scanner scanner = null;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {				
					String data = br.readLine();
					if(data == null) {
						System.out.println("closed by server");
						break;
					}
					System.out.println(data);
				}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
