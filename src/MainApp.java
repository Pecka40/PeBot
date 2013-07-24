import java.awt.EventQueue;

import javax.swing.JFrame;

import bot.classHolder.ScriptChooser;
import bot.classHolder.classHolder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainApp {

	private JFrame frame;
	static classHolder holder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
		holder = new classHolder();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 106, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Scripts");
		menuBar.add(mnNewMenu);

		JMenuItem mntmRunScript = new JMenuItem("Run script");
		mntmRunScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// holder.scriptChooser();
					new ScriptChooser(holder);
			}
		});
		mnNewMenu.add(mntmRunScript);

		JMenu mnUtilities = new JMenu("Utilities");
		menuBar.add(mnUtilities);

		JMenuItem mntmRectangleMaker = new JMenuItem("Rectangle maker");
		mnUtilities.add(mntmRectangleMaker);
	}
}
