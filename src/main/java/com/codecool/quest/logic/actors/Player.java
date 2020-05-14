package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.actors.Actor;

public class Player extends Actor {
    public Player(Cell cell, int health) {
        super(cell, health);
    }

    public Player(Cell cell){
        super(cell);
    }

    public void pickUpItems(){
        if(this.getCell().getType() != CellType.FLOOR){
            this.getCell().setType(CellType.FLOOR);
        }
    }

    public String getTileName() {
        return "player";
    }
}
