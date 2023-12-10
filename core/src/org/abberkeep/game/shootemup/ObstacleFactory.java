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
import com.badlogic.gdx.graphics.Color;
import java.util.Random;
import org.abberkeep.gameframework.Updatable;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.movement.Direction;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.movement.ScriptMovement;
import org.abberkeep.gameframework.movement.actions.EasingAction;
import org.abberkeep.gameframework.movement.actions.MoveAction;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.ActorFactory;

/**
 * Title: ObstacleFactory
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 9, 2023
 * @author Gary Deken
 * @version
 */
public class ObstacleFactory extends ActorFactory<Obstacle> implements Updatable {
   private static Motion[] motion;
   private float currentTime;
   private Random random;

   public ObstacleFactory(BaseScreen baseScreen, Random random) {
      super(baseScreen, 15);
      this.random = random;
      Motion motionMove = new SingleMotion(new BlockAnimation(20, 20));
      motionMove.setColor(Color.BROWN);
      Motion motionDestroy = new SingleMotion(new BlockAnimation(20, 20));
      motionDestroy.setColor(Color.RED);
      motion = new Motion[2];
      motion[0] = motionMove;
      motion[1] = motionDestroy;
      setupQueue();
   }

   @Override
   protected Movement buildMovement() {
      MoveAction action = new MoveAction(Direction.SOUTH, 3f);
      ScriptMovement movement = new ScriptMovement(action);
      EasingAction action2 = new EasingAction(2f, Direction.SOUTH, EasingAction.EASING_POWER.BI);
      movement.addAction(action2);

      return movement;
   }

   @Override
   protected Motion[] buildMoveMotions() {
      return motion;
   }

   @Override
   protected Motion[] buildStillMotions() {
      return motion;
   }

   @Override
   protected Obstacle construct(Movement buildMovement, Motion[] buildMoveMotions, Motion[] buildStillMotions) {
      return new Obstacle(buildMovement(), buildMoveMotions(), buildStillMotions(), this);
   }

   @Override
   public void update(float deltaTime) {
      currentTime += deltaTime;

      if (currentTime > 1f) {
         createNewActor(random.nextInt(Gdx.graphics.getWidth()), Gdx.graphics.getHeight() + 20);
         currentTime = 0;
      }
   }

}
