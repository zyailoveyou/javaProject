package Calendar;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import approvel.ApprovalWindows;
import approvel.BackupApprovelWindows;
import approvel.testwindows;
import backup.BackupDownWindows;
import user.LoginInWindows;

   public class main {
	
	public static void main(String[] args) {
			
	    try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginInWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
			
	    
	    
	    
			LoginInWindows window = new LoginInWindows();
			window.getFrame().setVisible(true);
			window.getFrame().requestFocus();
											
      }
 }