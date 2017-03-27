package com.iteration3.controller;

import com.iteration3.model.map.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*--------------------------------------------------------------------------------------
|    ${NAME} Module: Created by ${USER} on ${DATE}.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/
public class ControlDispatch implements KeyListener{

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
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }
}
