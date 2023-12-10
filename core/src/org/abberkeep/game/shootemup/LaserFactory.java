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

import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.movement.Direction;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.movement.SingleMovement;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.ActorFactory;

/**
 * Title: LaserFactory
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 8, 2023
 * @author Gary Deken
 * @version
 */
public class LaserFactory extends ActorFactory<Laser> {
   private Motion[] laserMotion;

   public LaserFactory(BaseScreen baseScreen, Animation animation) {
      super(baseScreen, 10);
      this.laserMotion = new Motion[1];
      this.laserMotion[0] = new SingleMotion(animation);
      setupQueue();
   }

   @Override
   protected Movement buildMovement() {
      return new SingleMovement(4f, Direction.NORTH);
   }

   @Override
   protected Motion[] buildMoveMotions() {
      return laserMotion;
   }

   @Override
   protected Motion[] buildStillMotions() {
      return laserMotion;
   }

   @Override
   protected Laser construct(Movement buildMovement, Motion[] buildMoveMotions, Motion[] buildStillMotions) {
      return new Laser(buildMovement(), buildMoveMotions(), buildStillMotions(), this);
   }

}
