package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Scorpion extends Actor {
    public Scorpion(Cell cell, int health, int damage) {
        super(cell, health, damage);
    }

    public Scorpion(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "scorpion";
    }
}
