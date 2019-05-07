package uitest1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;

import data.persondayinformation;
import windows.ExtraWorkWindows;
import windows.VacationWindows;

public class mylabel extends JLabel implements MouseListener {
	
	private Color choosecolor;
	private Color nochoosecolor;
	private boolean ischoose = false;
	private String dayclearinformationString;
	private CalendarWindows cal;
	private persondayinformation information = new persondayinformation();
	
	
	public Color getChoosecolor() {
		return choosecolor;
	}

	public Color getNochoosecolor() {
		return nochoosecolor;

	}

	public boolean getIschoose() {
		return ischoose;
	}
		
		
	public String getDayclearinformationString() {
		return dayclearinformationString;
	}

	
	public CalendarWindows getCal() {
		return cal;
	}

	public mylabel(CalendarWindows cal) {
		
		super();
		choosecolor = new Color(255,206, 82);
		nochoosecolor = new Color(255,255,255);
		this.setBackground(nochoosecolor);
		this.cal = cal;
								
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!ischoose) {
			
			setBackground(choosecolor);
			ischoose = true;						
			String optionchoose = getCal().getVacationorExtrawork();
			
			if (optionchoose.equals("请假")) {
			
				VacationWindows Vwindow = new VacationWindows(this);
				Vwindow.getFrame().setVisible(true);
				Vwindow.getFrame().addWindowListener(new WindowAdapter() {
					
					@Override
					public void windowClosed(WindowEvent e) {
						
						if (Vwindow.getnodaychoose()) {
							
							setBackground(nochoosecolor);
							ischoose = false;
							return;
							
						}
						
						else {
							
							information = Vwindow.getdaypersoninformation();
							
						}
						

					}
					
				});
			
		      }
			
			else if (optionchoose.equals("加班")) {
				
			    ExtraWorkWindows ewindoWindow = new ExtraWorkWindows();
			    ewindoWindow.getFrame().setVisible(true);
			    ewindoWindow.getFrame().addWindowListener(new WindowAdapter() {
			    	
			    	@Override
			    	public void windowClosed(WindowEvent e) {
			    		
			    		

			    	}
			    	
				});
						
		      }
		
		    else {
			
			     System.out.println("错误");
		    }
			
		
			
		}

							
			
			

		else {
			
			setBackground(nochoosecolor);
			ischoose = false;
			
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	
	

}
