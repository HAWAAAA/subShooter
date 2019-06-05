package state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HowToPlayState extends State
{
	private Texture howTo;

	public HowToPlayState(GameStateManager gsm)
	{
		super(gsm);
		howTo = new Texture("badlogic.jpg");
	}

	@Override
	public void handleInput() 
	{
		
	}

	@Override
	public void update(float dt) 
	{
		
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.begin();
		sb.draw(howTo, 0, 0, howTo.getWidth(), howTo.getHeight());
		dispose();
		sb.end();
		
		
	}

	@Override
	public void dispose() 
	{
		howTo.dispose();
	}
	

}