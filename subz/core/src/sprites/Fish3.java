package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Fish3
{

	private Texture fish3;
	private Vector2 posFish1;

	private float MOVEMENT = -500;
	private Vector3 position;
	private Vector3 velocity;
	private Animation fishA;
	private Texture texture;

	public Fish3(float x, float speed)
	{
		MOVEMENT = (300  - speed ) -500;
		fish3 = new Texture("fish3A.png");
		int rand = (int) (Math.random() * 690);

		texture = new Texture("fish3A.png");
		fishA = new Animation(new TextureRegion(texture), 4, 0.2f);

		position = new Vector3(x, rand, 0);
		velocity = new Vector3(0, 0, 0);

	}

	public void update(float dt , float speed)
	{ 
		MOVEMENT = (300  - speed ) -500;
		fishA.update(dt);
		velocity.add(0, position.y, 0);
		velocity.scl(dt);
		position.add(MOVEMENT * dt, 0, 0);

		velocity.scl(1 / dt); // adds scale version of velocity

	}

	public TextureRegion getFish()
	{
		return fishA.getFrame();
	}

	public Vector3 getPosition()
	{
		return position;

	}

}