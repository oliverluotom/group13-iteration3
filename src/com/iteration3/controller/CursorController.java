package com.iteration3.controller;

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

        keymap.put(KeyCode.NUMPAD1, new Action(){
            public void execute(){
                window.moveCursorSW();
            }
        });

        keymap.put(KeyCode.NUMPAD7, new Action(){
            public void execute(){
                window.moveCursorNW();
            }
        });

        keymap.put(KeyCode.NUMPAD8, new Action(){
            public void execute(){
                window.moveCursorNorth();
            }
        });

        keymap.put(KeyCode.NUMPAD9, new Action(){
            public void execute(){
                window.moveCursorNE();
            }
        });

        keymap.put(KeyCode.NUMPAD3, new Action(){
            public void execute(){
                window.moveCursorSE();
            }
        });

        keymap.put(KeyCode.NUMPAD2, new Action(){
            public void execute(){
                window.moveCursorSouth();
            }
        });

    }
}
