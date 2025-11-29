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
package org.abberkeep.game.shootemup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: Ship
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 3, 2023
 * @author Gary Deken
 * @version
 */
public class Ship extends BaseShip {
   private Sound laserSound;
   private LaserFactory laserFactory;
   private float countdown = 0;

   public Ship(Movement movement, Motion motion, LaserFactory factory, Sound hitSound, Sound laserSound) {
      super(movement, motion, motion, Color.WHITE, 10, hitSound);
      this.laserFactory = factory;
      this.laserSound = laserSound;
   }

   @Override
   public void handleCollision(Sprite other) {
      if (other instanceof Obstacle) {
         if (((Obstacle) other).isDestroyed()) {
            return;
         }
         hit();
      }
      super.handleCollision(other);
   }

   @Override
   public void updateChild(float deltaTime) {
      if (x < 5) {
         x = 5;
      } else if (x + width + 5 > Gdx.graphics.getWidth()) {
         x = Gdx.graphics.getWidth() - width - 5;
      }
      if (y < 5) {
         y = 5;
      } else if (y > 200) {
         y = 200;
      }
      //if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
      if (Controllers.getCurrent().getButton(1)) {
         if (countdown < 0) {
            // fire
            laserFactory.createNewActor(x + (width / 2), y + Laser.HEIGHT + height + 2, 0);
            laserSound.play();
            countdown = .25f;
         }
      }
      countdown -= deltaTime;
   }

}
