package GUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import bot.classHolder.ScriptLoader.ScriptFile;

public class scriptsPanel extends JPanel{

	private static List<scriptPanel> ScriptPanels = null;
	private int height = 5;

	public scriptsPanel(ScriptFile[] scriptFiles) {
		this.setLayout(null);

		List<scriptPanel> panels = new ArrayList<scriptPanel>();

		for (int i = 0; i < scriptFiles.length; i++) {

			panels.add(new scriptPanel(scriptFiles[i].getName(), scriptFiles[i]
					.getVersion(), scriptFiles[i].getAuthor(), scriptFiles[i]
					.getDescription(), scriptFiles[i].getScript()));
			height = height + 70;
			if (i == 0) {
				panels.get(i).setBounds(10, 5, 435, 60);
			} else {
				panels.get(i).setBounds(10, 70 * i + 5, 435, 60);
			}
			this.add(panels.get(i));
		}
		ScriptPanels = panels;
	}

	public void repaintComponents() {
		for (scriptPanel s : ScriptPanels) {
			s.repaint();
		}
	}

	public static Object getSelectedScript(){
		Object o = null;
		for(int i = 0;i<ScriptPanels.size();i++){
			if(ScriptPanels.get(i).isSelected()){
				o = ScriptPanels.get(i).getScript();
				break;
			}
		}
		return o;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(435, height);
	}

	private static void reset(String name){
		System.out.println(name);
		for(int i = 0;i<ScriptPanels.size();i++){
			ScriptPanels.get(i).selected(false);
		}
		for(int i = 0;i<ScriptPanels.size();i++){
			System.out.println(ScriptPanels.get(i).getName());
			if(ScriptPanels.get(i).getName().contentEquals(name)){
				ScriptPanels.get(i).selected(true);
				break;
			}
		}
	}
	
	public static void selectedMe(String name){
		System.out.println(name);
		reset(name);
	}

}
