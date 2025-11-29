/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial.movement;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.screen.map.SimpleSpriteMap;

/**
 * Title: ControllerScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 27, 2025
 * @author Gary Deken
 * @version
 */
public class ControllerScreen extends BaseScreen {
   private ControllerDecor[] buttons = new ControllerDecor[15];
   private ControllerDecor[] axis = new ControllerDecor[6];

   @Override
   public void show() {
      SimpleSpriteMap map = new SimpleSpriteMap(1);
      Controllers.getControllers();
      Controller controller = Controllers.getCurrent();
      System.out.println("Axis: " + controller.getAxisCount());
      System.out.println("Buttons: " + controller.getMaxButtonIndex());
      int y = 200;
      int x = 10;

      for (int i = 0; i < buttons.length; i++) {
         BlockAnimation animation = new BlockAnimation(20, 20);
         animation.setColor(Color.DARK_GRAY);
         buttons[i] = new ControllerDecor(animation, false, i);
         buttons[i].setLocation(x, y);
         x += 30;
         map.addDecor(buttons[i]);
      }
      x = 10;
      y = 300;
      for (int i = 0; i < axis.length; i++) {
         BlockAnimation animation = new BlockAnimation(20, 20);
         animation.setColor(Color.DARK_GRAY);
         axis[i] = new ControllerDecor(animation, true, i);
         axis[i].setLocation(x, y);
         x += 30;
         map.addDecor(axis[i]);
      }

      setGameMap(map);
   }

}
