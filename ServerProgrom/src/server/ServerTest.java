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
			System.out.println("监听等待客户端链接");
			Socket s = ss.accept(); // 阻塞
			System.out.println("开始一个新的文件接收进程");
			MyServer myServer = new MyServer();
			myServer.SetSocket(s);
			
			Thread serverThread = new Thread(myServer);
			serverThread.start();
			System.out.println("启动结束");

		}

	}


}
