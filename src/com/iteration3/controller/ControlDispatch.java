package com.iteration3.controller;

import com.iteration3.model.map.Map;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/*--------------------------------------------------------------------------------------
|    ControlDispatch: Created by Clay&Ricardo on 3/27/17.
|---------------------------------------------------------------------------------------
|   Entry-point for all controls
|   Events are sent to the current control state for handling
---------------------------------------------------------------------------------------*/
public class ControlDispatch implements EventHandler<KeyEvent>{

    private ControlDispatchState currentState;
    Map map;

    public ControlDispatch(Map map, ControlDispatchState state){
        setCurrentState(state);
        this.map = map;
    }

    public void setCurrentState(ControlDispatchState state){
        currentState = state;
    }
   
	@Override
	public void handle(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}
}
