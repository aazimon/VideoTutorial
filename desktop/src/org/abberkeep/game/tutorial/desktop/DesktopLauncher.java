package org.abberkeep.game.tutorial.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.abberkeep.game.tutorial.GameTutorial;

public class DesktopLauncher {
   public static void main(String[] arg) {
      LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
      // set the screen size
      config.height = 600;
      config.width = 800;
      new LwjglApplication(new GameTutorial(), config);
   }
}
