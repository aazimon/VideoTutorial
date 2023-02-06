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
package test.java;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.abberkeep.gameframework.screen.BaseScreen;

/**
 * Title: ShapeExample
 *
 * <p>
 * Description: </p>
 *
 * Copyright (c) Feb 4, 2023
 * @author Gary Deken
 * @version
 */
public class ShapeExample extends BaseScreen {

   public ShapeExample() {
      super(0, 0);
   }

   @Override
   public void show() {
   }

   @Override
   protected void renderChild(float deltaTime) {
      float y = 20;
      batch.end();
      ShapeRenderer shape = new ShapeRenderer();
      //shape.setProjectionMatrix(matrix);
      shape.begin(ShapeRenderer.ShapeType.Line);
      shape.setColor(Color.RED);
//      shape.rect(150, y, 128, 128);
//      shape.arc(60, y+60, 50, 10, 30);
//      shape.circle(60, y + 60, 50);
//      shape.ellipse(60, y + 60, 20, 40, 20f);
//      shape.line(10, y, 30, 100);
//      shape.triangle(10, y, 50, 20, 10, 80);
      shape.end();
      batch.flush();
      batch.begin();
   }
}
