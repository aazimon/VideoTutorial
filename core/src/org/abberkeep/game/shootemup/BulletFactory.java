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

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.LoopAnimation;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.movement.Direction;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.movement.ScriptMovement;
import org.abberkeep.gameframework.movement.actions.MoveAction;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.ActorFactory;

/**
 * Title: BulletFactory
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Jan 26, 2024
 * @author Gary Deken
 * @version
 */
public class BulletFactory extends ActorFactory<Bullet> {
   private TextureRegion[] bullet;

   public BulletFactory(BaseScreen baseScreen, TextureRegion[] bullet) {
      super(baseScreen);
      this.bullet = bullet;
      queueSize = 20;
      setupQueue();
   }

   @Override
   protected Movement buildMovement() {
      ScriptMovement movement = new ScriptMovement(new MoveAction(Direction.SOUTH, 4f));

      return movement;
   }

   @Override
   protected Motion[] buildMoveMotions() {
      return new Motion[]{new SingleMotion(new LoopAnimation(.1f, bullet))};
   }

   @Override
   protected Motion[] buildStillMotions() {
      return null;
   }

   @Override
   protected Bullet construct(Movement buildMovement, Motion[] buildMoveMotions, Motion[] buildStillMotions) {
      return new Bullet(buildMovement, buildMoveMotions, buildMoveMotions);
   }

}
