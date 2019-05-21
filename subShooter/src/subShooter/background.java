package subShooter;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class background
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BufferedImage ocean;
	
	public void paint(Graphics g)
	{
		image();
		
		g.drawImage(ocean, 50, 50, null);
		
	}
	
	public void image()
	{

	
	try {
		ocean = ImageIO.read(new File("subShooter/src/images/ocean.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
		
		/*
		JLabel picLabel = new JLabel(new ImageIcon(ocean));
		JPanel jPanel = new JPanel();
		jPanel.add(picLabel);
		JFrame f = new JFrame();
		f.add(jPanel);
		f.setVisible(true);
		*/
	}

}
