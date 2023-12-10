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

import com.badlogic.gdx.graphics.Color;
import java.util.Random;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.screen.SimpleScreen;

/**
 * Title: ShootemUpScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 3, 2023
 * @author Gary Deken
 * @version
 */
public class ShootemUpScreen extends SimpleScreen {
   private Random random;

   @Override
   public void show() {
      BlockAnimation animationLaser = new BlockAnimation(Laser.WIDTH, Laser.HEIGHT);
      animationLaser.setColor(Color.RED);
      LaserFactory laserFactory = new LaserFactory(this, animationLaser);

      BlockAnimation shipAni = new BlockAnimation(100, 40);
      SingleMotion shipMotion = new SingleMotion(shipAni);
      Ship ship = new Ship(shipMotion, laserFactory, getSound("Laser.wav"));
      ship.setLocation(width / 2 - 50, 60);

      addActor(ship);

      random = new Random(System.currentTimeMillis());

      ObstacleFactory obstacleFactory = new ObstacleFactory(this, random);

      addUpdatable(obstacleFactory);

   }

}
