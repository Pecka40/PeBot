package bot.methodes;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import bot.classHolder.classHolder;

public class Mouse {

	private int speed = 20;
	classHolder holder;

	public Mouse(classHolder hold) {
		holder = hold;
	}

	/**
	 * @param x
	 *            X coordinate
	 * @param y
	 *            Y coordinate Hops mouse to the position
	 */
	public void mouseHop(int x, int y) {
		holder.robot().mouseMove(x, y);
	}

	/**
	 * @param timeBetweenEachPixelms
	 *            Sets the mouse speed
	 */
	public void setSpeed(int timeBetweenEachPixelms) {
		speed = timeBetweenEachPixelms;
	}

	public void mouseMove(int x, int y) {

		int sx = MouseInfo.getPointerInfo().getLocation().x;
		int sy = MouseInfo.getPointerInfo().getLocation().y;

		for (int i = 0; i < 100; i++) {
			int mov_x = ((x * i) / 100) + (sx * (100 - i) / 100);
			int mov_y = ((y * i) / 100) + (sy * (100 - i) / 100);
			holder.robot().mouseMove(mov_x, mov_y);
			holder.robot().delay(speed);
		}
	}

	public void mouseClick() {
		mouseClick(true);
	}

	public void mouseClick(boolean rightClick) {
		if (rightClick) {
			holder.robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
			holder.robot().delay(holder.Utils().random(40, 165));
			holder.robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} else {
			holder.robot().mousePress(InputEvent.BUTTON3_DOWN_MASK);
			holder.robot().delay(holder.Utils().random(40, 165));
			holder.robot().mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		}
	}

	public void mouseMoveCurve(int x, int y) {
		Point[] path = BezierCurvePoints(MouseInfo.getPointerInfo()
				.getLocation().x, MouseInfo.getPointerInfo().getLocation().y,
				x, y);

		for (int i = 0; i < path.length; i++) {
			holder.robot().mouseMove(path[i].x, path[i].y);
			holder.robot().delay(speed);
		}
	}

	/**
	 * Bezier Curve
	 */
	private Point[] BezierCurvePoints(int startX, int startY, int endX, int endY) {

		// Setting the first Point
		List<Point> rangePoints = new ArrayList<Point>();
		rangePoints.add(new Point(startX, startY));

		rangePoints.add(new Point(holder.Utils().random(1, endX - startX)
				+ startX, holder.Utils().random(1, endY - startY) + startY));
		rangePoints.add(new Point(holder.Utils().random(1, endX - startX)
				+ startX, holder.Utils().random(1, endY - startY) + startY));
		rangePoints.add(new Point(endX, endY));

		Point[] coordlist = rangePoints.toArray(new Point[4]);

		List<Point> returnList = new ArrayList<Point>();

		double t;
		double k = .025;
		double x2, y2;

		for (t = k; t <= 1 + k; t += k) {
			// use
			x2 = (coordlist[0].x + t
					* (-coordlist[0].x * 3 + t
							* (3 * coordlist[0].x - coordlist[0].x * t)))
					+ t
					* (3 * coordlist[1].x + t
							* (-6 * coordlist[1].x + coordlist[1].x * 3 * t))
					+ t
					* t
					* (coordlist[2].x * 3 - coordlist[2].x * 3 * t)
					+ coordlist[3].x * t * t * t;
			y2 = (coordlist[0].y + t
					* (-coordlist[0].y * 3 + t
							* (3 * coordlist[0].y - coordlist[0].y * t)))
					+ t
					* (3 * coordlist[1].y + t
							* (-6 * coordlist[1].y + coordlist[1].y * 3 * t))
					+ t
					* t
					* (coordlist[2].y * 3 - coordlist[2].y * 3 * t)
					+ coordlist[3].y * t * t * t;
			int x = (int) Math.round(x2);
			int y = (int) Math.round(y2);

			returnList.add(new Point(x, y));
		}

		return returnList.toArray(new Point[returnList.size()]);
	}

}
