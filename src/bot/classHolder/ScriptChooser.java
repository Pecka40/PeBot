package bot.classHolder;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import GUI.scriptsPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScriptChooser extends JFrame{
	
	private JFrame frame = this;
	
	/**
	 * Create the frame.
	 *
	 */
	public ScriptChooser(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(new scriptsPanel(new ScriptLoader().getScriptFile()));
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ScriptRunner(scriptsPanel.getSelectedScript());
				frame.dispose();
				try {
					this.finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		this.setVisible(true);
		
	}
}
