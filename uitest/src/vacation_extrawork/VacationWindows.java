package vacation_extrawork;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Calendar.CalendarWindows;
import Calendar.Mylabel;
import ojdbc.DataBaseOperation;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextField;
import javax.swing.JLabel;

public class VacationWindows {

	private JFrame frame;
	JCheckBox morningnocheck;
	private boolean noinformationsubmit = true;
	private String[] reasonsliStrings = new String[] {"换休","年休","事假","丧假","产假","陪护假","未打卡说明"};
	private Color activeColor = new Color(255, 255, 255);
	private Color nagativecColor =  new Color(150,150,150);

	private OneManData data = new OneManData(new ArrayList<Dayinformation>());
	private Mylabel label;
	
	private JComboBox<String> vacationreasons;
	private TextField reasonsexplanation;

	
	
	public OneManData getPersondata() {
		
		return data;
	}
	
	public boolean getnoinformationsubmit() {
		
		return noinformationsubmit;
		
	}
	
	public Mylabel getlabel() {
		return label;
	}
	

		
	public JFrame getFrame() {
		return frame;
	}
	
	

	public VacationWindows(Mylabel label) {

		this.label = label;
		initialize();
	}
	
	public void activeTextfield() {

		reasonsexplanation.setEnabled(true);
		reasonsexplanation.setBackground(activeColor);

	}
	
	public void nagativeTextfield() {
		
		reasonsexplanation.setEnabled(false);
		reasonsexplanation.setBackground(nagativecColor);
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 181, 336);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		vacationreasons = new JComboBox<String>();
		vacationreasons.setPreferredSize(new Dimension(32, 40));
		vacationreasons.setFont(new Font("黑体", Font.BOLD, 18));
		vacationreasons.setModel(new DefaultComboBoxModel<String>(reasonsliStrings));
		frame.getContentPane().add(vacationreasons, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JCheckBox morningnocheck = new JCheckBox("上午未打");
		morningnocheck.setBackground(new Color(245, 245, 245));
		panel.add(morningnocheck);
		morningnocheck.setFont(new Font("黑体", Font.PLAIN, 16));
		morningnocheck.setHorizontalAlignment(SwingConstants.CENTER);
				
		JCheckBox afternoonnocheck = new JCheckBox("下午未打");
		afternoonnocheck.setBackground(new Color(245, 245, 245));
		panel.add(afternoonnocheck);
		afternoonnocheck.setFont(new Font("黑体", Font.PLAIN, 16));
		afternoonnocheck.setHorizontalAlignment(SwingConstants.CENTER);
		
		JCheckBox wholedaynoclear = new JCheckBox("全天未打");
		wholedaynoclear.setHorizontalAlignment(SwingConstants.CENTER);
		wholedaynoclear.setFont(new Font("黑体", Font.PLAIN, 16));
		wholedaynoclear.setBackground(new Color(245, 245, 245));
		panel.add(wholedaynoclear);
		
		reasonsexplanation = new TextField();
		reasonsexplanation.setText("\u8BF7\u8F93\u5165\u672A\u6253\u5361\u539F\u56E0");
		reasonsexplanation.setFont(new Font("微软雅黑", Font.BOLD, 16));
		panel.add(reasonsexplanation);
		
		ButtonGroup mygourpButtonGroup = new ButtonGroup();
		mygourpButtonGroup.add(morningnocheck);
		mygourpButtonGroup.add(afternoonnocheck);
		mygourpButtonGroup.add(wholedaynoclear);
		
		JButton submitvacation = new JButton("提交");
		submitvacation.setPreferredSize(new Dimension(61, 40));
		frame.getContentPane().add(submitvacation, BorderLayout.SOUTH);
				
		nagativeTextfield();
				
		vacationreasons.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String reasonsString = (String)vacationreasons.getSelectedItem();
				
				if (reasonsString.equals("未打卡说明")) {
					
                    activeTextfield();
					
					
				}
				else {
					
					nagativeTextfield();

					
				}				
			}
		});
			
		
		
		
		
		
		submitvacation.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
													
					if (morningnocheck.isSelected()&&!afternoonnocheck.isSelected()) 
					{					
					 
						   setdata("上午未打",reasonsexplanation.getText());
						   noinformationsubmit = false;
						 						 						 
					}
						
					else if (!morningnocheck.isSelected()&&afternoonnocheck.isSelected()) 
					{					
							setdata("下午未打",reasonsexplanation.getText());
							noinformationsubmit = false;

					}
						
					else if(wholedaynoclear.isSelected())
					{					
						    setdata("全天未打",reasonsexplanation.getText());
						    noinformationsubmit = false;

					}
						
					else 
					{							
					     noinformationsubmit = true;
					}
				
							
				frame.dispose();
											
			}
		});
			
	}
	
	
	public void setdata(String Actualtimenoclear,String Explainreason) {
				 
		 String nameString = getlabel().getNewSubimitWindows().getUser().getCheckname();	 
		 Dayinformation information = new Dayinformation();
		 String catogoryString = getlabel().getNewSubimitWindows().getVacationorExtrawork();
		 information.setreasons(catogoryString);
		 String vacationreasonString = (String)vacationreasons.getSelectedItem();
		 information.setreasons_details(vacationreasonString);
		 String timeString = String.valueOf(getlabel().getNewSubimitWindows().getyear())+"-"+
				 String.valueOf(getlabel().getNewSubimitWindows().getmonth())+"-"+getlabel().getText();
		 Date datetime = Date.valueOf(timeString);
		 information.setTime(datetime);
		 information.setLabelday(getlabel().getText());		 
		 information.setActualtimenoclear(Actualtimenoclear);
		 information.setreasons_explanation(Explainreason);
		 information.sethandleovertimework(null);
		 
		 
		 CheckTheManExist(nameString);
		 
		 for (int i=0;i<getlabel().getNewSubimitWindows().getSubmitdatagroup().size();i++) {
			if (nameString.equals(getlabel().getNewSubimitWindows().getSubmitdatagroup().get(i).getName())) {				
				getlabel().getNewSubimitWindows().getSubmitdatagroup().get(i).getDayinformation().add(information);				
			}

		}
		 
		 
		 System.out.println(nameString+"写入假期信息完成");
		
	}
	
	
	private void CheckTheManExist(String name) {
		
		 boolean exist = false;
		 for (int i=0;i<getlabel().getNewSubimitWindows().getSubmitdatagroup().size();i++) {
			if (name.equals(getlabel().getNewSubimitWindows().getSubmitdatagroup().get(i).getName())) {				
				exist = true;		
			}
		 }
		 
		 if (!exist) {
			
			 CreateOneManData(name);
			 
		 }
		 
		
		
	}
	
	
	private void CreateOneManData(String name) {
		
		OneManData OnePersondata = new OneManData(new ArrayList<Dayinformation>());
		OnePersondata.setName(name);
		int id = -1;	
		id = Integer.valueOf(getlabel().getNewSubimitWindows().getUser().getId());
			
		if (id != -1) {
			
			OnePersondata.setId(id);
			getlabel().getNewSubimitWindows().getSubmitdatagroup().add(OnePersondata);
			
		}
		else {
			System.out.println("id查询错误，放弃添加人员信息");
		}
		
		
	}
	
	
}
