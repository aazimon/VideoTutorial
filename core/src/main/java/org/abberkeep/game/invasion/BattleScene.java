/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
   public static final int BATTLE_LAYER = 1;
   public static final int DESTROYED_LAYER = 0;

   @Override
   public void show() {
      int y = 550;
      SimpleSpriteMap map = new SimpleSpriteMap(2);
      AlienTroops troops = AlienTroopBuilder.createAlientTroops(y, 5, 10);

      map.addUpdatable(troops);
      troops.getAliens().forEach(lst -> lst.forEach(alien -> map.addActor(alien)));

      setGameMap(map);
   }

}
