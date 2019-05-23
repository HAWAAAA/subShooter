package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SubStrike;

public class MenuState extends State
{
	private Texture background;
	private Texture play;
	

	public MenuState(GameStateManager gsm) 
	{
		super(gsm);
		background = new Texture("ocean.png");
		play = new Texture("play.png");
	}

	@Override
	public void handleInput() 
	{
		if(Gdx.input.justTouched())
		{
			gsm.set(new PlayState(gsm));
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
		sb.draw(background, 0, 0, SubStrike.HEIGHT, SubStrike.HEIGHT);
		sb.draw(play, 682, 554 );
		sb.end();
	}

	@Override
	public void dispose()
	{
	background.dispose();
	play.dispose();

	}

}
