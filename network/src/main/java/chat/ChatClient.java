package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static String SERVER_IP = null;
	private static final int SERVER_PORT = 7000;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			SERVER_IP = InetAddress.getLocalHost().getHostAddress();
			
			// 1. Scanner 생성
			scanner = new Scanner(System.in);
			
			// 2. 소켓 생성
			socket = new Socket();
			
			// 3. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP,  SERVER_PORT));
			log("connected");
			
			// 4. IO Stream 받아오기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			
			Thread thread = new ChatClientThread(socket);
			thread.start();
			
			while(true) {
				if(scanner.hasNextLine() == false) {
					continue;
				}
				
				String message = scanner.nextLine();
				
				if("quit".equals(message)) {
					pw.println("quit");
					break;
				}
				
				if("".equals(message) == false){
					pw.println("message:" + message);
				}
			}
			
		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(socket != null && socket.isClosed() == false) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void log(String log) {
		System.out.println("[ChatClient] " + log);
	}
}
