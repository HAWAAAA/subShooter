package subShooter;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BufferedImage ocean;


	public Frame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sub Shooter");
		setSize(1080,700);
		setResizable(false);
		
		init();
		
		
	}
	
	public void init()
	{
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(1,1,0,0));
		Screen s = new Screen();
		add(s);
		setVisible(true);

		
	}
	
	public static void main(String[] args)
	{
		//ImagePanel panel = new ImagePanel(new ImageIcon("src/images/ocean.png").getImage());
		//JFrame frame = new JFrame();
		//frame.getContentPane().add(panel);
		//frame.pack();
		//frame.setVisible(true);
		Frame f = new Frame();
		
		
		//Frame f = new Frame();
		Screen s = new Screen();

		
	}
	

}
