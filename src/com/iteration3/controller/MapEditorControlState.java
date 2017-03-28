package com.iteration3.controller;

import com.iteration3.model.map.Map;

import java.awt.event.KeyEvent;
import java.util.HashMap;



import javafx.scene.input.KeyCode;


public class MapEditorControlState implements ControlDispatchState{
    private CursorController cursorController;
    private StatusController statusController;
    private HashMap<KeyCode,Action> keyMap;
    Map map;

    public MapEditorControlState(Map map){
        this.map = map;
        keyMap = new HashMap<>();
        cursorController = new CursorController();
        statusController = new StatusController(map,keyMap);
    }

    public void initHashMap(){
        
    }

    public void handleInput(KeyEvent e){
        if (keyMap.containsKey(e.getKeyCode()))
            keyMap.get(e.getKeyCode()).execute();
    }



}
