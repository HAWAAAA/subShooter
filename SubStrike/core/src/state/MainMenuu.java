package state;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuu implements Screen
{
	 private SpriteBatch batch;
	    protected Stage stage;
	    private Viewport viewport;
	    private OrthographicCamera camera;
	    private TextureAtlas atlas;
	    protected Skin skin;
	    
	    public MainMenuu()
	    {
	    	 atlas = new TextureAtlas("skin.atlas");
	         skin = new Skin(Gdx.files.internal("skin.json"), atlas);

	         batch = new SpriteBatch();
	         camera = new OrthographicCamera();
	         viewport = new FitViewport(Constants.WorldWidth, Constants.WorldHeight, camera);
	         viewport.apply();

	         camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	         camera.update();

	         stage = new Stage(viewport, batch);  
	    	
	    }

		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resume() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}
}
