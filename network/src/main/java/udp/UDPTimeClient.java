package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPTimeClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = UDPTimeServer.PORT;
	private static final int BUFFER_SIZE = UDPTimeServer.BUFFER_SIZE;

	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			// 1. 소켓 생성
			socket = new DatagramSocket();

			// 2. 입력 받기
			String line = "";

			// 3. 데이터 쓰기
			byte[] sendData = line.getBytes("UTF-8");
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
					new InetSocketAddress(SERVER_IP, SERVER_PORT));

			socket.send(sendPacket);

			// 4. 데이터 읽기
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			socket.receive(receivePacket); // blocking

			byte[] receiveData = receivePacket.getData();
			int length = receivePacket.getLength();
			String message = new String(receiveData, 0, length, "UTF-8");

			System.out.println(message);

		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}

	private static void log(String log) {
		System.out.println("[TimeClient]" + log);
	}
}
