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

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: EnemyShip
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 15, 2023
 * @author Gary Deken
 * @version
 */
public class EnemyShip extends BaseShip {
   private BulletFactory bullets;
   private float bulletTime = -1f;
   private boolean firing = false;
   private int bulletCount = 0;

   public EnemyShip(Movement movement, Motion motion, Sound hitSound, BulletFactory factory) {
      super(movement, motion, motion, Color.BLUE, 5, hitSound);
      this.bullets = factory;
   }

   @Override
   public void handleCollision(Sprite other) {
   }

   @Override
   protected void updateChild(float deltaTime) {
      bulletTime += deltaTime;
      if (!firing && bulletTime > 2f) {
         firing = true;
      }
      if (firing) {
         if (bulletTime > .2f) {
            bulletCount++;
            bulletTime = 0f;
            // ship width of 100
            bullets.createNewActor(getX() + 25, getY() - 16);
            bullets.createNewActor(getX() + 75, getY() - 16);
         }
         if (bulletCount > 9) {
            firing = false;
            bulletTime = 0;
            bulletCount = 0;
         }
      }
   }

}
