package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileMap {

    public static final int TILE_SIZE = 64;
    int width;
    int height;
    byte tiles[][];

    public int scrollX;

    public TileMap()
    {

    }

    void loadFromLevel(Level l)
    {
        width = l.getMapWidth();
        height = l.getMapHeight();

        tiles = new byte[height][];

        for(int i = 0; i < height; i++)
        {
            tiles[i] = new byte[width];
        }

        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
            {
                tiles[i][j] = l.getTileMap()[i][j];
            }
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
                    shapeRenderer.rect(TILE_SIZE * i - scrollX, TILE_SIZE * j, TILE_SIZE, TILE_SIZE);
                    shapeRenderer.setColor(Color.FIREBRICK);
                    shapeRenderer.rect(TILE_SIZE * i + 6 - scrollX, TILE_SIZE * j + 6, TILE_SIZE - 12, TILE_SIZE - 12);
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
        if(mapX >= width) mapX = width - 1;
        if(mapY >= height) mapY = height - 1;

        return tiles[mapY][mapX] != 0;
    }

    int nearestFloor(int x, int y)
    {
        int mapX = x / TILE_SIZE;
        int mapY = y / TILE_SIZE;

        if(mapX < 0) mapX = 0;
        if(mapY < 0) mapY = 0;
        if(mapX >= width) mapX = width - 1;
        if(mapY >= height) mapY = height - 1;

        while(mapY < height && tiles[mapY][mapX] == 0)
        {
            mapY++;
        }

        if(mapY >= height)
        {
            return 9999;
        }
        else
        {
            return mapY * TILE_SIZE;
        }
    }

    int nearestCeiling(int x, int y)
    {
        int mapX = x / TILE_SIZE;
        int mapY = y / TILE_SIZE;

        if(mapX < 0) mapX = 0;
        if(mapY < 0) mapY = 0;
        if(mapX >= width) mapX = width - 1;
        if(mapY >= height) mapY = height - 1;

        while(mapY >= 0 && tiles[mapY][mapX] == 0)
        {
            mapY--;
        }

        if(mapY < 0)
        {
            return -9999;
        }
        else
        {
            return ((mapY + 1) * TILE_SIZE) - 1;
        }
    }
}
