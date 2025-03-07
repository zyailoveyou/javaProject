package file_IO_operation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;

public class fileiotest {
	
	public static void main(String[] args) throws IOException {
		
		
		File myfile = new File("c:\\a.txt");
		
		FileInputStream mFileInputStream = new FileInputStream(myfile);
		
		BufferedInputStream mBufferedInputStream = new BufferedInputStream(mFileInputStream);
		
		
		File mFile2 = new File("c:\\b.txt");
		
		FileOutputStream mFileOutputStream2 = new FileOutputStream(mFile2);
		
		BufferedOutputStream mBufferedOutputStream = new BufferedOutputStream(mFileOutputStream2);
		
		byte[] bufferedbyte = new byte[1024];
		
		int len = 0;
		
		
		while ((len = mBufferedInputStream.read(bufferedbyte))!= -1) {
			mBufferedOutputStream.write(bufferedbyte,0,len);
			
		}
		
		mBufferedInputStream.close();
		mBufferedOutputStream.close();
		
		System.out.println("success");
	}

}
