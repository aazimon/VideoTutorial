/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial.movement;

import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.movement.GameStickMovement;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.screen.map.SimpleSpriteMap;
import org.abberkeep.gameframework.sprite.Actor;

/**
 * Title: ControllerStickScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 28, 2025
 * @author Gary Deken
 * @version
 */
public class ControllerStickScreen extends BaseScreen {

   @Override
   public void show() {
      SimpleSpriteMap map = new SimpleSpriteMap(1);

      map.addActor(buildActor());
      setGameMap(map);
   }

   private Actor buildActor() {
      BlockAnimation animation = new BlockAnimation(20, 20);
      animation.setColor(Color.GOLD);
      SingleMotion motion = new SingleMotion(animation);
      GameStickMovement movement = new GameStickMovement(1, 0, 2);

      Actor actor = new Actor(movement, motion, motion);

      actor.setLocation(360, 260);

      return actor;
   }

}
