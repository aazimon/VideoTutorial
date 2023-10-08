/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.animation.StaticRegionAnimation;
import org.abberkeep.gameframework.motion.FourWayMotion;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.MouseMovement;
import org.abberkeep.gameframework.screen.StaticScreen;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 *
 * @author gary
 */
public class ExampleStaticScreen extends StaticScreen {

   @Override
   public void show() {
      setBackgroundColor(Color.WHITE);
      Texture texture = getTexture("DemoCharacterA.png");
      Motion motion = new FourWayMotion(getTexture("DemoCharacterA.png"), 64, 64, 0.2f, 3, 2, 0, 1);
      TextureRegion[][] tr = TextureRegion.split(texture, 64, 64);
      Motion motionStill = new FourWayMotion(new StaticRegionAnimation(tr[3][1]), new StaticRegionAnimation(tr[2][1]),
         new StaticRegionAnimation(tr[0][1]), new StaticRegionAnimation(tr[1][1]));
      Actor actor = new Actor(new MouseMovement(Input.Buttons.LEFT, .8f), motion, motionStill);
      actor.setLocation(100, 100);

      addActor(actor);

      Decor soda = new Decor(new StaticAnimation(getTexture("Osaka-Soda.png")));
      soda.setLocation(150, 200);
      addDecor(soda);
   }

}
