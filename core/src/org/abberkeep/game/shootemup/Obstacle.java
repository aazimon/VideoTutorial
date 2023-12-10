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

import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.movement.ScriptMovement;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.BoundingBox;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: Obstacle
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 9, 2023
 * @author Gary Deken
 * @version
 */
public class Obstacle extends Actor {
   private boolean destroyed = false;
   private ObstacleFactory factory;

   public Obstacle(Movement movement, Motion[] moveMotion, Motion[] stillMotion, ObstacleFactory factory) {
      super(movement, moveMotion, stillMotion);
      this.factory = factory;
   }

   @Override
   public boolean contains(BoundingBox other) {
      if (destroyed) {
         return false;
      }
      return super.contains(other);
   }

   @Override
   public void handleCollision(Sprite other) {
      if (!destroyed) {
         ((ScriptMovement) movement).nextAction();
         currentMoveMotion = 1;
         destroyed = true;
      }
   }

   public boolean isDestroyed() {
      return destroyed;
   }

   @Override
   public void reset() {
      super.reset();
      currentMoveMotion = 0;
      destroyed = false;
   }

   @Override
   public void update(float deltaTime) {
      super.update(deltaTime);
      if (y - height < 0) {
         setRemove(true);
         factory.spriteRemoved(this);
      }
      if (destroyed && ((ScriptMovement) movement).isDone()) {
         setRemove(true);
         factory.spriteRemoved(this);
      }
   }

}