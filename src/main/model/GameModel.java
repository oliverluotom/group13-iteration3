package main.model;

import main.model.map.Map;

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