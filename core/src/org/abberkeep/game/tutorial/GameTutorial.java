package org.abberkeep.game.tutorial;

import org.abberkeep.gameframework.BaseGame;

public class GameTutorial extends BaseGame {

   @Override
   public void create() {
      super.create();
      GameScreen gameScrn = new GameScreen(800, 600);
      setScreen(gameScrn);
   }

}
