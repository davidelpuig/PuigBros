package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.Rectangle;

public class WalkingCharacter extends GameEntity {

    static final float GRAVITY = 300.f;
    TileMap map;

    protected boolean falling;

    public void setMap(TileMap map) {
        this.map = map;
    }

    public WalkingCharacter()
    {
        super();
        falling = false;
    }

    @Override
    public void act(float delta) {

        if(map.isSolid((int)(getX() - getWidth()/2),(int)(getY()+ getHeight()/2+delta*speed.y)) ||
                map.isSolid((int)(getX() + getWidth()/2),(int)(getY()+ getHeight()/2+delta*speed.y))
            )
        {
            falling = false;
            speed.y = 0;
        }
        else
        {
            falling = true;
            speed.y += delta*GRAVITY;
        }

        if(     speed.x > 0 && (
                map.isSolid((int)(getX() + getWidth()/2 + delta * speed.x), (int)(getY() - getHeight()*0.25f)) ||
                map.isSolid((int)(getX() + getWidth()/2 + delta * speed.x), (int)(getY() + getHeight()*0.25f))
                )
        )
        {
            speed.x = 0;
        }
        if(     speed.x < 0 && (
                map.isSolid((int)(getX() - getWidth()/2 + delta * speed.x), (int)(getY() - getHeight()*0.25f)) ||
                        map.isSolid((int)(getX() - getWidth()/2 + delta * speed.x), (int)(getY() + getHeight()*0.25f))
        )
        )
        {
            speed.x = 0;
        }
        super.act(delta);
    }

    @Override
    public void drawDebug(ShapeRenderer shapes) {
        super.drawDebug(shapes);

        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(Color.NAVY);
        shapes.rect(getX() - getWidth()*0.5f, getY() - getHeight()*0.5f, getWidth(), getHeight());
        shapes.end();
    }
}
