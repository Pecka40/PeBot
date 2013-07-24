package bot.classHolder;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ScriptLoader {

	classHolder holder;

	public ScriptLoader(classHolder holder) {
		this.holder = holder;
	}

	public Object[] getScripts() {

		List<Object> objList = new ArrayList<Object>();

		String path = holder.getPropLoader().getPathToScripts();
		System.out.println(path+"here?");
		File[] files = new File(path).listFiles();
		List<File> filesToCheck = new ArrayList<File>();
		System.out.println(files == null);
		for (File file : files) {
			if (file.isFile()) {
				filesToCheck.add(file);
			}
		}

		for (int i = 0; i < filesToCheck.size(); i++) {

			try {
				System.out.println(filesToCheck.get(i).getName());
				Object nextScript = loadScript(
						filesToCheck
								.get(i)
								.getName()
								.substring(
										0,
										filesToCheck.get(i).getName()
												.indexOf(".")),
						filesToCheck
								.get(i)
								.getAbsolutePath()
								.substring(
										0,
										filesToCheck.get(0).getAbsolutePath()
												.lastIndexOf("\\") + 1));
				objList.add(nextScript);
			} catch (InstantiationException | IllegalAccessException
					| MalformedURLException e) {
				e.printStackTrace();
			}

		}
		return objList.toArray(new Object[objList.size()]);
	}

	private Object loadScript(String name, String path)
			throws InstantiationException, IllegalAccessException,
			MalformedURLException {

		Object script = null;

		System.out.println(path);

		URL url = new URL("file:" + path);

		URL[] urls = { url };

		ClassLoader newScriptLoader = new URLClassLoader(urls);

		try {
			Class aClass = newScriptLoader.loadClass(name);
			script = aClass.newInstance();
		} catch (ClassNotFoundException | IllegalArgumentException
				| SecurityException e) {
			e.printStackTrace();
		}
		return script;
	}

	public ScriptFile[] getScriptFile(String path){

		Object[] scripts = getScripts();

		List<ScriptFile> listOfScriptFile = new ArrayList<ScriptFile>();

		for (int i = 0; i < scripts.length; i++) {

			Object nextScript = scripts[i];

			String name = null;
			String ver = null;
			String auth = null;
			String desc = null;

			for (int ii = 0; ii < nextScript.getClass().getMethods().length; ii++) {
				if(nextScript.getClass().getMethods()[ii].getName().contentEquals("getName")){
					try {
						name = (String) nextScript.getClass().getMethods()[ii].invoke(nextScript);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | SecurityException e) {
						e.printStackTrace();
					}
				}
				else if(nextScript.getClass().getMethods()[ii].getName().contentEquals("getAuthor")){
					try {
						auth = (String) nextScript.getClass().getMethods()[ii].invoke(nextScript);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | SecurityException e) {
						e.printStackTrace();
					}
				}
				else if(nextScript.getClass().getMethods()[ii].getName().contentEquals("getVersion")){
					try {
						ver = (String) nextScript.getClass().getMethods()[ii].invoke(nextScript);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | SecurityException e) {
						e.printStackTrace();
					}
				}
				else if(nextScript.getClass().getMethods()[ii].getName().contentEquals("getDescription")){
					try {
						desc = (String) nextScript.getClass().getMethods()[ii].invoke(nextScript);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | SecurityException e) {
						e.printStackTrace();
					}
				}
			}

			listOfScriptFile.add(new ScriptFile(name, ver, auth, desc,
					nextScript));
		}

		return listOfScriptFile
				.toArray(new ScriptFile[listOfScriptFile.size()]);
	}

	public class ScriptFile {
		private String name;
		private String version;
		private String author;
		private String description;
		private Object script;

		public ScriptFile(String Name, String Version, String Author,
				String Description, Object theScript) {
			name = Name;
			version = Version;
			author = Author;
			description = Description;
			script = theScript;
		}

		public String getName() {
			return name;
		}

		public String getVersion() {
			return version;
		}

		public String getAuthor() {
			return author;
		}

		public String getDescription() {
			return description;
		}

		public Object getScript() {
			return script;
		}

	}

}
