/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.invasion;

import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.motion.TwoWayMotion;
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

   public static AlienTroops createAlientTroops(int y, int rows, int columns) {
      AlienTroops troops = new AlienTroops(columns);
      int dif = SIZE + SPACE;
      List<List<Alien>> at = new ArrayList<>();

      for (int i = 0; i < rows; i++) {
         List<Alien> aliens = new ArrayList<>();
         for (int j = 0; j < columns; j++) {
            Alien a = createAlien(troops.getMovement());
            a.setLocation(AlienTroops.START_X + dif * j, y - dif * i, BattleScene.BATTLE_LAYER);
            aliens.add(a);
         }
         at.add(aliens);
      }
      troops.setAliens(at);

      return troops;
   }

   private static Alien createAlien(Movement movement) {
      Animation animation = new BlockAnimation(SIZE, SIZE);
      animation.setColor(Color.CORAL);
      TwoWayMotion move = new TwoWayMotion(animation, animation);
      SingleMotion shot = new SingleMotion(animation);
      Alien alien = new Alien(movement, move, shot);

      return alien;
   }
}
