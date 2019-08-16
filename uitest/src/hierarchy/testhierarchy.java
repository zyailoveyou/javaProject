package hierarchy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.BorderLayout;

public class testhierarchy {

	private JFrame frame;


	public JFrame getFrame() {
		return frame;
	}


	public testhierarchy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTree tree = new JTree();
		frame.getContentPane().add(tree, BorderLayout.CENTER);
	}

}
