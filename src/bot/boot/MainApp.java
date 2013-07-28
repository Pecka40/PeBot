package bot.boot;
import java.awt.EventQueue;

import javax.swing.JFrame;

import bot.classHolder.ScriptChooser;
import bot.classHolder.SystemTrayIcon;
import bot.classHolder.classHolder;
import bot.settings.About;
import bot.settings.Settings;
import bot.settings.Updater;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainApp {

	private static MainApp window;
	private JFrame frame;
	static classHolder holder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		new About();
		new Updater();
		Updater.checkForUpdate();
		new Settings();
		new SystemTrayIcon();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void show(boolean show){
		window.frame.setVisible(show);
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
		menuBar.setBounds(0, 0, 440, 27);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Scripts");
		menuBar.add(mnNewMenu);

		JMenuItem mntmRunScript = new JMenuItem("Run script");
		mntmRunScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ScriptChooser s = new ScriptChooser();
				s.setVisible(true);
			}
		});
		mnNewMenu.add(mntmRunScript);

		JMenuItem mntmResumeScript = new JMenuItem("Resume script");
		mntmResumeScript.setEnabled(false);
		mnNewMenu.add(mntmResumeScript);

		JMenuItem mntmStopScript = new JMenuItem("Stop script");
		mntmStopScript.setEnabled(false);
		mnNewMenu.add(mntmStopScript);

		JMenu mnUtilities = new JMenu("Utilities");
		menuBar.add(mnUtilities);

		JMenuItem mntmRectangleMaker = new JMenuItem("Rectangle maker");
		mnUtilities.add(mntmRectangleMaker);

		JMenu mnAbout = new JMenu("Bot");
		menuBar.add(mnAbout);

		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Updater.checkForUpdate();
			}
		});
		mnAbout.add(mntmUpdate);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mnAbout.add(mntmSettings);

		JMenuItem mntmCredits = new JMenuItem("Credits");
		mntmCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About.showCredits();
			}
		});
		mnAbout.add(mntmCredits);

		frame.setTitle("PeBot");
		frame.setIconImage(Settings.getIcon());

	}
}
