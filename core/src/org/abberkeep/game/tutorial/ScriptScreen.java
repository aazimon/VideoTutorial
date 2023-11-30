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

import static org.abberkeep.gameframework.movement.actions.EasingAction.EASING_POWER.TRI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.StaticRegionAnimation;
import org.abberkeep.gameframework.motion.FourWayMotion;
import org.abberkeep.gameframework.movement.Direction;
import org.abberkeep.gameframework.movement.ScriptMovement;
import org.abberkeep.gameframework.movement.actions.DestinationAction;
import org.abberkeep.gameframework.movement.actions.EasingAction;
import org.abberkeep.gameframework.movement.actions.GoToAction;
import org.abberkeep.gameframework.screen.SimpleScreen;
import org.abberkeep.gameframework.sprite.Actor;

/**
 * Title: ScriptScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 28, 2023
 * @author Gary Deken
 * @version
 */
public class ScriptScreen extends SimpleScreen {

   @Override
   public void show() {
      setBackgroundColor(Color.WHITE);
      Texture texture = getTexture("DemoCharacter2A.png");
      FourWayMotion motion = new FourWayMotion(texture, 64, 64, .2f, 3, 2, 0, 1);
      TextureRegion[][] textReg = TextureRegion.split(texture, 64, 64);
      FourWayMotion still = new FourWayMotion(new StaticRegionAnimation(textReg[3][1]), new StaticRegionAnimation(
         textReg[2][1]), new StaticRegionAnimation(textReg[0][1]), new StaticRegionAnimation(textReg[1][1]));
//      ScriptMovement movement = new ScriptMovement(new ChangeSpeedAction(0.8f, Direction.NORTH, 3f));
//
//      movement.addAction(new TimeMoveAction(Direction.EAST, .8f, 4f));
//      movement.addAction(new WaitAction(1f, Direction.SOUTH));
//      movement.addAction(new TimeMoveAction(Direction.NORTH, 0.8f, 2f, true));
      ScriptMovement movement = new ScriptMovement(new EasingAction(1f, Direction.EAST, 10f, TRI));

      movement.addAction(new DestinationAction(250, 250, 1f, true));
      movement.addAction(new DestinationAction(50, 250, 1f, true));
      movement.addAction(new DestinationAction(50, 50, 1f, true));
      movement.addAction(new DestinationAction(250, 50, 1f, true));
      movement.addAction(new GoToAction(movement, 2));

      Actor actor = new Actor(movement, motion, still);
      actor.setLocation(50, 50);

      addActor(actor);
   }

}
