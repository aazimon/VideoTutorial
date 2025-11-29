/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.invasion;

import java.util.List;
import org.abberkeep.gameframework.Updatable;
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
   private static final int EDGE = 15;
   private List<List<Alien>> aliens;
   private ControlledMovement movement;
   private int phase = 1;
   private int size = 0;

   public AlienTroops(int columns) {
      size = columns;
      movement = new ControlledMovement();
      movement.setSpeed(.5f);
      movement.setDirection(Direction.EAST);
   }

   public List<List<Alien>> getAliens() {
      return aliens;
   }

   public ControlledMovement getMovement() {
      return movement;
   }

   public void setAliens(List<List<Alien>> aliens) {
      this.aliens = aliens;
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
                  phase = 2;
               }
               break;
            case 2:
               // moving right and down
               if (last.getX() + last.getWidth() > END_X) {
                  // change to move left and down.
                  movement.setDirection(Direction.SOUTH_WEST);
                  phase = 3;
               }
               break;
            case 3:
               // moving left and down
               if (last.getX() + last.getWidth() < END_X + EDGE) {
                  // change to move left
                  movement.setDirection(Direction.WEST);
                  phase = 4;
               }
               break;
            case 4:
               // moving left
               if (first.getX() < START_X + EDGE) {
                  // change move left and down
                  movement.setDirection(Direction.SOUTH_WEST);
                  phase = 5;
               }
               break;
            case 5:
               // moving left and down
               if (first.getX() < START_X) {
                  // change to move right and down
                  movement.setDirection(Direction.SOUTH_EAST);
                  phase = 6;
               }
               break;

            default:
               // moving right and down
               if (first.getX() > START_X + EDGE) {
                  // change to move right
                  movement.setDirection(Direction.EAST);
                  phase = 1;
               }
         }
      }
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
