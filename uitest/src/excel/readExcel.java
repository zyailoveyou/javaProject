package excel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import ojdbc.DataBaseOperation;

public class readExcel {
	
	File inputexcelfile = new File("C:/汇景人员名单.xls");
		
	public void UpdateNamelist() throws BiffException, IOException, ClassNotFoundException, SQLException {
		
		Workbook inputWorkbook = Workbook.getWorkbook(inputexcelfile);	
		Sheet datasheet = inputWorkbook.getSheet(0);		
		int rows = datasheet.getRows();
		DataBaseOperation writeBaseOperation = new DataBaseOperation();
		writeBaseOperation.LinkToDataBase();
		
		for (int i = 0; i < rows; i++) {
			
			int id = Integer.valueOf(datasheet.getCell(0, i).getContents());
			String name = datasheet.getCell(1, i).getContents();						
			writeBaseOperation.InsertIntoOneLine_DATA_WOKERNAMELIST(id, name);
			
		}
		writeBaseOperation.DisposeDataBaseLink();		
		
	}
	
	
	
	

}
