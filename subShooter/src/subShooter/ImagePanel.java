package subShooter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image ocean;

	  public ImagePanel(String ocean) {
	    this(new ImageIcon(ocean).getImage());
	  }

	  public ImagePanel(Image ocean) 
	  {
	    this.ocean = ocean;
	    Dimension size = new Dimension(ocean.getWidth(null), ocean.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(ocean, 0, 0, null);
	  }

}
