package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import bot.classHolder.ScriptRunner;

import javax.swing.JScrollBar;

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
	public Dimension getPreferredSize() {
		return new Dimension(410,60);
	}

    private final Color Lime = new Color(0, 255, 51);

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		// g.drawImage(img, 10, 20, null);
		g.drawString(name + "" + selected+ver, 30, 20);
		if(selected){
			this.setBackground(Lime);
			
		}else{
			this.setBackground(null);
		}
		
	}
	
	public String getName(){
		return name;
	}
	
	public void selected(boolean isSelected){
		selected = isSelected;
		this.repaint();
	}
	
	public boolean isSelected(){
		return selected;
	}
	
	public Object getScript(){
		return script;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println(name);
		scriptsPanel.selectedMe(name);
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
