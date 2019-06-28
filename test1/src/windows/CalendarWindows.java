package windows;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import bag.Data2;
import javax.swing.JFrame;




public class CalendarWindows {
	
	private JFrame frame;

	


	public JFrame getFrame() {
		return frame;
	}

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarWindows window = new CalendarWindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalendarWindows() {
					
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//		Good1 good1 = new Good1();
		ArrayList<String> d2 = new ArrayList<String>();
		
		d2.add("goood");
		d2.add("123123");
		Iterator l = d2.iterator();
		
		while (l.hasNext()) {


		}
	
	

     }
}
