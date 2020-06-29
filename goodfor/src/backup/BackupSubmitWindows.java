package backup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Calendar.Mycalendar;
import Calendar.Mylabel;
import ojdbc.DataBaseOperation;
import user.User;
import vacation_extrawork.Dayinformation;
import vacation_extrawork.OneManData;
import javax.swing.GroupLayout.Alignment;

public class BackupSubmitWindows {

	private JFrame frame;
	private String[] yearlistdata;
	private String[] monthlistdata;
	private String[] vacationorextraworklistdata;
	private ArrayList<Mylabel> daylabeList = new ArrayList<Mylabel>();
	private ArrayList<OneManData> submitdatagroup = new ArrayList<OneManData>();
	private Date[] period = new Date[2];
	
	private String workername;

	private JComboBox<String> year;
	private JComboBox<String> month;
	private JComboBox<String> vacationorextrawork;
	private JLabel worknameinformation;
	
	public String getWorkername() {
		return workername;
	}
		
	public BackupSubmitWindows(User user) {
		

		workername = user.getCheckname();

		yearlistdata = new String[] {"2019��", "2020��", "2021��", "2022��", "2023��", "2024��", "2025��", "2026��", "2027��", "2028��", "2029��", "2030��", "2031��", "2032��", "2033��", "2034��", "2035��", "2036��", "2037��", "2038��", "2039��", "2040��", "2041��", "2042��", "2043��", "2044��", "2045��", "2046��", "2047��", "2048��", "2049��", "2050��"};
		monthlistdata = new String[] {"1��","2��","3��","4��","5��","6��","7��","8��","9��","10��","11��","12��"};
		vacationorextraworklistdata = new String[] {"δ��˵��","����","����","���","�¼�","����","ɥ��"};				
		initialize();
								
	}
	
	
		
	public ArrayList<Mylabel> getDaylabeList() {
		return daylabeList;
	}




	public Date[] getPeriod() {
		return period;
	}


	public ArrayList<OneManData> getSubmitdatagroup() {
		return submitdatagroup;
	}


	public void setSubmitdatagroup(ArrayList<OneManData> submitdatagroup) {
		this.submitdatagroup = submitdatagroup;
	}


	public String getVacationorExtrawork() {
				
		String indexinformation = (String)vacationorextrawork.getSelectedItem();		
		return indexinformation;
		
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public ArrayList<OneManData> getsubmitdatagroup() {
		
		return submitdatagroup;
		
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u8BF7\u5047\u63D0\u4EA4");
		frame.setBounds(100, 100, 441, 384);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		JPanel top = new JPanel();
		frame.getContentPane().add(top, BorderLayout.NORTH);
						
		year = new JComboBox<String>();
		year.setToolTipText("\u9009\u62E9\u5E74\u4EFD");
		year.setModel(new DefaultComboBoxModel<String>(yearlistdata));
		year.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 16));
		
		month = new JComboBox<String>();
		month.setToolTipText("\u9009\u62E9\u6708\u4EFD");
		month.setModel(new DefaultComboBoxModel<String>(monthlistdata));
		month.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 16));
		
		vacationorextrawork = new JComboBox<String>();
		vacationorextrawork.setToolTipText("\u9009\u62E9\u672A\u6253\u5361\u539F\u56E0");
		vacationorextrawork.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u5047", "\u52A0\u73ED", "\u6B63\u5E38\u4F11\u5047"}));
		vacationorextrawork.setFont(new Font("Adobe ���� Std R", Font.PLAIN, 16));
		
		worknameinformation = new JLabel("New label");
		worknameinformation.setFont(new Font("����", Font.PLAIN, 14));		
		worknameinformation.setText("��ӭ��¼��"+workername+"!");
		
		GroupLayout gl_top = new GroupLayout(top);
		gl_top.setHorizontalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(worknameinformation)
					.addGap(40)
					.addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(vacationorextrawork, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_top.setVerticalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(vacationorextrawork, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(worknameinformation))
					.addGap(9))
		);
		
		top.setLayout(gl_top);
		
		JPanel middle = new JPanel();
		middle.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frame.getContentPane().add(middle, BorderLayout.CENTER);
		middle.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		middle.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 7, 4, 2));
		
		JLabel label = new JLabel("\u661F\u671F\u4E00");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.BLUE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u661F\u671F\u4E8C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(label_2);
		
		JLabel label_1 = new JLabel("\u661F\u671F\u4E09");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(label_1);
		
		JLabel label_3 = new JLabel("\u661F\u671F\u56DB");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u661F\u671F\u4E94");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u661F\u671F\u516D");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u661F\u671F\u65E5");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(label_6);
		
		JPanel dayzoompJPanel = new JPanel();
		middle.add(dayzoompJPanel, BorderLayout.CENTER);
		dayzoompJPanel.setLayout(new GridLayout(6, 7, 4, 4));
		
		JPanel list = new JPanel();
		middle.add(list, BorderLayout.SOUTH);
		list.setLayout(new BorderLayout(0, 0));
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setFont(new Font("����", Font.PLAIN, 16));
		list.add(submit);
				
		submit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
							
				DataBaseOperation test = new DataBaseOperation();
				if (submitdatagroup.isEmpty()) {
					ShowDialog("û���κ����ݣ���������������");
					return;
				}
				try {
					test.InsertInto_DATA_VACATIONANDOVERWORK_ONEMANDATAGROUP(submitdatagroup);
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
					ShowDialog("���ݷ��ͳɹ�");
					submitdatagroup.clear();
					flashdata();
																					
			}
			
		});
		
		
		
//		for (int i = 0; i < 42; i++) {
//			
//			mylabel mylabel = new mylabel(this);
//			mylabel.setText("");
//			mylabel.setOpaque(true);
//			mylabel.setFont(new Font("����", Font.BOLD, 20));
//			mylabel.setHorizontalAlignment(SwingConstants.CENTER);
//			mylabel.setVerticalAlignment(SwingConstants.CENTER);
//			mylabel.addMouseListener(mylabel);
//			daylabeList.add(mylabel);
//			
//		}
		
		
		for (Mylabel i : daylabeList) {
			
			dayzoompJPanel.add(i);
		}
								
 		flashdata();
						
		year.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					flashdata();
				}

			}
		});
		
		
		month.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				if (e.getStateChange() == ItemEvent.SELECTED) {
					flashdata();
				}
				
			}
		});
		
	
	}


	public int getyear() {
		
		String cachesStringyear = (String)year.getSelectedItem();		
		String yearsString = cachesStringyear.substring(0,cachesStringyear.lastIndexOf("��"));		
		int year = Integer.parseInt(yearsString);
		return year;
	}
	
	public int getmonth() {
		String cachesStringmonth = (String)month.getSelectedItem();		
		String monthString = cachesStringmonth.substring(0,cachesStringmonth.lastIndexOf("��"));		
		int month = Integer.parseInt(monthString);
		return month;
		
	}
	
	public JComboBox<String> getYear() {
		return year;
	}


	public void setYear(JComboBox<String> year) {
		this.year = year;
	}
	

	public JComboBox<String> getMonth() {
		return month;
	}




	public JComboBox<String> getVacationorextrawork() {
		return vacationorextrawork;
	}
	
	
	//ˢ������
	private void flashdata() {
			
//		if (((String)downloadchoose.getSelectedItem()).equals("�ύģʽ")) {
			
			ModeSubmitFlash();
			
//		}
		
//		if (((String)downloadchoose.getSelectedItem()).equals("����ģʽ")) {
			
//			ModeDownloadFlash();
			
//		}
			    		
	}
	
	private void ModeDownloadFlash() {
		// TODO �Զ����ɵķ������
		
		int year = getyear();			
		int month = getmonth();
				
		Mycalendar myMycalendar = new Mycalendar();		
	    myMycalendar.setYear(year);
	    myMycalendar.setMonth(month);
	    
	    String[] daynumbergroup = myMycalendar.getCalendar();
	    
	    //����ˢ���������
	    for (int i = 0; i < 42; i++) {
			
	    	daylabeList.get(i).setText(daynumbergroup[i]);
	    	daylabeList.get(i).SetNoChooseState();
	    				
		}
		
		for (int i = 0; i <2; i++) {
			
			Calendar myCalendar = Calendar.getInstance();		
			if (period[i] !=null) {							
			 myCalendar.setTime(period[i]);
			
			 if (getyear() == myCalendar.get(Calendar.YEAR) && getmonth() == myCalendar.get(Calendar.MONTH)+1) {
				
				 for (int k = 0; k < 42; k++)  {
					 
					 int saveday  = -1;
					 if (daylabeList.get(k).getText()!=null) {
						 saveday = (Integer.valueOf(daylabeList.get(k).getText()));
						 
						 if (saveday ==myCalendar.get(Calendar.DAY_OF_MONTH)) {
								
							 daylabeList.get(k).SetChooseStatefornormalrestdayColor();
							 
						  } 
						 
					  }
					 					 				 				 										 					
				}
												
			 }
			
		  }
						
		}
		
	}




	private void ModeSubmitFlash() {
		
		int year = getyear();			
		int month = getmonth();
				
		Mycalendar myMycalendar = new Mycalendar();		
	    myMycalendar.setYear(year);
	    myMycalendar.setMonth(month);
	    
	    String[] daynumbergroup = myMycalendar.getCalendar();
	    
	    //����ˢ���������
	    for (int i = 0; i < 42; i++) {
			
	    	daylabeList.get(i).setText(daynumbergroup[i]);
	    	daylabeList.get(i).SetNoChooseState();
	    				
		}
	    
	    //��ʼˢ�¼��
	    if (submitdatagroup.isEmpty()) {
			
		    for (int i = 0; i < 42; i++) {
				
		    	daylabeList.get(i).SetNoChooseState();
		    				
			}
		}
	    
	    else {
	    		    	
	    	for (OneManData data:submitdatagroup) {
				
		    	if (data.getName().equals(getWorkername()))     	
		    	{
		    		
	    			for (Dayinformation in:data.getDayinformation()) {
	    				
	    				Calendar calendar = Calendar.getInstance();
	    				calendar.setTime(in.getTime());
	    				int restore_year = calendar.get(Calendar.YEAR);
	    				int restore_month= calendar.get(Calendar.MONTH)+1;
	    										    				    		        		    	
	    				if (getyear() == restore_year && getmonth() == restore_month) {
							
	    	    		    for (int i = 0; i < 42; i++) {
					    		    	
			    		    	if (in.getLabelday().equals(daylabeList.get(i).getText())) {
			    		    				    
			    		    		
			    		    		if (in.getreasons_details().equals("�����ݼ�")) {
			    		    			
			    		    			daylabeList.get(i).SetChooseStatefornormalrestdayColor();
									}
			    		    		else {
			    		    			daylabeList.get(i).SetChooseState();
									}
			    
									break;
								 }	    		    	
					         }
	    					
						}
	    						    		   
	    			 }
	    			 break;
	    			 
		    	 }
		    	
		    	else {
		    		
				    for (int i = 0; i < 42; i++) {
						
				    	daylabeList.get(i).SetNoChooseState();
				    				
					}
				    
				}
		    	
	    	}
	    }
		
		
	}
	

			
	private void ShowDialog(String word) {
		
		JOptionPane.showMessageDialog(null,word, "������ʾ", JOptionPane.ERROR_MESSAGE); 
				
	}
	

	
	public Date GetTheBiggerTimeInperiod() {
		
		if (period[0] !=null &&period[1] !=null ) {
			
			int result = period[0].compareTo(period[1]);
			
			if (result<0) {
				
				return period[1];
				
			}
			
			else if (result>0) {
				
				return period[0];
			}
			else {

                 Date error = Date.valueOf("9999-12-12");
                 return error;
			}
			
			
		}
		
		Date error = Date.valueOf("9999-12-12");
        return error;
		
	}

    
	public Date GetTheSmallerTimeInperiod() {
		
		
          if (period[0] !=null &&period[1] !=null ) {
			
			int result = period[0].compareTo(period[1]);
			
			if (result<0) {
				
				return period[0];
				
			}
			
			else if (result>0) {
				
				return period[1];
			}
			else {

                 Date error = Date.valueOf("9999-12-12");
                 return error;
			}
			
			
		}
		
		Date error = Date.valueOf("9999-12-12");
        return error;		
	}
}
