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
		// ����������Socket����
		ServerSocket ss = new ServerSocket(9000);
		System.out.println("�ȴ��ͻ�������");
		// �����ͻ��˵�����
		Socket s = ss.accept(); // ����
		System.out.println("������");
		System.out.println("���ڻ�ȡ�ͻ�������");

		// ��ȡ������
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];				
		int len = -1;
		len = is.read(bys);
	    while (len != -1) {
			len = is.read(bys, 0, len);
			System.out.println("okokok");
			
		}
	    
	    System.out.println("�Ѿ���ȡ��Ͽͻ�������");
	    System.out.println("����д����������");
		
		// ��ȡ�����
		OutputStream os = s.getOutputStream();
		os.write("�����Ѿ��յ�".getBytes());
		
		System.out.println("д������ͷ���Դ");

		// �ͷ���Դ
		s.close();
		// ss.close();
	}


}
