package com.iteration3.controller;
/*--------------------------------------------------------------------------------------
|    CursorController: Created by Clay on 3/27/17.
|---------------------------------------------------------------------------------------
|   Controller to define functions for moving around the map to select a tile
|
---------------------------------------------------------------------------------------*/
import com.iteration3.model.map.Map;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class CursorController {
    Map map;
    HashMap<KeyCode,Action> keyMap;
    GameWindow window;
    int mode;
    int index;

    public CursorController(Map map, GameWindow window, HashMap<KeyCode, Action> keymap){
        this.map = map;
        this.keyMap = keymap;

        initializeKeyMap();
    }

    private void initializeKeyMap(){
        keyMap.put(KeyCode.NUMPAD1, new Action(){
            public void execute(){
                window.moveCursorSW();
            }
        });

        keyMap.put(KeyCode.NUMPAD7, new Action(){
            public void execute(){
                window.moveCursorNW();
            }
        });

        keyMap.put(KeyCode.NUMPAD8, new Action(){
            public void execute(){
                window.moveCursorNorth();
            }
        });

        keyMap.put(KeyCode.NUMPAD9, new Action(){
            public void execute(){
                window.moveCursorNE();
            }
        });

        keyMap.put(KeyCode.NUMPAD3, new Action(){
            public void execute(){
                window.moveCursorSE();
            }
        });

        keyMap.put(KeyCode.NUMPAD2, new Action(){
            public void execute(){
                window.moveCursorSouth();
            }
        });
    }
}
