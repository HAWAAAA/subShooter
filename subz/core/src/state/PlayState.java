package state;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.SubStrike;

import sprites.Fish;
import sprites.Fish2;
import sprites.Fish3;
import sprites.Fish4;
import sprites.Submarine;
import sprites.Torpedo;

public class PlayState extends State {
	private Submarine sub;
	private Texture background;
	private Texture backgroundclouds;
	ArrayList<Fish> fishes = new ArrayList<Fish>();
	ArrayList<Fish2> fishes2 = new ArrayList<Fish2>();
	ArrayList<Fish3> fishes3 = new ArrayList<Fish3>();
	ArrayList<Fish4> fishes4 = new ArrayList<Fish4>();
	ArrayList<Torpedo> torpedos = new ArrayList<Torpedo>();
	private TextureRegion imgTextureRegion;
	private int offset = 0;
	private int CamX = 0;
	private int CamX1 = -1;
	private int renders = 0;

	public PlayState(GameStateManager gsm) {

		super(gsm);
		sub = new Submarine(50, 200);
		// cam.setToOrtho(false, SubStrike.WIDTH /2, SubStrike.HEIGHT / 2);

		backgroundclouds = new Texture("Backgroundclouds1.png");
		background = new Texture("background1.png");

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
	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			sub.jump();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			torpedos.add(new Torpedo(sub.getPosition().x, sub.getPosition().y + 80));
		}
	}
	

	@Override
	public void update(float dt) {
		handleInput();
		
		CamX -= 5;
		CamX1 -= 1;
		
		
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
	public void render(SpriteBatch sb) {
		// System.out.println(fishes.size());
		// sb.setProjectionMatrix(cam.combined); //where in the game world we are
		sb.begin();

		if (CamX < -background.getWidth() + 1920 ) {
			CamX = 0;
			CamX1 = 0;
		}
		sb.draw(backgroundclouds, CamX1 , 0);
		sb.draw(background, CamX , 0);

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
	public void dispose() {

	}

}