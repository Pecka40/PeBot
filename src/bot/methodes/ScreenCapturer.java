package bot.methodes;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ScreenCapturer {

	private Robot capturer;

	/**
	 * @return Returns BufferedImage of the screen
	 */
	public BufferedImage getScreen(Robot robot) {
		capturer = robot;
		return captureScreen();
	}

	private BufferedImage captureScreen() {
		BufferedImage scrImage = capturer.createScreenCapture(new Rectangle(
				Toolkit.getDefaultToolkit().getScreenSize()));
		return scrImage;
	}

}
