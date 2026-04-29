/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.abberkeep.game.tutorial.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import org.abberkeep.game.test.SimpleRenderMap;
import org.abberkeep.gameframework.animation.Animation;
import org.abberkeep.gameframework.animation.BlockAnimation;
import org.abberkeep.gameframework.background.FixedBackground;
import org.abberkeep.gameframework.screen.BaseScreen;

/**
 * Title: ComponentScreen
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Apr 5, 2026
 * @author Gary Deken
 * @version
 */
public class ComponentScreen extends BaseScreen {
   private Stage stage;
   private Label label1;
   private Label label1a;
   private Label label1b;
   private Label label2;
   private Label label3;

   @Override
   public void show() {
      stage = new Stage(viewport);
      Gdx.input.setInputProcessor(stage);
      int row_height = height / 15;
      int col_width = width / 15;

      Label.LabelStyle label1Style = new Label.LabelStyle();
      BitmapFont myFont = new BitmapFont(Gdx.files.internal("Battlestar-24.fnt"));
      label1Style.font = myFont;
      label1Style.fontColor = Color.RED;
      //Label.LabelStyle label1Style = new Label.LabelStyle(myFont, Color.BLUE);

      label1 = new Label("Title -BitmapFont-", label1Style);
      label1.setSize(width, row_height);
      label1.setPosition(0, height - row_height * 1);
      label1.setAlignment(Align.center);
      label1a = new Label("Title (BitmapFont)", label1Style);
      label1a.setSize(width, row_height);
      label1a.setPosition(0, height - row_height * 2);
      label1a.setAlignment(Align.center);
      label1b = new Label("Third Title", label1Style);
      label1b.setSize(width / 2, row_height);
      label1b.setPosition(0, height - row_height * 3);
      label1b.setAlignment(Align.center);
      Skin mySkin = new Skin(Gdx.files.internal("glassy-ui.json"));

      //label2 = new Label("This is a Label (skin)", mySkin, "black");
      label2 = new Label("This is a Label (skin)", mySkin, "big-black");
      label2.setSize(width / 15, row_height);
      label2.setPosition(col_width * 2, height - row_height * 5);

      label3 = new Label("This is a Label (skin) with wrap, this is making it longer then the previous label.", mySkin,
         "black");
      label3.setSize(width / 15 * 5, row_height);
      label3.setPosition(col_width * 2, height - row_height * 6);
      label3.setWrap(true);
      int yb = Gdx.graphics.getHeight() - row_height * 3;

      setStageComponents(mySkin, col_width, row_height);
      SimpleRenderMap map = new SimpleRenderMap() {
         @Override
         public void render(float deltaTime, SpriteBatch batch) {
            // Labels
            //label1.draw(batch, 1);
            //label1a.draw(batch, .5f);
            //label1b.draw(batch, .25f);
            //label2.draw(batch, 1);
            //label3.draw(batch, 1);
         }
      };

      Animation bg = new BlockAnimation(Gdx.graphics.getWidth(), height);
      bg.setColor(Color.WHITE);

      map.setBackground(new FixedBackground(bg, false));

      setGameMap(map);
   }

   private void setStageComponents(Skin mySkin, int col_width, int row_height) {
      int yLoc = Gdx.graphics.getHeight() - row_height;
      Label.LabelStyle label1Style = new Label.LabelStyle();
      BitmapFont myFont = new BitmapFont(Gdx.files.internal("Battlestar-24.fnt"));
      label1Style.font = myFont;
      label1Style.fontColor = Color.RED;
      // label
      Label outputLabel = new Label("-", label1Style);
      outputLabel.setSize(width, row_height);
      outputLabel.setPosition(0, yLoc);
      outputLabel.setAlignment(Align.center);
      stage.addActor(outputLabel);
      // button
      Button button1 = new TextButton("Text Button", mySkin, "small");
      button1.setSize(width / 3, row_height);
      button1.setPosition(col_width * 2, yLoc - row_height);
      InputListener inputListener = new InputListener() {
         @Override
         public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            outputLabel.setText("Press the Button");
         }

         @Override
         public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            outputLabel.setText("Button Pressed");
            return true;
         }
      };
      button1.addListener(inputListener);
      //stage.addActor(button1);
      // image button
      ImageButton imageButton = new ImageButton(mySkin);
      imageButton.addListener(inputListener);
      //imageButton.setSize(width / 4, row_height);
      imageButton.setPosition(col_width * 7, yLoc - row_height * 3);
      //stage.addActor(imageButton);
      // check box
      CheckBox checkBox = new CheckBox("Text for the check", mySkin);
      checkBox.setPosition(col_width * 2, yLoc - row_height * 2);
      ChangeListener changeListener = new ChangeListener() {
         @Override
         public void changed(ChangeListener.ChangeEvent event, Actor actor) {
            boolean isChecked = checkBox.isChecked();
            outputLabel.setText("Checkbox is now: " + (isChecked ? "On" : "Off"));
         }
      };
      checkBox.addListener(changeListener);
      //stage.addActor(checkBox);
      // slider
      Slider slider = new Slider(0, 10, 1, false, mySkin);
      slider.setPosition(col_width * 2, yLoc - row_height * 3);
      ChangeListener slidListener = new ChangeListener() {
         @Override
         public void changed(ChangeEvent event, Actor actor) {
            float value = slider.getValue();
            // Update game volume, brightness, or player speed
            outputLabel.setText("Slider value: " + value);
         }
      };
      slider.addListener(slidListener);
      //stage.addActor(slider);
      // text field
      TextField textField = new TextField("Sample Test for text Field", mySkin);
      textField.setPosition(col_width * 2, yLoc - row_height * 4);
      textField.setSize(300, row_height);
      //stage.addActor(textField);
      // text area
      TextArea textArea = new TextArea("Sample Text", mySkin);
      textArea.setPosition(col_width * 7, yLoc - row_height * 12);
      textArea.setSize(400, 300);
      stage.addActor(textArea);
   }

   @Override
   public void render(float deltaTime) {
      super.render(deltaTime);
      ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
      stage.act(deltaTime);
      stage.draw();
   }

}
