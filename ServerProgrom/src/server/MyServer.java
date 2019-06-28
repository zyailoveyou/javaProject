package server;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer implements Runnable  {
	
	
	private Socket s = null;
	
	public void SetSocket(Socket s) {
		
		this.s=s;
	}
	
	
	public void StarDataReceive(Socket s) throws IOException {
		
		

		System.out.println("已连接");
		System.out.println("正在获取客户端数据");

		// 获取输入流
		InputStream is = s.getInputStream();
		
		byte[] namelengthbyte = new byte[4];				
		int len = 0;
		len = is.read(namelengthbyte);
		
		int namelen = 0;
		
		namelen = (int) ((namelengthbyte[0] & 0xFF)
                | ((namelengthbyte[1] & 0xFF)<<8)
                | ((namelengthbyte[2] & 0xFF)<<16)
                | ((namelengthbyte[3] & 0xFF)<<24));
		
		System.out.println(namelen);
		System.out.println("开始读取名称");
				
		byte[] namestringbyte = new byte[namelen];
		len = is.read(namestringbyte);
		
		String namesString = new String(namestringbyte);
		System.out.println(namesString);
		
		System.out.println("准备读取文件数据");
		File receivefile = new File(System.getProperty("user.dir")+"\\"+namesString);		
		receivefile.createNewFile();
		System.out.println("创建文件完成");
		FileOutputStream fileOutputStream = new FileOutputStream(receivefile);
		
		byte[] bufferbyte = new byte[1024];
		while ((len = is.read(bufferbyte))!=-1) {
			
			fileOutputStream.write(bufferbyte);
			
		}
		fileOutputStream.flush();
		fileOutputStream.close();
		
		s.shutdownInput();
		s.close();
	

		
	}

	@Override
	public void run() {
		
		
		try {
			StarDataReceive(s);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
