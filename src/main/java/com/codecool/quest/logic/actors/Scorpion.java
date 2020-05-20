package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;

import java.util.Random;


public class Scorpion extends Actor {
    private Cell cell;
    public Scorpion(Cell cell, int health, int damage, int armor) {
        super(cell, health, damage, armor);
        this.cell=cell;
    }
    private int[][] movements = {{1,0},{-1,0},{0,1},{0,-1}};
    private void movementMechanics(Cell nextCell){
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    @Override
    public String getTileName() {
        return "scorpion";
    }

    public void move() {
        Cell nextCell;
        boolean hasMoved = false;
        Random r = new Random();
        while (hasMoved == false) {
            int randomMovement = r.nextInt((3 - 0) + 1) + 0;
            int xMove = movements[randomMovement][0];
            int yMove = movements[randomMovement][1];
            nextCell = cell.getNeighbor(xMove, yMove);
            if((nextCell.getActor() == null ) && (nextCell.getType() != CellType.WALL)){
                movementMechanics(nextCell);
                hasMoved = true;
            }
            if(this.getHealth() < 0){
                cell.setActor(null);
            }
        }
    }
}
