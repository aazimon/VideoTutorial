package org.abberkeep.game.tutorial;

import org.abberkeep.gameframework.BaseGame;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

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
      ExampleStaticScreen screen = new ExampleStaticScreen();
      screen.resize(400, 600);
      setScreen(screen);

   }

    public void addActor(Actor actor, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addDecor(Decor decor, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
