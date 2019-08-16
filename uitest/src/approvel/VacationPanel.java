package approvel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VacationPanel extends JPanel {
		
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

	public VacationPanel(String nameforwoker,String vacationdateforwoker,String vacationtimeforwoker,String vacationtypeforwoker,String departmentforwoker) {
		
		titlelabel.setFont(new Font("黑体", Font.BOLD, 20));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		vacationtype.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		vacationtime.setFont(new Font("微软雅黑", Font.BOLD, 16));
		approval.setFont(new Font("黑体", Font.BOLD, 16));
		approval.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		deny.setFont(new Font("黑体", Font.BOLD, 16));
		deny.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mygourpButtonGroup.add(approval);
		mygourpButtonGroup.add(deny);
		department.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1,true));
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
		
		GroupLayout gl_p1 = new GroupLayout(this);
		gl_p1.setHorizontalGroup(
			gl_p1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p1.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_p1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_p1.createSequentialGroup()
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(vacationtype, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(department, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_p1.createSequentialGroup()
							.addGap(230)
							.addComponent(approval)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(deny, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(17))
						.addComponent(vacationtime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(23))
				.addGroup(gl_p1.createSequentialGroup()
					.addGap(142)
					.addComponent(titlelabel)
					.addContainerGap(137, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
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
