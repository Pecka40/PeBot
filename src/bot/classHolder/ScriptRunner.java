package bot.classHolder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Anotation(Author = "", Description = "", Name = "", Version = "")
public class ScriptRunner extends Thread{

	private Object theScript;
	
	public ScriptRunner(Object script){
		theScript = script;
		System.out.println("Got the script");
		run();
	}
	
	
	boolean run = true;
	
	@Override
	public void run() {

		Method loop = null;
		Method onStart = null;
		Method onFinish = null;
		
		for(int i = 0;i<theScript.getClass().getMethods().length;i++){
			if(theScript.getClass().getMethods()[i].getName().contentEquals("loop")){
				loop = theScript.getClass().getMethods()[i];
			}else if(theScript.getClass().getMethods()[i].getName().contentEquals("onStart")){
				onStart = theScript.getClass().getMethods()[i];
			}
			else if(theScript.getClass().getMethods()[i].getName().contentEquals("onFinish")){
				onFinish = theScript.getClass().getMethods()[i];
			}
		}
		
		try {
			run = (boolean) onStart.invoke(theScript);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		while(run){
			try {
				int timeToSleep = (int) loop.invoke(theScript);
				if(timeToSleep < 1){
					run = false;
					break;
				}else{
					Thread.sleep(timeToSleep);
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
				System.out.println("Nesanāca loop");
			}
		}
		
		
	}

	

}
