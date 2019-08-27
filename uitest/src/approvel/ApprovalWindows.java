package approvel;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Calendar.Windows;
import mylayout.MyVFlowLayout;
import ojdbc.DataBaseOperation;
import tcp.ListInformation;
import user.User;
import java.awt.Color;
public class ApprovalWindows extends Windows {

	ListInformation informationgroup;

	ArrayList<VacationPanel> vacationPanels =  new ArrayList<VacationPanel>();
	public ApprovalWindows(User user,ListInformation information) throws ClassNotFoundException, SQLException {
		this.setUser(user);
		this.informationgroup=information;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 527);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("请假审批");
		
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
				
		JPanel panelcontainer = new JPanel();
		scrollPane.setViewportView(panelcontainer);
		MyVFlowLayout mvfl_panelcontainer = new MyVFlowLayout(MyVFlowLayout.TOP,20,20,false,false);
		panelcontainer.setLayout(mvfl_panelcontainer);
		
		if (informationgroup!= null) {
			
			for (ArrayList<String> list : informationgroup.getLineinformationgroup()) {
				VacationPanel vacationPanel = new VacationPanel(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
				panelcontainer.add(vacationPanel);
				vacationPanels.add(vacationPanel);
			}
			
		}
		
		else {
			return;
		}
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton quicklyapproval = new JButton("\u4E00\u952E\u540C\u610F");
		quicklyapproval.setForeground(Color.DARK_GRAY);
		quicklyapproval.setFont(new Font("幼圆", Font.BOLD, 16));
		panel.add(quicklyapproval);
		
		JButton submitapproval = new JButton("\u63D0\u4EA4\u5BA1\u6279");
		submitapproval.setForeground(Color.DARK_GRAY);
		submitapproval.setFont(new Font("幼圆", Font.BOLD, 16));
		panel.add(submitapproval);
		
		
		
		if (user!=null) {
			
			String userlevel_shape = user.getLevel_shape();
			
			
		}
		
		quicklyapproval.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for (VacationPanel v:vacationPanels) {
					
					v.Setcheckedstate();
					System.out.println(v.getWidth());
					System.out.println(v.getHeight());
				}
				
			}
		});
		
		
		submitapproval.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				ListInformation datagroup = new ListInformation();
				for (VacationPanel v:vacationPanels) {
					
					if (v.getcheckedstate() == true) {
												
						ArrayList<String> data = new ArrayList<String>();
						data.add(v.getWokername());
						data.add(v.getWokervacationtime());
						data.add(v.getWokervacationdate());
						datagroup.getLineinformationgroup().add(data);																							
					}
				}
				
				DataBaseOperation baseOperation = new DataBaseOperation();
				try {
					baseOperation.Update_VACATION_WORK_NORMOL_APPROVAL_state(datagroup);
					frame.dispose();
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		
		
		
	}

}
