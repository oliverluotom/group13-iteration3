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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import com.iteration3.model.GameModel;
import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.model.tile.*;
import com.iteration3.utilities.Visitor;
import com.iteration3.view.GameWindow;
import com.iteration3.view.Observer;

public class StatusController implements Observer, Visitor {
    
	GameModel model; 
	GameWindow window;
    HashMap<KeyCode,Action> keyMap;
    HashMap<String, Terrain> terrainMap;
    HashMap<String,ArrayList<Integer>> riverMap; 
    ArrayList<String> terrainTypes;
    ArrayList<String> riverTypes;
    
    int selectedTerrainIndex;
    int selectedRiverIndex;
    Location cursorLocation;
    
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
        cursorLocation = window.getCursorLocation();
      
        window.setTerrainType(terrainTypes.get(selectedTerrainIndex));
        window.setRiverType(riverTypes.get(selectedRiverIndex));
        window.setRotateOption("Must Select River to Rotate with Arrow Keys");
        
        selectTerrain = new SelectTerrain(this,window);
        selectRiver = new SelectRiver(this,window);
        rotateState = new RotateState(this,window);
        
        setCurrentState(selectTerrain);
        window.highlightTerrainOption();
        
        mapControls();
        setOnClickSubmit();
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
    
    public ArrayList<Integer> rotateEdgesClockWise(ArrayList<Integer> edges) {
    	for(int i = 0; i < edges.size();i++) {
    		edges.set(i, edges.get(i) + 1);
    		if(edges.get(i) > 6) edges.set(i, 1);
    		
    	}
    	
    	return edges;
    }
    
    public ArrayList<Integer> rotateEdgesCounterClockWise(ArrayList<Integer> edges) {
    	for(int i = 0; i < edges.size();i++) {
    		edges.set(i, edges.get(i) - 1);
    		if(edges.get(i) < 1) edges.set(i, 6);
    		
    	}
    	
    	return edges;
    }
    
   public ArrayList<Integer> getCurrentRiverEdges() {
	   return riverMap.get(getSelectedRiverType()) ;
   }
    
   public boolean hasSelectedRiver() {
	   if(riverMap.get(getSelectedRiverType()) != null) return true;
	   return false;
   }
   
    public String getSelectedRiverType() {
    	return riverTypes.get(selectedRiverIndex);
    }
    
    public Terrain getSlectedTerrain() {
    	return terrainMap.get(terrainTypes.get(selectedTerrainIndex));
    }
    
    public void displayCurrentTerrain() {
    	terrainMap.get(terrainTypes.get(selectedTerrainIndex)).acceptVisitor(this);
    }
    
    public void displayCurrentRiver() {
    	ArrayList<Integer> edges = getCurrentRiverEdges();
    	displayRiverEdges(edges);
    	
    }
    
    public void displayRiverEdges(ArrayList<Integer> riverEdges) {
    	
    	 // handle river sources
        if(riverEdges.size() == 1) {
            if(riverEdges.contains(1)) {
                window.drawPreviewImage("source1");
            }
            else if(riverEdges.contains(2)) {
                window.drawPreviewImage("source2");
            }
            else if(riverEdges.contains(3)) {
                window.drawPreviewImage("source3");
            }
            else if(riverEdges.contains(4)) {
                window.drawPreviewImage("source4");
            }
            else if(riverEdges.contains(5)) {
                window.drawPreviewImage("source5");
            }
            else if(riverEdges.contains(6)) {
                window.drawPreviewImage("source6");
            }
        }
        else if(riverEdges.size() == 2) {
        // handle adjacent rivers
            if(riverEdges.contains(1) && riverEdges.contains(2)) {
                window.drawPreviewImage("adj1");
            }
            else if(riverEdges.contains(2) && riverEdges.contains(3)) {
                window.drawPreviewImage("adj2");
            }
            else if(riverEdges.contains(3) && riverEdges.contains(4)) {
                window.drawPreviewImage("adj3");
            }
            else if(riverEdges.contains(4) && riverEdges.contains(5)) {
                window.drawPreviewImage("adj4");
            }
            else if(riverEdges.contains(5) && riverEdges.contains(6)) {
                window.drawPreviewImage("adj5");
            }
            else if(riverEdges.contains(6) && riverEdges.contains(1)) {
                window.drawPreviewImage("adj6");
            }
            // handle angled
            else if(riverEdges.contains(1) && riverEdges.contains(3)) {
                window.drawPreviewImage("angled1");
            }
            else if(riverEdges.contains(2) && riverEdges.contains(4)) {
                window.drawPreviewImage("angled2");
            }
            else if(riverEdges.contains(3) && riverEdges.contains(5)) {
                window.drawPreviewImage("angled3");
            }
            else if(riverEdges.contains(4) && riverEdges.contains(6)) {
                window.drawPreviewImage("angled4");
            }
            else if(riverEdges.contains(5) && riverEdges.contains(1)) {
                window.drawPreviewImage("angled5");
            }
            else if(riverEdges.contains(6) && riverEdges.contains(2)) {
                window.drawPreviewImage("angled6");
            }
            // handle straight
            else if(riverEdges.contains(1) && riverEdges.contains(4)) {
                window.drawPreviewImage("straight1");
            }
            else if(riverEdges.contains(2) && riverEdges.contains(5)) {
                window.drawPreviewImage("straight2");
            }
            else if(riverEdges.contains(3) && riverEdges.contains(6)) {
                window.drawPreviewImage("straight3");
            }

        }
        // handle triple rivers
        else if(riverEdges.size() == 3) {
            if(riverEdges.contains(1)) {
                window.drawPreviewImage("tri1");
            }
            else {
                window.drawPreviewImage("tri2");
            }
        }

    }




    
    
    public void setCurrentlySelectedRiverEdges(ArrayList<Integer> edges) {
    	riverMap.put(getSelectedRiverType(), edges);
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
    	
    	Action enterAction = new Action() {
    		public void execute() {
				if(isValidSubmission()) {
		   			if(hasSelectedRiver()) {
						
						model.addRiverFromGUI(cursorLocation, riverMap.get(riverTypes.get(selectedRiverIndex)));
					}
					
					model.addTileFromGUI(cursorLocation, terrainMap.get(terrainTypes.get(selectedTerrainIndex)));
				
	    		}
			}
    			
    	};
    	
    	keyMap.put(KeyCode.UP, upAction);
    	keyMap.put(KeyCode.DOWN, downAction);
    	keyMap.put(KeyCode.LEFT, leftAction);
    	keyMap.put(KeyCode.RIGHT, rightAction);
    	keyMap.put(KeyCode.ENTER, enterAction);
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
    	riverMap.put("Tri River",new ArrayList<Integer>(Arrays.asList(1,3,5)));
    	
    	
    }
    
    public boolean isValidSubmission() {
    	if(hasSelectedRiver()) {
			if(model.isValidPlacement(cursorLocation,getSlectedTerrain(), getCurrentRiverEdges())) {
				return true;
			} 
			else {
				return false;
			}
		}
		else {
			if(model.isValidPlacement(cursorLocation,getSlectedTerrain())) {
				return true;
			}
			else {
				return false;
			}
		}
    	
    }
    
    public void setOnClickSubmit() {
    	
    	EventHandler<ActionEvent> onSumbit = new EventHandler<ActionEvent> () {

			public void handle(ActionEvent event) {
				
				if(hasSelectedRiver()) {
					
					model.addRiverFromGUI(cursorLocation, riverMap.get(riverTypes.get(selectedRiverIndex)));
				}
				
				model.addTileFromGUI(cursorLocation, terrainMap.get(terrainTypes.get(selectedTerrainIndex)));
			}
    		
    	};
    	
    	window.setOnClickSubmit(onSumbit);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		cursorLocation = window.getCursorLocation();
		if(isValidSubmission()) window.enableSubmit();
		else window.disableSubmit();
	}

	@Override
	public void visit(WoodsTerrain terrain) {
		// TODO Auto-generated method stub
		window.drawPreviewImage("woods");
	}

	@Override
	public void visit(MountainTerrain terrain) {
		// TODO Auto-generated method stub
		window.drawPreviewImage("mountains");
	}

	@Override
	public void visit(DesertTerrain terrain) {
		// TODO Auto-generated method stub
		window.drawPreviewImage("desert");
	}

	@Override
	public void visit(PastureTerrain terrain) {
		// TODO Auto-generated method stub
		window.drawPreviewImage("pasture");
	}

	@Override
	public void visit(RockTerrain terrain) {
		// TODO Auto-generated method stub
		window.drawPreviewImage("rock");
	}

	@Override
	public void visit(SeaTerrain terrain) {
		// TODO Auto-generated method stub
		window.drawPreviewImage("sea");
	}
}
