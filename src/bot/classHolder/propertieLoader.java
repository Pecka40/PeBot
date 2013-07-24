package bot.classHolder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class propertieLoader {

	private String pathToClassSource = null;
	private String defaultPathToClassSource;

	public propertieLoader() {
		try {
			if (this.getClass().getProtectionDomain().getCodeSource()
					.getLocation().getPath().contains(".jar")) {
				pathToClassSource = this
						.getClass()
						.getProtectionDomain()
						.getCodeSource()
						.getLocation()
						.getPath()
						.substring(
								0,
								this.getClass().getProtectionDomain()
										.getCodeSource().getLocation()
										.getPath().lastIndexOf("/"))+"/Scripts/";
			} else {
				pathToClassSource = URLDecoder.decode(this.getClass()
						.getProtectionDomain().getCodeSource().getLocation()
						.getPath()
						+ "\\Scripts\\", "UTF-8");
			}
			System.out.println(pathToClassSource);
			defaultPathToClassSource = URLDecoder.decode(this.getClass()
					.getProtectionDomain().getCodeSource().getLocation()
					.getPath(), "UTF-8");
			System.out.println(defaultPathToClassSource);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getPathToScripts() {
		if (pathToClassSource != null) {
			return pathToClassSource;
		} else {
			return defaultPathToClassSource;
		}
	}

}
