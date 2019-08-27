package test1;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WindowsUI {
	
	private File ExcelinputFile =null;
	private File ExceloutputFile = null;
		
	public File getInputFile() {
		return ExcelinputFile;
	}




	public File getOutputFile() {
		return ExceloutputFile;
	}




	public void ShowWindows() {
		
		
		    Frame windowsFrame =new Frame("计算考勤");
	        windowsFrame.setSize(400, 250);
	        windowsFrame.setLocationRelativeTo(null);
	        windowsFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
	        windowsFrame.addWindowListener(new WindowAdapter() {
	        	
	        	@Override
	        	public void windowClosing(WindowEvent e) {

	        		System.exit(0);
	        	}
	        	
			});
	        
	        
	        TextField InputExcelDirectory = new TextField();	        
	        InputExcelDirectory.setColumns(30);
	        TextField OutPutExcelDirectory = new TextField();	        
	        OutPutExcelDirectory.setColumns(30);
	        Button InputExcelDirectoryButton = new Button("打开原始纪录");
	        InputExcelDirectoryButton.setSize(50, 50);
	        Button OutPutExcelDirectoryButton = new Button("打开输出记录");
	        OutPutExcelDirectoryButton.setSize(50, 50);	        
	        TextField sheetmonthname = new TextField();	        
	        sheetmonthname.setColumns(40);	      	        
	        Button beginButton = new Button("开始计算");
	        beginButton.setSize(50, 50);
	        
	        windowsFrame.add(InputExcelDirectory);
	        windowsFrame.add(InputExcelDirectoryButton);
	        windowsFrame.add(OutPutExcelDirectory);
	        windowsFrame.add(OutPutExcelDirectoryButton);
	        windowsFrame.add(sheetmonthname);
	        windowsFrame.add(beginButton);
	        	        	        
	        windowsFrame.setVisible(true);
	        
	        
	        InputExcelDirectoryButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
			        JFileChooser fileChooser = new JFileChooser();
			        fileChooser.setCurrentDirectory(new File("."));
			        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			        fileChooser.setMultiSelectionEnabled(false);			        
			        int result = fileChooser.showOpenDialog(windowsFrame);
			        
			        if (result == fileChooser.APPROVE_OPTION) {
			        	
			        	File inputFile = fileChooser.getSelectedFile();
			        	String filename = inputFile.getName();
			        	String postilfilename = filename.substring(filename.lastIndexOf(".")+1);
			        	if ( !(postilfilename.equals("xls"))) {
			        		
			        		System.out.println("不是xls结尾的文件");
			        		ShowDialog("不是xls结尾的文件");
			        		return;
							
						}
			        	
			        	ExcelinputFile = inputFile;	
			        	InputExcelDirectory.setText(inputFile.getAbsolutePath());
			        	
			        	
					}
			        
					
					
				}
			});
	        
	        OutPutExcelDirectoryButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			        JFileChooser fileChooser = new JFileChooser();
			        fileChooser.setCurrentDirectory(new File("."));
			        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			        fileChooser.setMultiSelectionEnabled(false);			        
			        int result = fileChooser.showOpenDialog(windowsFrame);
			        
			        
                    if (result == fileChooser.APPROVE_OPTION) {
			        	
			        	File OutPutFile = fileChooser.getSelectedFile();
			        	String filename = OutPutFile.getName();
			        	String postilfilename = filename.substring(filename.lastIndexOf(".")+1);
			        	if ( !(postilfilename.equals("xls"))) {
			        		
			        		System.out.println("不是xls结尾的文件");
			        		
			        		ShowDialog("不是xls结尾的文件");
			        		return;
							
						}
			        	
			        	ExceloutputFile = OutPutFile;
			        	OutPutExcelDirectory.setText(OutPutFile.getAbsolutePath());
			        	
					}
			        
					
				}
			});
	        
	        
	        beginButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (ExcelinputFile != null && ExceloutputFile != null ) {
						
						Workbook test1work = null;
						Workbook writetestworkbook = null;
						WritableWorkbook writetestworkbook2 = null;
						
						try {
							 test1work = Workbook.getWorkbook(ExcelinputFile);
							 writetestworkbook = Workbook.getWorkbook(ExceloutputFile);
							 writetestworkbook2= Workbook.createWorkbook(ExceloutputFile, writetestworkbook);
						} catch (BiffException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}					
						
						ArrayList<String> nameList = new ArrayList<String>();
						String sheetmonthnameString = sheetmonthname.getText();
						if (sheetmonthnameString.equals(null)) {
							
			        		System.out.println("计算月份的表单名称不能为空");			        		
			        		ShowDialog("计算月份的表单名称不能为空");
						}
						
						
						Sheet mysheSheet = writetestworkbook.getSheet(sheetmonthnameString);						
										
						int rows = mysheSheet.getRows();
						
						for (int i = 4; i < rows-3; i++) {
						  nameList.add((mysheSheet.getCell(1, i).getContents()));
						
					    }
						
						Assess.InitialDataInformation(nameList, test1work, "原始数据表单名称", writetestworkbook2, sheetmonthnameString);
						
						try {
							Assess.CalculateAllPersonDayInformations();
						} catch (RowsExceededException e1) {

							e1.printStackTrace();
						} catch (BiffException e1) {

							e1.printStackTrace();
						} catch (WriteException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						} catch (ParseException e1) {
	
							e1.printStackTrace();
						}
						
		
						
						
					}
					
					else {
												
						ShowDialog("输出文件或者输入文件没有设置");
						return;
					
					}
					
				}
			});
		
		
	}
	
	
	private void ShowDialog(String word) {
		
		JOptionPane.showMessageDialog(null,word, "错误提示ʾ", JOptionPane.ERROR_MESSAGE); 
				
	}

}
