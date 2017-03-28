package com.iteration3.controller;

import java.util.HashMap;

import com.iteration3.model.map.Map;

public class StatusController implements Controller{
    Map map;
    HashMap<Integer,Action> keyMap;
    int mode;
    int index;
    

    public StatusController(Map map, HashMap<Integer,Action> keyMap){
        this.map = map;
        this.keyMap = keyMap;
        mode = 0;
        mapControls();
    }

    public void nextMode(){
        mode++;
    }

    public void prevMode(){
        mode--;
    }

    public void nextElement(){
        index++;
    }

    public void prevElement(){
        index--;
    }


    private void mapControls() {
    	
    }
}
