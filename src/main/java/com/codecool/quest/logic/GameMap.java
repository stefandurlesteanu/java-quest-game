package com.codecool.quest.logic;

import com.codecool.quest.Tiles;
import com.codecool.quest.logic.actors.DeathSpirit;
import com.codecool.quest.logic.actors.Player;
import com.codecool.quest.logic.actors.Scorpion;
import com.codecool.quest.logic.actors.Skeleton;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private DeathSpirit deathSpirit;
    private Scorpion scorpion;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setDeathSpirit(DeathSpirit deathSpirit) {this.deathSpirit = deathSpirit;}
    public void setScorpion(Scorpion scorpion) {this.scorpion = scorpion;}

    public Scorpion getScorpion() {return scorpion;}
    public Player getPlayer() {
        return player;
    }
    public DeathSpirit getSpirit(){ return deathSpirit;}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
