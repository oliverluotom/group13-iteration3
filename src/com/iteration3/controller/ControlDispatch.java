package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.model.map.Map;
import com.iteration3.view.GameWindow;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/*--------------------------------------------------------------------------------------
|    ${NAME} Module: Created by ${USER} on ${DATE}.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/
public class ControlDispatch implements EventHandler<KeyEvent>{

    private ControlDispatchState currentState;
    private MapEditorControlState mapEditorState;

    public ControlDispatch(GameModel model, GameWindow window){
        
    	mapEditorState = new MapEditorControlState(model,window);
    			
    	setCurrentState(mapEditorState);
    	window.addKeyHandler(this);
    }

    public void setCurrentState(ControlDispatchState state){
        currentState = state;
    }
   
	@Override
	public void handle(KeyEvent event) {
		
		currentState.handleInput(event);
	}
}
