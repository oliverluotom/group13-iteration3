package com.iteration3.controller;

import java.util.ArrayList;
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
    HashMap<String,Integer[]> riverMap;
    ArrayList<ArrayList<String>> userOptions; 

    int selectedTerrain;
    int selectedRiver;
    int mode;

    public StatusController(GameModel model, GameWindow window, HashMap<KeyCode,Action> keyMap){
        this.model = model;
        this.keyMap = keyMap;
        this.window = window;
        mode = 0;
        
        terrainMap = new HashMap<>();
        riverMap = new HashMap<>();
        userOptions = new ArrayList<>();
        
        intializeOptions();
        
        mapControls();
    }

    public void nextMode(){
        mode++;
    }

    public void prevMode(){
        mode--;
    }

    public void nextElement(){
        
    }

    public void prevElement(){
        
    }


    private void mapControls() {
    	
    }
    
    private void intializeOptions() {
    	ArrayList<String> terrains = new ArrayList<>();
    	
    	terrains.add("Pasture");
    	terrainMap.put("Pasture", new PastureTerrain());
    	
    	terrains.add("Woods");
    	terrainMap.put("Woods", new WoodsTerrain());
    	
    	terrains.add("Mountain");
    	terrainMap.put("Mountain", new MountainTerrain());
    	
    	terrains.add("Desert");
    	terrainMap.put("Desert", new DesertTerrain());
    	
    	terrains.add("Rock");
    	terrainMap.put("Rock", new RockTerrain());
    	
    	terrains.add("Sea");
    	terrainMap.put("Sea", new SeaTerrain());
    	
    	userOptions.add(terrains);
    	selectedTerrain = 0;
    	window.setTerrainType(terrains.get(selectedTerrain));
    	window.highlightTerrainOption();
    	
    	Action leftAction = new Action(){
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				selectedTerrain--;
				if(selectedTerrain < 0) selectedTerrain = terrains.size() -1;
				window.highlightTerrainOption();
				window.setTerrainType(userOptions.get(mode).get(selectedTerrain));
			}
    		
    	};
    	
    	Action rightAction = new Action(){
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				selectedTerrain++;
				if(selectedTerrain >= terrains.size()) selectedTerrain = 0;
				window.highlightTerrainOption();
				window.setTerrainType(userOptions.get(mode).get(selectedTerrain));
			}
    		
    	};
    	
    	keyMap.put(KeyCode.LEFT, leftAction);
    	keyMap.put(KeyCode.RIGHT, rightAction);
  
    }
    
   
}
