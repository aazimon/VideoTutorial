/*
 * Copyright (c) 2022-2025 Gary Deken
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
package org.abberkeep.game.invasion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.animation.StaticRegionAnimation;
import org.abberkeep.gameframework.motion.ControlledMotion;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.movement.Movement;

/**
 * Title: AlienTroopBuilder
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 22, 2025
 * @author Gary Deken
 * @version
 */
public class AlienTroopBuilder {
   public static final int SIZE = 25;
   private static final int SPACE = 20;

   public static AlienTroops createAlientTroops(int y, int rows, int columns, float speed, Texture texture) {
      AlienTroops troops = new AlienTroops(columns, speed);
      int dif = SIZE + SPACE;
      List<List<Alien>> at = new ArrayList<>();

      for (int i = 0; i < rows; i++) {
         List<Alien> aliens = new ArrayList<>();
         for (int j = 0; j < columns; j++) {
            Alien a = createAlien(troops.getMovement(), texture);
            a.setLocation(AlienTroops.START_X + dif * j, y - dif * i, 0);
            aliens.add(a);
         }
         at.add(aliens);
      }
      troops.setAliens(at);

      return troops;
   }

   private static Alien createAlien(Movement movement, Texture texture) {
      Animation animation = new BlockAnimation(SIZE, SIZE);
      animation.setColor(Color.RED);
      BlockAnimation animation1 = new BlockAnimation(SIZE, SIZE);
      animation1.setColor(Color.CORAL);
      BlockAnimation animation2 = new BlockAnimation(SIZE, SIZE);
      animation2.setColor(Color.GOLD);
      BlockAnimation animation3 = new BlockAnimation(SIZE, SIZE);
      animation3.setColor(Color.LIME);
      BlockAnimation animation4 = new BlockAnimation(SIZE, SIZE);
      animation4.setColor(Color.FIREBRICK);
      BlockAnimation animation5 = new BlockAnimation(SIZE, SIZE);
      animation5.setColor(Color.VIOLET);
      TextureRegion[] tr = TextureRegion.split(texture, 36, 36)[0];
      Animation aniDown = new StaticRegionAnimation(tr[0]);
      Animation aniRight = new StaticRegionAnimation(tr[2]);
      Animation aniLeft = new StaticRegionAnimation(tr[1]);
//      ControlledMotion motion = new ControlledMotion(animation1, animation2, animation3, animation4, animation5);
      ControlledMotion motion = new ControlledMotion(aniDown, aniRight, aniLeft);
      SingleMotion shot = new SingleMotion(animation);
      Alien alien = new Alien(movement, motion, shot);

      return alien;
   }
}
