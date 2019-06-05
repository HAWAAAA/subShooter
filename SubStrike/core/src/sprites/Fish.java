package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Fish
{

	private Texture fish1;
	private Vector2 posFish1;

	private static final int MOVEMENT = -400;
	private Vector3 position;
	private Vector3 velocity;
	private Animation fishA;
	private Texture texture;

	public Fish(float x)
	{
		fish1 = new Texture("Fish1A.png");
		int rand = (int) (Math.random() * 690);

		texture = new Texture("Fish1A.png");
		fishA = new Animation(new TextureRegion(texture), 4, 0.2f);

		position = new Vector3(x, rand, 0);
		velocity = new Vector3(0, 0, 0);

	}

	public void update(float dt)
	{
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
