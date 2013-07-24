package bot.methodes;

import java.util.Random;

public class Utils {

	Random random = new Random();

	/**
	 * Returns a random integer with min as the inclusive lower bound and max as
	 * the exclusive upper bound.
	 * 
	 * @param min
	 *            The inclusive lower bound.
	 * @param max
	 *            The exclusive upper bound.
	 * @return Random integer min <= n < max.
	 */
	public int random(final int min, final int max) {
		final int n = Math.abs(max - min);
		return Math.min(min, max) + (n == 0 ? 0 : random.nextInt(n));
	}

}
