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
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: Laser
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 8, 2023
 * @author Gary Deken
 * @version
 */
public class Laser extends Actor {
   public static final int HEIGHT = 15;
   public static final int WIDTH = 4;
   private LaserFactory factory;

   public Laser(Movement movement, Motion[] moveMotion, Motion[] stillMotion, LaserFactory factory) {
      super(movement, moveMotion, stillMotion);
      this.factory = factory;
   }

   @Override
   public void handleCollision(Sprite other) {
      if (other instanceof Obstacle) {
         if (!((Obstacle) other).isDestroyed()) {
            setRemove(true);
         }
      }
      super.handleCollision(other);
   }

   @Override
   public void update(float deltaTime) {
      super.update(deltaTime);
      if (y > Gdx.graphics.getHeight()) {
         setRemove(true);
      }
   }

}
