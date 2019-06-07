package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Torpedo
{

	private Texture TorpedoText;

	private static final int MOVEMENT = 800;
	private Vector3 position;
	private Vector3 velocity;

	public Torpedo(float x, float y)
	{
		
		
		TorpedoText = new Texture("Torpedo.png");

		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);

	}

	public Texture getTorpedoText()
	{
		return TorpedoText;

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