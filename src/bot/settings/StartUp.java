package bot.settings;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StartUp extends JFrame {

	private JPanel contentPane;
	private Image img;
	private boolean startingup = true;
	JLabel lblNewLabel;
	
	/**
	 * Create the frame.
	 */
	public StartUp() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Starting up");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(Settings.getPath("Images")+"\\startup.gif"));
		lblNewLabel.setBounds(38, 12, 264, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(38, 94, 314, 19);
		contentPane.add(lblNewLabel_1);
		
		this.setVisible(true);
	}
	
	public void setIcon(){
		File f = new File(Settings.getPath("Images")+"\\startup.gif");
		img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e1) {
			e1.printStackTrace();
			try {
				Downloader.download("https://dl.dropboxusercontent.com/u/17610658/Bot/startup.gif", Settings.getPath("Images")+"\\startup.gif");
				f = new File(Settings.getPath("Images")+"\\startup.gif");
				img = ImageIO.read(f);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		this.setIconImage(img);
		lblNewLabel.setIcon(new ImageIcon(Settings.getPath("Images")+"\\startup.gif"));
	}
	
	private void startingUp(){
		while(startingup){
			
		}
	}

}
