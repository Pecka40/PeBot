package bot.classHolder;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bot.boot.MainApp;
import bot.settings.About;
import bot.settings.Settings;
import bot.settings.Updater;

public class SystemTrayIcon {
	
	private static MenuItem startScript;
	private static MenuItem stopScript;
	private static MenuItem showHide;
	
	public SystemTrayIcon() {

		if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
		
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(Settings.getSysTray());
        final SystemTray tray = SystemTray.getSystemTray();
       
        // Create a pop-up menu components
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				About.showCredits();
			}
        });
        
        MenuItem checkUpdate = new MenuItem("Check updates");
        checkUpdate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Updater.checkForUpdate();
			}
        });
        
        startScript = new MenuItem("Start script");
        startScript.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(startScript.getLabel().contentEquals("Start script")){
					new ScriptChooser();
				}else if(startScript.getLabel().contentEquals("Pause script")){
					ScriptRunner.pause(true);
				}else if(startScript.getLabel().contentEquals("Resume script")){
					ScriptRunner.pause(false);
				}
			}
        });
        
        stopScript = new MenuItem("Stop script");
        stopScript.setEnabled(false);
        stopScript.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ScriptRunner.stopScript();
			}
        });
       
       showHide = new MenuItem("Hide");
        showHide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(showHide.getLabel().contentEquals("Hide")){
					MainApp.show(false);
					showHide.setLabel("Show");
				}else if(showHide.getLabel().contentEquals("Show")){
					MainApp.show(true);
					showHide.setLabel("Hide");
				}
			}
        });
        
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(new ActionListener(){
        	@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        });
       
        //Add components to pop-up menu
        popup.add(aboutItem);
        popup.add(checkUpdate);
        
        popup.addSeparator();
        
        popup.add(startScript);
        popup.add(stopScript);
        
        popup.addSeparator();
        
        popup.add(showHide);
        
        popup.add(exitItem);
       
        trayIcon.setPopupMenu(popup);
       
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
		
	}
	
	public static void scriptStarted(){
		startScript.setName("Pause script");
		stopScript.setEnabled(true);
	}
	
	public static void scriptStoped(){
		startScript.setName("Start script");
		stopScript.setEnabled(false);
	}
	
	public static void scriptPaused(boolean isPaused){
		if(isPaused){
			startScript.setName("Resume script");
		}else{
			startScript.setName("Pause script");
		}
	}

}
