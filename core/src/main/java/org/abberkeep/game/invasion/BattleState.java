/*
 * Copyright (c) 2022-2025 Gary Deken
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
package org.abberkeep.game.invasion;

import org.abberkeep.gameframework.state.GameState;

/**
 *
 * @author GaryDeken
 */
public class BattleState extends GameState {
   private BattleScene currentScene;
   private float speed = .5f;

   @Override
   public void activateState() {
      currentScene = new BattleScene(speed);
      controller.setScreen(currentScene);
   }

   @Override
   public void deactivateState() {
      currentScene.dispose();
   }

   @Override
   public void update(float deltaTime) {
      if (currentScene.isTroopsDone()) {
         speed += .5f;
         changeState(this);
      }
   }

}
