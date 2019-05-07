import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.WindowConstants;

public class test1 {
	
	public static void main(String[] args) {
		
		
		    Frame windowsFrame =new Frame("窗口测试");
	        windowsFrame.setSize(400, 250);
	        windowsFrame.setLocationRelativeTo(null);
	        windowsFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
	        windowsFrame.addWindowListener(new WindowAdapter() {
	        	
	        	@Override
	        	public void windowClosing(WindowEvent e) {
	        		// TODO 自动生成的方法存根
	        		System.exit(0);
	        	}
	        	
			});
	        
	        
	        TextField InputExcelDirectory = new TextField();	        
	        InputExcelDirectory.setColumns(30);
	        TextField OutPutExcelDirectory = new TextField();	        
	        OutPutExcelDirectory.setColumns(30);
	        Button InputExcelDirectoryButton = new Button("打开原始纪录");
	        InputExcelDirectoryButton.setSize(50, 50);
	        Button OutPutExcelDirectoryButton = new Button("打开输出纪录");
	        OutPutExcelDirectoryButton.setSize(50, 50);
	        
	        Button beginButton = new Button("开始计算");
	        beginButton.setSize(50, 50);
	        
	        windowsFrame.add(InputExcelDirectory);
	        windowsFrame.add(InputExcelDirectoryButton);
	        windowsFrame.add(OutPutExcelDirectory);
	        windowsFrame.add(OutPutExcelDirectoryButton);
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
			        		return;
							
						}
			 
			        	
			        	
						
					}
			        
					
					
				}
			});
		
		



		
		
		
		
	}

}
