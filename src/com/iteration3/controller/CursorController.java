package com.iteration3.controller;
/*--------------------------------------------------------------------------------------
|    CursorController: Created by Clay on 3/27/17.
|---------------------------------------------------------------------------------------
|   Controller to define functions for moving around the map to select a tile
|   Cursor keeps track of its location on the map
---------------------------------------------------------------------------------------*/
import com.iteration3.model.GameModel;
import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class CursorController {
    Map map;
    HashMap<KeyCode,Action> keyMap;
    GameWindow window;
    Location location;

    public CursorController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keymap){
        this.map = map;
        this.keyMap = keymap;
        this.window = window;
        location = new Location(0,0,0);
        initializeKeyMap();
    }

    private void initializeKeyMap(){
        keyMap.put(KeyCode.NUMPAD1, new Action(){
            public void execute(){
                window.moveCursorSW();
                location.getSouthWest();
            }
        });

        keyMap.put(KeyCode.NUMPAD7, new Action(){
            public void execute(){
                window.moveCursorNW();
                location.getNorthWest();
            }
        });

        keyMap.put(KeyCode.NUMPAD8, new Action(){
            public void execute(){
                window.moveCursorNorth();
                location.getNorth();
            }
        });

        keyMap.put(KeyCode.NUMPAD9, new Action(){
            public void execute(){
                window.moveCursorNE();
                location.getNorthEast();
            }
        });

        keyMap.put(KeyCode.NUMPAD3, new Action(){
            public void execute(){
                window.moveCursorSE();
                location.getSouthEast();
            }
        });

        keyMap.put(KeyCode.NUMPAD2, new Action(){
            public void execute(){
                window.moveCursorSouth();
                location.getSouth();
            }
        });
    }

    public Location getCursorLocation(){
        return location;
    }
}
