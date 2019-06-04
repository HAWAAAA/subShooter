package state;

import java.awt.event.KeyEvent;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.SubStrike;
import static com.badlogic.gdx.graphics.Texture.TextureWrap.Repeat;

import sprites.Fish;
import sprites.Submarine;
import sprites.Fish;
import sprites.Fish2;
import sprites.Fish3;
import sprites.Fish4;
import sprites.Submarine;
import sprites.Torpedo;

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
    private int renders = 0;
    private boolean leftmouse = false;

    ArrayList<Fish> fishes = new ArrayList<Fish>();
	ArrayList<Fish2> fishes2 = new ArrayList<Fish2>();
	ArrayList<Fish3> fishes3 = new ArrayList<Fish3>();
	ArrayList<Fish4> fishes4 = new ArrayList<Fish4>();
	ArrayList<Torpedo> torpedos = new ArrayList<Torpedo>();
    
    
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


public void fishies() {
int fishrand = 0;
	int rand = 1 + (int) (Math.random() * 4);
	System.out.println(rand);
	for (int loops = 0; loops < rand; loops++)
	{
	 fishrand = 1 + (int) (Math.random() * 4);	
	
	if(fishrand == 1) {
 int randX = 1800 + (int) (Math.random() * 500);
	fishes.add(new Fish(randX));	
	}
	else if(fishrand == 2)
	{
		 int randX = 1800 + (int) (Math.random() * 500);
	fishes2.add(new Fish2(randX));
	}
	else if(fishrand == 3)
	{
		 int randX = 1800 + (int) (Math.random() * 500);
	fishes3.add(new Fish3(randX));
	}
	else if(fishrand == 4)
	{
		 int randX = 1800 + (int) (Math.random() * 500);
	fishes4.add(new Fish4(randX));
	}
	}	

}
	@Override
	public void handleInput() 
	{
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
		{
			sub.jump();
		}
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && leftmouse == false) 
		{
			torpedos.add(new Torpedo(sub.getPosition().x, sub.getPosition().y + 80));
			leftmouse = true;
		}

		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) == false && leftmouse == true)
		{
			leftmouse = false;
		}

	}

	@Override
	public void update(float dt) 
	{
		handleInput();
		sub.update(dt);
		CamX -= 5;
		CamX1 -= 0.7;
	
		
		
		for (int loops = 0; loops < fishes.size(); loops++) 
		{   Boolean removed = false;
			for (int Tloops = 0; Tloops < torpedos.size(); Tloops++) {
				if( (torpedos.get(Tloops).getPosition().x >= fishes.get(loops).getPosition().x && torpedos.get(Tloops).getPosition().x <= fishes.get(loops).getPosition().x + fishes.get(loops).getFish1().getWidth()) && (torpedos.get(Tloops).getPosition().y  >= fishes.get(loops).getPosition().y && torpedos.get(Tloops).getPosition().y <= fishes.get(loops).getPosition().y + fishes.get(loops).getFish1().getHeight()) )
				{
					torpedos.remove(Tloops);
					fishes.remove(loops);
					removed = true;
					break;
				}
			}
			if (removed == false && (fishes.get(loops).getPosition().x <= -fishes.get(loops).getFish1().getWidth())) {
				fishes.remove(loops);
			} 
			else if(removed == false)
			{
				fishes.get(loops).update(dt);
			}
		
		}
		
		for (int loops = 0; loops < fishes2.size(); loops++) 
		{   Boolean removed = false;
			for (int Tloops = 0; Tloops < torpedos.size(); Tloops++) {
				if( (torpedos.get(Tloops).getPosition().x >= fishes2.get(loops).getPosition().x && torpedos.get(Tloops).getPosition().x <= fishes2.get(loops).getPosition().x + fishes2.get(loops).getFish1().getWidth()) && (torpedos.get(Tloops).getPosition().y  >= fishes2.get(loops).getPosition().y && torpedos.get(Tloops).getPosition().y <= fishes2.get(loops).getPosition().y + fishes2.get(loops).getFish1().getHeight()) )
				{
					torpedos.remove(Tloops);
					fishes2.remove(loops);
					removed = true;
					break;
				}
			}
			if (removed == false && (fishes2.get(loops).getPosition().x <= -fishes2.get(loops).getFish1().getWidth())) {
				fishes2.remove(loops);
			} 
			else if(removed == false)
			{
				fishes2.get(loops).update(dt);
			}
		
		}
		
		for (int loops = 0; loops < fishes3.size(); loops++) 
		{   Boolean removed = false;
			for (int Tloops = 0; Tloops < torpedos.size(); Tloops++) {
				if( (torpedos.get(Tloops).getPosition().x >= fishes3.get(loops).getPosition().x && torpedos.get(Tloops).getPosition().x <= fishes3.get(loops).getPosition().x + fishes3.get(loops).getFish1().getWidth()) && (torpedos.get(Tloops).getPosition().y  >= fishes3.get(loops).getPosition().y && torpedos.get(Tloops).getPosition().y <= fishes3.get(loops).getPosition().y + fishes3.get(loops).getFish1().getHeight()) )
				{
					torpedos.remove(Tloops);
					fishes3.remove(loops);
					removed = true;
					break;
				}
			}
			if (removed == false && (fishes3.get(loops).getPosition().x <= -fishes3.get(loops).getFish1().getWidth())) {
				fishes3.remove(loops);
			} 
			else if(removed == false)
			{
				fishes3.get(loops).update(dt);
			}
		
		}
		
		for (int loops = 0; loops < fishes4.size(); loops++) 
		{   Boolean removed = false;
			for (int Tloops = 0; Tloops < torpedos.size(); Tloops++) {
				if( (torpedos.get(Tloops).getPosition().x >= fishes4.get(loops).getPosition().x && torpedos.get(Tloops).getPosition().x <= fishes4.get(loops).getPosition().x + fishes4.get(loops).getFish1().getWidth()) && (torpedos.get(Tloops).getPosition().y  >= fishes4.get(loops).getPosition().y && torpedos.get(Tloops).getPosition().y <= fishes4.get(loops).getPosition().y + fishes4.get(loops).getFish1().getHeight()) )
				{
					torpedos.remove(Tloops);
					fishes4.remove(loops);
					removed = true;
					break;
				}
			}
			if (removed == false && (fishes4.get(loops).getPosition().x <= -fishes4.get(loops).getFish1().getWidth())) {
				fishes4.remove(loops);
			} 
			else if(removed == false)
			{
				fishes4.get(loops).update(dt);
			}
		
		}
		
		
		
		sub.update(dt);
		
		for (int loops = 0; loops < torpedos.size(); loops++) {

			if (torpedos.get(loops).getPosition().x >= torpedos.get(loops).getTorpedoText().getWidth() + 1800) {
				torpedos.remove(loops);
			} else {
				torpedos.get(loops).update(dt);
			}

		}

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
		
		if (renders == 120) {
			fishies();
			renders = 0;

		}
		for (int loops = 0; loops < torpedos.size(); loops++) {

			sb.draw(torpedos.get(loops).getTorpedoText(), torpedos.get(loops).getPosition().x,
					torpedos.get(loops).getPosition().y);
		}
		sb.draw(sub.getTexture(), sub.getPosition().x, sub.getPosition().y);
		
		for (int loops = 0; loops < fishes.size(); loops++) {
			sb.draw(fishes.get(loops).getFish1(), fishes.get(loops).getPosition().x, fishes.get(loops).getPosition().y);
		}
		for (int loops = 0; loops < fishes2.size(); loops++) {
			sb.draw(fishes2.get(loops).getFish1(), fishes2.get(loops).getPosition().x, fishes2.get(loops).getPosition().y);
		}
		for (int loops = 0; loops < fishes3.size(); loops++) {
			sb.draw(fishes3.get(loops).getFish1(), fishes3.get(loops).getPosition().x, fishes3.get(loops).getPosition().y);
		}
		for (int loops = 0; loops < fishes4.size(); loops++) {
			sb.draw(fishes4.get(loops).getFish1(), fishes4.get(loops).getPosition().x, fishes4.get(loops).getPosition().y);
		}

		renders++;
		sb.end();
		}
	

	@Override
	public void dispose() 
	{

	}

}