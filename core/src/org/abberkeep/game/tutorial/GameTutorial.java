package org.abberkeep.game.tutorial;

import org.abberkeep.gameframework.BaseGame;

public class GameTutorial extends BaseGame {

   @Override
   public void create() {
      super.create();
//      ImageScreen screen = new ImageScreen(800, 600);
//      AnimationScreen screen = new AnimationScreen(800, 600);
      MotionScreen screen = new MotionScreen(800, 600);
      setScreen(screen);
   }

}
