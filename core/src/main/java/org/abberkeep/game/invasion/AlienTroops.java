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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.abberkeep.gameframework.Updatable;
import org.abberkeep.gameframework.motion.ControlledMotion;
import org.abberkeep.gameframework.movement.ControlledMovement;
import org.abberkeep.gameframework.movement.Direction;

/**
 * Title: AlienTroops
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 22, 2025
 * @author Gary Deken
 * @version
 */
public class AlienTroops implements Updatable {
   public static final int START_X = 50;
   public static final int END_X = 750;
   private static final int EDGE = 60;
   private List<List<Alien>> aliens;
   private ControlledMovement movement;
   private List<ControlledMotion> motion = new ArrayList<>();
   private int phase = 1;
   private int size = 0;
   private Random r = new Random(System.currentTimeMillis());
   private float countdown = 1f;
   private float lowest = 500;

   public AlienTroops(int columns, float speed) {
      size = columns;
      movement = new ControlledMovement();
      movement.setSpeed(speed);
      movement.setDirection(Direction.EAST);
   }

   public List<List<Alien>> getAliens() {
      return aliens;
   }

   public float getLowest() {
      return lowest;
   }

   public ControlledMovement getMovement() {
      return movement;
   }

   public void setAliens(List<List<Alien>> aliens) {
      this.aliens = aliens;
      for (List<Alien> lst : aliens) {
         for (Alien alien1 : lst) {
            motion.add((ControlledMotion) alien1.getMoveMotions()[0]);
         }
      }
   }

   @Override
   public void update(float deltaTime) {
      Alien first = getFirst();
      Alien last = getLast();
      if (first != null && last != null) {
         switch (phase) {
            case 1:
               // moving east (right)
               if (last.getX() + last.getWidth() > END_X - EDGE) {
                  // change to move right and down
                  movement.setDirection(Direction.SOUTH_EAST);
                  motion.forEach(mtn -> mtn.setCurrentIndex(1));
                  phase = 2;
               }
               break;
            case 2:
               // moving right and down
               if (last.getX() + last.getWidth() > END_X) {
                  // change to move left and down.
                  movement.setDirection(Direction.SOUTH_WEST);
                  motion.forEach(mtn -> mtn.setCurrentIndex(1));
                  phase = 3;
               }
               break;
            case 3:
               // moving left and down
               if (last.getX() + last.getWidth() < END_X - EDGE) {
                  // change to move left
                  movement.setDirection(Direction.WEST);
                  motion.forEach(mtn -> mtn.setCurrentIndex(0));
                  phase = 4;
               }
               break;
            case 4:
               // moving left
               if (first.getX() < START_X + EDGE) {
                  // change move left and down
                  movement.setDirection(Direction.SOUTH_WEST);
                  motion.forEach(mtn -> mtn.setCurrentIndex(2));
                  phase = 5;
               }
               break;
            case 5:
               // moving left and down
               if (first.getX() < START_X) {
                  // change to move right and down
                  movement.setDirection(Direction.SOUTH_EAST);
                  motion.forEach(mtn -> mtn.setCurrentIndex(2));
                  phase = 6;
               }
               break;

            default:
               // moving right and down
               if (first.getX() > START_X + EDGE) {
                  // change to move right
                  movement.setDirection(Direction.EAST);
                  motion.forEach(mtn -> mtn.setCurrentIndex(0));
                  phase = 1;
               }
         }
         lowest = last.getY();
      }
      // change color
//      if (countdown < 0) {
//         motion.forEach(mtn -> mtn.setCurrentIndex(r.nextInt(5)));
//         countdown = 1f;
//      }
//      countdown -= deltaTime;
   }

   private Alien getFirst() {
      for (int i = 0; i < size; i++) {
         for (List<Alien> alien : aliens) {
            Alien a = alien.get(i);

            if (!a.isRemove() && a.getX() < 1000) {
               return a;
            }
         }
      }
      return null;
   }

   private Alien getLast() {
      for (int i = size - 1; i > -1; i--) {
         for (List<Alien> alien : aliens) {
            Alien a = alien.get(i);
            if (!a.isRemove() && a.getX() > 0) {
               return a;
            }
         }
      }
      return null;
   }
}
