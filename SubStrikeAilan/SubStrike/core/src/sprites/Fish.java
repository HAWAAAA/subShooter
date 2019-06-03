package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;


public class Fish 
{
	public static final int VARIATION = 130;
	private Texture fish1;
	private Vector2 posFish1;
	private Random rand;
	
	
	public Fish(float x)
	{
		fish1 = new Texture("Fish1.png");
		rand = new Random();
		
		posFish1 = new Vector2(x, rand.nextInt(VARIATION));
				
	}
	
	public Texture getFish1()
	{
		return fish1;
	}
	
	public Vector2 getPosFish()
	{
		return posFish1;
	}
	

}