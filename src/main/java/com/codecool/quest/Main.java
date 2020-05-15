package com.codecool.quest;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.GameMap;
import com.codecool.quest.logic.Inventory;
import com.codecool.quest.logic.MapLoader;
import com.codecool.quest.logic.actors.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            ((map.getWidth() * Tiles.TILE_WIDTH)),
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label damageLabel = new Label();
    Label armorLabel = new Label();


    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));
        ui.setVgap(5);
        ui.setHgap(5);
        Button pickUpButton = new Button("Pick Up Item");
        pickUpButton.setOnAction(e -> {
            map.getPlayer().pickUpItems();
            refresh();
        });
        Button inventory = new Button("Inventory");
        inventory.setOnAction(e -> Inventory.display("Inventory"));



        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);
        ui.add(new Label("Damage: "),0,1);
        ui.add(damageLabel,1,1);
        ui.add(new Label("Armor: "),0,2);
        ui.add(armorLabel,1,2);
        ui.add(pickUpButton,0,3);
        ui.add(inventory,1,3);


        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);


        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.addEventFilter(KeyEvent.KEY_PRESSED,this::onKeyPressed);

        primaryStage.setTitle("Codecool Quest");
        primaryStage.show();

    }

    private void onKeyPressed(KeyEvent keyEvent) {
        if(!(map.getPlayer().getHealth() <= 0)) {
            switch (keyEvent.getCode()) {
                case UP:
                    map.getPlayer().move(0, -1);
                    refresh();
                    break;
                case DOWN:
                    map.getPlayer().move(0, 1);
                    refresh();
                    break;
                case LEFT:
                    map.getPlayer().move(-1, 0);
                    refresh();
                    break;
                case RIGHT:
                    map.getPlayer().move(1, 0);
                    refresh();
                    break;
            }
        }
    }





    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }

        healthLabel.setText("" + map.getPlayer().getHealth());
        damageLabel.setText("" + map.getPlayer().getDamage());
        armorLabel.setText("" + map.getPlayer().getArmor());
    }
}
