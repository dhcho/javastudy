package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickName;
	private Socket socket;
	private List<PrintWriter> listWriters;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			// 4. IO Stream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			while(true) {
				// 5. 데이터 읽기
				String data = br.readLine();
				if(data == null) {
					ChatServer.log("closed by client");
					doQuit(pw);
					break;
				}
				
				String[] tokens = data.split(":");
				
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					ChatServer.log("에러: 알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch(SocketException e) {
			ChatServer.log("suddenly closed by client");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doQuit(PrintWriter writer) {
		removeWriter(writer);
		
		String data = nickName + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeWriter(PrintWriter writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doMessage(String message) {
		broadcast(nickName + ": " +  message);
	}

	private void doJoin(String nickName, PrintWriter printWriter) {
		this.nickName = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		
		broadcast(data);
		
		/* writer pool에 저장 */
		addWriter(printWriter);
		
		// ack
		printWriter.println("join:ok");
		printWriter.flush();
	}

	private void addWriter(PrintWriter printWriter) {
		synchronized(listWriters) {
			listWriters.add(printWriter);
		}
	}
	
	private void broadcast(String data) {
		synchronized(listWriters) {
			for(PrintWriter writer : listWriters) {
				writer.println(data);
				writer.flush();
			}
		}
	}
}
