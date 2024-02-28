package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    PuigBros game;
    Joypad joypad;

    public GameScreen(PuigBros game)
    {
        this.game = game;

        // Create joypad
        joypad = new Joypad(game.camera);
        joypad.addButton(40,80, 60, 60, "Left");
        joypad.addButton(160,80, 60, 60, "Right");
        joypad.addButton(100,20, 60, 60, "Down");
        joypad.addButton(100,140, 60, 60, "Up");



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        game.camera.update();

        ScreenUtils.clear(1, 0, 0, 1);

        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        //game.batch.draw(game.img, 0, 0);
        game.batch.end();

        game.shapeRenderer.setProjectionMatrix(game.camera.combined);
        game.shapeRenderer.begin();
        game.shapeRenderer.setColor(Color.YELLOW);
        game.shapeRenderer.line(0,0,800,480);
        game.shapeRenderer.end();
        joypad.render(game.shapeRenderer);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
