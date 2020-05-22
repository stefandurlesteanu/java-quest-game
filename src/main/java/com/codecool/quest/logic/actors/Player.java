package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Player extends Actor {
    private String equipment = "nakedPlayer";
    private boolean isArmorAlready = false;
    private final ArrayList<String> inventory = new ArrayList<>(Arrays.asList("armor", "axe", "key"));


    public Player(Cell cell, int health, int damage, int armor) {
        super(cell, health, damage, armor);
    }


    public Player(Cell cell){
        super(cell);
    }

    public void pickUpItems(){
        if((this.getCell().getType() != CellType.FLOOR) && (inventory.contains(this.getCell().getTileName()))){
            Inventory.addItem(this.getCell().getTileName());
            this.getCell().setType(CellType.FLOOR);
        }
        if(Inventory.getItems().contains("axe")){
            this.setDamage(5);
            equipment = "swordPlayer";
            if((Inventory.getItems().contains("axe")) && (Inventory.getItems().contains("armor"))){
                equipment = "armorSwordPlayer";
            }
        }
        if((Inventory.getItems().contains("armor")) && (isArmorAlready == false)){
            System.out.println(isArmorAlready);
            this.setArmor(5);
            equipment = "armorPlayer";
            isArmorAlready = true;
        }

    }


    public String getTileName() {
        return equipment;
    }
    public void setEquipment(String equipment){
        this.equipment=equipment;
    }
    public String getEquipment(){
        return this.equipment;
    }
}
