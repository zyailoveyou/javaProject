package test1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Assess {
	
	
	private static String halfdaynoclear_postil ;
	private static String fulldaynoclear_postil ;
	private static String fiveMinutesLate_postil ;
	private static String fifteenMinutesLate_postil ;	
	private static String thirtyMinutesLate_postil ;	
	private static String halfdayLate_postil ;	
	private static HashMap<String,Integer> AssessDayInformation = null; 
	private static HashMap<String,Integer> LateDayInformation = null; 
	
	
	private static ArrayList<String> WholenameList;
	private static ArrayList<String> ActualCalculateuWholenameList;
	private static Workbook DataResouceWorkbook;
	private static String dataResouceWorkbookSheetName;
	private static WritableWorkbook DataInputwWritableWorkbook;
	private static String dataWriteableWorkbookSheetName;
	
	
	
	public static void InitialDataInformation
	       (ArrayList<String> WholenameList,
			Workbook DataResouceWorkbook,
			String dataResouceWorkbookSheetName,
			WritableWorkbook DataInputwWritableWorkbook,
			String dataWriteableWorkbookSheetName
	    		   )
	 {
//		Assess.WholenameList = WholenameList;
		
			
		Assess.DataResouceWorkbook = DataResouceWorkbook;
		Assess.dataResouceWorkbookSheetName = dataResouceWorkbookSheetName;
		Assess.DataInputwWritableWorkbook = DataInputwWritableWorkbook;
		Assess.dataWriteableWorkbookSheetName = dataWriteableWorkbookSheetName;
		Assess.WholenameList = Assess.getWholenameList();
		Assess.ActualCalculateuWholenameList = Assess.getaActualCalculateuWholenameList();
		
		
		
	 }
		

	private static ArrayList<String> getaActualCalculateuWholenameList() {
		
		ArrayList<String> nameList = new ArrayList<String>();
		Sheet calculatesheetSheet = DataResouceWorkbook.getSheet(0);
		
		int rows = calculatesheetSheet.getRows();
		String nameStringRecive = "";
		
		for (int i = 0; i < rows; i++) {
			
			String nameString = calculatesheetSheet.getCell(0, i).getContents();
			  
			  if (!(nameString.equals(nameStringRecive))) {
				  
				  nameList.add((calculatesheetSheet.getCell(0, i).getContents()));
				  nameStringRecive = nameString;
				  
				
			    }
			
			
		    }
		
				
		return nameList;
	}


	private static ArrayList<String> getWholenameList() {
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		Sheet calculatesheetSheet = DataInputwWritableWorkbook.getSheet(dataWriteableWorkbookSheetName);
		
		int rows = calculatesheetSheet.getRows();
		
		for (int i = 4; i < rows-3; i++) {
		  nameList.add((calculatesheetSheet.getCell(1, i).getContents()));
		
	    }
		
		return nameList;
	}


	public static String getHalfdaynoclear_postil() {
		return halfdaynoclear_postil;
	}


	public static String getFulldaynoclear_postil() {
		return fulldaynoclear_postil;
	}
	
	

	public static String getFiveMinutesLate_postil() {
		return fiveMinutesLate_postil;
	}


	public static String getFifteenMinutesLate_postil() {
		return fifteenMinutesLate_postil;
	}


	public static String getThirtyMinutesLate_postil() {
		return thirtyMinutesLate_postil;
	}


	public static String getHalfdayLate_postil() {
		return halfdayLate_postil;
	}


	public static HashMap<String,Integer> getAssessDayInformation() {
		return AssessDayInformation;
	}



	public static int CaculationAssessDaysByPerson(String Personname,
			                                       Workbook workbook,
			                                       String Sheetname) 
			
			throws BiffException, IOException {
		
	
		Sheet caculateSheet = workbook.getSheet(0);		
		int rows = caculateSheet.getRows();
		int columns   =  caculateSheet.getColumns();
		
		int resultcount = 0;
		for (int i = 0; i < rows; i++) {
			
			caculateSheet.getCell(0, i).getContents();
			
			if (Personname.equals(caculateSheet.getCell(0, i).getContents())) {
				resultcount++;
			}
			
		}
		
		return resultcount;
		
	}
	
	
	
	
	public static void SingleOnePersonCaculationAssessActualDays(
			String Personname,
            Workbook workbook,
            String Sheetname) 

         throws BiffException, IOException {
				 
		  int fulldayclear = Assess.CaculationAssessDaysByPerson(Personname, workbook, Sheetname);
		  		  
		  HashMap<String,Integer> result = new HashMap<String, Integer>();
		  
		  int actualdayclear = 0;
		  int morningnoclear = 0;
		  int afternoonnoclear = 0;
		  int halfdayclear = 0;
		  int fulldaynoclear = 0;
		  
		  String fulldaynoclear_postilinformation = null;
		  String halfdaynoclear_postilinformation = null;
		  	  
		  result.put("fulldayclear", fulldayclear);
		  

          Sheet caculateSheet = workbook.getSheet(0);

          int rows = caculateSheet.getRows();
          int columns   =  caculateSheet.getColumns();

          for (int i = 0; i < rows; i++) {
    	   		  
    		  if (Personname.equals(caculateSheet.getCell(0, i).getContents()))
    			  
    		     {
    			  
    			  if ((caculateSheet.getCell(6, i).getContents()).equals("") == true) 
    			  
    			   {
     				  if ((caculateSheet.getCell(7, i).getContents()).equals("") == true) 
    				  {
     					  
     					 fulldaynoclear++;
     					 
     					 if (fulldaynoclear_postilinformation == null) {
     						 fulldaynoclear_postilinformation  = 
     					     caculateSheet.getCell(2, i).getContents() + " 全天未打"+"\n";
						 }
     					 
     					 else {
     						 
     						fulldaynoclear_postilinformation 
        					 += caculateSheet.getCell(2, i).getContents() + " 全天未打"+"\n";
							
						 }
     					 
    				  }
     				  
     				  else {
						
     					 morningnoclear++;
     					 
     					 if (halfdaynoclear_postilinformation == null) {
     						 
     						halfdaynoclear_postilinformation =
     						caculateSheet.getCell(2, i).getContents() + " 上午未打"+"\n";
							
						}
     					 
     					 else {
     						 halfdaynoclear_postilinformation 
         					 += caculateSheet.getCell(2, i).getContents() + " 上午未打"+"\n";
						 }
     					
					   }
    				  
				   }
    			  
    			   else {
    				  
    				  if ((caculateSheet.getCell(7, i).getContents()).equals("") == true) 
    				  {
    					  
    					  afternoonnoclear++;
      					 if (halfdaynoclear_postilinformation ==null) {
     						 
      						halfdaynoclear_postilinformation =
      						caculateSheet.getCell(2, i).getContents() + " 下午未打"+"\n";
 							
 						}
      					 
      					 else {
      						 halfdaynoclear_postilinformation 
          					 += caculateSheet.getCell(2, i).getContents() + " 下午未打"+"\n";
 						 }
      					
 					   }
    					  
    					  
    				  }
					
				   }
    			  
    		    }

           
        
        halfdayclear = morningnoclear + afternoonnoclear;   
        actualdayclear = fulldayclear - halfdayclear -fulldaynoclear;
        
        result.put("actualdayclear", actualdayclear);
        result.put("halfdayclear", halfdayclear);
        result.put("morningnoclear", morningnoclear);
        result.put("afternoonnoclear", afternoonnoclear);
        result.put("fulldaynoclear", fulldaynoclear);  
        
        AssessDayInformation = result;
        
        
        fulldaynoclear_postil = fulldaynoclear_postilinformation;
        halfdaynoclear_postil = halfdaynoclear_postilinformation;
        

     }
	
	
	
	
	public static void SinglePersonWriteDate(
			String Personname,
            WritableWorkbook workbook,
            String Sheetname) throws RowsExceededException, WriteException, IOException
	
	{
		
		
		WritableSheet test2sheet = workbook.getSheet(Sheetname);
		//设置字体居中格式等等
		
		//设置字体
		WritableFont font = new WritableFont(
				WritableFont.createFont("宋体"), 
				12, WritableFont.BOLD, 
				false, 
				UnderlineStyle.NO_UNDERLINE);
		
		//设置单元格格式
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		
				
		for (int i = 4; i < WholenameList.size()+5; i++) {
			
			if ((test2sheet.getCell(1, i).getContents()).equals(Personname))
			{
				
					Number fulldayclear = new Number(2, i,  AssessDayInformation.get("fulldayclear"),cellFormat);
					
					test2sheet.addCell(fulldayclear);
					
					Number actualdayclear = new Number(3, i,  AssessDayInformation.get("actualdayclear"),cellFormat);	
					test2sheet.addCell(actualdayclear);
					
					Number halfdayclear = new Number(4, i,  AssessDayInformation.get("halfdayclear"),cellFormat);	
					WritableCellFeatures Halfdaynoclear_postil = new WritableCellFeatures();
					Halfdaynoclear_postil.setComment(Assess.getHalfdaynoclear_postil(),3.00,25.00);
					halfdayclear.setCellFeatures(Halfdaynoclear_postil);
					test2sheet.addCell(halfdayclear);
					
					Number fulldaynoclear = new Number(5, i,  AssessDayInformation.get("fulldaynoclear"),cellFormat);
					WritableCellFeatures fulldaynoclear_postil = new WritableCellFeatures();
					fulldaynoclear_postil.setComment(Assess.getFulldaynoclear_postil(),3.00,25.00);
					fulldaynoclear.setCellFeatures(fulldaynoclear_postil);
					test2sheet.addCell(fulldaynoclear);
					
					return;
				
			}			
		}
		

		
	}
	
	
    public static void CalculateAllPersonDayInformations() throws BiffException, IOException, RowsExceededException, WriteException, ParseException 
    
    {
    	for(String name : ActualCalculateuWholenameList)
    	{
    		
    		SingleOnePersonCaculationAssessActualDays(name, DataResouceWorkbook, dataResouceWorkbookSheetName); 		
    		SinglePersonWriteDate(name, DataInputwWritableWorkbook, dataWriteableWorkbookSheetName);
    		SingleOnePersonCaculationLateTimes(name, DataResouceWorkbook, dataResouceWorkbookSheetName);
    		SingleOnePersonCaculationWriteLateDays(name, DataInputwWritableWorkbook, dataWriteableWorkbookSheetName);
    		  		   		
    	}
    	DataInputwWritableWorkbook.write();
		DataInputwWritableWorkbook.close();
		
		System.out.println("OK");
		
	}
	
	
	
	public static void SingleOnePersonCaculationLateTimes(			
			String Personname,
            Workbook workbook,
            String Sheetname) throws ParseException
	
	{
		Sheet caculateSheet = workbook.getSheet(0);	
        int rows = caculateSheet.getRows();
        int columns   =  caculateSheet.getColumns();
        
		DateFormat LateTimesdaDateFormat = new SimpleDateFormat("HH:mm");
	    String fifteenMinutes= "00:15";
	    String fiveMinutes= "00:05";
	    String thirtyMinutes= "00:30";
	    String timeZero = "00:00";
	    
		java.util.Date fifteenMinutestimes = null;
		java.util.Date fiveMinutestimes = null;
		java.util.Date thirtyMinutestimes = null;
		java.util.Date timeZerotimes = null;
		java.util.Date NowLateTimes = null;

		
		fifteenMinutestimes = LateTimesdaDateFormat.parse(fifteenMinutes);
		fiveMinutestimes = LateTimesdaDateFormat.parse(fiveMinutes);
		thirtyMinutestimes = LateTimesdaDateFormat.parse(thirtyMinutes);
		timeZerotimes = LateTimesdaDateFormat.parse(timeZero);
		
		
		String NowLate = null;
		
		
		int fiveMinutesLate = 0 ;
		int fifteenMinutesLate = 0 ;	
		int thirtyMinutesLate = 0 ;	
		int halfdayLate = 0 ;	
		
		String fiveMinutesLate_postilinformation = null;
		String fifteenMinutesLate_postilinformation = null;
		String thirtyMinutesLate_postilinformation = null;
		String halfdayLate_postilinformation = null;
		
		HashMap<String,Integer> result = new HashMap<String, Integer>();

	    
        for (int i = 1; i < rows; i++) 
          {
  	   		  
  		   if (Personname.equals(caculateSheet.getCell(0, i).getContents()))
  			  
  		      {
  			   

  			   
                if ((caculateSheet.getCell(10, i).getContents()).equals("") == false)
                {
                	
                	
              	     NowLate = caculateSheet.getCell(10, i).getContents();
               	     NowLateTimes = LateTimesdaDateFormat.parse(NowLate);
                	

                	if(NowLateTimes.getTime()!=timeZerotimes.getTime())
                		
                	{	
                	
                	if (NowLateTimes.getTime() <= fiveMinutestimes.getTime() )
                	{
                		
                		fiveMinutesLate++;
                		
    					 if (fiveMinutesLate_postilinformation == null) {
     						 
    						 fiveMinutesLate_postilinformation =
    						 caculateSheet.getCell(2, i).getContents() +" " + caculateSheet.getCell(10, i).getContents()  + "\n";
							
						}
    					 
    					 else {
    						 fiveMinutesLate_postilinformation
        					 += caculateSheet.getCell(2, i).getContents() + " " +caculateSheet.getCell(10, i).getContents() + "\n";
						 }                		
					}
                	
                	else if (NowLateTimes.getTime() > fiveMinutestimes.getTime() && NowLateTimes.getTime() <= fifteenMinutestimes.getTime())
                	{
						
                		fifteenMinutesLate++;
                		
   					    if (fifteenMinutesLate_postilinformation == null) {
 						 
   					    	fifteenMinutesLate_postilinformation =
   					        caculateSheet.getCell(2, i).getContents() +" " + caculateSheet.getCell(10, i).getContents() + "\n";
						
					     }
					 
					   else {
						   fifteenMinutesLate_postilinformation
    					   += caculateSheet.getCell(2, i).getContents() +" " + caculateSheet.getCell(10, i).getContents() + "\n";
					     }   
                		
					}
                	
                	else if (NowLateTimes.getTime() > fifteenMinutestimes.getTime() && NowLateTimes.getTime() <= thirtyMinutestimes.getTime()) 
                	{
                		
                		thirtyMinutesLate++;
                		
   					    if (thirtyMinutesLate_postilinformation == null) {
    						 
   					    	thirtyMinutesLate_postilinformation =
   					        caculateSheet.getCell(2, i).getContents() +" " + caculateSheet.getCell(10, i).getContents() + "\n";
						
					     }
					 
					   else {
						   thirtyMinutesLate_postilinformation
    					   += caculateSheet.getCell(2, i).getContents() +" " + caculateSheet.getCell(10, i).getContents() + "\n";
					     }   
                		
						
					}
                	
                	else {
                		
                		
                		halfdayLate++;
                		
   					    if (halfdayLate_postilinformation == null) {
   						 
   					    	halfdayLate_postilinformation =
   					        caculateSheet.getCell(2, i).getContents() +" " + caculateSheet.getCell(10, i).getContents() + "\n";
						
					     }
					 
					   else {
						   halfdayLate_postilinformation
    					   += caculateSheet.getCell(2, i).getContents() + " " +caculateSheet.getCell(10, i).getContents() + "\n";
					     }                   		               						
                	}	
                  }
                }

  			    
  		      };
  				
	        }
        
        result.put("fiveMinutesLate", fiveMinutesLate);
        result.put("fifteenMinutesLate", fifteenMinutesLate);
        result.put("thirtyMinutesLate", thirtyMinutesLate);
        result.put("halfdayLate", halfdayLate);
        
        LateDayInformation = result;
        
        fiveMinutesLate_postil = fiveMinutesLate_postilinformation;
        fifteenMinutesLate_postil = fifteenMinutesLate_postilinformation;
        thirtyMinutesLate_postil = thirtyMinutesLate_postilinformation;
        halfdayLate_postil = halfdayLate_postilinformation;
        
        
	}
	
    
	
	public static void SingleOnePersonCaculationWriteLateDays(
			String Personname,
            WritableWorkbook workbook,
            String Sheetname) throws WriteException 
	{
		WritableSheet test2sheet = workbook.getSheet(Sheetname);
		//设置字体居中格式等等
		
		//设置字体
		WritableFont font = new WritableFont(
				WritableFont.createFont("宋体"), 
				12, WritableFont.BOLD, 
				false, 
				UnderlineStyle.NO_UNDERLINE);
		
		//设置单元格格式
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setAlignment(Alignment.CENTRE);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		
		for (int i = 4; i < WholenameList.size()+5; i++) {
			
			if ((test2sheet.getCell(1, i).getContents()).equals(Personname))
			{
				
					Number fiveMinutesLate = new Number(6, i,  LateDayInformation.get("fiveMinutesLate"),cellFormat);
					WritableCellFeatures fiveMinutesLate_postil = new WritableCellFeatures();
					fiveMinutesLate_postil.setComment(Assess.getFiveMinutesLate_postil(),3.00,25.00);
					fiveMinutesLate.setCellFeatures(fiveMinutesLate_postil);
					test2sheet.addCell(fiveMinutesLate);
					
										
					Number fifteenMinutesLate = new Number(7, i,  LateDayInformation.get("fifteenMinutesLate"),cellFormat);	
					WritableCellFeatures fifteenMinutesLate_postil = new WritableCellFeatures();
					fifteenMinutesLate_postil.setComment(Assess.getFifteenMinutesLate_postil(),3.00,25.00);
					fifteenMinutesLate.setCellFeatures(fifteenMinutesLate_postil);
					test2sheet.addCell(fifteenMinutesLate);
					
										
					Number thirtyMinutesLate = new Number(8, i,  LateDayInformation.get("thirtyMinutesLate"),cellFormat);	
					WritableCellFeatures thirtyMinutesLate_postil = new WritableCellFeatures();
					thirtyMinutesLate_postil.setComment(Assess.getThirtyMinutesLate_postil(),3.00,25.00);
					thirtyMinutesLate.setCellFeatures(thirtyMinutesLate_postil);
					test2sheet.addCell(thirtyMinutesLate);
					
					Number halfdayLate = new Number(9, i, LateDayInformation.get("halfdayLate"),cellFormat);
					WritableCellFeatures halfdayLate_postil = new WritableCellFeatures();
					halfdayLate_postil.setComment(Assess.getHalfdayLate_postil(),3.00,25.00);
					halfdayLate.setCellFeatures(halfdayLate_postil);
					test2sheet.addCell(halfdayLate);
					
					return;
				
			}
			
		}
		
		
		
		
		
		
		
	}
	

	
	

}
