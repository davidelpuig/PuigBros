package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    PuigBros game;

    public GameScreen(PuigBros game)
    {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1, 0, 0, 1);
        game.batch.begin();
        //game.batch.draw(img, 0, 0);
        game.batch.end();

        game.shapeRenderer.begin();
        game.shapeRenderer.circle(100,100,75);
        game.shapeRenderer.end();
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
