package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashState extends State
{
	private Texture loadScreen;

	public SplashState(GameStateManager gsm) 
	{
		super(gsm);
		loadScreen = new Texture("Loading Screen.png");
		

		}

	@Override
	public void handleInput()
	{
		if (Gdx.input.isTouched())
		{
			gsm.set(new MenuState(gsm));
			dispose();
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY))
		{
			gsm.set(new MenuState(gsm));
			dispose();
		}
	}

	@Override
	public void update(float dt) 
	{
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb)
{
		sb.begin();
		sb.draw(loadScreen, 0, 0, 1920, 1080);
		sb.end();		
	}

	@Override
	public void dispose() 
	{
		loadScreen.dispose();
	}

}
