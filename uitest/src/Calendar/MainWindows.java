package Calendar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import MyThread.MyThread;
import approvel.ApprovalWindows;
import ojdbc.DataBaseOperation;
import tcp.ListInformation;
import user.LoginInWindows;
import user.User;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class MainWindows {

	private JFrame frame;
	private User user;

	
	public User getUser() {
		return user;
	}

	public JFrame getFrame() {
		return frame;
	}

	public MainWindows(User user) {
		this.user = user;
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setFont(new Font("宋体", Font.BOLD, 18));
		frame.setTitle("\u6B22\u8FCE\u767B\u5F55\uFF0C"+user.getCheckname());
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("黑体", Font.PLAIN, 14));
		frame.setJMenuBar(menuBar);
		
		
		ImageIcon icon11 = new ImageIcon("src/image/考勤功能.png");
		JMenu modeselect = new JMenu("\u8003\u52E4\u529F\u80FD");
		modeselect.setBorder(new EmptyBorder(2, 2, 2, 2));
		modeselect.setIconTextGap(6);
		modeselect.setFont(new Font("黑体", Font.PLAIN, 16));
		modeselect.setIcon(icon11);
		menuBar.add(modeselect);
		
		
		ImageIcon icon1 = new ImageIcon("src/image/提交考勤.png");
		
		JMenuItem submitmode = new JMenuItem("\u63D0\u4EA4\u8003\u52E4");
		submitmode.setIconTextGap(10);
		submitmode.setIcon(icon1);
		submitmode.setHorizontalAlignment(SwingConstants.CENTER);
		submitmode.setFont(new Font("宋体", Font.PLAIN, 12));
		modeselect.add(submitmode);
		
		ImageIcon icon2 = new ImageIcon("src/image/下载考勤.png");
		JMenuItem downloadmode = new JMenuItem("\u4E0B\u8F7D\u8003\u52E4");
		downloadmode.setIconTextGap(10);
		downloadmode.setIcon(icon2);
		downloadmode.setHorizontalAlignment(SwingConstants.CENTER);
		downloadmode.setFont(new Font("宋体", Font.PLAIN, 12));
		modeselect.add(downloadmode);
		
		
		ImageIcon icon22 = new ImageIcon("src/image/审批功能.png");
		JMenu approvel = new JMenu("审批功能");
		approvel.setBorder(new EmptyBorder(2, 2, 2, 2));
		approvel.setIconTextGap(6);
		approvel.setFont(new Font("黑体", Font.PLAIN, 16));
		approvel.setIcon(icon22);
		menuBar.add(approvel);
		

		ImageIcon icon23 = new ImageIcon("src/image/请假审批.png");
		JMenuItem vacationapproval = new JMenuItem("\u8BF7\u5047\u5BA1\u6279");
		vacationapproval.setIconTextGap(10);
		vacationapproval.setHorizontalAlignment(SwingConstants.CENTER);
		vacationapproval.setFont(new Font("宋体", Font.PLAIN, 12));
		vacationapproval.setIcon(icon23);
		approvel.add(vacationapproval);
		
		ImageIcon icon24 = new ImageIcon("src/image/考勤审批.png");
		JMenuItem assessapproval = new JMenuItem("\u8003\u52E4\u5BA1\u6279");
		assessapproval.setIconTextGap(10);
		assessapproval.setHorizontalAlignment(SwingConstants.CENTER);
		assessapproval.setFont(new Font("宋体", Font.PLAIN, 12));
		assessapproval.setIcon(icon24);
		approvel.add(assessapproval);
		
		ImageIcon icon25 = new ImageIcon("src/image/关于.png");
		JMenu aboutinformation = new JMenu("\u5173\u4E8E");
		aboutinformation.setBorder(new EmptyBorder(2, 2, 2, 2));
		aboutinformation.setIconTextGap(6);
		aboutinformation.setFont(new Font("黑体", Font.PLAIN, 16));
		aboutinformation.setIcon(icon25);
		menuBar.add(aboutinformation);
		
		SubimitWindows SnewSubimitWindows = new SubimitWindows(getUser());
		DownloadWindows DnewSubimitWindows = new DownloadWindows(getUser());

		
		
		
		
		if (Integer.valueOf(getUser().getWhether_manager())!=1) {
			
			approvel.setEnabled(false);
		}
		
		if (Integer.valueOf(getUser().getVACATION_APPROVAL_NORMAL())!=1&&Integer.valueOf(getUser().getVACATION_APPROVAL_HIGHER())!=1) {
			
			vacationapproval.setEnabled(false);
		}
		
		if (Integer.valueOf(getUser().getASSESS_APPROVAL_NORMAL())!=1&&Integer.valueOf(getUser().getASSESS_APPROVAL_HIGHER())!=1) {
			
			assessapproval.setEnabled(false);
		}
		
		
		
		submitmode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				SubimitWindows newSubimitWindows = new SubimitWindows(getUser());
//				MyThread myThread = new MyThread(newSubimitWindows);				
//				Thread starThread = new Thread(myThread);
//				starThread.start();
				SnewSubimitWindows.getFrame().setVisible(true);
			}
		});
		
		downloadmode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				DownloadWindows newSubimitWindows = new DownloadWindows(getUser());
//				MyThread myThread = new MyThread(newSubimitWindows);				
//				Thread starThread = new Thread(myThread);
//				starThread.start();
				DnewSubimitWindows.getFrame().setVisible(true);
				
			}
		});
		
		vacationapproval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				DataBaseOperation dataBaseOperation = new DataBaseOperation();
				ListInformation informationgroup = null;
				try {
					informationgroup = dataBaseOperation.Selectfrom_DATA_VACATION_WORK_APPROVAL_ForUser(user);
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				
				
				if (informationgroup!=null) {
					
					ApprovalWindows testwindows;
					try {
						testwindows = new ApprovalWindows(user,informationgroup);
						testwindows.getFrame().setVisible(true);
					} catch (ClassNotFoundException e1) {

						e1.printStackTrace();
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					
				}
				

				

				
			}
		});
		
		
	
	}
	
	private void ShowDialog(String word) {
		
		JOptionPane.showMessageDialog(null,word, "提示", JOptionPane.INFORMATION_MESSAGE); 
				
	}

}
