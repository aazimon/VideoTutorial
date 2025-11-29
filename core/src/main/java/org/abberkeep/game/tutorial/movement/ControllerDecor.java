/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial.movement;

import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: ControllerDecor
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 27, 2025
 * @author Gary Deken
 * @version
 */
public class ControllerDecor extends Decor {
   private boolean isAxis;
   private int id;

   public ControllerDecor(Animation animation, boolean axis, int id) {
      super(animation);
      isAxis = axis;
      this.id = id;
   }

   @Override
   public void update(float deltaTime) {
      if (isAxis) {
         if (Controllers.getCurrent().getAxis(id) != 0) {
            animation.setColor(Color.GREEN);
         } else {
            animation.setColor(Color.BLUE);
         }
      } else {
         if (Controllers.getCurrent().getButton(id)) {
            animation.setColor(Color.GREEN);
         } else {
            animation.setColor(Color.BLUE);
         }
      }
      super.update(deltaTime);
   }

}
