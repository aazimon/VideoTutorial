/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import org.abberkeep.game.test.SimpleRenderMap;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.utils.FontUtil;

/**
 * Title: ComponentScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Feb 26, 2026
 * @author Gary Deken
 * @version
 */
public class FontScreen extends BaseScreen {
   private float updateTime = 0;
   private int start = 0;
   private int end = 40;
   private int max = 0;
   private BitmapFont font;
   private GlyphLayout glyph1;
   private BitmapFont font2;
   private GlyphLayout glyph2;
   private int[] setOfChars = {127, 129, 141, 143, 144, 157};
   private String message;
   private String m2 = "-";
   private float tracker = 0;
   private int id = 0;

   @Override
   public void show() {
      //String fontFile = "Arial-10.fnt";
      //String fontFile = "Battlestar-24.fnt";
      String fontFile2 = "Buffied-24.fnt";
      //String fontFile = "Source Sans Pro SB-24.fnt";
      String fontFile = "ArialBlock.fnt";
      //String fontFile = "NotoNash.fnt";
      message = "Babylon 5 is a seminal science fiction television series renowned for its ambitious five-year story arc and complex political intrigue. Set on a massive space station in neutral territory, the show explores the delicate diplomacy and escalating tensions between diverse alien civilizations. Its pioneering use of computer-generated imagery and deeply developed character arcs left a lasting legacy on the structure of modern serialized storytelling.";
      max = message.length();

      font = new BitmapFont(Gdx.files.internal(fontFile));
      glyph1 = new GlyphLayout(font, message, Color.BLUE, 0, Align.left, false);
      //glyph1 = new GlyphLayout(font, message, Color.BLUE, 300, Align.left, true);
      //glyph1 = new GlyphLayout(font, message, 4, 20, Color.BLUE, 300, Align.left, true, "");
      font2 = new BitmapFont(Gdx.files.internal(fontFile2));
      //glyph2 = new GlyphLayout(font2, message, Color.CORAL, 300, Align.left, true);
      //glyph2 = new GlyphLayout(font2, message, Color.CORAL, 300, Align.right, true);
      //glyph2 = new GlyphLayout(font2, message, Color.CORAL, 300, Align.center, true);

      char[] c = new char[FontUtil.LATIN_FONT_IDS.length];
      for (int i = 0; i < c.length; i++) {
         if (id < FontUtil.LATIN_FONT_IDS.length) {
            c[i] = FontUtil.LATIN_FONT_IDS[id];
            id++;
         }
      }
      tracker = 0;
      m2 = new String(c);

      //Color clr = new Color(.5f, .2f, 1f, 1f);
      Color clr = new Color(1f, .2f, 1f, .5f);
      font.setColor(clr);
      glyph1.setText(font2, message, clr, 400, Align.left, true);

      SimpleRenderMap map = new SimpleRenderMap() {
         @Override
         public void render(float deltaTime, SpriteBatch batch) {
            //font.draw(batch, message, 10, 10);
            //font.draw(batch, glyph1, 10, 200);
            //font2.draw(batch, glyph2, 10, 200);
            //font.draw(batch, message, 10, 500, 300, Align.left, false);
            //font.draw(batch, message, 10, 500, 300, Align.left, true);
            //font.draw(batch, message, 10, 500, 400, Align.right, true);
            //font.draw(batch, message, 10, 500, 400, Align.center, true);
            // other alignments.
            //font.draw(batch, message, 10, 500, 400, Align.bottom, true); // right align
            //font.draw(batch, message, 10, 500, 400, Align.bottomLeft, true); // left align
            //font.draw(batch, message, 10, 500, 400, Align.bottomRight, true); // right align
            //font.draw(batch, message, 10, 500, 400, Align.top, true); // right align
            //font.draw(batch, message, 10, 500, 400, Align.topLeft, true); // left align
            //font.draw(batch, message, 10, 500, 400, Align.topRight, true); // right align
            // Wrapping
            //font.draw(batch, message, 10, 500, 8, 135, 300, Align.left, true);
            //font.draw(batch, message, 10, 500, 8, 135, 300, Align.left, true, " Place at end");
            // Marque
            updateTime += deltaTime;
            if (updateTime > .2) {
               if (end < max) {
                  start++;
                  end++;
               }
               updateTime = 0;
            }
            //font.draw(batch, message, 10, 500, start, end, 400, Align.left, false, "");
            // All fonts from Bit Map Font Generator
            //font.draw(batch, m2, 50, 550, 500f, Align.left, true);
            // Changing the color before rendering the font does not change the color of the font.
            //batch.setColor(Color.FOREST);
            //font.draw(batch, m2, 50, 550, 500f, Align.left, true);
            //batch.setColor(Color.WHITE);
            // setting color and transluncy
            //font.draw(batch, message, 50, 550, 500f, Align.left, true);
            font2.draw(batch, glyph1, 60, 550);
         }
      };

      setGameMap(map);
   }

}
