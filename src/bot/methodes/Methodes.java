package bot.methodes;

import java.awt.AWTException;
import java.awt.Robot;

import bot.classHolder.classHolder;
import bot.methodes.Keyboard.KEYS;

public class Methodes {

	public Mouse mouse;
	public Keyboard keyboard;
	private classHolder holder = new classHolder();
	private Robot robot;
	
	public Methodes(){
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		mouse = new Mouse(holder);
		keyboard = new Keyboard(robot);
	}
	
}
