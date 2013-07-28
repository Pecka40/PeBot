package bot.settings;

import javax.swing.JOptionPane;

public class About {

	private static String version = "0.1 Alpha";

	public static void showCredits() {
		JOptionPane.showMessageDialog(null,
				"This color bot was made by Pecka40." + System.lineSeparator()
						+ "Version: " + getVersion());
	}

	public static String getVersion() {
		return version;
	}

}
