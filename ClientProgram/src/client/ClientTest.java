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
		// �����ͻ���Socket����
		Socket s = new Socket("114.115.178.162", 9000);

		// ��ȡ�����
		OutputStream os = s.getOutputStream();
		os.write("���������ܺ�,�ʺ�˯��".getBytes());
		s.shutdownOutput();

		// ��ȡ������
		InputStream is = s.getInputStream();
		ByteArrayOutputStream mbyteaArrayOutputStream = new ByteArrayOutputStream();
		byte[] bys = new byte[1024];		
		int len = is.read(bys);// ����
		String client = new String(bys,0,len);
		System.out.println("client��������:" + client);
		



		// �ͷ���Դ
		s.close();
		
	}

}
