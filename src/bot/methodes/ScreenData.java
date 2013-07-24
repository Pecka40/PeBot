package bot.methodes;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import bot.classHolder.classHolder;

public class ScreenData {

	classHolder hold;

	public ScreenData(classHolder holder) {
		hold = holder;
	}
	
	public ScreenData() {
		hold = new classHolder();
	}

	public Point getPoint(BufferedImage img) {
		Point thePoint = null;
		BufferedImage Large = hold.capturer().getScreen(hold.robot());

		for (int outerX = 0; outerX < Large.getWidth() - img.getWidth(); outerX++) {

			con: for (int outerY = 0; outerY < Large.getHeight()
					- img.getHeight(); outerY++) {

				for (int innerX = 0; innerX < img.getWidth(); innerX++) {

					for (int innerY = 0; innerY < img.getHeight(); innerY++) {

						Color cNeedle = new Color(img.getRGB(innerX, innerY));

						Color cHaystack = new Color(Large.getRGB(innerX
								+ outerX, innerY + outerY));

						if (cNeedle.getBlue() != cHaystack.getBlue()
								|| cNeedle.getGreen() != cHaystack.getGreen()
								|| cNeedle.getRed() != cHaystack.getRed()) {
							continue con;
						}
					}
				}
				thePoint = new Point(outerX, outerY);
				return thePoint;
			}
		}
		return thePoint;
	}

	private Point getPoint(BufferedImage Large, BufferedImage[] Small, int c) {
		Point Point = null;

		for (int x = 0; x < c; x++) {
			System.out.println(x);

			for (int outerX = 0; outerX < Large.getWidth()
					- Small[x].getWidth(); outerX++) {

				con: for (int outerY = 0; outerY < Large.getHeight()
						- Small[x].getHeight(); outerY++) {

					for (int innerX = 0; innerX < Small[x].getWidth(); innerX++) {

						for (int innerY = 0; innerY < Small[x].getHeight(); innerY++) {

							Color cNeedle = new Color(Small[x].getRGB(innerX,
									innerY));

							Color cHaystack = new Color(Large.getRGB(innerX
									+ outerX, innerY + outerY));

							if (cNeedle.getBlue() != cHaystack.getBlue()
									|| cNeedle.getGreen() != cHaystack
											.getGreen()
									|| cNeedle.getRed() != cHaystack.getRed()) {
								continue con;
							}
						}
					}
					System.out.println("Ir");
					Point = new Point(outerX, outerY);
					return Point;
				}
			}

		}
		System.out.println("Nav");
		return Point;
	}

}
