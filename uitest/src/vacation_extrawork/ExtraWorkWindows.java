package vacation_extrawork;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.SwingConstants;

import Calendar.Mylabel;
import ojdbc.DataBaseOperation;

import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class ExtraWorkWindows {

	
	private boolean noinformationsubmit = true;
	private JFrame frame;
	private Mylabel label;
	private JComboBox extraworktype;
	private JCheckBox morningextrawork;
	private JCheckBox afternoonextrawork;
	private JCheckBox wholedayextrawork;
	private JComboBox howtodealwithoverwork;
	private JPanel panelreason;
	private JLabel labelreason;
	private JPanel paneltime;
	private JLabel labeltime;
	private JPanel panelhandle;
	private JLabel labelhandlework;
		
	public boolean isNoinformationsubmit() {
		return noinformationsubmit;
	}

	public Mylabel getlabel() {
		return label;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getFrame() {
		return frame;
	}

	public ExtraWorkWindows(Mylabel label) {
		this.label = label;
		initialize();
	}
	
	public boolean getnoinformationsubmit() {
		
		return noinformationsubmit;
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u52A0\u73ED\u8BBE\u7F6E");
		frame.setBounds(100, 100, 207, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		ButtonGroup mygourpButtonGroup = new ButtonGroup();
		
		panelreason = new JPanel();
		panelreason.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		labelreason = new JLabel("\u539F\u56E0\u9009\u62E9\uFF1A");
		extraworktype = new JComboBox();
		extraworktype.setPreferredSize(new Dimension(38, 40));
		extraworktype.setFont(new Font("黑体", Font.BOLD, 16));
		extraworktype.setModel(new DefaultComboBoxModel(new String[] {"\u4F11\u606F\u65E5\u52A0\u73ED", "\u6CD5\u5B9A\u8282\u5047\u65E5\u52A0\u73ED", "\u8D85\u65F6\u52A0\u73ED", "\u7EDF\u4E00\u52A0\u73ED"}));
		GroupLayout gl_panelreason = new GroupLayout(panelreason);
		gl_panelreason.setHorizontalGroup(
			gl_panelreason.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelreason.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelreason.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelreason.createSequentialGroup()
							.addComponent(extraworktype, 0, 164, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_panelreason.createSequentialGroup()
							.addComponent(labelreason)
							.addGap(5))))
		);
		gl_panelreason.setVerticalGroup(
			gl_panelreason.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelreason.createSequentialGroup()
					.addGap(5)
					.addComponent(labelreason)
					.addGap(5)
					.addComponent(extraworktype, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		panelreason.setLayout(gl_panelreason);
		
		paneltime = new JPanel();
		paneltime.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		labeltime = new JLabel("\u65F6\u95F4\u9009\u62E9\uFF1A");
		
		morningextrawork = new JCheckBox("\u4E0A\u5348\u52A0\u73ED");
		morningextrawork.setFont(new Font("黑体", Font.PLAIN, 16));
		morningextrawork.setHorizontalAlignment(SwingConstants.LEFT);
		morningextrawork.setAlignmentX(Component.CENTER_ALIGNMENT);
		mygourpButtonGroup.add(morningextrawork);
		
		afternoonextrawork = new JCheckBox("\u4E0B\u5348\u52A0\u73ED");
		afternoonextrawork.setFont(new Font("黑体", Font.PLAIN, 16));
		afternoonextrawork.setHorizontalAlignment(SwingConstants.LEFT);
		afternoonextrawork.setAlignmentX(Component.CENTER_ALIGNMENT);
		mygourpButtonGroup.add(afternoonextrawork);
		
		wholedayextrawork = new JCheckBox("\u5168\u5929\u52A0\u73ED");
		wholedayextrawork.setFont(new Font("黑体", Font.PLAIN, 16));
		wholedayextrawork.setHorizontalAlignment(SwingConstants.LEFT);
		wholedayextrawork.setAlignmentX(Component.CENTER_ALIGNMENT);
		mygourpButtonGroup.add(wholedayextrawork);
		GroupLayout gl_paneltime = new GroupLayout(paneltime);
		gl_paneltime.setHorizontalGroup(
			gl_paneltime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paneltime.createSequentialGroup()
					.addGroup(gl_paneltime.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_paneltime.createSequentialGroup()
							.addGap(5)
							.addComponent(labeltime, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_paneltime.createSequentialGroup()
						
							.addComponent(morningextrawork))
						.addGroup(gl_paneltime.createSequentialGroup()
							
							.addComponent(wholedayextrawork))
						.addGroup(gl_paneltime.createSequentialGroup()
							
							.addComponent(afternoonextrawork)))
					.addGap(5))
		);
		gl_paneltime.setVerticalGroup(
			gl_paneltime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paneltime.createSequentialGroup()
					.addGap(5)
					.addComponent(labeltime)
					.addGap(5)
					.addComponent(morningextrawork)
					.addGap(5)
					.addComponent(afternoonextrawork)
					.addGap(5)
					.addComponent(wholedayextrawork)
					.addGap(5))
		);
		paneltime.setLayout(gl_paneltime);
		
		panelhandle = new JPanel();
		panelhandle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		labelhandlework = new JLabel("\u5904\u7406\u65B9\u5F0F\uFF1A");
		
		howtodealwithoverwork = new JComboBox();
		howtodealwithoverwork.setFont(new Font("黑体", Font.BOLD, 16));
		howtodealwithoverwork.setModel(new DefaultComboBoxModel(new String[] {"\u8BA1\u5DE5\u8D44", "\u8BA1\u6362\u4F11"}));
		GroupLayout gl_panelhandle = new GroupLayout(panelhandle);
		gl_panelhandle.setHorizontalGroup(
			gl_panelhandle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelhandle.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelhandle.createParallelGroup(Alignment.LEADING)
						.addComponent(howtodealwithoverwork, 0, 122, Short.MAX_VALUE)
						.addComponent(labelhandlework))
					.addContainerGap())
		);
		gl_panelhandle.setVerticalGroup(
			gl_panelhandle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelhandle.createSequentialGroup()
					.addGap(5)
					.addComponent(labelhandlework)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(howtodealwithoverwork, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panelhandle.setLayout(gl_panelhandle);
		
		JButton submitextrawork = new JButton("\u8BBE\u7F6E\u4FE1\u606F");
		submitextrawork.setFont(new Font("黑体", Font.BOLD, 16));
		submitextrawork.setPreferredSize(new Dimension(93, 40));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(submitextrawork, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(panelhandle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(paneltime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(panelreason, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addGap(5))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(panelreason, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(paneltime, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(panelhandle, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(submitextrawork, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		submitextrawork.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (morningextrawork.isSelected()&&!afternoonextrawork.isSelected()) 
				{					
				 
					   setdata("上午未打",null);
					   noinformationsubmit = false;
					 						 						 
				}
					
				else if (!morningextrawork.isSelected()&&afternoonextrawork.isSelected()) 
				{					
						setdata("下午未打",null);
						noinformationsubmit = false;

				}
					
				else if(wholedayextrawork.isSelected())
				{					
					    setdata("全天未打",null);
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
		 
		 String nameString = getlabel().getCal().getUser().getCheckname();	 		 		 
		 Dayinformation information = new Dayinformation();
		 String catogoryString = getlabel().getNewSubimitWindows().getVacationorExtrawork();
		 String vacationreasonString = (String)extraworktype.getSelectedItem();
		 String timeString = String.valueOf(getlabel().getNewSubimitWindows().getyear())+"-"+
				 String.valueOf(getlabel().getNewSubimitWindows().getmonth())+"-"+getlabel().getText();
		 Date datetime = Date.valueOf(timeString);
		 String howtodealwithovertimework  = (String)howtodealwithoverwork.getSelectedItem();
		 
		 information.setreasons(catogoryString);
		 information.setreasons_details(vacationreasonString);
		 information.setTime(datetime);
		 information.setLabelday(getlabel().getText());
		 information.setActualtimenoclear(Actualtimenoclear);
		 information.setreasons_explanation(Explainreason);
		 information.sethandleovertimework(howtodealwithovertimework);
		 
		 CheckTheManExist(nameString);
		 
		 for (int i=0;i<getlabel().getNewSubimitWindows().getSubmitdatagroup().size();i++) {
			if (nameString.equals(getlabel().getNewSubimitWindows().getSubmitdatagroup().get(i).getName())) {				
				getlabel().getNewSubimitWindows().getSubmitdatagroup().get(i).getDayinformation().add(information);				
			}

		}
		 
		 
		 System.out.println(nameString+"写入加班信息完成");
		
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
		DataBaseOperation getidBaseOperation = new DataBaseOperation();
		int id = -1;
		try {
			id = getidBaseOperation.GetID_from_Nanme(name);
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (SQLException e1) {
	
			e1.printStackTrace();
		}
		
		if (id != -1) {
			
			OnePersondata.setId(id);
			getlabel().getNewSubimitWindows().getSubmitdatagroup().add(OnePersondata);
			
		}
		else {
			System.out.println("id查询错误，放弃添加人员信息");
		}
		
		
	}
	
	
		

}
