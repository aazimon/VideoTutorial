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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.Random;
import java.util.function.Supplier;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.movement.ScriptMovement;
import org.abberkeep.gameframework.movement.actions.GoToAction;
import org.abberkeep.gameframework.movement.actions.RandomDestinationAction;
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

   @Override
   public void show() {
      BlockAnimation animationLaser = new BlockAnimation(Laser.WIDTH, Laser.HEIGHT);
      animationLaser.setColor(Color.RED);
      LaserFactory laserFactory = new LaserFactory(this, animationLaser);

      BlockAnimation shipAni = new BlockAnimation(100, 40);
      SingleMotion shipMotion = new SingleMotion(shipAni);
      Ship ship = new Ship(shipMotion, laserFactory, getSound("ShipHit.wav"), getSound("Laser.wav"));
      ship.setLocation(width / 2 - 50, 60);

      addActor(ship);

      ObstacleFactory obstacleFactory = new ObstacleFactory(this, getSound("Obstacle Explosion.wav"));
      EnemyShip enemyShip = buildEnemyShip();

      EnemyManager manager = new EnemyManager(this, obstacleFactory, enemyShip);

      addUpdatable(manager);

   }

   private BulletFactory buildBullerFactory() {
      TextureRegion[][] bullets = TextureRegion.split(getTexture("Bullet.png"), 15, 15);
      return new BulletFactory(this, bullets[0]);
   }

   private EnemyShip buildEnemyShip() {
      Random random = new Random(System.currentTimeMillis());
      RandomDestinationAction action = new RandomDestinationAction(() -> random.nextInt(10) * 10 + 100,
         () -> Gdx.graphics.getHeight() - 80, 2.5f);
      Supplier<Integer> randHeight = () -> height - 80 - (random.nextInt(5) * 15);
      Supplier<Integer> randLeft = () -> 10 + (random.nextInt(10) * 10);
      Supplier<Integer> randRight = () -> width - 100 - (random.nextInt(10) * 10);
      RandomDestinationAction action2 = new RandomDestinationAction(randRight, randHeight, 2.5f);
      action2.addGoal(randLeft, randHeight);
      ScriptMovement enemyMovement = new ScriptMovement(action);
      enemyMovement.addAction(action2);
      enemyMovement.addAction(new GoToAction(enemyMovement, 1));
      BlockAnimation enemyAni = new BlockAnimation(100, 40);
      enemyAni.setColor(Color.BLUE);
      SingleMotion enemyMotion = new SingleMotion(enemyAni);
      EnemyShip enemyShip = new EnemyShip(enemyMovement, enemyMotion, getSound("EnemyHit.wav"), buildBullerFactory());

      return enemyShip;
   }

}
