package client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.spi.LocaleNameProvider;

public class ClientTest {
	
	public static void main(String[] args) throws IOException {
		// 创建客户端Socket对象
		Socket s = new Socket("114.115.178.162", 9000);

		// 获取输出流
		OutputStream os = s.getOutputStream();
		os.write("今天天气很好,适合睡觉".getBytes());
		s.shutdownOutput();

		// 获取输入流
		InputStream is = s.getInputStream();
		ByteArrayOutputStream mbyteaArrayOutputStream = new ByteArrayOutputStream();
		byte[] bys = new byte[1024];		
		int len = is.read(bys);// 阻塞
		String client = new String(bys,0,len);
		System.out.println("client接收数据:" + client);
		



		// 释放资源
		s.close();
		
	}

}
