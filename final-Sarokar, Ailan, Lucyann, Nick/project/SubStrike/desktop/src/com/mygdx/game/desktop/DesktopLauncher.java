package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.SubStrike;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SubStrike.WIDTH;
		config.height = SubStrike.HEIGHT;
		config.title = SubStrike.TITLE;

		
		new LwjglApplication(new SubStrike(), config);
		
		
	}
}