package Calendar;

import javax.swing.ImageIcon;

import approvel.ApprovalWindows;
import approvel.BackupApprovelWindows;
import approvel.testwindows;
import backup.BackupDownWindows;
import user.LoginInWindows;

   public class main {
	
	public static void main(String[] args) {
			
		ImageIcon icon = new ImageIcon("uitest/image/upload.png");
			LoginInWindows window = new LoginInWindows();
			window.getFrame().setVisible(true);
			window.getFrame().requestFocus();
		
//		ApprovalWindows testwindows = new ApprovalWindows();
//		testwindows.getFrame().setVisible(true);
//		
//		BackupApprovelWindows tesBackupDownWindows = new BackupApprovelWindows();
//		tesBackupDownWindows.getFrame().setVisible(true);

										
      }
 }
