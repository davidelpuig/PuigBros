package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    PuigBros game;
    Joypad joypad;

    Stage stage;
    TileMap tileMap;

    Player player;

    public GameScreen(PuigBros game)
    {
        this.game = game;

        // Create joypad
        joypad = new Joypad(game.camera);
        joypad.addButton(40,340, 60, 60, "Left");
        joypad.addButton(160,340, 60, 60, "Right");
        joypad.addButton(100,400, 60, 60, "Down");
        joypad.addButton(100,280, 60, 60, "Up");
        joypad.addButton(700,340, 60, 60, "Jump");

        tileMap = new TileMap();
        stage = new Stage();
        player = new Player();
        player.setMap(tileMap);
        player.setJoypad(joypad);
        stage.addActor(player);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        // Render step =============================================
        game.camera.update();

        ScreenUtils.clear(Color.SKY);

        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        //game.batch.draw(game.img, 0, 0);
        game.batch.end();

        game.shapeRenderer.setProjectionMatrix(game.camera.combined);
        /*game.shapeRenderer.begin();
        game.shapeRenderer.setColor(Color.YELLOW);
        game.shapeRenderer.line(0,0,800,480);
        game.shapeRenderer.end();*/
        tileMap.render(game.shapeRenderer);
        stage.draw();
        player.drawDebug(game.shapeRenderer);
        joypad.render(game.shapeRenderer);

        // Update step =============================================
        stage.act(delta);
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
