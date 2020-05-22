package com.codecool.quest.logic;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    protected static ObservableList<String> listOfItems = FXCollections.observableArrayList();


    public static void display(String title){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        ListView<String> itemsView = new ListView<>();
        itemsView.getItems().addAll(listOfItems);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(itemsView ,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

    public static void addItem(String item){
        listOfItems.add(item);
    }
    public static void removeItem(String item) {listOfItems.remove(item);}

    public static ObservableList<String> getItems() {
        return listOfItems;
    }
}
