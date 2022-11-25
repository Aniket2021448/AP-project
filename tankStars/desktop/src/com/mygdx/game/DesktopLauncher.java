package com.mygdx.game;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.tankStars;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		Graphics.DisplayMode display = Lwjgl3ApplicationConfiguration. getDisplayMode();
		config.setForegroundFPS(60);
		config.setFullscreenMode(display);
		config.setResizable(true);

		config.useVsync(true);
		config.setTitle("AP_Project_sem3");

		new Lwjgl3Application(new tankStars(), config);
	}
}
