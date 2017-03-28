package com.iteration3.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class GameWindow extends VBox {
    private MenuBar menuBar;
    private MapView mapView;
    private StatusView statusView;


    public GameWindow(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        initializeWindow();
    }

    private void initializeWindow() {
        this.mapView = new MapView(this.getWidth(), (2.0/3)*this.getHeight());
        this.statusView = new StatusView(this.getWidth(),(1.0/3)*this.getHeight());
        this.menuBar = new MenuBar();
        this.menuBar.prefWidthProperty().bind(this.widthProperty());

        Menu fileMenu = new Menu("File");
        MenuItem newMap = new MenuItem("Create New Map");
        MenuItem importMapFileItem = new MenuItem("Import Map File...");
        MenuItem exportMapFileItem = new MenuItem("Export Map File...");
        fileMenu.getItems().add(newMap);
        fileMenu.getItems().add(importMapFileItem);
        fileMenu.getItems().add(exportMapFileItem);
        this.menuBar.getMenus().add(fileMenu);

        //TODO: Add Status View to the addAll() call below
        this.getChildren().addAll(menuBar, mapView, statusView);
    }
}
