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
import com.iteration3.view.Observable;
import com.iteration3.view.Observer;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class CursorController implements Observable {
 
    HashMap<KeyCode,Action> keyMap;
    ArrayList<Observer> observers;
    GameWindow window;

    public CursorController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keymap){
       
        this.keyMap = keymap;
        this.window = window;

        
        observers = new ArrayList<>();

        initializeKeyMap();
    }

    //load keymap with controls
    //could be adjusted to read from a file for custom controls
    private void initializeKeyMap(){
        keyMap.put(KeyCode.NUMPAD1, new Action(){
            public void execute(){
                window.moveCursorSW();

                
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD7, new Action(){
            public void execute(){
                window.moveCursorNW();

                
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD8, new Action(){
            public void execute(){
                window.moveCursorNorth();

                
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD9, new Action(){
            public void execute(){
                window.moveCursorNE();

                
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD3, new Action(){
            public void execute(){
                window.moveCursorSE();

                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD2, new Action(){
            public void execute(){
                window.moveCursorSouth();

                notifyAllObservers();

            }
        });
    }

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}

	@Override
	public void notifyObserver(Observer obs) {
		// TODO Auto-generated method stub
		obs.update();
	}

	@Override
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		for(Observer obs: observers) {
			obs.update();
		}
	}


}
