package org.abberkeep.game.tutorial;

import org.abberkeep.gameframework.BaseGame;

public class GameTutorial extends BaseGame {

   @Override
   public void create() {
      super.create();
//      ImageScreen screen = new ImageScreen();
//      AnimationScreen screen = new AnimationScreen();
      //MotionScreen screen = new MotionScreen();
      //InputScreen screen = new InputScreen();
      MouseMovementScreen screen = new MouseMovementScreen();
      screen.resize(400, 600);
      setScreen(screen);

   }

}
