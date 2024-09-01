/*
 * Copyright (c) 2022-2023 Gary Deken
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.abberkeep.game.tutorial;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.animation.StaticRegionAnimation;
import org.abberkeep.gameframework.motion.FourWayMotion;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.MouseMovement;
import org.abberkeep.gameframework.screen.SimpleScreen;
import org.abberkeep.gameframework.sound.RandomSound;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: SimpleTest
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 1, 2023
 * @author Gary Deken
 * @version
 */
public class SimpleTest extends SimpleScreen {

   @Override
   public void show() {
      //setBackgroundColor(Color.WHITE);
      Texture texture = getTexture("DemoCharacter.jpg");
      Motion motion = new FourWayMotion(texture, 64, 64, 0.2f, 3, 2, 0, 1);
      TextureRegion[][] tr = TextureRegion.split(texture, 64, 64);
      Motion motionStill = new FourWayMotion(new StaticRegionAnimation(tr[3][1]), new StaticRegionAnimation(tr[2][1]),
         new StaticRegionAnimation(tr[0][1]), new StaticRegionAnimation(tr[1][1]));
      Actor actor = new Actor(new MouseMovement(Input.Buttons.LEFT, 0.8f), motion, motionStill);
      //Actor actor = new Actor(new TwoKeyMovement(Input.Keys.RIGHT, Input.Keys.LEFT, 0.8f, true), motion, motionStill);
//      Actor actor = new Actor(new FourKeyMovement(Input.Keys.UP, Input.Keys.DOWN, Input.Keys.RIGHT,
//         Input.Keys.LEFT, 0.8f, true), motion, motionStill);
      actor.setLocation(250, 250);
      actor.getBounds().setXInset(10);
      actor.getBounds().setYInset(10);
      actor.getBounds().setWidth(44);
      actor.getBounds().setHeight(44);

      // adding sound
      Sound s1 = getSound("Bit-Footsteps-1.wav");
      Sound s2 = getSound("Bit-Footsteps-2.wav");
      Sound s3 = getSound("Bit-Footsteps-3.wav");
      Sound s4 = getSound("Bit-Footsteps-4.wav");
      RandomSound rs = new RandomSound(s1);
      rs.addSound(s2);
      rs.addSound(s3);
      rs.addSound(s4);
      actor.getMoveMotions()[0].setSound(rs);

      addActor(actor);

      Decor soda = new Decor(new StaticAnimation(getTexture("Osaka-Soda.png")));
      soda.setLocation(150, 200);
      addDecor(soda);

      Decor sodaRight = new Decor(new StaticAnimation(getTexture("Osaka-Soda.png")));
      sodaRight.setLocation(350, 200);
      addDecor(sodaRight);

      Decor sodaUp = new Decor(new StaticAnimation(getTexture("Osaka-Soda.png")));
      sodaUp.setLocation(250, 350);
      addDecor(sodaUp);

      Decor sodaLeft = new Decor(new StaticAnimation(getTexture("Osaka-Soda.png")));
      sodaLeft.setLocation(250, 50);
      addDecor(sodaLeft);

   }

}
