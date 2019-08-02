package zzzz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import oracle.net.aso.f;


public class excel {
	
	File inputexcelfile = new File("C:/exceltest.xls");
		
	public void UpdateNamelist() throws BiffException, IOException, ClassNotFoundException, SQLException {
		
		Workbook inputWorkbook = Workbook.getWorkbook(inputexcelfile);	
		Sheet datasheet = inputWorkbook.getSheet(0);		
		int rows = datasheet.getRows();
		DataBaseOperation writeBaseOperation = new DataBaseOperation();
		writeBaseOperation.LinkToDataBase();
		
		for (int i = 0; i < rows; i++) {
			

			String nameString = datasheet.getCell(0, i+1).getContents();
			String typenumber = datasheet.getCell(1, i+1).getContents();
			String guigeString = datasheet.getCell(2, i+1).getContents();
			float  price = Float.valueOf(datasheet.getCell(5, i+1).getContents());
			float  taoshu = Float.valueOf(datasheet.getCell(7, i+1).getContents());
			
							
			writeBaseOperation.InsertIntoOneLine_DATA_WOKERNAMELIST(nameString, typenumber,guigeString,price,taoshu);
			
		}
		writeBaseOperation.DisposeDataBaseLink();
		System.out.println("³É¹¦ÁË");
		
	}
	
	
	
	

}

