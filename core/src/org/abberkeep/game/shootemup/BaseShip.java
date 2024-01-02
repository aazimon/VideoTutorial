/*
 * Copyright (c) 2022-2024 Gary Deken
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

import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.effects.ColorCycleEffect;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.sprite.Actor;

/**
 * Title: BaseShip
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jan 1, 2024
 * @author Gary Deken
 * @version
 */
public abstract class BaseShip extends Actor {
   private ColorCycleEffect hitEffect;
   private boolean hit = false;
   private int maxHits;

   public BaseShip(Movement movement, Motion moveMotion, Motion stillMotion, Color shipColor, int maxHits) {
      super(movement, moveMotion, stillMotion);
      hitEffect = new ColorCycleEffect(shipColor, Color.RED, .4f);
      hitEffect.addColorCycle(shipColor, .4f);
      this.maxHits = maxHits;
   }

   public void hit() {
      if (!hit) {
         hit = true;
         maxHits--;
         if (maxHits < 1) {
            setRemove(true);
         }
         hitEffect.reset();
         moveMotion[0].setColorEffect(hitEffect);
         stillMotion[0].setColorEffect(hitEffect);
      }
   }

   @Override
   public void update(float deltaTime) {
      super.update(deltaTime);
      if (hit && hitEffect.isDone()) {
         hit = false;
      }
      updateChild(deltaTime);
   }

   protected abstract void updateChild(float deltaTime);

}
