package calendar_test1;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class testmain1 {
	
	public static void main(String[] args) {
		
        try {  
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //windows������  
         }catch (Exception e) {  
           e.printStackTrace();  
         }  
         CalendarFrame frame=new CalendarFrame();   
         frame.setBounds(100,100,360,300);   
         frame.setTitle("����С����");  
         frame.setLocationRelativeTo(null);//���������ʾ  
         frame.setVisible(true);   
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		
	}

}
