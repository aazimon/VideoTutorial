/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.invasion;

import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: Alien
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 22, 2025
 * @author Gary Deken
 * @version
 */
public class Alien extends Actor {

   public Alien(Movement movement, Motion moveMotion, Motion stillMotion) {
      super(movement, moveMotion, stillMotion);
   }

   @Override
   public void handleCollision(Sprite other) {
      super.handleCollision(other);
   }

   private void hit() {
      setRemove(true);
   }

}
