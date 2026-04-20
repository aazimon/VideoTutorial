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

import org.abberkeep.gameframework.screen.BaseScreen;
import org.abberkeep.gameframework.screen.map.SimpleSpriteMap;

/**
 * Title: BattleScene
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Nov 22, 2025
 * @author Gary Deken
 * @version
 */
public class BattleScene extends BaseScreen {
   private AlienTroops troops;
   private float speed;

   public BattleScene(float speed) {
      super();
      this.speed = speed;
   }

   @Override
   public void show() {
      int y = 550;
      SimpleSpriteMap map = new SimpleSpriteMap(2);
      troops = AlienTroopBuilder.createAlientTroops(y, 5, 10, speed, getTexture("AlienShip.png"));

      map.addUpdatable(troops);
      troops.getAliens().forEach(lst -> lst.forEach(alien -> map.addActor(alien)));

      setGameMap(map);
   }

   public boolean isTroopsDone() {
      System.out.println(troops.getLowest());
      return troops.getLowest() < 350;
   }

}
