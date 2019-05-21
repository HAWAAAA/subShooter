package subShooter;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dx, dy;
	//private BufferedImage submarine;
	//private BufferStrategy bs;
	//private Graphics g;
	//private Display display;


	public Player(int x, int y, int width, int height, int dx, int dy)
	{
		setBounds(x, y, width, height);
		this.dx = dy;
		this.dy = dy;
		
	}
	

	public void tick()		//updates
	{
		//this.x += dx;
		this.y += dy;
		
	}
	
	public void draw(Graphics g)
	{
		g.fillRect(this.x, this.y, this.width, this.height);
		
		
	}

	public void setDx(int dx)
	{
		this.dx = dx;
	}
	
	public void setDy(int dy)
	{
		this.dy = dy;
	}
}
