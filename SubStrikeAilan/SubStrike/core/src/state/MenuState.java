package state;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SubStrike;

public class MenuState extends State
{
	final static int START_WIDTH = 445;
	final static int START_HEIGHT = 119;
	final static int START_X = 719;
	final static int START_Y = 508;

	final static int OPTIONS_WIDTH = 232;
	final static int OPTIONS_HEIGHT = 50;
	final static int OPTIONS_X = 820;
	final static int OPTIONS_Y = 405;

	final static int HOWTOPLAY_WIDTH = 414;
	final static int HOWTOPLAY_HEIGHT = 50;
	final static int HOWTOPLAY_X = 726;
	final static int HOWTOPLAY_Y = 405;

	final static int EXIT_WIDTH = 137;
	final static int EXIT_HEIGHT = 50;
	final static int EXIT_X = 868;
	final static int EXIT_Y = 303;

	private Texture background;
	private Texture play;
	private Texture options;
	private Texture howToPlay;
	private Texture exit;
	private Texture start;

	public MenuState(GameStateManager gsm)
	{
		super(gsm);
		background = new Texture("Main Menu/BackgroundWithTitle.png");
		// background = new Texture("Main Menu.png");
		start = new Texture("Main Menu/Start.png");
		options = new Texture("Main Menu/options.png");
		howToPlay = new Texture("Main Menu/HowToPlay.png");
		exit = new Texture("Main Menu/Exit.png");
	}

	@Override
	public void handleInput()
	{
		/*
		 * playButton.addListener(new EventListener()) {
		 * 
		 * @Override public boolean handle(new EventListener)) { gsm.set(new
		 * PlayState(gsm)); dispose(); return true; } }
		 */

		/*
		 * if(Gdx.input.justTouched()) { gsm.set(new PlayState(gsm)); dispose(); }
		 */

	}

	@Override
	public void update(float dt)
	{
		handleInput();
	}

	public void render(SpriteBatch sb)
	{

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		sb.draw(background, 0, 0, 1920, 1080);

		// Start button
		sb.draw(start, START_X, START_Y, START_WIDTH, START_HEIGHT);
		int playX = SubStrike.WIDTH / 2 - START_WIDTH / 2;
		if (Gdx.input.getX() < playX + START_WIDTH && Gdx.input.getX() > playX && SubStrike.HEIGHT - Gdx.input.getY() < START_Y + START_HEIGHT
				&& SubStrike.HEIGHT - Gdx.input.getAccelerometerY() > START_Y)
		{

			if (Gdx.input.isTouched())
			{
				gsm.set(new PlayState(gsm));
			}

		} else
		{
			sb.draw(start, START_X, START_Y, START_WIDTH, START_HEIGHT);
		}

		/*
		 * //Options button sb.draw(options, OPTIONS_X, OPTIONS_Y, OPTIONS_WIDTH,
		 * OPTIONS_HEIGHT); int optionsX = SubStrike.WIDTH / 2 - OPTIONS_WIDTH / 2; if
		 * (Gdx.input.getX() < optionsX + OPTIONS_WIDTH && Gdx.input.getX() > optionsX
		 * && SubStrike.HEIGHT - Gdx.input.getY() < 405 + OPTIONS_WIDTH &&
		 * SubStrike.HEIGHT - Gdx.input.getAccelerometerY() > 405) {
		 * 
		 * if (Gdx.input.isTouched()) { //gsm.set(new PlayState(gsm)); }
		 * 
		 * } else { sb.draw(options, OPTIONS_X, OPTIONS_Y, OPTIONS_WIDTH,
		 * OPTIONS_HEIGHT); }
		 */

		// How To Play Button
		sb.draw(howToPlay, HOWTOPLAY_X, HOWTOPLAY_Y, HOWTOPLAY_WIDTH, HOWTOPLAY_HEIGHT);
		int howToPlayX = SubStrike.WIDTH / 2 - HOWTOPLAY_WIDTH / 2;
		if (Gdx.input.getX() < howToPlayX + HOWTOPLAY_WIDTH && Gdx.input.getX() > howToPlayX && SubStrike.HEIGHT - Gdx.input.getY() < HOWTOPLAY_Y + HOWTOPLAY_WIDTH
				&& SubStrike.HEIGHT - Gdx.input.getAccelerometerY() > HOWTOPLAY_Y)
		{

			if (Gdx.input.isTouched())
			{
				// gsm.set(new PlayState(gsm));
			}

		} else
		{
			sb.draw(howToPlay, HOWTOPLAY_X, HOWTOPLAY_Y, HOWTOPLAY_WIDTH, HOWTOPLAY_HEIGHT);
		}

		// exit button
		sb.draw(exit, EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);
		int exitX = SubStrike.WIDTH / 2 - EXIT_WIDTH / 2;
		if (Gdx.input.getX() < exitX + EXIT_WIDTH && Gdx.input.getX() > exitX && SubStrike.HEIGHT - Gdx.input.getY() < EXIT_Y + EXIT_WIDTH && SubStrike.HEIGHT - Gdx.input.getAccelerometerY() > EXIT_Y)
		{

			if (Gdx.input.isTouched())
			{
				Gdx.app.exit();
			}

		} else
		{
			sb.draw(exit, EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);
		}

		sb.end();
	}

	@Override
	public void dispose()
	{
		background.dispose();

	}

}