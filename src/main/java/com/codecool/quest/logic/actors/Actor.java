package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health;
    protected int playerDamage = 5;
    protected int skeletonDamage = 2;


    public Actor(Cell cell, int health) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
    }

    public Actor(Cell cell){
        this(cell, 10);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
//        System.out.println(nextCell.getType());
        if ((nextCell.getType() != CellType.WALL) && (nextCell.getActor() == null)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if(nextCell.getActor().getTileName().equals("skeleton")){
            attack(nextCell.getActor());
        }

    }

    public void attack(Actor opponent){
        opponent.health -= playerDamage;
        cell.getActor().health -= skeletonDamage;
        if(opponent.health <=0){
            opponent.getCell().setActor(null);
        }
        if (this.health <= 0){
            cell.setActor(null);
        }
    }



    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
