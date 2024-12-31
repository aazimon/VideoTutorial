package org.abberkeep.game.tutorial;

import org.abberkeep.game.checkerboard.CheckerBoardScreen;
import org.abberkeep.gameframework.BaseGame;

public class GameTutorial extends BaseGame {

   @Override
   public void create() {
      super.create();
//      ImageScreen screen = new ImageScreen();
//      AnimationScreen screen = new AnimationScreen();
      //MotionScreen screen = new MotionScreen();
      //InputScreen screen = new InputScreen();
      //MouseMovementScreen screen = new MouseMovementScreen();
      //SpriteScreen screen = new SpriteScreen();
      //SoundScreen screen = new SoundScreen();
      //SimpleTest screen = new SimpleTest();
      //ScriptScreen screen = new ScriptScreen();
      //ShootemUpScreen screen = new ShootemUpScreen();
      CheckerBoardScreen screen = new CheckerBoardScreen();

      setScreen(screen);

   }

}
