package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Missile 
{
	public static final int SPEED = 500;
	//public static final int DEFAULT_Y = 40;
	
	float x, y;
	public boolean remove = false;
	Texture missile;
	
	public Missile(float x)
	{
		this.x = x;
		//this.y= y;
		missile = new Texture("Torpedo.png");
	}

	public void update(float deltaTime)
	{
		x += SPEED * deltaTime;
		if (x > Gdx.graphics.getWidth())
		{
			remove = true;
		}
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(missile, x, y);
	}
}
