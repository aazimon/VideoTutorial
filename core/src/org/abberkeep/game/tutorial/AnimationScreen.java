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
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.screen.BaseScreen;

/**
 * Title: AnimationScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 18, 2022
 * @author Gary Deken
 * @version
 */
public class AnimationScreen extends BaseScreen {
   private Animation<TextureRegion> animation;
   private Animation<TextureRegion> animation2;
   private float animationTime;
   private int loops = 4;
   private Animation<TextureRegion> animationDown;
   private Animation<TextureRegion> animationLeft;
   private Animation<TextureRegion> animationRight;
   private Animation<TextureRegion> animationUp;
   private float cx = 100;
   private float cy = 100;
   private float mv = .8f;
   private char direct = 'r';

   public AnimationScreen(int width, int height) {
      super(width, height);
   }

   @Override
   public void show() {
      setBackgroundColor(Color.WHITE);
      TextureRegion[][] textureRegions1 = TextureRegion.split(getTexture("MovingBall.png"), 50, 200);
      animation = new Animation<>(0.1f, textureRegions1[0]);
      TextureRegion[][] textureRegions2 = TextureRegion.split(getTexture("Bouncing Ball.png"), 50, 200);
      animation2 = new Animation<>(0.1f, textureRegions2[0]);
      animation2.setPlayMode(Animation.PlayMode.LOOP);
      TextureRegion[][] regionWalk = TextureRegion.split(getTexture("DemoCharacter.jpg"), 64, 64);
      animationDown = new Animation<>(0.2f, regionWalk[0]);
      animationDown.setPlayMode(Animation.PlayMode.LOOP);
      animationLeft = new Animation<>(0.2f, regionWalk[1]);
      animationLeft.setPlayMode(Animation.PlayMode.LOOP);
      animationRight = new Animation<>(0.2f, regionWalk[2]);
      animationRight.setPlayMode(Animation.PlayMode.LOOP);
      animationUp = new Animation<>(0.2f, regionWalk[3]);
      animationUp.setPlayMode(Animation.PlayMode.LOOP);
   }

   @Override
   protected void renderChild(float deltaTime) {
      animationTime += deltaTime;

      //batch.draw(animation.getKeyFrame(animationTime), 0, 100);
      int loopNumber = (int) (animationTime / animation.getAnimationDuration());
      boolean loop = false;
      if (loopNumber < loops) {
         loop = true;
      }
      //batch.draw(animation.getKeyFrame(animationTime, loop), 75, 100);
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
            batch.draw(animationRight.getKeyFrame(animationTime), cx, cy);
            break;
         case 'u':
            cy += mv;
            if (cy > 200) {
               cy = 200;
               direct = 'l';
            }
            batch.draw(animationUp.getKeyFrame(animationTime), cx, cy);
            break;
         case 'l':
            cx -= mv;
            if (cx < 100) {
               cx = 100;
               direct = 'd';
            }
            batch.draw(animationLeft.getKeyFrame(animationTime), cx, cy);
            break;
         case 'd':
            cy -= mv;
            if (cy < 100) {
               cy = 100;
               direct = 'r';
            }
            batch.draw(animationDown.getKeyFrame(animationTime), cx, cy);
            break;
         default:
            throw new AssertionError();
      }

   }

}
