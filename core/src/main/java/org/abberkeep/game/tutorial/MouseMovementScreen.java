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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.background.FixedBackground;
import org.abberkeep.gameframework.motion.FourWayMotion;
import org.abberkeep.gameframework.movement.MouseMovement;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.screen.ScreenInput;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: MouseMovementScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jul 1, 2023
 * @author Gary Deken
 * @version
 */
public class MouseMovementScreen extends BaseScreen {
   private float x = 100;
   private float y = 100;
   private FourWayMotion motion1;
   private SpriteUpdate spriteUpdate;
   private SpriteUpdate spriteUpdate2;
   private MouseMovement movement;
   private Animation animation;
   private Animation wallAnimation;
   private Animation wallAnimation2;

   @Override
   public void show() {
      setBackground(new FixedBackground(new BlockAnimation(100, 100), true));
      motion1 = new FourWayMotion(getTexture("DemoCharacterA.png"), 64, 64, 0.2f, 3, 2, 0, 1);
      movement = new MouseMovement(Input.Buttons.LEFT, 1f);
      spriteUpdate = new SpriteUpdate() {
         @Override
         public boolean contains(BoundingBox other) {
            return false;
         }

         @Override
         public boolean contains(int x, int y) {
            return false;
         }

         @Override
         public float getX() {
            return x;
         }

         @Override
         public float getY() {
            return y;
         }

         @Override
         public void setLocation(float nX, float nY) {
            x = nX;
            y = nY;
         }

         @Override
         public void setRemove(boolean remove) {
            //
         }

         @Override
         public void setX(float nx) {
            x = nx;
         }

         @Override
         public void setY(float ny) {
            y = ny;
         }
      };
      spriteUpdate2 = new SpriteUpdate() {
         float spX;
         float spY;

         @Override
         public boolean contains(BoundingBox other) {
            return false;
         }

         @Override
         public boolean contains(int x, int y) {
            return false;
         }

         @Override
         public float getX() {
            return spX;
         }

         @Override
         public float getY() {
            return spY;
         }

         @Override
         public void setLocation(float nX, float nY) {
            spX = nX;
            spY = nY;
         }

         @Override
         public void setRemove(boolean remove) {
            //
         }

         @Override
         public void setX(float x) {
            spX = x;
         }

         @Override
         public void setY(float y) {
            spY = y;
         }
      };
      animation = new BlockAnimation(5, 5);
      animation.setColor(Color.BLUE);
      wallAnimation = new StaticAnimation(getTexture("Wall.png"));
      wallAnimation2 = new StaticAnimation(getTexture("Wall.png"));
      wallAnimation2.setTranslucency(0.6f);
   }

   @Override
   public void addActor(Actor actor) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void addDecor(Decor decor) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   protected void renderChild(float deltaTime) {
      if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
         spriteUpdate2.setX(ScreenInput.getX());
         spriteUpdate2.setY(ScreenInput.getY());
      }
      if (Gdx.input.isKeyPressed(Input.Keys.A)) {
         viewport.getCamera().translate(-1f, 0f, 0f);
      } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
         viewport.getCamera().translate(1f, 0f, 0f);
      } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
         viewport.getCamera().translate(0f, 1f, 0f);
      } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
         viewport.getCamera().translate(0f, -1f, 0f);
      }
      wallAnimation.draw(batch, 200, 5);
      movement.update(deltaTime, spriteUpdate);
      motion1.update(deltaTime, movement.getDirection());
      motion1.draw(batch, spriteUpdate.getX(), spriteUpdate.getY());
      if (spriteUpdate.getX() >= 200 - motion1.getWidth() && spriteUpdate.getX() <= 220) {
         wallAnimation2.draw(batch, 200, 5);
//      } else {
//         wallAnimation.setTranslucency(1f);
      }
      animation.draw(batch, spriteUpdate2.getX(), spriteUpdate2.getY());
   }

}
