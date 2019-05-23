package state;

import java.awt.event.KeyEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SubStrike;

import sprites.Submarine;

public class PlayState extends State
{
	private Submarine sub;
	private Texture background;
	

	public PlayState(GameStateManager gsm) 
	{
		super(gsm);
		sub = new Submarine(50, 200);
		cam.setToOrtho(false, SubStrike.WIDTH /2, SubStrike.HEIGHT / 2);
		background = new Texture("ocean2.png");
	}

	@Override
	public void handleInput() 
	{
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
		{
			sub.jump();
		}


	}

	@Override
	public void update(float dt) 
	{
		handleInput();
		sub.update(dt);
	
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sb.setProjectionMatrix(cam.combined); //where in the game world we are
		sb.begin();
		sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
		sb.draw(sub.getTexture(), sub.getPosition().x, sub.getPosition().y);
		sb.end();
	}

	@Override
	public void dispose() 
	{

	}

}
