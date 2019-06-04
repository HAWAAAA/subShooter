package state;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.SubStrike;

import sprites.Fish;
import sprites.Missile;
import sprites.Submarine;

public class PlayState extends State
{
	private Submarine sub;
	private Texture background;
	private Fish fish;
    private int offset = 0;
    private int CamX = 0;
    private final int SPEED = 300;

    
    private final int SUB_WIDTH = 281;
    
	public PlayState(GameStateManager gsm) 
	{
		super(gsm);
		sub = new Submarine(50, 200);
		//cam.setToOrtho(false, SubStrike.WIDTH /2, SubStrike.HEIGHT / 2);
		background = new Texture("background.png");
		
       
		//fish = new Fish(100);
		
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
		CamX -= 10;
		
	
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		
		//sb.setProjectionMatrix(cam.combined); //where in the game world we are
		sb.begin();
		
	if (CamX  < -background.getWidth() + 1920  - offset   )
	   {
	    offset += background.getWidth() - 1920;
	    }
	
	if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
	{
		
	}
		
		sb.draw(background, CamX  + offset ,0);

		sb.draw(sub.getTexture(), sub.getPosition().x, sub.getPosition().y);
		//sb.draw(fish.getFish1(), fish.getPosFish().x, fish.getFish1().y);
		sb.end();
		
	}

	@Override
	public void dispose() 
	{

	}

}