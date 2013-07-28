package GUI;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoundedRangeModel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import bot.classHolder.ScriptLoader.ScriptFile;

import javax.swing.ScrollPaneConstants;

public class scriptsPanel extends JScrollPane implements MouseListener{

	scriptPanel[] ScriptPanels = null;
	
	public scriptsPanel(ScriptFile[] scriptFiles){
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.addMouseListener(this);
		List<scriptPanel> panels = new ArrayList<scriptPanel>();
		for(int i = 1;i<scriptFiles.length+1;i++){
			panels.add(new scriptPanel(scriptFiles[i-1].getName(),scriptFiles[i-1].getVersion(),scriptFiles[i-1].getAuthor(),scriptFiles[i-1].getDescription(),scriptFiles[i-1].getScript()));
			if(i == 1){
				panels.get(i-1).setBounds(10, 10, 410, 60);
			}else{
				panels.get(i-1).setBounds(10, 300, 430, 60);	
			}
			this.add(panels.get(i-1));
			
		}
		ScriptPanels = panels.toArray(new scriptPanel[panels.size()]);

	}
	
	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return new Dimension(200,200);
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(200,200);
	}

	public void repaintComponents(){
		for(scriptPanel s:ScriptPanels){
			s.repaint();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		repaintComponents();
		this.revalidate();
		this.setViewport(this.createViewport());
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
