package excel;

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

import data.Dayinformation;
import data.OneManData;
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
		sheet = workbook.createSheet("1111", 0);
		
		titles.add("姓名");
		titles.add("日期");
		titles.add("类别");
		titles.add("假种");
		titles.add("打卡情况");
		titles.add("未打卡说明");
		
		//设置字体格式
		WritableFont font = new WritableFont(
				WritableFont.createFont("宋体"), 
				12, WritableFont.BOLD, 
				false, 
				UnderlineStyle.NO_UNDERLINE);
		
		//设置单元格格式
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		
		for (int i = 0;i<titles.size();i++) {
			
			jxl.write.Label titlestring = new jxl.write.Label(i, 0, titles.get(i), cellFormat);
			
			sheet.addCell(titlestring);
			
		}
		

		
	}
	
	public void writeline(ArrayList<OneManData> data) throws WriteException 
	{
				
		//设置字体格式
		WritableFont font = new WritableFont(
				WritableFont.createFont("宋体"), 
				12, WritableFont.NO_BOLD, 
				false, 
				UnderlineStyle.NO_UNDERLINE);
		
		//设置单元格格式
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		for (OneManData in:data) {
			
			for (Dayinformation information2 : in.getDayinformation()) {
				
				
				jxl.write.Label nameLabel = new jxl.write.Label(0, nowline,in.getName(), cellFormat);
				jxl.write.Label timeLabel = new jxl.write.Label(1, nowline,information2.getTime(), cellFormat);
				jxl.write.Label catagoryLabel = new jxl.write.Label(2, nowline,information2.getreasons(), cellFormat);
				jxl.write.Label subcatagorylabel = new jxl.write.Label(3, nowline,information2.getreasons_details(), cellFormat);
				jxl.write.Label actualtimenoclearlabel = new jxl.write.Label(4, nowline,information2.getActualtimenoclear(), cellFormat);
				jxl.write.Label explainlabel = new jxl.write.Label(5, nowline,information2.getreasons_explanation(), cellFormat);
				
				sheet.addCell(nameLabel);
				sheet.addCell(timeLabel);
				sheet.addCell(catagoryLabel);
				sheet.addCell(subcatagorylabel);
				sheet.addCell(actualtimenoclearlabel);
				sheet.addCell(explainlabel);
				
				nowline++;
				
			}

			
		}
		

		
						
	}
	
	public void writedone() throws IOException, WriteException {
		
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
