package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Calendar.MainWindows;
import MyThread.MyThread;
import backup.BackupSubmitWindows;
import backup.CalendarWindows;
import implement.RoundBorder;
import ojdbc.DataBaseOperation;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;

import java.awt.Color;

public class LoginInWindows {

	private JFrame frmHjassesssystemAlpha;
	private JTextField usenametextfiled;
	private JPasswordField passwordtextfiled;

	
	public JFrame getFrame() {
		return frmHjassesssystemAlpha;
	}
	
	public LoginInWindows() {
		initialize();
	}

	private void initialize() {
		frmHjassesssystemAlpha = new JFrame();
		frmHjassesssystemAlpha.setFont(new Font("Dialog", Font.PLAIN, 12));
		frmHjassesssystemAlpha.setResizable(false);
		frmHjassesssystemAlpha.setTitle("HJ_Assess_System alpha1.0");
		frmHjassesssystemAlpha.setBounds(100, 100, 417, 300);
		frmHjassesssystemAlpha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHjassesssystemAlpha.setLocationRelativeTo(null);		
		ImageIcon icon = new ImageIcon("src/image/汇景图标.png");		
		frmHjassesssystemAlpha.setIconImage(icon.getImage());
		
		Box AccounthorizontalBox = Box.createHorizontalBox();		
		Box PasswordhorizontalBox = Box.createHorizontalBox();		
		JLabel usernamelabel = new JLabel("帐号");
		usernamelabel.setForeground(Color.DARK_GRAY);
		usernamelabel.setFont(new Font("幼圆", Font.BOLD, 16));
		
		usenametextfiled = new JTextField();
		usenametextfiled.setForeground(Color.DARK_GRAY);
		usenametextfiled.setFont(new Font("微软雅黑", Font.BOLD, 16));
		usenametextfiled.setColumns(10);
		usenametextfiled.setBorder(new RoundBorder());
		
		JButton login = new JButton("\u767B\u5F55");
		login.setForeground(Color.DARK_GRAY);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.setFont(new Font("幼圆", Font.BOLD, 16));
		
		JButton register_1 = new JButton("\u6CE8\u518C");
		register_1.setForeground(Color.DARK_GRAY);
		register_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		register_1.setFont(new Font("幼圆", Font.BOLD, 16));
		
		JLabel passwordlable = new JLabel("密码");
		passwordlable.setForeground(Color.DARK_GRAY);
		passwordlable.setFont(new Font("幼圆", Font.BOLD, 16));
		
		passwordtextfiled = new JPasswordField();
		passwordtextfiled.setForeground(Color.DARK_GRAY);
		passwordtextfiled.setFont(new Font("微软雅黑", Font.BOLD, 16));
		passwordtextfiled.setBorder(new RoundBorder());
		
		JLabel imagetitle = new JLabel("");
		
		GroupLayout groupLayout = new GroupLayout(frmHjassesssystemAlpha.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(145)
							.addComponent(login)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(register_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(usernamelabel)
								.addComponent(passwordlable))
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordtextfiled)
								.addComponent(usenametextfiled, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(imagetitle, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(AccounthorizontalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(PasswordhorizontalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(86))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(AccounthorizontalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(PasswordhorizontalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(imagetitle, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usenametextfiled, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernamelabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordtextfiled, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordlable))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(login, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(register_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frmHjassesssystemAlpha.getContentPane().setLayout(groupLayout);
		
				
		
		ImageIcon icon2 = new ImageIcon("src/image/汇景logo.jpg");
		icon2.setImage(
				icon2.getImage().
      		  getScaledInstance(377,95, Image.SCALE_DEFAULT)); 
		imagetitle.setIcon(icon2);
		
				register_1.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						RegisterWindows register = new RegisterWindows();
						register.getFrame().setVisible(true);
						
					}
				});
		
		
		login.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
		
				String username = usenametextfiled.getText();
				String password = passwordtextfiled.getText();
				
				try {
					Map<User,String> resultmap = User.LoginInUser(username, password);					
					Set<Map.Entry<User, String>> set = resultmap.entrySet();
					Iterator<Map.Entry<User, String>> iterator;
								    
				    iterator = set.iterator();	
				    
					User loginuser = null;
					String  resultstring = null;
						
					while (iterator.hasNext()) {
						Map.Entry<User, String> loginresult= (Map.Entry<User, String>) iterator.next();
						loginuser = loginresult.getKey();
						resultstring = loginresult.getValue();						
					}
						
											
					if (resultstring.equals("成功登录")) {
							
						
						ShowDialog(resultstring);
						getFrame().dispose();
						MainWindows windows  = new MainWindows(loginuser);
						windows.getFrame().setVisible(true);
														
					}
						
					else {
							
						ShowDialog(resultstring);
							
					}
																
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				
				
			}
			
		});
		
		
		login.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == 13 || e.getKeyCode() == 16777296) {
										
					String username = usenametextfiled.getText();
					String password = passwordtextfiled.getText();
					
					try {
						Map<User,String> resultmap = User.LoginInUser(username, password);					
						Set<Map.Entry<User, String>> set = resultmap.entrySet();
						Iterator<Map.Entry<User, String>> iterator;
									    
					    iterator = set.iterator();	
					    
						User loginuser = null;
						String  resultstring = null;
							
						while (iterator.hasNext()) {
							Map.Entry<User, String> loginresult= (Map.Entry<User, String>) iterator.next();
							loginuser = loginresult.getKey();
							resultstring = loginresult.getValue();						
						}
							
												
						if (resultstring.equals("成功登录")) {
								
							
							ShowDialog(resultstring);
							getFrame().dispose();
							MainWindows windows  = new MainWindows(loginuser);
							windows.getFrame().setVisible(true);
															
						}
							
						else {
								
							ShowDialog(resultstring);
								
						}
																	
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

         JOptionPane.showMessageDialog(null,word, "提示ʾ", JOptionPane.INFORMATION_MESSAGE); 
		
    }
}
