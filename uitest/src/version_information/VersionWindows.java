package version_information;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class VersionWindows  {

	private JFrame frmInformation;
	
	
	public JFrame getFrame() {
		return frmInformation;
	}

	public VersionWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInformation = new JFrame();
		frmInformation.setTitle("Information");
		frmInformation.setBounds(100, 100, 363, 223);
		frmInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInformation.setLocationRelativeTo(null);
				
		ImageIcon icon = new ImageIcon("src/image/汇景图标.png");		
		frmInformation.setIconImage(icon.getImage());
				
		JLabel VersionInfo = new JLabel("Ver：HJ_Assess_System alpha1.0");
		VersionInfo.setFont(new Font("Adobe Ming Std L", Font.PLAIN, 18));
		
		JLabel lblByalexZhang = new JLabel("Desiger：Alex Zhang");
		lblByalexZhang.setFont(new Font("Adobe Myungjo Std M", Font.PLAIN, 12));
		
		JLabel lblEmailqqcom = new JLabel("Email：zyailoveyou123@gmail.com");
		GroupLayout groupLayout = new GroupLayout(frmInformation.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(137, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblByalexZhang, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailqqcom))
					.addGap(22))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(VersionInfo)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addComponent(VersionInfo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblByalexZhang, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(lblEmailqqcom, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		frmInformation.getContentPane().setLayout(groupLayout);
	}
}
