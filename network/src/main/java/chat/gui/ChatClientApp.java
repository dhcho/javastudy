package chat.gui;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	private static String SERVER_IP = null;
	private static final int SERVER_PORT = 7000;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			SERVER_IP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		//1. create socket
		//2. connect to server
		//3. create iostream
		//4. join
		// String line = br.readLine();
		Socket socket = new Socket();
		
		String line = "JOIN:OK";
		
		if("JOIN:OK".equals(line)) {
			try {
				socket.connect( new InetSocketAddress(SERVER_IP, SERVER_PORT) );
				consoleLog("채팅방에 입장하였습니다.");
				new ChatWindow(name, socket).show();
				
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
	            String request = "join:" + name + "\r\n";
	            pw.println(request);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void consoleLog(String log) {
        System.out.println(log);
    }

}