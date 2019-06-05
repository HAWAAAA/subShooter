package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Fish4
{

	private Texture fish1;
	private Vector2 posFish1;

	private static final int MOVEMENT = -400;
	private Vector3 position;
	private Vector3 velocity;

	public Fish4(float x)
	{
		fish1 = new Texture("Fish4.png");
		int rand = (int) (Math.random() * 690);

		position = new Vector3(x, rand, 0);
		velocity = new Vector3(0, 0, 0);

	}

	public Texture getFish1()
	{
		return fish1;
	}

	public Vector3 getPosition()
	{
		return position;

	}

	public void update(float dt)
	{

		velocity.add(0, position.y, 0);
		velocity.scl(dt);
		position.add(MOVEMENT * dt, 0, 0);

		velocity.scl(1 / dt); // adds scale version of velocity

	}

}