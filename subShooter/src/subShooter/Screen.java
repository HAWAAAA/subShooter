package subShooter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Screen extends JPanel implements ActionListener, KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferStrategy bs;
	BufferedImage sub;
	Timer t = new Timer(10,this);	//game loop
	Player p = new Player(10, 360, 10, 10, 0, 0);
	Image img = new ImageIcon("src/images/submarine.png").getImage();
	
	public Screen()
	{
		addKeyListener(this);
		setFocusable(true);
		t.start();
		
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		p.tick();
		
		repaint();
	}

	

	public void paint(Graphics g)
	{
		sub = new BufferedImage (img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		g = sub.createGraphics();
		System.out.println("hi");
		//g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(img, 0, 50, null);
		setVisible(true);
		//p.draw(g);
		//g.drawImage(ocean, 50, 50, null);
		
	}
	
	
	public void keyPressed(KeyEvent k) 
	{
		switch (k.getKeyCode())
		{
		case KeyEvent.VK_SPACE:
			p.setDy(-5);
			//p.setDx(1);
			break;
			/*
		case KeyEvent.VK_S:
			p.setDy(1);
			break;
		case KeyEvent.VK_A:
			p.setDx(-1);
			break;
		case KeyEvent.VK_W:
			p.setDy(-1);
			break;
			*/
		}
		
	}

	
	public void keyReleased(KeyEvent k)
	{
		switch (k.getKeyCode())
		{
		case KeyEvent.VK_SPACE:
			p.setDy(1);
			//p.setDx(1);
			break;
		}
		
	}

	
	public void keyTyped(KeyEvent arg0) 
	{
		
	}

	
	
}

