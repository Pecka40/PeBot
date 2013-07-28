
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import bot.classHolder.Script;
import bot.classHolder.classHolder;


public class PeAplenkums extends Script{
	
	BufferedImage shield;
	private classHolder holder = new classHolder();
	
	@Override
	public boolean onStart() { 
		try {
			shield = ImageIO.read(PeAplenkums.class.getResource("shield.bmp"));
		} catch (IOException e) {
			System.out.println("Couldnt read img");
			e.printStackTrace();
		}
		
		return true;
	}


	@Override
	public int loop() {
		System.out.println("Getting the point");
		Point p = holder.screenData().getPoint(shield);
		if(p != null){
			holder.mouse().mouseHop(p.x, p.y);
			holder.mouse().mouseClick();
		}else{
			System.out.println("No point of shield,not moving mouse");
		}
		return holder.Utils().random(40, 100);
	}


	@Override
	public String getName() {
		return "PeAplenkums";
	}


	@Override
	public String getAuthor() {
		return "Pecka";
	}


	@Override
	public String getVersion() {
		return "0.1";
	}


	@Override
	public String getDescription() {
		return "Does shields";
	}


}
