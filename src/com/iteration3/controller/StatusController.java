package com.iteration3.controller;

import com.iteration3.model.map.Map;

public class StatusController implements Controller{
    Map map;
    int mode;
    int index;

    public StatusController(Map map){
        this.map = map;
        mode = 0;
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


}
