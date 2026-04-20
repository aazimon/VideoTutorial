/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.invasion;

import com.badlogic.gdx.graphics.Color;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.effects.ChainEffect;
import org.abberkeep.gameframework.effects.TranslucencyEffect;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.screen.map.SimpleSpriteMap;
import org.abberkeep.gameframework.sprite.Decor;
import org.abberkeep.gameframework.state.GameState;

/**
 *
 * @author GaryDeken
 */
public class SplashState extends GameState {
   private BaseScreen screen;
   private float counter = 0f;

   @Override
   public void activateState() {
      screen = new BaseScreen() {
         @Override
         public void show() {
            SimpleSpriteMap map = new SimpleSpriteMap(1);
            Decor splash = new Decor(new StaticAnimation(getTexture("AbberKeep.png")));
            splash.setLocation(400 - splash.getWidth() / 2, 300 - splash.getHeight() / 2);
            BlockAnimation block = new BlockAnimation(800, 600, Color.BLACK);
            ChainEffect effect = new ChainEffect(new TranslucencyEffect(1, 0, 2f), new TranslucencyEffect(0, 0, 3f),
               new TranslucencyEffect(0, 1, 2f));
            block.addEffects(effect);
            Decor cover = new Decor(block);

            map.addDecor(splash);
            map.addDecor(cover);
            setGameMap(map);
         }
      };
      controller.setScreen(screen);
   }

   @Override
   public void deactivateState() {
      screen.dispose();
   }

   @Override
   public void update(float deltaTime) {
      if (counter > 8f) {
         changeState(new BattleState());
      }
      counter += deltaTime;

   }

}
