package com.iteration3.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatusView extends VBox {
	
	Label terrainType, riverType, rotateOption;
	Button submitButton, removeButton; 
	Text selectTerrain, selectRiver;
	
	public StatusView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		terrainType = new Label();
		riverType = new Label();
		rotateOption = new Label();
		
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
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(selectTerrain,terrainType,selectRiver, riverType,rotateOption);
		
		HBox horizontalPane = new HBox(10);
		horizontalPane.setAlignment(Pos.CENTER);
		
		horizontalPane.getChildren().addAll(submitButton,removeButton);
		
		this.getChildren().add(horizontalPane);
	}
	
	protected void add(Node node) {
		this.getChildren().add(node);
	}
	
	public void highlightTerrainOption() {
		selectTerrain.setFill(Color.BLUE);
		selectRiver.setFill(Color.BLACK);
		rotateOption.setTextFill(Color.BLACK);
		
	}
	
	public void highlightRiverOption() {
		selectRiver.setFill(Color.BLUE);
		selectTerrain.setFill(Color.BLACK);
		rotateOption.setTextFill(Color.BLACK);
	}
	
	public void highlightRotateOption() {
		rotateOption.setTextFill(Color.BLUE);
		selectTerrain.setFill(Color.BLACK);
		selectRiver.setFill(Color.BLACK);
	}
	
	public void invalidateTerrainOption() {
		selectTerrain.setFill(Color.RED);
		selectRiver.setFill(Color.BLACK);
		rotateOption.setTextFill(Color.BLACK);
	}
	
	public void invalidateRiverOption() {
		selectRiver.setFill(Color.RED);
		selectTerrain.setFill(Color.BLACK);
		rotateOption.setTextFill(Color.BLACK);
	}
	
	public void invalidateRotateOption() {
		rotateOption.setTextFill(Color.RED);
		selectTerrain.setFill(Color.BLACK);
		selectRiver.setFill(Color.BLACK);
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
}

