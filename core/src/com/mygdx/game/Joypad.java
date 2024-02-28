package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class Joypad implements InputProcessor {

    class Button {

        Rectangle rect;
        String action;
        boolean pressed;


        Button(int x, int y, int sx, int sy, String action)
        {
            rect = new Rectangle(x, y, sx, sy);
            this.action = action;
            pressed = false;
        }
    }

    ArrayList<Button> buttons;
    final OrthographicCamera camera;

    public Joypad(OrthographicCamera camera)
    {
        this.camera = camera;
        buttons = new ArrayList<>();

        Gdx.input.setInputProcessor(this);

    }

    public void addButton(int x, int y, int sx, int sy, String action)
    {
        Button b = new Button(x, y, sx, sy, action);
        buttons.add(b);
    }

    public void render(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = 0; i < buttons.size(); i++)
        {
            Button b = buttons.get(i);
            shapeRenderer.setColor(b.pressed ? Color.YELLOW : Color.BLACK);
            shapeRenderer.ellipse(b.rect.x, b.rect.y, b.rect.width, b.rect.height, 2);
            shapeRenderer.rect(b.rect.x, b.rect.y, b.rect.width, b.rect.height);
        }
        shapeRenderer.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {

        Vector3 touchPos = new Vector3();
        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(touchPos);

        for(int i = 0; i < buttons.size(); i++)
        {
            if(buttons.get(i).rect.contains(touchPos.x,touchPos.y))
            {
                buttons.get(i).pressed = true;
            }
        }

        return true; // return true to indicate the event was handled
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        // your touch up code here
        for(int i = 0; i < buttons.size(); i++)
        {
            buttons.get(i).pressed = false;
        }
        return true; // return true to indicate the event was handled
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
