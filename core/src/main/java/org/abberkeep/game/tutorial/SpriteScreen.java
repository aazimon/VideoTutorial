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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.animation.LayeredAnimation;
import org.abberkeep.gameframework.animation.LoopAnimation;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.animation.StaticRegionAnimation;
import org.abberkeep.gameframework.background.FixedBackground;
import org.abberkeep.gameframework.motion.FourWayMotion;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.MouseMovement;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: SpriteScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Aug 13, 2023
 * @author Gary Deken
 * @version
 */
public class SpriteScreen extends BaseScreen {
//   private float x = 100;
//   private float y = 100;
//   private FourWayMotion motion;
//   private Movement movement;
//   private SpriteUpdate sprite;
//   private Animation sodaAnimation;
//   private Animation treeAnimation;
//   private Animation tree2Animation;
   private Actor actor;
   private Decor soda;
   private Decor tree;

   @Override
   public void show() {
      setBackground(new FixedBackground(new BlockAnimation(100, 100), true));
//      motion = new FourWayMotion(getTexture("DemoCharacterA.png"), 64, 64, 0.2f, 3, 2, 0, 1);
//      movement = new MouseMovement(Input.Buttons.LEFT, 1f);
      Texture texture = getTexture("DemoCharacterA.png");
      Motion motion = new FourWayMotion(getTexture("DemoCharacterA.png"), 64, 64, 0.2f, 3, 2, 0, 1);
      TextureRegion[][] tr = TextureRegion.split(texture, 64, 64);
      Motion motionStill = new FourWayMotion(new StaticRegionAnimation(tr[3][1]), new StaticRegionAnimation(tr[2][1]),
         new StaticRegionAnimation(tr[0][1]), new StaticRegionAnimation(tr[1][1]));
      //actor = new Actor(new TwoKeyMovement(Input.Keys.D, Input.Keys.A, 0.3f, true), motion, motionStill);
      //actor = new Actor(new FourKeyMovement(Input.Keys.W, Input.Keys.S, Input.Keys.D, Input.Keys.A, 0.8f), motion, motionStill);
      actor = new Actor(new MouseMovement(Input.Buttons.LEFT, .8f), motion, motionStill);
      actor.setLocation(100, 100);
      //      sprite = new SpriteUpdate() {
      //         @Override
      //         public float getX() {
      //            return x;
      //         }
      //
      //         @Override
      //         public float getY() {
      //            return y;
      //         }
      //
      //         @Override
      //         public void setLocation(float nX, float nY) {
      //            x = nX;
      //            y = nY;
      //         }
      //
      //         @Override
      //         public void setX(float nx) {
      //            x = nx;
      //         }
      //
      //         @Override
      //         public void setY(float ny) {
      //            y = ny;
      //         }
      //      };
      //      sodaAnimation = new StaticAnimation(getTexture("Osaka-Soda.png"));
      //      treeAnimation = new StaticAnimation(getTexture("Osaka-Tree-G.png"));
      //      tree2Animation = new LoopAnimation(0.1f, TextureRegion.split(getTexture("Osaka-Treetop-G.png"), 96, 84)[0]);
      soda = new Decor(new StaticAnimation(getTexture("Osaka-Soda.png")));
      soda.setLocation(50, 200);
      LayeredAnimation animation = new LayeredAnimation(new StaticAnimation(getTexture("Osaka-Tree-G.png")));
      LoopAnimation treeTop = new LoopAnimation(0.1f, TextureRegion.split(getTexture("Osaka-Treetop-G.png"), 96, 84)[0]);
      treeTop.setYOffset(54);
      animation.addAnimation(treeTop);
      tree = new Decor(animation);
      tree.setLocation(200, 105);
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
      actor.update(deltaTime);
      soda.update(deltaTime);
      tree.update(deltaTime);
      actor.draw(batch);
      soda.draw(batch);
      tree.draw(batch);

//      tree2Animation.update(deltaTime);
//      movement.update(deltaTime, sprite);
//      motion.update(deltaTime, movement.getDirection());
//      motion.draw(batch, x, y);
//      sodaAnimation.draw(batch, 50, 200);
//      treeAnimation.draw(batch, 200, 105);
//      tree2Animation.draw(batch, 200, 159);
   }

}
