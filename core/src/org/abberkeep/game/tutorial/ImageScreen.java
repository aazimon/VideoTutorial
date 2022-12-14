/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import org.abberkeep.gameframework.screen.BaseScreen;

/**
 * Title: GameScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Dec 9, 2022
 * @author Gary Deken
 * @version
 */
public class ImageScreen extends BaseScreen {
   private Texture img;

   public ImageScreen(int width, int height) {
      super(width, height);
      setBackgroundColor(Color.WHITE);
   }

   @Override
   public void show() {
      img = getTexture("DemoPortait.png");
   }

   @Override
   protected void renderChild(float deltaTime) {
      float y = 20;
      // draws the image.
      batch.draw(img, 0, y);
      // draw resizing of the image
      //batch.draw(img, 150, y, 256, 256);
      // batch.draw(img, 150, y, 100, 200);
      // draw a region of the image
      //batch.draw(img, 150, y, 15, 15, 128, 128);
      //batch.draw(img, 150, y, 15, 5, 100, 105);
      // zoom in on portion of the image
      //batch.draw(img, 150, y, 128, 128, 0f, 1f, 1f, 0f);
      //batch.draw(img, 150, y, 128, 128, 0f, .75f, 1f, .25f);
      batch.draw(img, 150, y, 128, 128, 0f, 1.75f, 1f, .25f);
      //batch.draw(img, 150, y, 30, 35, 0.3f, .5f, .45f, .35f);
      //batch.draw(img, 150, y, 128, 128, 1f, 0f, 0f, 1f);
      // draw resizing, portion and flipping.
      //batch.draw(img, 150, y, 100, 105, 15, 5, 100, 105, true, false);
      // drawing with rotation
      //batch.draw(img, 150, y, 0, 0, 128, 128, 1, 1, 15f, 0, 0, 128, 128, false, false);
      //batch.draw(img, 150, y, 0, 0, 128, 128, 1, 1, 15f, 15, 5, 100, 105, false, false);
      // colorizing the image
      //batch.setColor(Color.RED);
      //batch.draw(img, 150, y);
      //batch.setColor(Color.CLEAR);
      batch.setColor(Color.WHITE);
      batch.draw(img, 300, y);

   }

}
