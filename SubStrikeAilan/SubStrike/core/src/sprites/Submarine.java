package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;


public class Submarine
{
	private static final int GRAVITY = 7;
	private static final int MOVEMENT = 0;
	private Vector3 position;
	private Vector3 velocity;
	private Animation subAnimation;
	private Texture texture;
	private Texture sub;
	private Sound splash;
	private Sound splash1;
	private Music Underwater;
	private Music waves;
	private boolean sound;
	private boolean above = false;
	

	public Submarine(float x, float y)
	{
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);
		texture = new Texture("YellowSubmarineA.png");
		subAnimation = new Animation(new TextureRegion(texture), 4, 0.2f);

		splash = Gdx.audio.newSound(Gdx.files.internal("WaterSplash.mp3"));
		splash1 = Gdx.audio.newSound(Gdx.files.internal("WaterSplash1.mp3"));
		
		Underwater = Gdx.audio.newMusic(Gdx.files.internal("Underwater.mp3"));
		Underwater.setLooping(true);
		Underwater.setVolume(2f);
		Underwater.play();

		waves = Gdx.audio.newMusic(Gdx.files.internal("Waves.mp3"));
		waves.setLooping(true);
		waves.setVolume(0);
		waves.play();
	}

	public void update(float dt)
	{

		subAnimation.update(dt);
		if (position.y > 0) // prevents from falling offstage
		{
			velocity.add(0, GRAVITY, 0);
		}
		velocity.add(0, GRAVITY, 0);
		velocity.scl(dt);
		position.add(MOVEMENT * dt, velocity.y, 0);
		if (position.y < 25)
		{
			position.y = 25;
		}

		if (position.y > 690)
		{
			position.y = 690;
			Underwater.setVolume(0);
			waves.setVolume(0.15f);
		} else
		{
			Underwater.setVolume(1f);
			waves.setVolume(0);
		}

		if (position.y >= 690 && above == false)
		{
			above = true;
			splash.play(0.5f);
		}

		if (position.y < 690 && above == true)
		{
			above = false;
			splash1.play(0.5f);
		
		}
		
	

		velocity.scl(1 / dt); // adds scale version of velocity

	}
	
	
	
	public void stopSounds() {
		
		waves.stop();
		Underwater.stop();
	}
	
	public Vector3 getPosition()
	{
		return position;

	}

	public TextureRegion getTexture()
	{
		return subAnimation.getFrame();
	}

	public void jump()
	{
		velocity.y = -500;

	}
}