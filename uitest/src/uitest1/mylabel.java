package uitest1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.JLabel;

import data.Dayinformation;
import data.OneManData;
import windows.ExtraWorkWindows;
import windows.VacationWindows;

public class mylabel extends JLabel implements MouseListener {
	
	private Color choosecolor;
	private Color nochoosecolor;
	private boolean ischoose = false;
	private String dayclearinformationString;
	private CalendarWindows cal;
	private Dayinformation information = new Dayinformation();
	
	public void SetChooseState() {
		setBackground(choosecolor);
		ischoose = true;	
	}
	
	public void SetNoChooseState() {
		setBackground(nochoosecolor);
		ischoose = false;	
	}
	
	public void Removedata(String name) {
			
		ArrayList<OneManData> data= getCal().getDatagroup();
		
		Iterator<OneManData> l = data.iterator();
		
		while(l.hasNext()) {
			
			OneManData oneManData = (OneManData)l.next();
			
			if (oneManData.getName().equals(name)) {
				
				ArrayList<Dayinformation> dayinformations = oneManData.getDayinformation();			
				Iterator<Dayinformation> l2 = dayinformations.iterator();				
				while (l2.hasNext()) {
					
					Dayinformation dayinformation = (Dayinformation)l2.next();
					if (dayinformation.getLabelday().equals(getText())) {
						
						l2.remove();
					}
					
					
				}
				
			}
			
			

			
		}
				
	}
		
	public Dayinformation getinformation() {
		
		return information;
		
	}
	
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
						
						if (Vwindow.getnoinformationsubmit()) {
							
							SetNoChooseState();
							return;
							
						}
						
						else {
							
							System.out.println("OK");
							
						}
						
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						
						SetNoChooseState();
						return;
					}
					
				});
			
		      }
			
			else if (optionchoose.equals("加班")) {
				
			    ExtraWorkWindows ewindoWindow = new ExtraWorkWindows(this);
			    ewindoWindow.getFrame().setVisible(true);
			    ewindoWindow.getFrame().addWindowListener(new WindowAdapter() {
			    	
			    	@Override
			    	public void windowClosed(WindowEvent e) {
			    				
						if (ewindoWindow.getnoinformationsubmit()) {
							
							SetNoChooseState();
							return;
							
						}
						
						else {
							
							System.out.println("OK");
							
						}
			    		    		

			    	}
			    	
				});
						
		      }
		
		    else {
			
			     System.out.println("错误");
		    }
			
		
			
		}

							
			
		else {
			
			Removedata((String)getCal().getNamelist().getSelectedItem());		
			SetNoChooseState();
			
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
