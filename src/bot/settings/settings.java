package bot.settings;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Settings{

	private static String defaultLocation;
	private static Image icon;
	private static Image sysTray;
	private static StartUp start;
	
	public Settings(){
		defaultLocation = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		System.out.println("Default directory: "+defaultLocation);
		File[] files = new File(defaultLocation).listFiles();
		boolean hasDir = false;
		
		for(File f:files){
			if(f.isDirectory() && f.getName().contentEquals("PeBot")){
				hasDir = true;
				break;
			}
		}
		
		if(!hasDir){
			int answer = JOptionPane.showConfirmDialog(null, "Are you ok with PeBot making a PeBot directory in you`r documents?", "User`s answer", JOptionPane.YES_NO_OPTION);
			if(answer != JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Then you can not use PeBot!");
				System.exit(0);
			}else{
				defaultLocation = defaultLocation + "\\PeBot";
				new File(defaultLocation).mkdir();
			}
		}else{
			defaultLocation = defaultLocation + "\\PeBot";
		}
		
		start = new StartUp();
		start.setIcon();
		
		System.out.println("PeBotDir: "+defaultLocation);
		
		files = new File(defaultLocation).listFiles();
		boolean[] hasDirs = {false,false,false,false,false,false,false};
		
		for(File f:files){
			if(f.isDirectory() && f.getName().contentEquals("Fonts")){
				hasDirs[0] = true;
			}
			if(f.isDirectory() && f.getName().contentEquals("Scripts")){
				hasDirs[1] = true;
			}
			if(f.isDirectory() && f.getName().contentEquals("Script settings")){
				hasDirs[2] = true;
			}
			if(f.isDirectory() && f.getName().contentEquals("Settings")){
				hasDirs[3] = true;
			}
			if(f.isDirectory() && f.getName().contentEquals("Logs")){
				hasDirs[4] = true;
			}
			if(f.isDirectory() && f.getName().contentEquals("Images")){
				hasDirs[5] = true;
			}
			if(f.isDirectory() && f.getName().contentEquals("Other resources")){
				hasDirs[6] = true;
			}
		}

		if(hasDirs[5] == false){
			new File(defaultLocation+"\\Images").mkdir();
			try {
				Downloader.download("https://dl.dropboxusercontent.com/u/17610658/Bot/icon.gif", defaultLocation+"\\Images\\icon.gif");
				Downloader.download("https://dl.dropboxusercontent.com/u/17610658/Bot/SysTray.gif", defaultLocation+"\\Images\\sysTray.gif");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		File f = new File(Settings.getPath("Images")+"\\icon.gif");
		BufferedImage img = null;
		try {
			img = ImageIO.read(f);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			try {
				Downloader.download("https://dl.dropboxusercontent.com/u/17610658/Bot/icon.gif", Settings.getPath("Images")+"\\icon.gif");
				f = new File(Settings.getPath("Images")+"\\icon.gif");
				img = ImageIO.read(f);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		icon = img;
		
		f = new File(Settings.getPath("Images")+"\\sysTray.gif");
		img = null;
		try {
			img = ImageIO.read(f);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			try {
				Downloader.download("https://dl.dropboxusercontent.com/u/17610658/Bot/sysTray.gif", Settings.getPath("Images")+"\\sysTray.gif");
				f = new File(Settings.getPath("Images")+"\\sysTray.gif");
				img = ImageIO.read(f);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		sysTray = img;
		
		
		if(hasDirs[0] == false){
			new File(defaultLocation+"\\Fonts").mkdir();
			
		}
		if(hasDirs[1] == false){
			new File(defaultLocation+"\\Scripts").mkdir();
		}
		if(hasDirs[2] == false){
			new File(defaultLocation+"\\Script settings").mkdir();
		}
		if(hasDirs[3] == false){
			new File(defaultLocation+"\\Settings").mkdir();
		}
		if(hasDirs[4] == false){
			new File(defaultLocation+"\\Logs").mkdir();
		}
		if(hasDirs[6] == false){
			new File(defaultLocation+"\\Other resources").mkdir();
		}
		
		stopStart();
	}
	
	public static Image getIcon(){
		return icon;
	}
	
	public static Image getSysTray(){
		return sysTray;
	}
	
	public static String getPath(String folderName){
		return defaultLocation+"\\"+folderName;
	}
	public static void stopStart(){
		start.setVisible(false);
		start.dispose();
	}
}
