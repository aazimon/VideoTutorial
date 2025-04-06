/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.test;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.abberkeep.gameframework.screen.map.GameMap;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.sprite.Sprite;

/**
 * Title: SimpleRenderMap
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Mar 19, 2025
 * @author Gary Deken
 * @version
 */
public abstract class SimpleRenderMap extends GameMap {
   @Override
   public void addActor(Actor actor) {
      //
   }

   @Override
   public void addDecor(Decor decor) {
      //
   }

   @Override
   public void addSprite(Sprite sprite) {
      //
   }

   @Override
   protected void addOffCycle() {
      //
   }

   @Override
   public void renderCycle(float deltaTime, SpriteBatch batch) {
      render(deltaTime, batch);
   }

   public abstract void render(float deltaTime, SpriteBatch batch);

   @Override
   protected void drawSprites(SpriteBatch batch) {
      //
   }

   @Override
   protected void updateSprites(float deltaTime) {
      //
   }

}
