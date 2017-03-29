package com.iteration3.view;

import com.iteration3.controller.MapFileController;
import com.iteration3.model.map.Location;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;

public class GameWindow extends BorderPane {
    private MenuBar menuBar;
    private MenuItem importMapFileItem, exportMapFileItem;
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
        importMapFileItem = new MenuItem("Import Map File...");
        exportMapFileItem = new MenuItem("Export Map File...");
        fileMenu.getItems().add(newMap);
        fileMenu.getItems().add(importMapFileItem);
        fileMenu.getItems().add(exportMapFileItem);
        this.menuBar.getMenus().add(fileMenu);

        //TODO: Add Status View to the addAll() call below
		this.setTop(menuBar);
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

	public void drawRiver(String imageURL, int x, int y) {
    	mapView.drawRiver(imageURL, x, y);
	}

	public void drawTile(String imageURL, int x, int y) {
		mapView.drawTile(imageURL, x, y);
	}

	public void update(){
    	mapView.update();
	}

	public void moveCursorNW(){
		mapView.moveCursorNW();
	}
	public void moveCursorNE(){
		mapView.moveCursorNE();
	}
	public void moveCursorSW(){
		mapView.moveCursorSW();
	}
	public void moveCursorSE(){
		mapView.moveCursorSE();
	}
	public void moveCursorNorth(){
		mapView.moveCursorNorth();
	}
	public void moveCursorSouth(){
		mapView.moveCursorSouth();
	}

	public Location getCursorLocation(){
		return mapView.getCursorLocation();
	}

	public void disableSubmit() {
		statusView.invalidateSubmit();
	}
	
	public void enableSubmit() {
		statusView.validateSumbit();
	}

	public void setOnClickImport(EventHandler<ActionEvent> handler){
		importMapFileItem.setOnAction(handler);
	} // TODO
	public void setOnClickExport(EventHandler<ActionEvent> handler){
		exportMapFileItem.setOnAction(handler);
	} // TODO

}
