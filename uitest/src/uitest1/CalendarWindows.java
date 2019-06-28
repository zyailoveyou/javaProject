package uitest1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.jgoodies.forms.layout.CellConstraints.Alignment;

import data.Dayinformation;
import data.OneManData;
import excel.wrtieExcel;
import jxl.write.WriteException;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CalendarWindows {



	private JFrame frame;
	private String[] namelistdata;
	private String[] yearlistdata;
	private String[] monthlistdata;
	private String[] vacationorextraworklistdata;
	private ArrayList<mylabel> daylabeList = new ArrayList<mylabel>();
	private ArrayList<String> choosedaylist =  new ArrayList<String>();
	private ArrayList<OneManData> datagroup = new ArrayList<OneManData>();
	
	
	JComboBox<String> year;
	JComboBox<String> month;
	JComboBox<String> vacationorextrawork;
	JComboBox<String> namelist;
	boolean allistest = false;
	
	


	/**
	 * Launch the application.


	/**
	 * Create the application.
	 */
	public CalendarWindows() {
		
		namelistdata = new String[] {"陈诚","张雪","钟静鸿","汪怡雯","吴友兰","彭小波","谢金豆","杨易","廖龙"};
		yearlistdata = new String[] {"2019年", "2020年", "2021年", "2022年", "2023年", "2024年", "2025年", "2026年", "2027年", "2028年", "2029年", "2030年", "2031年", "2032年", "2033年", "2034年", "2035年", "2036年", "2037年", "2038年", "2039年", "2040年", "2041年", "2042年", "2043年", "2044年", "2045年", "2046年", "2047年", "2048年", "2049年", "2050年"};
		monthlistdata = new String[] {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
		vacationorextraworklistdata = new String[] {"未打卡说明","换休","病假","年假","事假","产假","丧假"};
			
		
		initialize();
		
		

		
	}
	
	
	public String getVacationorExtrawork() {
				
		String indexinformation = (String)vacationorextrawork.getSelectedItem();
		
		return indexinformation;
		
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public ArrayList<OneManData> getDatagroup() {
		
		return datagroup;
		
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel top = new JPanel();
		frame.getContentPane().add(top, BorderLayout.NORTH);
		top.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		year = new JComboBox<String>();
		year.setToolTipText("\u9009\u62E9\u5E74\u4EFD");
		year.setModel(new DefaultComboBoxModel<String>(yearlistdata));
		year.setFont(new Font("Adobe 黑体 Std R", Font.PLAIN, 16));
		top.add(year);
		
		month = new JComboBox<String>();
		month.setToolTipText("\u9009\u62E9\u6708\u4EFD");
		month.setModel(new DefaultComboBoxModel<String>(monthlistdata));
		month.setFont(new Font("Adobe 黑体 Std R", Font.PLAIN, 16));
		top.add(month);
		
		vacationorextrawork = new JComboBox<String>();
		vacationorextrawork.setToolTipText("\u9009\u62E9\u672A\u6253\u5361\u539F\u56E0");
		vacationorextrawork.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u5047", "\u52A0\u73ED"}));
		vacationorextrawork.setFont(new Font("Adobe 黑体 Std R", Font.PLAIN, 16));
		top.add(vacationorextrawork);
		
		namelist = new JComboBox<String>();
		namelist.setToolTipText("\u9009\u62E9\u4EBA\u5458");
		namelist.setModel(new DefaultComboBoxModel<String>(namelistdata));
		namelist.setFont(new Font("Adobe 黑体 Std R", Font.PLAIN, 16));
		top.add(namelist);
		
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
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u661F\u671F\u4E8C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(label_2);
		
		JLabel label_1 = new JLabel("\u661F\u671F\u4E09");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(label_1);
		
		JLabel label_3 = new JLabel("\u661F\u671F\u56DB");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u661F\u671F\u4E94");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u661F\u671F\u516D");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u661F\u671F\u65E5");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		panel.add(label_6);
		
		JPanel dayzoompJPanel = new JPanel();
		middle.add(dayzoompJPanel, BorderLayout.CENTER);
		dayzoompJPanel.setLayout(new GridLayout(6, 7, 4, 4));
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setFont(new Font("宋体", Font.PLAIN, 16));
		middle.add(submit, BorderLayout.SOUTH);
		
		
		
		for (int i = 0; i < 42; i++) {
			
			mylabel mylabel = new mylabel(this);
			mylabel.setText("");
			mylabel.setOpaque(true);
			mylabel.setFont(new Font("宋体", Font.BOLD, 20));
			mylabel.setHorizontalAlignment(SwingConstants.CENTER);
			mylabel.setVerticalAlignment(SwingConstants.CENTER);
			mylabel.addMouseListener(mylabel);
			daylabeList.add(mylabel);
			
		}
		
		
		for (mylabel i : daylabeList) {
			
			dayzoompJPanel.add(i);
		}
		
		OneManData firstPersondata = new OneManData(new ArrayList<Dayinformation>());
		firstPersondata.setName((String)namelist.getSelectedItem());
		datagroup.add(firstPersondata);
		
		flashdata();
		
		

			
		year.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				flashdata();
			}
		});
		
		
		month.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				flashdata();
				
			}
		});
		
		
		submit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				choosedaylist.clear();
				
				//创建一个EXCEL文件
				
			    String year = (String)getYear().getSelectedItem();
			    String month = (String)getMonth().getSelectedItem();
			    
				try {
					wrtieExcel ttExcel = new wrtieExcel(year+month+"请假加班说明.xls");
		            ttExcel.writeline(datagroup);
					ttExcel.writedone();
					ttExcel.sendtoserver();
					ShowDialog("数据已经成功提交");
				} catch (WriteException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// DO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
														
			}
			
		});
		
		
		namelist.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					
					String nameString = (String)namelist.getSelectedItem();
					
					if (datagroup.isEmpty()) {
						
						OneManData persondata = new OneManData(new ArrayList<Dayinformation>());
						persondata.setName(nameString);
						datagroup.add(persondata);
						
					}
					
					else {
						boolean result =false;
						for (int i = 0;i<datagroup.size();i++) {
							
							if (nameString.equals(datagroup.get(i).getName()))
							{							
								result = result||true;							
							}
							
							result =result||false;
						}
		
						if (!result) {
						
							OneManData persondata = new OneManData(new ArrayList<Dayinformation>());
							persondata.setName(nameString);
							datagroup.add(persondata);
							allistest = false;
						}
						
					}
					
					flashdata();
					
				}								
				
			}
		});
		
	
	}


	public int getyear() {
		
		String cachesStringyear = (String)year.getSelectedItem();		
		String yearsString = cachesStringyear.substring(0,cachesStringyear.lastIndexOf("年"));		
		int year = Integer.parseInt(yearsString);
		return year;
	}
	
	public int getmonth() {
		String cachesStringmonth = (String)month.getSelectedItem();		
		String monthString = cachesStringmonth.substring(0,cachesStringmonth.lastIndexOf("月"));		
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


	public JComboBox<String> getNamelist() {
		return namelist;
	}


	public JComboBox<String> getVacationorextrawork() {
		return vacationorextrawork;
	}
	
	
	//刷新数据
	private void flashdata() {
		
	
		int year = getyear();
			
		int month = getmonth();
		
		
		mycalendar myMycalendar = new mycalendar();		
	    myMycalendar.setYear(year);
	    myMycalendar.setMonth(month);
	    
	    String[] daynumbergroup = myMycalendar.getCalendar();
	    
	    
	    for (int i = 0; i < 42; i++) {
			
	    	daylabeList.get(i).setText(daynumbergroup[i]);
	    				
		}
	    
	    for (OneManData data:datagroup) {
			
	    	if (data.getName().equals((String)namelist.getSelectedItem())) {
	    		
	    		if (data.getDayinformation().isEmpty()) {
	    			
	    		    for (int i = 0; i < 42; i++) {
	    				
	    		    	daylabeList.get(i).SetNoChooseState();
	    		    				
	    			}
	    								
				}
	    		
	    		else {
	    			
	    		    for (int i = 0; i < 42; i++) {
	    				
	    		    	daylabeList.get(i).SetNoChooseState();
	    		    				
	    			}
	    		    
	    			for (Dayinformation in:data.getDayinformation()) {
						
		    		    for (int i = 0; i < 42; i++) {
		    					    		    	
		    		    	if (in.getLabelday().equals(daylabeList.get(i).getText())) {		    		    		
		    		    		daylabeList.get(i).SetChooseState();
								break;
							}
		    		    				
		    			}
	    				
						
					}
					
				}

				
			}
			
		}
	    		
	}
	
	private void ShowDialog(String word) {
		
		JOptionPane.showMessageDialog(null,word, "错误提示", JOptionPane.ERROR_MESSAGE); 
				
	}

}
