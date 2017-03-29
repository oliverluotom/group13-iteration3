package com.iteration3.controller;

/*--------------------------------------------------------------------------------------
|    MapEditorControlState: Created by Clay on 3/27/17.
|---------------------------------------------------------------------------------------
|   State class dedicated to control mode when building a map
|   Composed of CursorController and StatusController
---------------------------------------------------------------------------------------*/

import com.iteration3.model.GameModel;
import com.iteration3.model.map.Map;
import com.iteration3.view.GameWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class MapEditorControlState implements ControlDispatchState{
    private CursorController cursorController;
    private StatusController statusController;
    private MapFileController mapFileController;
    private HashMap<KeyCode,Action> keyMap;
    GameModel model;
    GameWindow window;

    public MapEditorControlState(GameModel model, GameWindow window){
        this.model = model;
        this.window = window;
        keyMap = new HashMap<>();
        cursorController = new CursorController(model, window, keyMap);
        statusController = new StatusController(model,window,keyMap);

        cursorController.addObserver(statusController);

        mapFileController = new MapFileController(model, window);

        
        setOnClearMap();
    }

    //execute action if it is a valid key for this state
    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }
    
    private void setOnClearMap() {
    	
    	EventHandler<ActionEvent> clearMap = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				window.clearMap();
			}
    		
    	};
    	
    	window.onClickCreateMap(clearMap);
    }
}
