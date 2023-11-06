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
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.motion.FourWayMotion;
import org.abberkeep.gameframework.motion.TwoWayMotion;
import org.abberkeep.gameframework.movement.FourKeyMovement;
import org.abberkeep.gameframework.movement.TwoKeyMovement;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.SpriteUpdate;

/**
 * Title: InputScreen
 *
 * <p>
 * Description: Tutorial for Input from users, and using the Movement class.</p>
 *
 * Copyright (c) Jun 14, 2023
 * @author Gary Deken
 * @version 0.7
 */
public class InputScreen extends BaseScreen {
   private BlockAnimation animation;
   private BlockAnimation animation1;
   private boolean display = false;
   private int count = 0;
   private TwoKeyMovement movement;
   private TwoWayMotion motion;
   private float x = 100;
   private float y = 100;
   private FourKeyMovement movement1;
   private FourWayMotion motion1;
   private SpriteUpdate spriteUpdate;

   @Override
   public void show() {
      setBackgroundColor(Color.WHITE);
      animation = new BlockAnimation(20, 20);
      animation.setColor(Color.BLUE);
      animation1 = new BlockAnimation(20, 20);
      animation1.setColor(Color.DARK_GRAY);
      movement = new TwoKeyMovement(Input.Keys.RIGHT, Input.Keys.LEFT, 0.8f, true);
      //movement = new TwoKeyMovement(Input.Keys.UP, Input.Keys.DOWN, false);
//      movement.setSpeed(0.8f);
      motion = new TwoWayMotion(getTexture("Jojo-Running.png"), 50, 62, .2f, 1, 0);
      //motion.setHorizontal(false);
      movement1 = new FourKeyMovement(Input.Keys.UP, Input.Keys.DOWN, Input.Keys.RIGHT, Input.Keys.LEFT, 0.8f, true);
//      movement1.setSpeed(0.8f);
      motion1 = new FourWayMotion(getTexture("DemoCharacter.jpg"), 64, 64, 0.2f, 3, 2, 0, 1);
      spriteUpdate = new SpriteUpdate() {
         @Override
         public boolean contains(BoundingBox other) {
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
         public void setX(float nX) {
            x = nX;
         }

         @Override
         public void setY(float nY) {
            y = nY;
         }
      };
   }

   @Override
   protected void renderChild(float deltaTime) {
      if (Gdx.input.isKeyPressed(Input.Keys.A)) {
         viewport.getCamera().translate(-1f, 0f, 0f);
      } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
         viewport.getCamera().translate(1f, 0f, 0f);
      }

      //int x = 0;
      //int y = 0;
      //animation1.draw(batch, 100, 100);
      //x = Gdx.input.getX();
      //y = Gdx.input.getY();
      //x = ScreenInput.getX();
      //y = ScreenInput.getY();
      //x = Gdx.input.getDeltaX();
      //y = Gdx.input.getDeltaY();
      //y = ScreenInput.getDeltaY();
      //boolean b = false;
      //b = Gdx.input.isButtonJustPressed(Input.Buttons.LEFT);
      //b = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
      //b = Gdx.input.isKeyPressed(Input.Keys.B);
      //b = Gdx.input.isKeyJustPressed(Input.Keys.A);
//      if (b) {
//         count++;
//         System.out.println("Input: " + count);
//         x = ScreenInput.getX();
//         y = ScreenInput.getY();
//      }
//      if (!display) {
//         display = true;
//         Gdx.input.getTextInput(new Input.TextInputListener() {
//            @Override
//            public void input(String string) {
//               System.out.println(string);
//            }
//
//            @Override
//            public void canceled() {
//               System.out.println("canceled");
//            }
//         }, "Heading", "", "hint text");
//      }
      //x += 100;
      //y += 100;
      //animation.draw(batch, x, y);
      //movement.update(deltaTime);
      //motion.update(deltaTime, movement.getDirection());
      //x = x + movement.getXUpdate();
      //y = y + movement.getYUpdate();
      //motion.draw(batch, x, y);
      movement1.update(deltaTime, spriteUpdate);
      motion1.update(deltaTime, movement1.getDirection());
//      x = x + movement1.getXUpdate();
//      y = y + movement1.getYUpdate();
      motion1.draw(batch, spriteUpdate.getX(), spriteUpdate.getY());
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
