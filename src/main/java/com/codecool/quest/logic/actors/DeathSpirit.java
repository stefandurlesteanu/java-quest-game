package com.codecool.quest.logic.actors;
import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import java.lang.reflect.Array;
import java.util.Random;

public class DeathSpirit extends Actor {
    private Actor toFollow;
    private Cell cell;

    public DeathSpirit(Cell cell,Actor toFollow){
        super(cell);
        this.toFollow = toFollow;
        this.cell=cell;
    }
    

    @Override
    public String getTileName(){ return "deathSpirit"; }
    public void move(){
//        int playerX = toFollow.getX();
//        int playerY = toFollow.getY();
//        int distanceX = playerX-cell.getX();
//        int distanceY = playerY-cell.getY();
//        System.out.println("Nr mutarii este " + moveCount + "  playerx = " + playerX + "  player y = " + playerY);
//        System.out.println("Nr mutarii este " + moveCount + "  enemyX = " + cell.getX() + "  enemyy = " + cell.getY());
//        System.out.println("Distanta x este " + distanceX + "   distanta y este " + distanceY);
//
//        Cell nextCell;
//        boolean hasMoved = false;
//        Random r = new Random();
//        while(hasMoved == false){
//            int randomMovement = r.nextInt((3-0)+1) + 0;
//            int xMove = movements[randomMovement][0];
//            int yMove = movements[randomMovement][1];
//            nextCell = cell.getNeighbor(xMove,yMove);
//            if (nextCell.getType() != CellType.WALL){
//                movementMechanics(nextCell);
//                hasMoved = true;
//            }
//
//        }
//        if((playerX != cell.getX()) && (playerY != cell.getY())){
//            if(cell.getNeighbor(1,0).getType() != CellType.WALL){
//                nextCell = cell.getNeighbor(1,0);
//                movementMechanics(nextCell);
//            } else if(cell.getNeighbor(-1,0).getType() != CellType.WALL){
//                nextCell = cell.getNeighbor(-1,0);
//                movementMechanics(nextCell);
//            } else if(cell.getNeighbor(0,1).getType() != CellType.WALL){
//                nextCell = cell.getNeighbor(0,1);
//                movementMechanics(nextCell);
//            } else if(cell.getNeighbor(0,-1).getType() != CellType.WALL){
//                nextCell = cell.getNeighbor(0,-1);
//                movementMechanics(nextCell);
//            }
//        }
//        if ((this.getX() < distanceX) && (cell.getNeighbor(1,0).getType() != CellType.WALL)){
//            System.out.println("Prima");
//            nextCell = cell.getNeighbor(1,0);
//            movementMechanics(nextCell);
//        } else if((this.getX() > distanceX) && (cell.getNeighbor(-1,0).getType() != CellType.WALL)){
//            System.out.println("A doua");
//            nextCell = cell.getNeighbor(-1,0);
//            movementMechanics(nextCell);}
//        else if ((this.getY() < distanceY) && (cell.getNeighbor(0,1).getType() != CellType.WALL)){
//            System.out.println("A treia");
//            nextCell = cell.getNeighbor(0,1);
//            movementMechanics(nextCell);
//        } else if((this.getY() > distanceY) && (cell.getNeighbor(0,-1).getType() != CellType.WALL)){
//            System.out.println("A patra");
//            nextCell = cell.getNeighbor(0,-1);
//            movementMechanics(nextCell);
//        }

//        Cell nextCell = cell.getNeighbor(1,0);
//        if (nextCell.getType() != CellType.WALL){
//            cell.setActor(null);
//            nextCell.setActor(this);
//            cell=nextCell;
//        }
//        if(playerX > this.getCell().getX()){
//            nextCell = this.getCell().getNeighbor(1,0);
//            if (nextCell.getType() != CellType.WALL){
//                this.getCell().setActor(null);
//                nextCell.setActor(this);
//            }
//        } else if(playerY < this.getCell().getX()){
//            nextCell = this.getCell().getNeighbor(-1,0);
//            if (nextCell.getType() != CellType.WALL){
//                this.getCell().setActor(null);
//                nextCell.setActor(this);
//            }
//        }
//        if(playerY > this.getCell().getY()){
//            nextCell = this.getCell().getNeighbor(0,1);
//            if (nextCell.getType() != CellType.WALL){
//                this.getCell().setActor(null);
//                nextCell.setActor(this);
//            }
//        } else if(playerY < this.getCell().getY()){
//            nextCell = this.getCell().getNeighbor(0,-1);
//            if(nextCell.getType() != CellType.WALL){
//                this.getCell().setActor(null);
//                nextCell.setActor(this);
//            }
//        }

    }
}
