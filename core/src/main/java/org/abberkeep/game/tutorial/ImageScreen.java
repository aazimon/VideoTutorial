/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: GameScreen
 *
 * <p>
 * Description: Tutorial for demonstrating still image rendering, and then for creating Animation class.</p>
 *
 * Copyright (c) Dec 9, 2022
 * @author Gary Deken
 * @version 0.2
 */
public class ImageScreen extends BaseScreen {
   private Texture img;
   private StaticAnimation sa1;
   private StaticAnimation sa2;
   private StaticAnimation sa3;

   @Override
   public void show() {
      setBackgroundColor(Color.WHITE);
      img = getTexture("DemoPortait.png");
      sa1 = new StaticAnimation(img);
      sa2 = new StaticAnimation(img, 100, 200);
      sa3 = new StaticAnimation(img);
      sa3.setRotation(45);
      sa3.setCropping(15, 5, 100, 105);
      sa1.setRotation(45);
      sa2.setRotation(45);
   }

   @Override
   protected void renderChild(float deltaTime) {
      float y = 20;
      // draws the image.
      //sa1.draw(batch, 2, y);
      // draw resizing of the image
      //sa2.draw(batch, 150, y);
      // draw a region of the image
      //sa3.draw(batch, 400, y);
      // zoom in on portion of the image
      batch.draw(img, 10, y);
      //batch.draw(img, 150, y, 128, 128, .25f, 1f, 1f, 0f);
      //batch.draw(img, 150, y, 128, 128, 0f, .75f, 1f, .25f);
      //batch.draw(img, 150, y, 128, 128, 0f, 1.75f, 1f, .25f);
      //batch.draw(img, 150, y, 30, 35, 0.3f, .5f, .45f, .35f);
      //batch.draw(img, 150, y, 128, 128, 1f, 0f, 0f, 1f);
      // draw resizing, portion and flipping.
      //batch.draw(img, 150, y, 100, 105, 15, 5, 100, 105, true, false);
      // drawing with rotation
      //batch.draw(img, 150, y, 0, 0, 128, 128, 1, 1, 15f, 0, 0, 128, 128, false, false);
      //batch.draw(img, 150, y, 0, 0, 128, 128, 1, 1, 15f, 15, 5, 100, 105, false, false);
      // colorizing the image
      batch.setColor(1, 1, 1, .4f);
      batch.draw(img, 50, y);
      //batch.setColor(Color.CLEAR);
      batch.setColor(Color.WHITE);
      //batch.draw(img, 300, y);
   }

   @Override
   public void addActor(Actor actor) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void addDecor(Decor decor) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

}
