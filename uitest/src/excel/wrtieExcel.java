package excel;

import java.awt.Label;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.common.LengthConverter;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import vacation_extrawork.Dayinformation;
import vacation_extrawork.OneManData;

public class wrtieExcel {
	
	private WritableWorkbook workbook;	
	private ArrayList<String> titles= new ArrayList<String>();
	private int nowline = 1;
	private WritableSheet sheet;
	private String dictionaryString;
	
	public wrtieExcel(String name) throws WriteException, IOException {
		
		createxcel(name);
		
	}
	
	public void createxcel(String name) throws IOException, WriteException{
		
		File currentFile = new File(System.getProperty("user.dir")+"\\"+name);
		dictionaryString = System.getProperty("user.dir")+"\\"+name;
		
		currentFile.createNewFile();
		
		workbook = Workbook.createWorkbook(currentFile);
		sheet = workbook.createSheet("�쳣���ڵ���", 0);
		
		titles.add("����");
		titles.add("���ID");
		titles.add("ʱ��");
		titles.add("ʵ���쳣����ʱ��");
		titles.add("�쳣����ԭ��");
		titles.add("�쳣����ԭ��ϸ��");
		titles.add("�쳣����˵��");
		titles.add("�쳣���ڴ���ʽ");
		
		//���������ʽ
		WritableFont font = new WritableFont(
				WritableFont.createFont("����"), 
				12, WritableFont.BOLD, 
				false, 
				UnderlineStyle.NO_UNDERLINE);
		
		//���õ�Ԫ���ʽ
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		
		for (int i = 0;i<titles.size();i++) {
			
			jxl.write.Label titlestring = new jxl.write.Label(i, 0, titles.get(i), cellFormat);
			
			sheet.addCell(titlestring);
			
		}
		

		
	}
	
	public void writeline(ArrayList<String> datagroup) throws WriteException 
	{
				
		//���������ʽ
		WritableFont font = new WritableFont(
				WritableFont.createFont("����"), 
				12, WritableFont.NO_BOLD, 
				false, 
				UnderlineStyle.NO_UNDERLINE);
		
		//���õ�Ԫ���ʽ
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		for (int i= 0;i<8;i++) {
											
				jxl.write.Label nameLabel = new jxl.write.Label(i, nowline,datagroup.get(i), cellFormat);								
				sheet.addCell(nameLabel);			
												
		}
		nowline++;	
								
	}
	
	public void writedone() throws IOException, WriteException {
		
		nowline =1;
		workbook.write();
		workbook.close();
		
		
	}
	
	public void sendtoserver() throws UnknownHostException, IOException {
		
		File informationFile = new File(dictionaryString);		
		String filename = informationFile.getName();		
		FileInputStream in = new FileInputStream(informationFile);
		
		Socket s = new Socket("111.230.138.68", 9101);		
		OutputStream out = s.getOutputStream();
		
		byte[] namebytes = filename.getBytes();
		int namelength = namebytes.length;
		
		byte[] intbytes= new byte[4];
		              
        intbytes[0] =  (byte) ( namelength & 0xFF);
        intbytes[1] =  (byte) ((namelength>>8) & 0xFF);
        intbytes[2] =  (byte) ((namelength>>16) & 0xFF);
        intbytes[3] =  (byte) ((namelength>>24) & 0xFF);
        
        out.write(intbytes);
        out.flush();
        out.write(namebytes);			
        out.flush();
        
        byte[] buffereddata = new byte[1024];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in,1024);        
        int len = 0;       
        while ((len = bufferedInputStream.read(buffereddata))!=-1) {
			
        	out.write(buffereddata);
			
		}
        
        out.flush();
		in.close();
		s.shutdownOutput();
		
		
		
	}
	
	

}
