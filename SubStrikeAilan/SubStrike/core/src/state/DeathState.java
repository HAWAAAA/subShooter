package state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DeathState extends State  
{
	private Texture death;

	public DeathState(GameStateManager gsm) 
	{
		super(gsm);
		death = new Texture("Death.png");
	}

	@Override
	public void handleInput()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float dt) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.begin();
		sb.draw(death, 0, 0, death.getWidth(), death.getHeight());
		sb.end();
		
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		
	}

}