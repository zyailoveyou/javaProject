package approvel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import implement.BackgroundPanel;
import implement.RoundBorder;

public class VacationPanel extends BackgroundPanel {
	

	JLabel titlelabel = new JLabel("\u5F02\u5E38\u51FA\u52E4\u8BF4\u660E");	
	JLabel name = new JLabel("\u59D3\u540D\uFF1A\u5F20\u5343\u5531");		
	JLabel vacationtype = new JLabel("\u5047\u522B\uFF1A\u6362\u4F11");		
	JLabel vacationtime = new JLabel("\u8BF7\u5047\u65F6\u95F4\uFF1A");		
	JCheckBox approval = new JCheckBox("\u5141\u8BB8");		
	JCheckBox deny = new JCheckBox("\u62D2\u7EDD");
	ButtonGroup mygourpButtonGroup = new ButtonGroup();	
	JLabel department = new JLabel("\u90E8\u95E8\uFF1A\u529E\u516C\u5BA4");
	
	String wokername = null;
	String wokervacationtype = null;
	String wokervacationdate = null;
	String wokervacationtime = null;
	String wokerdepartment = null;
	String reasonsString = null;
	
	
	                                         
	public String getWokername() {
		return wokername;
	}

	public String getWokervacationtype() {
		return wokervacationtype;
	}

	public String getWokervacationdate() {
		return wokervacationdate;
	}

	public String getWokervacationtime() {
		return wokervacationtime;
	}

	public String getWokerdepartment() {
		return wokerdepartment;
	}

	public VacationPanel(String nameforwoker,String vacationdateforwoker,String vacationtimeforwoker,String vacationtypeforwoker,String departmentforwoker,String reasonsString) {
		
			
		titlelabel.setFont(new Font("幼圆", Font.BOLD, 20));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.DARK_GRAY);
		name.setFont(new Font("幼圆", Font.PLAIN, 14));
		vacationtype.setForeground(Color.DARK_GRAY);
		vacationtype.setFont(new Font("幼圆", Font.PLAIN, 14));
		vacationtime.setForeground(Color.DARK_GRAY);
		vacationtime.setFont(new Font("幼圆", Font.BOLD, 16));
		approval.setForeground(Color.DARK_GRAY);
		approval.setFont(new Font("黑体", Font.BOLD, 16));
		approval.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		deny.setForeground(Color.DARK_GRAY);
		deny.setFont(new Font("黑体", Font.BOLD, 16));
		deny.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mygourpButtonGroup.add(approval);
		mygourpButtonGroup.add(deny);
		department.setForeground(Color.DARK_GRAY);
		department.setFont(new Font("幼圆", Font.PLAIN, 14));
		
		this.setBorder(new RoundBorder());
		this.setBackground(Color.WHITE);
		
		wokername = nameforwoker;
		wokervacationtype = vacationtypeforwoker;
		wokervacationdate = vacationdateforwoker;
		wokervacationtime = vacationtimeforwoker;
		wokerdepartment = departmentforwoker;
		
		name.setText("姓名："+wokername);
		vacationtype.setText("类型："+vacationtypeforwoker);
		department.setText("部门："+wokerdepartment);
		vacationtime.setText("时间："+vacationdateforwoker+" "+vacationtimeforwoker);
		
		JLabel reasons = new JLabel("未打卡原因："+reasonsString);
		reasons.setForeground(Color.DARK_GRAY);
		reasons.setFont(new Font("幼圆", Font.BOLD, 16));
		
		GroupLayout gl_p1 = new GroupLayout(this);
		gl_p1.setHorizontalGroup(
			gl_p1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p1.createSequentialGroup()
					.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p1.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_p1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_p1.createSequentialGroup()
									.addComponent(name, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(vacationtype, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(50)
									.addComponent(department, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_p1.createSequentialGroup()
									.addGap(230)
									.addComponent(approval)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(deny, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(17))
								.addComponent(vacationtime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_p1.createSequentialGroup()
							.addGap(142)
							.addComponent(titlelabel)))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_p1.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(reasons, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		gl_p1.setVerticalGroup(
			gl_p1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p1.createSequentialGroup()
					.addGap(26)
					.addComponent(titlelabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_p1.createParallelGroup(Alignment.BASELINE)
						.addComponent(vacationtype, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(department, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(vacationtime, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(reasons, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_p1.createParallelGroup(Alignment.BASELINE)
						.addComponent(approval)
						.addComponent(deny))
					.addGap(24))
		);
		this.setLayout(gl_p1);
		
	}
	
	public boolean getApprovalState() {
		
		if (approval.isSelected()) {
			
			return true;
		}

		else {
			return false;
		}		
		
	}
	
	public boolean getcheckedstate() {
		
		return approval.isSelected();
		
	}
	
	public void Setcheckedstate() {
		
		approval.setSelected(true);
	}
}
