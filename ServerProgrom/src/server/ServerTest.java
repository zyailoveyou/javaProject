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
		// 创建服务器Socket对象
		ServerSocket ss = new ServerSocket(9000);
		System.out.println("等待客户端链接");
		// 监听客户端的连接
		Socket s = ss.accept(); // 阻塞
		System.out.println("已连接");
		System.out.println("正在获取客户端数据");

		// 获取输入流
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];				
		int len = -1;
		len = is.read(bys);
	    while (len != -1) {
			len = is.read(bys, 0, len);
			System.out.println("okokok");
			
		}
	    
	    System.out.println("已经获取完毕客户端数据");
	    System.out.println("正在写入输入数据");
		
		// 获取输出流
		OutputStream os = s.getOutputStream();
		os.write("数据已经收到".getBytes());
		
		System.out.println("写入完毕释放资源");

		// 释放资源
		s.close();
		// ss.close();
	}


}
