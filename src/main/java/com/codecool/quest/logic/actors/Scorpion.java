package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.GameMap;
import com.codecool.quest.logic.MapLoader;
import com.codecool.quest.logic.actors.Actor;

public class Scorpion extends Actor {
    public Scorpion(Cell cell, int health, int damage, int armor) {
        super(cell, health, damage, armor);
    }
    

    @Override
    public String getTileName() {
        return "scorpion";
    }
}
