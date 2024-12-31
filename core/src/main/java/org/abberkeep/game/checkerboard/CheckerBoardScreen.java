/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.checkerboard;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.animation.LoopAnimation;
import org.abberkeep.gameframework.animation.StaticAnimation;
import org.abberkeep.gameframework.background.Background;
import org.abberkeep.gameframework.background.FixedBackground;
import org.abberkeep.gameframework.motion.Motion;
import org.abberkeep.gameframework.motion.SingleMotion;
import org.abberkeep.gameframework.movement.MouseDragMovement;
import org.abberkeep.gameframework.movement.Movement;
import org.abberkeep.gameframework.screen.SimpleScreen;

/**
 * Title: CheckerBoardScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Sep 21, 2024
 * @author Gary Deken
 * @version
 */
public class CheckerBoardScreen extends SimpleScreen {

   @Override
   public void show() {
      Background bg = new FixedBackground(new StaticAnimation(getTexture("Board.jpg")), true);

      setBackground(bg);

      Chip chipRed1 = buildChip(getTexture("RedChip.png"), getTexture("RedChipMove.png"));
      chipRed1.setLocation(100, 100);
      Chip chipBlack1 = buildChip(getTexture("BlackChip.png"), getTexture("BlackChipMove.png"));
      chipBlack1.setLocation(300, 100);

      addActor(chipRed1);
      addActor(chipBlack1);
   }

   private Chip buildChip(Texture stillTexture, Texture moveTexture) {
      Motion stillMotion = new SingleMotion(new StaticAnimation(stillTexture));
      Animation animation = new LoopAnimation(.2f, TextureRegion.split(moveTexture, 100, 100)[0]);
      Motion move = new SingleMotion(animation);
      Movement movement = new MouseDragMovement(Input.Buttons.LEFT);

      Chip chip = new Chip(movement, move, stillMotion);

      return chip;
   }

}
