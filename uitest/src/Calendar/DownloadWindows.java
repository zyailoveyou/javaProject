package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import excel.wrtieExcel;
import jxl.write.WriteException;
import ojdbc.DataBaseOperation;
import tcp.ListInformation;
import user.User;
import java.awt.FlowLayout;

public class DownloadWindows extends Windows {

	private String[] yearlistdata;
	private String[] monthlistdata;
	private ArrayList<Mylabel> daylabeList = new ArrayList<Mylabel>();
	private Date[] period = new Date[2];
	private JComboBox<String> year;
	private JComboBox<String> month;
	private JComboBox<String> vacationorextrawork;
	private JLabel worknameinformation;

	private JComboBox<String> detailstype;
	


	public DownloadWindows(User user) {
		setUser(user);
		setWindowsMode("下载模式");
		yearlistdata = new String[] {"2019年", "2020年", "2021年", "2022年", "2023年", "2024年", "2025年", "2026年", "2027年", "2028年", "2029年", "2030年", "2031年", "2032年", "2033年", "2034年", "2035年", "2036年", "2037年", "2038年", "2039年", "2040年", "2041年", "2042年", "2043年", "2044年", "2045年", "2046年", "2047年", "2048年", "2049年", "2050年"};
		monthlistdata = new String[] {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("下载窗口");
		frame.setBounds(100, 100, 580, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		JPanel top = new JPanel();
		frame.getContentPane().add(top, BorderLayout.NORTH);
						
		year = new JComboBox<String>();
		year.setToolTipText("\u9009\u62E9\u5E74\u4EFD");
		year.setModel(new DefaultComboBoxModel<String>(yearlistdata));
		year.setFont(new Font("黑体", Font.BOLD, 16));
		
		month = new JComboBox<String>();
		month.setToolTipText("\u9009\u62E9\u6708\u4EFD");
		month.setModel(new DefaultComboBoxModel<String>(monthlistdata));
		month.setFont(new Font("黑体", Font.BOLD, 16));
		
		vacationorextrawork = new JComboBox<String>();
		vacationorextrawork.setToolTipText("\u9009\u62E9\u672A\u6253\u5361\u539F\u56E0");
		vacationorextrawork.setModel(new DefaultComboBoxModel(new String[] {"全部","\u8BF7\u5047", "\u52A0\u73ED", "\u6B63\u5E38\u4F11\u5047"}));
		vacationorextrawork.setFont(new Font("黑体", Font.BOLD, 16));
		
		worknameinformation = new JLabel("New label");
		worknameinformation.setFont(new Font("黑体", Font.BOLD,16));		
		worknameinformation.setText("欢迎登录"+"，"+user.getCheckname()+"!");
		
		detailstype = new JComboBox<String>();
		detailstype.setToolTipText("\u9009\u62E9\u672A\u6253\u5361\u539F\u56E0");
		

		detailstype.setModel(new DefaultComboBoxModel(new String[] {"全部", "换休", "年休", "事假","丧假", "产假", "陪护假", "未打卡说明"}));
		detailstype.setFont(new Font("黑体", Font.BOLD, 16));
		
		GroupLayout gl_top = new GroupLayout(top);
		gl_top.setHorizontalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap()
					.addComponent(worknameinformation)
					.addGap(30)
					.addComponent(year, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(month, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(vacationorextrawork, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(detailstype, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		gl_top.setVerticalGroup(
			gl_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_top.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(worknameinformation)
						.addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(vacationorextrawork, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(detailstype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		
		JPanel list = new JPanel();
		middle.add(list, BorderLayout.SOUTH);
		list.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton download = new JButton("\u4E0B\u8F7D\u4FE1\u606F");
		download.setFont(new Font("黑体", Font.BOLD, 16));
		list.add(download);
		
		
		  for (int i = 0; i < 42; i++) {
				
				Mylabel mylabel = new Mylabel(this);
				mylabel.setText("");
				mylabel.setOpaque(true);
				mylabel.setFont(new Font("黑体", Font.PLAIN, 20));
				mylabel.setHorizontalAlignment(SwingConstants.CENTER);
				mylabel.setVerticalAlignment(SwingConstants.CENTER);
				mylabel.addMouseListener(mylabel);
				daylabeList.add(mylabel);
				dayzoompJPanel.add(mylabel);
			}
												
	 		flashdata();
							
			year.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {

					
					if (e.getStateChange() == ItemEvent.SELECTED) {
						flashdata();
					}

				}
			});
			
			
			month.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {

					if (e.getStateChange() == ItemEvent.SELECTED) {
						flashdata();
					}
					
				}
			});
			
			vacationorextrawork.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					if (e.getStateChange() == ItemEvent.SELECTED) {
						
						
						if (((String)vacationorextrawork.getSelectedItem()).equals("请假")) {
							
							detailstype.setModel(new DefaultComboBoxModel(new String[] {"全部", "换休", "年休", "事假","丧假", "产假", "陪护假", "未打卡说明"}));
							
						}
						
						if (((String)vacationorextrawork.getSelectedItem()).equals("加班")) {
							
							detailstype.setModel(new DefaultComboBoxModel(new String[] {"全部","休息日加班", "统一加班", "超时加班","法定节假日加班"}));
							
						}
						
						
						if (((String)vacationorextrawork.getSelectedItem()).equals("正常休假")) {
							
							detailstype.setModel(new DefaultComboBoxModel(new String[] {"全部"}));
							
						}
						
						
						if (((String)vacationorextrawork.getSelectedItem()).equals("全部")) {
							
							detailstype.setModel(new DefaultComboBoxModel(new String[] {"全部"}));
							
						}
						
						
					}
					
				}
			});
			
			
		   download.addMouseListener(new MouseAdapter() {
						

			public void mouseClicked(MouseEvent e) {
				ListInformation listInformation= null;
				DataBaseOperation dataBaseOperation = new DataBaseOperation();
				try {
				  listInformation = dataBaseOperation.Selectfrom_DATA_VACATIONANDOVERWORK_Downloadchoose_ForOneName(user.getCheckname(), getVacationorExtrawork(), getdetailstype(), period);
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				}  catch (SQLException e1) {

					e1.printStackTrace();
				} 
				
				if (listInformation !=null) {
					
					JFileChooser fileChooser=new JFileChooser();
					FileNameExtensionFilter filter=new FileNameExtensionFilter("*.xls","xls");
					fileChooser.setFileFilter(filter);
					fileChooser.setMultiSelectionEnabled(false);
					fileChooser.setCurrentDirectory(new File("c:/"));
					fileChooser.setSelectedFile(new File("异常考勤数据.xls"));
					int result = fileChooser.showSaveDialog(null);
					
					if (result == JFileChooser.APPROVE_OPTION) {
						
						File file=fileChooser.getSelectedFile();
						String path = file.getPath();
						System.out.println(path);
						try {
							wrtieExcel write  = new wrtieExcel(file);
							
							for (ArrayList<String> data:listInformation.getLineinformationgroup()) {
								
								write.writeline(data);
							}
							write.writedone();
												
						} catch (WriteException e1) {
							
							e1.printStackTrace();
						} catch (IOException e1) {
				
							e1.printStackTrace();
						}
						
						ShowDialog("成功导出");
						
					}
					
					if(result == JFileChooser.CANCEL_OPTION) {
						
						
					}
					
					
				}
	
				

			}
		});
		
		
	}
	
	
	

	private void ShowDialog(String word) {
		
		JOptionPane.showMessageDialog(null,word, "提示", JOptionPane.INFORMATION_MESSAGE); 
				
	}
	
	public Date[] getPeriod() {
		return period;
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
	
	public String getVacationorExtrawork() {
		
		String indexinformation = (String)vacationorextrawork.getSelectedItem();		
		return indexinformation;
		
	}
	
	public String getdetailstype() {
		
		String indexinformation = (String)detailstype.getSelectedItem();		
		return indexinformation;
		
	}
	
	
	private void flashdata() {
		int year = getyear();			
		int month = getmonth();
				
		Mycalendar myMycalendar = new Mycalendar();		
	    myMycalendar.setYear(year);
	    myMycalendar.setMonth(month);
	    
	    String[] daynumbergroup = myMycalendar.getCalendar();
	    

	    for (int i = 0; i < 42; i++) {
			
	    	daylabeList.get(i).setText(daynumbergroup[i]);
	    	daylabeList.get(i).SetNoChooseState();
	    				
		}
		
		for (int i = 0; i <2; i++) {
			
			Calendar myCalendar = Calendar.getInstance();		
			if (period[i]!=null) {							
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

}
