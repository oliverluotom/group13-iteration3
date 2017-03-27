package com.iteration3.model;

import com.iteration3.model.map.Map;

public class GameModel {
    private Map map;

    public GameModel(){
        map = new Map();
    }

    public Map getMap(){
        return map;
    }

    public void setMap(Map map){
        this.map=map;
    }
}