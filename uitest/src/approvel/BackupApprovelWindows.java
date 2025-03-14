package approvel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

public class BackupApprovelWindows {

	private JFrame frame;


	public BackupApprovelWindows() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(" ");
		frame.setBounds(100, 100, 468, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelscroll = new JPanel();
		
		JPanel p1 = new JPanel();
		p1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		p1.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(panelscroll);
		
		JLabel titlelabel = new JLabel("\u5F02\u5E38\u51FA\u52E4\u8BF4\u660E");
		titlelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel name = new JLabel("\u59D3\u540D\uFF1A\u5F20\u5343\u5531");
		name.setFont(new Font("����", Font.PLAIN, 14));
		
		JLabel vacationtype = new JLabel("\u5047\u522B\uFF1A\u6362\u4F11");
		vacationtype.setFont(new Font("����", Font.PLAIN, 14));
		
		JLabel vacationtime = new JLabel("\u8BF7\u5047\u65F6\u95F4\uFF1A");
		vacationtime.setFont(new Font("΢���ź�", Font.BOLD, 16));
		
		JCheckBox approval = new JCheckBox("\u5141\u8BB8");
		approval.setFont(new Font("΢���ź�", Font.BOLD, 16));
		approval.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JCheckBox deny = new JCheckBox("\u62D2\u7EDD");
		deny.setFont(new Font("΢���ź�", Font.BOLD, 16));
		deny.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		ButtonGroup mygourpButtonGroup = new ButtonGroup();
		mygourpButtonGroup.add(approval);
		mygourpButtonGroup.add(deny);
		
		JLabel department = new JLabel("\u90E8\u95E8\uFF1A\u529E\u516C\u5BA4");
		department.setFont(new Font("����", Font.PLAIN, 14));
		
		GroupLayout gl_p1 = new GroupLayout(p1);
		gl_p1.setHorizontalGroup(
			gl_p1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p1.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addGroup(gl_p1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_p1.createSequentialGroup()
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(vacationtype, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(department, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_p1.createSequentialGroup()
							.addGap(201)
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
		p1.setLayout(gl_p1);
		GroupLayout gl_panelscroll = new GroupLayout(panelscroll);
		gl_panelscroll.setHorizontalGroup(
			gl_panelscroll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelscroll.createSequentialGroup()
					.addContainerGap()
					.addComponent(p1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelscroll.setVerticalGroup(
			gl_panelscroll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelscroll.createSequentialGroup()
					.addGap(5)
					.addComponent(p1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		panelscroll.setLayout(gl_panelscroll);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
