package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileMap {

    static final int TILE_SIZE = 64;
    int width = 14;
    int height = 8;
    byte tiles[][] = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public TileMap()
    {

    }

    public void render(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int j = 0; j < height; j++)
            for(int i = 0; i < width; i++)
            {
                if(tiles[j][i] != 0)
                {
                    shapeRenderer.setColor(Color.OLIVE);
                    shapeRenderer.rect(TILE_SIZE * i, TILE_SIZE * j, TILE_SIZE, TILE_SIZE);
                    shapeRenderer.setColor(Color.FIREBRICK);
                    shapeRenderer.rect(TILE_SIZE * i + 6, TILE_SIZE * j + 6, TILE_SIZE - 12, TILE_SIZE - 12);
                }
            }
        shapeRenderer.end();
    }

    boolean isSolid(int x, int y)
    {
        int mapX = x / TILE_SIZE;
        int mapY = y / TILE_SIZE;

        if(mapX < 0) mapX = 0;
        if(mapY < 0) mapY = 0;
        if(mapX >= width * TILE_SIZE) mapX = (width * TILE_SIZE) - 1;
        if(mapY >= height * TILE_SIZE) mapY = (height * TILE_SIZE) - 1;

        return tiles[mapY][mapX] != 0;
    }

}
