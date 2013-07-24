package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import bot.classHolder.ScriptRunner;

public class scriptPanel extends JPanel implements MouseListener {

	private Image img;
	private String name = "PeMagicMiner", ver = "Version", author = "Pecka",
			desc = "Description";
	private boolean selected = false;
	private Object script;

	public scriptPanel(String Name, String Version, String Author,
			String Description,Object o) {
		this.addMouseListener(this);
		name = Name;
		ver = Version;
		author = Author;
		desc = Description;
		script = o;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setOpaque(true);
		g.setColor(Color.BLACK);
		// g.drawImage(img, 10, 20, null);
		g.drawString(name + "" + selected+ver, 30, 20);
		this.setBackground(new Color(255, 249, 189));
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		selected = !selected;
		this.repaint();
		System.out.println("Starting Script");
		new ScriptRunner(script);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
