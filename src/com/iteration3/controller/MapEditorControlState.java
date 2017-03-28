package com.iteration3.controller;

import com.iteration3.model.map.Map;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.HashMap;

public class MapEditorControlState implements ControlDispatchState{
    private CursorController cursorController;
    private StatusController statusController;
    private HashMap<KeyCode,Action> keyMap;
    Map map;
    GameWindow window;

    public MapEditorControlState(Map map, GameWindow window){
        this.map = map;
        this.window = window;
        keyMap = new HashMap<>();
        cursorController = new CursorController(map, window, keyMap);
        statusController = new StatusController(map,keyMap);
    }

    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }
}
