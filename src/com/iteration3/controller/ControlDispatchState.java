package com.iteration3.controller;


import javafx.scene.input.KeyEvent;

/*--------------------------------------------------------------------------------------
|    ControlDispatchState: Created by Clay on 3/27/17.
|---------------------------------------------------------------------------------------
|   Interface for all control state objects
|   ControlDispatch will send key input to states for handling
---------------------------------------------------------------------------------------*/
public interface ControlDispatchState {

    public void handleInput(KeyEvent event);
}
