package state;

import java.awt.event.KeyEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.SubStrike;
import static com.badlogic.gdx.graphics.Texture.TextureWrap.Repeat;

import sprites.Fish;
import sprites.Submarine;

public class PlayState extends State
{
	private Submarine sub;
	private Texture background;
	private Texture backgroundclouds;
	private Texture sun;
	private Texture hearts;
	private Fish fish;
	private TextureRegion imgTextureRegion;
    private int offset = 0;
    private double CamX = 0;
    private float CamX1 = -1;
    float sourceX = 0;
    float sourceX1 = 0;
    final int WIDTH = 7000;
    final int HEIGHT = 1080;
    
    
    
public PlayState(GameStateManager gsm) 
	{
		super(gsm);
		sub = new Submarine(50, 200);
		cam.setToOrtho(false, SubStrike.WIDTH, SubStrike.HEIGHT);
		
		hearts = new Texture("Hearts.png");
		backgroundclouds = new Texture("Backgroundclouds1.png");
		background = new Texture("background.png");
		sun = new Texture("Sun.png");
		backgroundclouds.setWrap(Repeat, Repeat);
		background.setWrap(Repeat, Repeat);
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
		CamX -= 5;
		CamX1 -= 0.7;
	
	}

	@Override
	public void render(SpriteBatch sb) 
	{
		sourceX += 5;
		sourceX1 += 1;
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sourceX = (sourceX + Gdx.graphics.getDeltaTime() / 3/4) % background.getWidth();
		sourceX1 = (sourceX1 + Gdx.graphics.getDeltaTime() / 3/4) % background.getWidth();
	
		sb.draw(backgroundclouds, 0, 0, WIDTH, HEIGHT, (int) sourceX1, 0, background.getWidth(), background.getHeight(), false, false);
		sb.draw(background, 0, 0, WIDTH, HEIGHT, (int) sourceX, 0, background.getWidth(), background.getHeight(), false, false);
		sb.draw(sun, CamX1  + offset, 0);
		sb.draw(hearts, 40, 900);
		sb.draw(sub.getTexture(), sub.getPosition().x, sub.getPosition().y);
		sb.end();
	}

	@Override
	public void dispose() 
	{

	}

}