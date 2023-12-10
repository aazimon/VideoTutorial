package org.abberkeep.game.tutorial.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.abberkeep.game.tutorial.GameTutorial;

public class DesktopLauncher {
   public static void main(String[] arg) {
      Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
      config.setTitle("Video Tutorial");
      // set the screen size
      config.setWindowedMode(700, 900);
      new Lwjgl3Application(new GameTutorial(), config);
   }
}
