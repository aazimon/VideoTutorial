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

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.animation.BounceAnimation;
import org.abberkeep.gameframework.animation.LoopAnimation;
import org.abberkeep.gameframework.animation.RandomAnimation;
import org.abberkeep.gameframework.background.FixedBackground;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: AnimationScreen
 *
 * <p>
 * Description: Tutorial for demonstrating animated images, and then for creating Animation class.</p>
 *
 * Copyright (c) Dec 18, 2022
 * @author Gary Deken
 * @version 0.3
 */
public class AnimationScreen extends BaseScreen {
   private LoopAnimation loopAnimation1;
   private BounceAnimation bounceAnimation1;
   private RandomAnimation randomAnimation1;
   private LoopAnimation loopAnimation2;
   private LoopAnimation loopAnimationDown;
   private LoopAnimation loopAnimationLeft;
   private LoopAnimation loopAnimationRight;
   private LoopAnimation loopAnimationUp;
   private float cx = 100;
   private float cy = 100;
   private float mv = .8f;
   private char direct = 'r';

   @Override
   public void show() {
      setBackground(new FixedBackground(new BlockAnimation(100, 100), true));
      TextureRegion[][] textureRegions1 = TextureRegion.split(getTexture("MovingBall.png"), 50, 200);

      loopAnimation1 = new LoopAnimation(0.1f, textureRegions1[0], 3);
      bounceAnimation1 = new BounceAnimation(0.1f, textureRegions1[0]);
      bounceAnimation1.setRotation(90f);
      randomAnimation1 = new RandomAnimation(0.2f, textureRegions1[0], 2);
      TextureRegion[][] textureRegions2 = TextureRegion.split(getTexture("Bouncing Ball.png"), 50, 200);
      loopAnimation2 = new LoopAnimation(0.1f, textureRegions2[0]);
      loopAnimation2.setSize(25, 100);
      loopAnimation2.setRotation(45f);

      TextureRegion[][] regionWalk = TextureRegion.split(getTexture("DemoCharacter.jpg"), 64, 64);
      loopAnimationDown = new LoopAnimation(0.2f, regionWalk[0]);
      loopAnimationLeft = new LoopAnimation(0.2f, regionWalk[1]);
      loopAnimationRight = new LoopAnimation(0.2f, regionWalk[2]);
      loopAnimationUp = new LoopAnimation(0.2f, regionWalk[3]);
   }

   @Override
   protected void renderChild(float deltaTime) {
      loopAnimation1.update(deltaTime);
      bounceAnimation1.update(deltaTime);
      randomAnimation1.update(deltaTime);
      loopAnimation2.update(deltaTime);

//      loopAnimation1.draw(batch, 10, 100);
//      bounceAnimation1.draw(batch, 10, 100);
//      randomAnimation1.draw(batch, 10, 100);
//      loopAnimation2.draw(batch, 100, 100);
      // Resizing
      //batch.draw(animation2.getKeyFrame(animationTime), 10, 100, 50, 200);
      //batch.draw(animation2.getKeyFrame(animationTime), 80, 100, 25, 100);
      // rotating  and sizing.
      //batch.draw(animation2.getKeyFrame(animationTime), 150, 100, 0, 0, 200, 50, 1, 1, 0, false);
      //batch.draw(animation2.getKeyFrame(animationTime), 150, 100, 0, 0, 200, 50, -1, 1, 0, true);
      switch (direct) {
         case 'r':
            cx += mv;
            if (cx > 200) {
               cx = 200;
               direct = 'u';
            }
            loopAnimationRight.update(deltaTime);
            loopAnimationRight.draw(batch, cx, cy);
            break;
         case 'u':
            cy += mv;
            if (cy > 200) {
               cy = 200;
               direct = 'l';
            }
            loopAnimationUp.update(deltaTime);
            loopAnimationUp.draw(batch, cx, cy);
            break;
         case 'l':
            cx -= mv;
            if (cx < 100) {
               cx = 100;
               direct = 'd';
            }
            loopAnimationLeft.update(deltaTime);
            loopAnimationLeft.draw(batch, cx, cy);
            break;
         case 'd':
            cy -= mv;
            if (cy < 100) {
               cy = 100;
               direct = 'r';
            }
            loopAnimationDown.update(deltaTime);
            loopAnimationDown.draw(batch, cx, cy);
            break;
         default:
            throw new AssertionError();
      }

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
