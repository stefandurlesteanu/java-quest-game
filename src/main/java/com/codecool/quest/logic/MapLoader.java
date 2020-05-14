package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.Player;
import com.codecool.quest.logic.actors.Scorpion;
import com.codecool.quest.logic.actors.Skeleton;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'k':
                            cell.setType(CellType.KEY);
                            break;
                        case 'g':
                            cell.setType(CellType.GUN);
                            break;
                        case 'd':
                            cell.setType(CellType.OPENDOOR);
                            break;
                        case 'D':
                            cell.setType(CellType.CLOSEDOOR);
                            break;
                        case 'o':
                            cell.setType(CellType.FLOOR);
                            new Scorpion(cell, 8);
                            break;
                        case '1':
                            cell.setType(CellType.TREE);
                            break;
                        case '2':
                            cell.setType(CellType.BUSH);
                            break;
                        case '3':
                            cell.setType(CellType.TREE2);
                            break;
                        case '4':
                            cell.setType(CellType.FLOWER);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
