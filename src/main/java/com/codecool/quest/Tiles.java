package com.codecool.quest;

import com.codecool.quest.logic.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int zoom = 1;
    public static int TILE_WIDTH = 32/zoom;


    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();

    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH*zoom + 2);
            y = j * (TILE_WIDTH*zoom + 2);
            w = TILE_WIDTH*zoom;
            h = TILE_WIDTH*zoom;
        }
    }

    static {
        //Actors
        tileMap.put("scorpion", new Tile(24,5));
        tileMap.put("nakedPlayer", new Tile(25, 0));
        tileMap.put("swordPlayer", new Tile(27, 0));
        tileMap.put("armorSwordPlayer", new Tile(28, 0));
        tileMap.put("armorPlayer", new Tile(30, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        //Buildings
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("openDoor", new Tile(11,10));
        tileMap.put("closeDoor", new Tile(9,10));
        //Inventory
        tileMap.put("key", new Tile(16,23));
        tileMap.put("axe", new Tile(6,30));
        tileMap.put("armor", new Tile(0,23));
        //Nature
        tileMap.put("tree", new Tile(0,1));
        tileMap.put("bush", new Tile(5,0));
        tileMap.put("tree2", new Tile(3,1));
        tileMap.put("flower", new Tile(15,6));

    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }

    public static void setZoom(int newZoom){
        zoom = newZoom;
    }

    public static int getZoom(){
        return zoom;
    }
}
