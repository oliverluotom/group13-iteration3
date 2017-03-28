package com.iteration3.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class StatusView extends VBox {
	
	Label terrainType, riverType, rotateOption;
	Button submitButton, removeButton; 
	Text selectTerrain, selectRiver;
	
	public StatusView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		terrainType = new Label("");
		riverType = new Label("");
		rotateOption = new Label("");
		
		submitButton = new Button("Create Tile");
		removeButton = new Button("Remove Tile");
		
		selectTerrain = new Text("Select the tile's terrain");
		selectRiver = new Text("Select the tile's river");
		
		initializeView();
	}
	
	public StatusView() {
		
		super(10);
		
		terrainType = new Label();
		riverType = new Label();
		rotateOption = new Label();
		
		submitButton = new Button("Create Tile");
		removeButton = new Button("Remove Tile");
		
		selectTerrain = new Text("Select the tile's terrain");
	    selectRiver = new Text("Select the tile's river");
		
		initializeView();
	}
	
	private void initializeView() {
		
		Label title = new Label("Map Building Menu");
		title.setFont(Font.font("Verdana", FontWeight.BOLD,30));
		
		this.setAlignment(Pos.TOP_CENTER);
		
		this.getChildren().add(title);
		
		
		this.getChildren().add(selectTerrain);
		
		this.getChildren().add(terrainType);
		
		
		this.getChildren().add(selectRiver);
		
		
		this.getChildren().add(riverType);
		
		
		this.getChildren().add(rotateOption);
		
		HBox horizontalPane = new HBox(10);
		horizontalPane.setAlignment(Pos.CENTER);
		
		horizontalPane.getChildren().addAll(submitButton,removeButton);
		
		
		this.getChildren().add(horizontalPane);
		
		selectTerrain.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		selectRiver.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,15));
		
		terrainType.setFont(Font.font(15));
		riverType.setFont(Font.font(15));
		rotateOption.setFont(Font.font(15));
		
		terrainType.setTextFill(Color.DARKGRAY);
		riverType.setTextFill(Color.DARKGRAY);
		rotateOption.setTextFill(Color.DARKGREY);
	}
	
	public void highlightTerrainOption() {
		selectTerrain.setFill(Color.BLUE);
		selectRiver.setFill(Color.BLACK);
		
		terrainType.setTextFill(Color.BLACK);
		rotateOption.setTextFill(Color.DARKGREY);
		riverType.setTextFill(Color.DARKGRAY);
	}
	
	public void highlightRiverOption() {
		selectRiver.setFill(Color.BLUE);
		selectTerrain.setFill(Color.BLACK);
		rotateOption.setTextFill(Color.BLACK);
		
		riverType.setTextFill(Color.BLACK);
		rotateOption.setTextFill(Color.DARKGREY);
		terrainType.setTextFill(Color.DARKGRAY);
	}
	
	public void highlightRotateOption() {
		rotateOption.setTextFill(Color.BLUE);
		selectTerrain.setFill(Color.BLACK);
		selectRiver.setFill(Color.BLACK);
		
		terrainType.setTextFill(Color.DARKGRAY);
		riverType.setTextFill(Color.DARKGRAY);
	}
	
	public void invalidateTerrainOption() {
		selectTerrain.setFill(Color.RED);
		selectRiver.setFill(Color.BLACK);
		rotateOption.setTextFill(Color.BLACK);
		
		terrainType.setTextFill(Color.DARKGREY);
		rotateOption.setTextFill(Color.DARKGREY);
		riverType.setTextFill(Color.DARKGRAY);
	}
	
	public void invalidateRiverOption() {
		selectRiver.setFill(Color.RED);
		selectTerrain.setFill(Color.BLACK);
		rotateOption.setTextFill(Color.BLACK);
		
		terrainType.setTextFill(Color.DARKGREY);
		rotateOption.setTextFill(Color.DARKGREY);
		riverType.setTextFill(Color.DARKGRAY);
	}
	
	public void invalidateRotateOption() {
		rotateOption.setTextFill(Color.RED);
		selectTerrain.setFill(Color.BLACK);
		selectRiver.setFill(Color.BLACK);
		
		terrainType.setTextFill(Color.DARKGREY);
		riverType.setTextFill(Color.DARKGRAY);
	}
	
	public void setTerrainType(String terrain) {
		terrainType.setText(terrain);
	}
	
	public void setRiverType(String river) {
		riverType.setText(river);
	}
	
	public void setRotateOption(String rotation) {
		rotateOption.setText(rotation);
	}
	
	public void setOnClickSubmit(EventHandler<ActionEvent> handler) {
		submitButton.setOnAction(handler);
		
	}
	
	public void setOnClickRemove(EventHandler<ActionEvent> handler) {
		removeButton.setOnAction(handler);
	}
}

