package org.abberkeep.game.tutorial;

import org.abberkeep.gameframework.BaseGame;

public class GameTutorial extends BaseGame {

   @Override
   public void create() {
      super.create();
//      ImageScreen gameScrn = new ImageScreen(800, 600);
//      setScreen(gameScrn);
      AnimationScreen screen = new AnimationScreen(800, 600);
      setScreen(screen);
   }

}
