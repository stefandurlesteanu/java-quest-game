package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.actors.Actor;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public void pickUpItems(){
        System.out.println(this.getCell().getType());
    }

    public String getTileName() {
        return "player";
    }
}
