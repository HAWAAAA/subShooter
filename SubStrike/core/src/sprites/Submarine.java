package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Submarine 
{
	private static final int GRAVITY = 9;
	private static final int MOVEMENT = 0;
	private Vector3 position;
	private Vector3 velocity;
	private Animation subAnimation;
	private Texture texture;
	private Texture sub;
	public Rectangle subRect;
	
	public Submarine(float x, float y)
	{
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);
		texture = new Texture("YellowSubmarineA.png");
		subAnimation = new Animation(new TextureRegion(texture), 4, 0.2f);		
		
	}
	
	public void update(float dt)
	{
		subAnimation.update(dt);
		if (position.y > 0)  //prevents from falling offstage
		{ 
			velocity.add(0,GRAVITY, 0);
		}
		velocity.add(0, GRAVITY, 0);
		velocity.scl(dt);
		position.add(MOVEMENT * dt, velocity.y, 0);
		if (position.y < 25)
		{
			position.y = 25;
		}
		
		if (position.y > 690)
		{
			position.y = 690;

		} 
		
		
		velocity.scl(1/dt); //adds scale version of velocity
	}
	
	public Vector3 getPosition()
	{
		return position;
		
	}
	
	public TextureRegion getTexture()
	{  
		return subAnimation.getFrame();
	}
	
	public Texture getSub()
	{
		return texture;
	}
	
	public void jump()
	{
		velocity.y = -500;
		
		
	}
	
}
	
	
	