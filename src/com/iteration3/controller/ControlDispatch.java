package com.iteration3.controller;

import com.iteration3.model.map.Map;

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
