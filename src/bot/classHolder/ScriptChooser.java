package bot.classHolder;

import java.awt.LayoutManager;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import GUI.scriptPanel;
import GUI.scriptsPanel;

import javax.swing.JButton;

import bot.classHolder.ScriptLoader.ScriptFile;

import java.awt.GridLayout;

public class ScriptChooser extends JFrame{

	private JPanel contentPane;
	//private scriptsPanel scrollPane;
	
	/**
	 * Create the frame.
	 *
	 */
	public ScriptChooser(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		
		
		ScriptFile[] a = new ScriptLoader().getScriptFile();
		
		scriptPanel s = new scriptPanel(a[0].getName(), null, null, null, a[0].getScript());
		scriptPanel s2 = new scriptPanel(a[0].getName(), null, null, null, a[0].getScript());
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane = new JPanel();
		s.setBounds(10, 10, 300, 50);
		contentPane.add(s);
		s2.setBounds(10, 10, 300, 50);
		contentPane.add(s2);
		scrollPane.add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(scrollPane);
		
		contentPane.setLayout(null);
		
		//scrollPane = new scriptsPanel(new ScriptLoader().getScriptFile());
		
		
		
		
		
		JButton btnRunScript = new JButton("Run script");
		btnRunScript.setBounds(354, 229, 105, 22);
		contentPane.add(btnRunScript);
		this.setVisible(true);
		
	}
	
}
