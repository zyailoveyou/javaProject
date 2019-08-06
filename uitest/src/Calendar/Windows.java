package Calendar;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import user.user;
import vacation_extrawork.OneManData;

public class Windows {

	protected JFrame frame;
//	protected ArrayList<OneManData> submitdatagroup = new ArrayList<OneManData>();
	protected String WindowsMode;
	protected user user;
	 	
	public JFrame getFrame() {
		return frame;
	}
	public String getWindowsMode() {
		return WindowsMode;
	}
	public user getUser() {
		return user;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public void setWindowsMode(String windowsMode) {
		WindowsMode = windowsMode;
	}
	public void setUser(user user) {
		this.user = user;
	}
	
	
	
	
}
