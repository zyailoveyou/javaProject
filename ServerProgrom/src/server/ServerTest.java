package server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	
	public static void main(String[] args) throws IOException {


		
		while (true) {
			ServerSocket ss = new ServerSocket(9101);
			System.out.println("�����ȴ��ͻ�������");
			Socket s = ss.accept(); // ����
			System.out.println("��ʼһ���µ��ļ����ս���");
			MyServer myServer = new MyServer();
			myServer.SetSocket(s);
			
			Thread serverThread = new Thread(myServer);
			serverThread.start();
			System.out.println("��������");

		}

	}


}
