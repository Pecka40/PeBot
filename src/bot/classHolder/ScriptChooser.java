package bot.classHolder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

import bot.classHolder.ScriptLoader.ScriptFile;
import GUI.scriptPanel;
import GUI.scriptsPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JScrollBar;

import java.awt.ScrollPane;

import javax.swing.JButton;

public class ScriptChooser extends JFrame implements MouseListener {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 *
	 */
	public ScriptChooser(classHolder holder){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scriptsPanel scrollPane = new scriptsPanel(holder.scriptLoader().getScriptFile(
				holder.getPropLoader().getPathToScripts()));
		scrollPane.setBounds(10, 11, 449, 213);
		contentPane.add(scrollPane);
		
		
		JButton btnRunScript = new JButton("Run script");
		btnRunScript.setBounds(354, 229, 105, 22);
		contentPane.add(btnRunScript);

		//addScripts(holder);

		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
