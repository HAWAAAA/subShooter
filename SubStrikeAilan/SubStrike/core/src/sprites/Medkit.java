package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Medkit
{

	private Texture fish5;
	private Vector2 posFish1;

	private static final int MOVEMENT = -350;
	private Vector3 position;
	private Vector3 velocity;
	private Animation medkitA;
	private Texture texture;

	public Medkit(float x)
	{
		fish5 = new Texture("medkitA.png");
		int rand = (int) (Math.random() * 690);

		texture = new Texture("medkitA.png");
		medkitA = new Animation(new TextureRegion(texture), 4, 0.2f);

		position = new Vector3(x, rand, 0);
		velocity = new Vector3(0, 0, 0);

	}

	public void update(float dt)
	{
		medkitA.update(dt);
		velocity.add(0, position.y, 0);
		velocity.scl(dt);
		position.add(MOVEMENT * dt, 0, 0);

		velocity.scl(1 / dt); // adds scale version of velocity

	}

	public TextureRegion getFish()
	{
		return medkitA.getFrame();
	}

	public Vector3 getPos()
	{
		return position;

	}

}
