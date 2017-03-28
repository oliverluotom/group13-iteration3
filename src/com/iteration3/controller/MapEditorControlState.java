package com.iteration3.controller;

import com.iteration3.model.map.Map;

import java.awt.event.KeyEvent;
import java.util.HashMap;


import static java.awt.event.KeyEvent.*;

public class MapEditorControlState implements ControlDispatchState{
    private CursorController cursorController;
    private StatusController statusController;
    private HashMap<Integer,Action> keyMap;
    Map map;

    public MapEditorControlState(Map map){
        this.map = map;
        keyMap = new HashMap<>();
        cursorController = new CursorController();
        statusController = new StatusController(map,keyMap);
    }

    public void initHashMap(){
        keyMap.put(VK_UP, new UpModeAction(statusController, map));
        keyMap.put(VK_DOWN, new DownModeAction(statusController, map));
        keyMap.put(VK_RIGHT, new RightElementAction(statusController, map));
        keyMap.put(VK_LEFT, new LeftElementAction(statusController, map));
    }

    public void handleInput(KeyEvent e){
        if (keyMap.containsKey(e.getKeyCode()))
            keyMap.get(e.getKeyCode()).execute();
    }



}
