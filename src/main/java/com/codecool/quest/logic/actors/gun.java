package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class gun extends Actor {
    public gun(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "gun";
    }
}
