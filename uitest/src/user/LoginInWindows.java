package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Calendar.MainWindows;
import MyThread.MyThread;
import backup.BackupSubmitWindows;
import backup.CalendarWindows;
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

public class LoginInWindows {

	private JFrame frame;
	private JTextField usenametextfiled;
	private JPasswordField passwordtextfiled;

	
	public JFrame getFrame() {
		return frame;
	}
	
	public LoginInWindows() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u767B\u5F55\u7A97\u53E3");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		JPanel northfillin = new JPanel();
		FlowLayout fl_northfillin = (FlowLayout) northfillin.getLayout();
		fl_northfillin.setVgap(30);
		fl_northfillin.setHgap(10);
		frame.getContentPane().add(northfillin, BorderLayout.NORTH);
		
		JPanel centerfillin = new JPanel();
		frame.getContentPane().add(centerfillin, BorderLayout.CENTER);
		
		Box AccounthorizontalBox = Box.createHorizontalBox();
		
		JLabel usernamelabel = new JLabel("\u5E10\u53F7\uFF1A");
		usernamelabel.setFont(new Font("黑体", Font.BOLD, 16));
		AccounthorizontalBox.add(usernamelabel);
		
		usenametextfiled = new JTextField();
		usenametextfiled.setFont(new Font("微软雅黑", Font.BOLD, 16));
		AccounthorizontalBox.add(usenametextfiled);
		usenametextfiled.setColumns(10);
		
		Box PasswordhorizontalBox = Box.createHorizontalBox();
		
		JLabel passwordlable = new JLabel("\u5BC6\u7801\uFF1A");
		passwordlable.setFont(new Font("黑体", Font.BOLD, 16));
		PasswordhorizontalBox.add(passwordlable);
		
		passwordtextfiled = new JPasswordField();
		passwordtextfiled.setFont(new Font("微软雅黑", Font.BOLD, 16));
		PasswordhorizontalBox.add(passwordtextfiled);
		
		JLabel notification = new JLabel("\u63D0\u793A\u4FE1\u606F");
		notification.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout gl_centerfillin = new GroupLayout(centerfillin);
		gl_centerfillin.setHorizontalGroup(
			gl_centerfillin.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_centerfillin.createSequentialGroup()
					.addContainerGap(74, Short.MAX_VALUE)
					.addGroup(gl_centerfillin.createParallelGroup(Alignment.LEADING)
						.addComponent(notification)
						.addComponent(AccounthorizontalBox, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
						.addComponent(PasswordhorizontalBox, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		gl_centerfillin.setVerticalGroup(
			gl_centerfillin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerfillin.createSequentialGroup()
					.addContainerGap()
					.addComponent(AccounthorizontalBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PasswordhorizontalBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(notification)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
		flowLayout_3.setHgap(30);
		PasswordhorizontalBox.add(panel_1);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(30);
		AccounthorizontalBox.add(panel);
		centerfillin.setLayout(gl_centerfillin);
		
		JPanel southfillin = new JPanel();	
		frame.getContentPane().add(southfillin, BorderLayout.SOUTH);
		
		JButton login = new JButton("\u767B\u5F55");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.setFont(new Font("黑体", Font.BOLD, 16));
		
		JButton register = new JButton("\u6CE8\u518C");
		register.setFont(new Font("黑体", Font.BOLD, 16));
		GroupLayout gl_southfillin = new GroupLayout(southfillin);
		gl_southfillin.setHorizontalGroup(
			gl_southfillin.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_southfillin.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(login)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(register)
					.addGap(148))
		);
		gl_southfillin.setVerticalGroup(
			gl_southfillin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_southfillin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_southfillin.createParallelGroup(Alignment.BASELINE)
						.addComponent(login)
						.addComponent(register))
					.addGap(42))
		);
		southfillin.setLayout(gl_southfillin);
		
		JPanel westfillin = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) westfillin.getLayout();
		frame.getContentPane().add(westfillin, BorderLayout.WEST);
		
		JPanel eastfillin = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) eastfillin.getLayout();
		frame.getContentPane().add(eastfillin, BorderLayout.EAST);
		
		
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

		
		register.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RegisterWindows register = new RegisterWindows();
				register.getFrame().setVisible(true);
				
			}
		});
	}
	
	
    private void ShowDialog(String word) {

         JOptionPane.showMessageDialog(null,word, "提示ʾ", JOptionPane.INFORMATION_MESSAGE); 
		
    }
	
	

}
