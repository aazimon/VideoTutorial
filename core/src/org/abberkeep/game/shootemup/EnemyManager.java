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
import java.util.Random;
import org.abberkeep.gameframework.Updatable;

/**
 * Title: EnemyManager
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 15, 2023
 * @author Gary Deken
 * @version
 */
public class EnemyManager implements Updatable {
   private ShootemUpScreen screen;
   private ObstacleFactory obstacleFactory;
   private float obstacleTime;
   private float shipTime;
   private Random random;
   private int width;
   private EnemyShip enemyShip;
   private boolean enemyAdded = false;

   public EnemyManager(ShootemUpScreen screen, ObstacleFactory obstacleFactory, EnemyShip enemy) {
      this.screen = screen;
      this.obstacleFactory = obstacleFactory;
      width = Gdx.graphics.getWidth() - 40;
      random = new Random(System.currentTimeMillis());
      this.enemyShip = enemy;
   }

   @Override
   public void update(float deltaTime) {
      obstacleTime += deltaTime;
      shipTime += deltaTime;

      if (obstacleTime > 1f) {
         obstacleFactory.createNewActor(random.nextInt(width) + 20, Gdx.graphics.getHeight() + 20);
         obstacleTime = 0;
      }
      if (!enemyAdded && shipTime > 10f) {
         enemyShip.setLocation(0, Gdx.graphics.getHeight() + 45);
         screen.addActor(enemyShip);
         enemyAdded = true;
      }
   }

}
