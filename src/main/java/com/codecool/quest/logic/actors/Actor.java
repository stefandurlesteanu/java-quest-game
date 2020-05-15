package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health;
    private int damage;
    protected int playerDamage = 5;
    protected int skeletonDamage = 2;




    public Actor(Cell cell, int health, int damage) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.damage = damage;
    }

    public Actor(Cell cell){
        this(cell, 10, 2);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if ((nextCell.getType() != CellType.WALL) && (nextCell.getActor() == null)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if(nextCell.getActor() != null){
            attack(nextCell.getActor());
        }

    }

    public void attack(Actor opponent){
        int newHealth = opponent.getHealth() - this.getDamage();
        opponent.setHealth(newHealth);
        if (opponent.getHealth() > 0){
            cell.getActor().health -= opponent.getDamage();
        } else {
            opponent.getCell().setActor(null);
        }
        if (this.health <= 0){
            cell.setActor(null);
        }
    }



    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int newDamage) {
        this.damage = newDamage;
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
