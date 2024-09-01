/*
 * Copyright (c) 2022-2023 Gary Deken
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.abberkeep.game.tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.sprite.Actor;
import org.abberkeep.gameframework.sprite.Decor;

/**
 * Title: SoundScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Aug 20, 2023
 * @author Gary Deken
 * @version
 */
public class SoundScreen extends BaseScreen {
   private Sound s;
   private Music m;
   private boolean paused = false;
   private long id;

   @Override
   public void show() {
      String f1 = "HB_Starter_-_Fantasy_-_Battle.mp3";
      String f2 = "Explosion3.wav";
      String f3 = "Hello.wav";
      s = getSound(f3);
      m = getMusic(f2);
   }

   @Override
   protected void renderChild(float deltaTime) {
      if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
         id = s.play();
         //s.setPan(id, 1f, .6f);
         //s.setLooping(id, true);
         s.setPitch(id, 1.6f);
      }
      if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
         m.play();
         m.setVolume(.5f);
      }
      if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
         if (paused) {
            s.resume();
            //m.play();
            paused = false;
         } else {
            s.pause();
            //m.pause();
            paused = true;
         }
      }
      if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
         //m.stop();
         s.setLooping(id, false);
      }
      if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
         //m.setPosition(60f);
      }
      //System.out.println(m.getPosition());
   }

   @Override
   public void addActor(Actor actor) {
   }

   @Override
   public void addDecor(Decor decor) {
   }

}
