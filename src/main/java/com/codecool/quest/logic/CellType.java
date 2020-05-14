package com.codecool.quest.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    KEY("key"),
    GUN("gun"),
    OPENDOOR("openDoor"),
    CLOSEDOOR("closeDoor"),
    TREE("tree"),
    BUSH("bush"),
    TREE2("tree2"),
    FLOWER("flower");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
