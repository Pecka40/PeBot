package bot.classHolder;

import java.awt.AWTException;
import java.awt.Robot;

import bot.listener.*;
import bot.methodes.Mouse;
import bot.methodes.ScreenCapturer;
import bot.methodes.ScreenData;
import bot.methodes.Utils;

public class classHolder {

	private ListenerOfButtons listener = new ListenerOfButtons();
	private ScreenCapturer capturer = new ScreenCapturer();
	//private ScriptRunner scriptRunner = new ScriptRunner();
	//private ScriptChooser scriptChooser = new ScriptChooser(this);
	//private ScriptLoader scriptLoader = new ScriptLoader(this);
	private ScreenData screenData = new ScreenData(this);
	private Robot robo;
	private Mouse mouse = new Mouse(this);
	private Utils utilities = new Utils();
	private propertieLoader propLoader = new propertieLoader();

	public classHolder() {
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Returns random class
	 */
	public Utils Utils() {
		return utilities;
	}

	/**
	 * @return Returns mouse class
	 */
	public Mouse mouse() {
		return mouse;
	}

	/**
	 * @return Returns Robot class
	 */
	public Robot robot() {
		return robo;
	}

	/**
	 * @return Returns Screen data class
	 */
	public ScreenData screenData() {
		return screenData;
	}

	/**
	 * @return Returns button listener
	 */
	public ListenerOfButtons ButtonListener() {
		return listener;
	}

	/**
	 * 
	 * @return Returns ScriptChooser
	 */
	/*
	 * public ScriptChooser scriptChooser(){ return scriptChooser; }
	 */

	/**
	 * @return Returns ScriptRunner class
	 */
	/*public ScriptRunner Scriptrunnner() {
		return scriptRunner;
	}*/

	/**
	 * @return Returns Screen capturer
	 */
	public ScreenCapturer capturer() {
		return capturer;
	}


	public propertieLoader getPropLoader() {
		return propLoader;
	}

}
