package com.iteration3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameWindow extends BorderPane {
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
        this.setCenter(mapView);
        this.setBottom(statusView);
    }
    
    public void highlightTerrainOption() {
    	statusView.highlightTerrainOption();
    }
    
    public void highlightRiverOption() {
		statusView.highlightRiverOption();
	}
	
	public void highlightRotateOption() {
		statusView.highlightRotateOption();
	}
	
	public void invalidateTerrainOption() {
		statusView.invalidateTerrainOption();
	}
	
	public void invalidateRiverOption() {
		statusView.invalidateRiverOption();
	}
	
	public void invalidateRotateOption() {
		statusView.invalidateRotateOption();
	}
	
	public void setTerrainType(String terrain) {
		statusView.setTerrainType(terrain);
	}
	
	public void setRiverType(String river) {
		statusView.setRiverType(river);
	}
	
	public void setRotateOption(String rotation) {
		statusView.setRotateOption(rotation);
	}
	
	public void setOnClickSubmit(EventHandler<ActionEvent> handler) {
		statusView.setOnClickSubmit(handler);
	}
	
	public void setOnClickRemove(EventHandler<ActionEvent> handler) {
		statusView.setOnClickRemove(handler);
	}
	
	public void addKeyHandler(EventHandler <KeyEvent> handler) {
		this.setOnKeyPressed(handler);
	}

	public void moveCursorNW(){}
	public void moveCursorNE(){}
	public void moveCursorSW(){}
	public void moveCursorSE(){}
	public void moveCursorNorth(){}
	public void moveCursorSouth(){}
}
