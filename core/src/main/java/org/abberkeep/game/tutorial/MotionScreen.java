/*
 * Copyright (c) 2022-2022 Gary Deken
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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.animation.LayeredAnimation;
import org.abberkeep.gameframework.animation.LoopAnimation;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.background.FixedBackground;
import org.abberkeep.gameframework.motion.FourWayMotion;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.motion.TwoWayMotion;
import org.abberkeep.gameframework.movement.Direction;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: AnimationScreen
 *
 * <p>
 * Description: Tutorial for encapsulating animations into a Motion class.</p>
 *
 * Copyright (c) Dec 18, 2022
 * @author Gary Deken
 * @version 0.6
 */
public class MotionScreen extends BaseScreen {
   private FourWayMotion fourWayMotion;
   private FourWayMotion fourWayMotion1;
   private TwoWayMotion twoWayMotion;
   private SingleMotion singleMotion;
   private float cx = 100;
   private float cy = 100;
   private float mv = .8f;
   private float direction = Direction.EAST;

   @Override
   public void show() {
      setBackground(new FixedBackground(new BlockAnimation(100, 100), true));
      TextureRegion[][] textureRegions1 = TextureRegion.split(getTexture("Magic-Ring.png"), 39, 48);

      StaticAnimation egg = new StaticAnimation(getTexture("Egg.png"));
      LoopAnimation loopAnimation1 = new LoopAnimation(0.03f, textureRegions1[0]);
      egg.setColor(Color.CHARTREUSE);
      LayeredAnimation layeredAnimation = new LayeredAnimation(egg);
      layeredAnimation.addAnimation(loopAnimation1);
//      BounceAnimation bounceAnimation1 = new BounceAnimation(0.1f, textureRegions1[0]);
//      RandomAnimation randomAnimation1 = new RandomAnimation(0.2f, textureRegions1[0]);

//      TextureRegion[][] regionWalk = TextureRegion.split(getTexture("DemoCharacter.jpg"), 64, 64);
//      LoopAnimation loopAnimationDown = new LoopAnimation(0.2f, regionWalk[0]);
//      LoopAnimation loopAnimationLeft = new LoopAnimation(0.2f, regionWalk[1]);
//      LoopAnimation loopAnimationRight = new LoopAnimation(0.2f, regionWalk[2]);
//      LoopAnimation loopAnimationUp = new LoopAnimation(0.2f, regionWalk[3]);
      //fourWayMotion = new FourWayMotion(loopAnimationUp, loopAnimationRight, loopAnimationDown, loopAnimationLeft);
      //fourWayMotion = new FourWayMotion(getTexture("DemoCharacter.jpg"), 64, 64, 0.2f, 3, 2, 0, 1);
//      fourWayMotion1 = new FourWayMotion(loopAnimation1, loopAnimation1, loopAnimation1, loopAnimation1);
      singleMotion = new SingleMotion(layeredAnimation);
//      TextureRegion[][] textureRegions2 = TextureRegion.split(getTexture("Jojo-Running.png"), 50, 62);
//      LoopAnimation walkLeft = new LoopAnimation(.2f, textureRegions2[0]);
//      LoopAnimation walkRight = new LoopAnimation(.2f, textureRegions2[1]);
      //twoWayMotion = new TwoWayMotion(walkRight, walkLeft);
      //twoWayMotion = new TwoWayMotion(getTexture("Jojo-Running.png"), 50, 62, .2f, 1, 0);
   }

   @Override
   protected void renderChild(float deltaTime) {
      if (direction == Direction.EAST) {
         cx += mv;
         if (cx > 200) {
            cx = 200;
            direction = Direction.NORTH;
         }
      } else if (direction == Direction.NORTH) {
         cy += mv;
         if (cy > 200) {
            cy = 200;
            direction = Direction.WEST;
         }
      } else if (direction == Direction.WEST) {
         cx -= mv;
         if (cx < 100) {
            cx = 100;
            direction = Direction.SOUTH;
         }
      } else {
         cy -= mv;
         if (cy < 100) {
            cy = 100;
            direction = Direction.EAST;
         }
      }
//      fourWayMotion1.update(deltaTime, direction);
//      fourWayMotion1.draw(batch, cx, cy);
      singleMotion.update(deltaTime, direction);
      singleMotion.draw(batch, cx, cy);
//      if (direction == Direction.EAST) {
//         cx += mv;
//         if (cx > 300) {
//            direction = Direction.WEST;
//         }
//      } else {
//         cx -= mv;
//         if (cx < 100) {
//            direction = Direction.EAST;
//         }
//      }
//      twoWayMotion.update(deltaTime, direction);
//      twoWayMotion.draw(batch, cx, cy);
   }

   @Override
   public void addActor(Actor actor) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void addDecor(Decor decor) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

}
