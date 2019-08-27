package approvel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;

import mylayout.MyVFlowLayout;
import javax.swing.JButton;
import java.awt.Font;

public class testwindows {

	private JFrame frame;


	public testwindows() {
		initialize();
	}
	
	
	public JFrame getFrame() {
		return frame;
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 527);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		VacationPanel vacationPanel = new VacationPanel("123", "123", "123", "123","123","123");
		VacationPanel vacationPanel2 = new VacationPanel("123", "123", "123", "123","123","123");
		
		JPanel panelcontainer = new JPanel();
		scrollPane.setViewportView(panelcontainer);
		panelcontainer.setLayout(new MyVFlowLayout(MyVFlowLayout.TOP,20,20,true,false));
		
		panelcontainer.add(vacationPanel);
		panelcontainer.add(vacationPanel2);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton quicklyapproval = new JButton("\u4E00\u952E\u540C\u610F");
		quicklyapproval.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(quicklyapproval);
		
		JButton submitapproval = new JButton("\u63D0\u4EA4\u5BA1\u6279");
		submitapproval.setFont(new Font("����", Font.PLAIN, 16));
		panel.add(submitapproval);
	}

}
