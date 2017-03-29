package com.iteration3.controller;
/*--------------------------------------------------------------------------------------
|    StatusController: Created by Ricardo on 3/28/17.
|---------------------------------------------------------------------------------------
|   Controller responsible for defining actions related to cycling through tiles
|   options and finally submitting a tile for creation
---------------------------------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javafx.scene.input.KeyCode;

import com.iteration3.model.GameModel;
import com.iteration3.model.map.Map;
import com.iteration3.model.tile.*;
import com.iteration3.view.GameWindow;

public class StatusController {
    
	GameModel model; 
	GameWindow window;
    HashMap<KeyCode,Action> keyMap;
    HashMap<String, Terrain> terrainMap;
    HashMap<String,ArrayList<Integer>> riverMap; 
    ArrayList<String> terrainTypes;
    ArrayList<String> riverTypes;
    
    int selectedTerrainIndex;
    int selectedRiverIndex;
   
    StatusControllerState currentState;
    StatusControllerState selectTerrain;
    StatusControllerState selectRiver;
    StatusControllerState rotateState;
    
    
    public StatusController(GameModel model, GameWindow window, HashMap<KeyCode,Action> keyMap){
        this.model = model;
        this.keyMap = keyMap;
        this.window = window;
        
        terrainMap = new HashMap<>();
        riverMap = new HashMap<>();
        terrainTypes = new ArrayList<>();
        riverTypes = new ArrayList<>();
        
        intializeTerrainOptions();
        intializeRiverOptions();
        
        selectedTerrainIndex = 0;
        selectedRiverIndex = 0;
        
        window.setTerrainType(terrainTypes.get(selectedTerrainIndex));
        window.setRiverType(riverTypes.get(selectedRiverIndex));
        window.setRotateOption("Rotate Tile with Arrow Keys");
        
        selectTerrain = new SelectTerrain(this,window);
        selectRiver = new SelectRiver(this,window);
        rotateState = new RotateState(this,window);
        
        setCurrentState(selectTerrain);
        window.highlightTerrainOption();
        
        mapControls();
    }

    public void cycleUP(){
        currentState.cycleUp();
    }

    public void cycleDown(){
        currentState.cycleDown();
    }

    public void cycleLeft(){
        currentState.cycleLeft();
    }

    public void cylceRight(){
    	currentState.cycleRight();
    }

    public void setCurrentState(StatusControllerState state) {
    	currentState = state;
    }
    
    public StatusControllerState getSelectRiverState() {
    	return selectRiver;
    }
    
    public StatusControllerState getSelectTerrainState() {
    	return selectTerrain;
    }
    
    public StatusControllerState getRotateState() {
    	return rotateState;
    }
    
    public void incrementTerrainIndex() {
    	selectedTerrainIndex++;
    	if(selectedTerrainIndex >= terrainTypes.size()) selectedTerrainIndex = 0;
    }
    
    public void decrementTerrainIndex() {
    	selectedTerrainIndex--;
    	if(selectedTerrainIndex < 0) selectedTerrainIndex = terrainTypes.size() - 1;
    }
    
    public void incrementRiverIndex() {
    	selectedRiverIndex++;
    	if(selectedRiverIndex >= riverTypes.size()) selectedRiverIndex = 0;
    }
    
    public void decrementRiverIndex() {
    	selectedRiverIndex--;
    	if(selectedRiverIndex < 0) selectedRiverIndex = riverTypes.size() - 1;
    }
    
    public String getSelectedTerrainType() {
    	return terrainTypes.get(selectedTerrainIndex);
    }
    
    public String getSelectedRiverType() {
    	return riverTypes.get(selectedRiverIndex);
    }
    
    private void mapControls() {
    	
    	Action upAction = new Action() {
			public void execute() {
				currentState.cycleUp();
			}
    		
    	};
    	
    	Action downAction = new Action() {
			public void execute() {
				currentState.cycleDown();
			}
    		
    	};
    	
    	Action leftAction = new Action() {
			public void execute() {
				currentState.cycleLeft();
			}
 
    	};
    	
    	Action rightAction = new Action() {
			public void execute() {
				currentState.cycleRight();
			}
    		
    	};
    	
    	keyMap.put(KeyCode.UP, upAction);
    	keyMap.put(KeyCode.DOWN, downAction);
    	keyMap.put(KeyCode.LEFT, leftAction);
    	keyMap.put(KeyCode.RIGHT, rightAction);
    }
    
    private void intializeTerrainOptions() {
    	
    	terrainTypes.add("Pasture");
    	terrainMap.put("Pasture", new PastureTerrain());
    	
    	terrainTypes.add("Woods");
    	terrainMap.put("Woods", new WoodsTerrain());
    	
    	terrainTypes.add("Mountain");
    	terrainMap.put("Mountain", new MountainTerrain());
    	
    	terrainTypes.add("Desert");
    	terrainMap.put("Desert", new DesertTerrain());
    	
    	terrainTypes.add("Rock");
    	terrainMap.put("Rock", new RockTerrain());
    	
    	terrainTypes.add("Sea");
    	terrainMap.put("Sea", new SeaTerrain());
       	
    }
    
    private void intializeRiverOptions() {
    	
    	riverTypes.add("None");
    	
    	riverTypes.add("Source River");
    	riverMap.put("Source River", new ArrayList<Integer>(Arrays.asList(1)));
    	
    	riverTypes.add("Adjacent Edge River");
    	riverMap.put("Adjacent Edge River",new ArrayList<Integer>(Arrays.asList(1,2)));
    	
    	riverTypes.add("Angled River");
    	riverMap.put("Angled River",new ArrayList<Integer>(Arrays.asList(1,3)));
    	
    	riverTypes.add("Linear River");
    	riverMap.put("Linear River",new ArrayList<Integer>(Arrays.asList(1,4)));
    	
    	riverTypes.add("Tri River");
    	riverMap.put("Adjacent Edge River",new ArrayList<Integer>(Arrays.asList(1,3,5)));
    	
    	
    }
}
