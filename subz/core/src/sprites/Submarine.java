package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Submarine 
{
	private static final int GRAVITY = -15;
	private static final int MOVEMENT = 5;
	private Vector3 position;
	private Vector3 velocity;
	
	private Texture sub;
	
	public Submarine(int x, int y)
	{
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);
		sub = new Texture("YellowSubmarine.png");
		
	}
	
	public void update(float dt)
	{
		if (position.y > 0)  //prevents from falling offstage
		{
			velocity.add(0,GRAVITY, 0);
		}
		velocity.add(0, GRAVITY, 0);
		velocity.scl(dt);
		position.add(MOVEMENT * dt, velocity.y, 0);
		if (position.y < 0)
		{
			position.y = 0;
		}
		velocity.scl(1/dt); //adds scale version of velocity

	}
	
	public Vector3 getPosition()
	{
		return position;
		
	}
	
	public Texture getTexture()
	{
		return sub;
	}
	
	public void jump()
	{
		velocity.y = 350;
		
	}
}