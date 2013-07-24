package bot.classHolder;

abstract public class Script {

	abstract public String getName();
	abstract public String getAuthor();
	abstract public String getVersion();
	abstract public String getDescription();
	
	abstract public int loop();

	public boolean onStart() {
		return true;
	}

	/**
	 * Does on script stop
	 */
	public void onFinish() {
	}

}
