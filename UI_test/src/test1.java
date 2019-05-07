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
		
		
		    Frame windowsFrame =new Frame("���ڲ���");
	        windowsFrame.setSize(400, 250);
	        windowsFrame.setLocationRelativeTo(null);
	        windowsFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
	        windowsFrame.addWindowListener(new WindowAdapter() {
	        	
	        	@Override
	        	public void windowClosing(WindowEvent e) {
	        		// TODO �Զ����ɵķ������
	        		System.exit(0);
	        	}
	        	
			});
	        
	        
	        TextField InputExcelDirectory = new TextField();	        
	        InputExcelDirectory.setColumns(30);
	        TextField OutPutExcelDirectory = new TextField();	        
	        OutPutExcelDirectory.setColumns(30);
	        Button InputExcelDirectoryButton = new Button("��ԭʼ��¼");
	        InputExcelDirectoryButton.setSize(50, 50);
	        Button OutPutExcelDirectoryButton = new Button("�������¼");
	        OutPutExcelDirectoryButton.setSize(50, 50);
	        
	        Button beginButton = new Button("��ʼ����");
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
			        		
			        		System.out.println("����xls��β���ļ�");
			        		return;
							
						}
			 
			        	
			        	
						
					}
			        
					
					
				}
			});
		
		



		
		
		
		
	}

}
