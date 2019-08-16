package MyThread;

import Calendar.Windows;
import backup.BackupSubmitWindows;

public class MyThread implements Runnable {

	private Windows windows;
	
	public MyThread(Windows windows) {
		
		this.windows = windows;
		
	}
	
	@Override
	public void run() {
		
		windows.getFrame().setVisible(true);
		
	}

}
