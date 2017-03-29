package com.iteration3.model;

import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.model.tile.River;
import com.iteration3.model.tile.Tile;

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

    public void addTileFromFile(Location l, Tile t) {
        getMap().addTileFromFile(l,t);
    }

    public void addRiverFromFile(Location l, River r) {
       getMap().addRiverFromFile(l,r);
    }

    public void addTileFromGUI(Location l, Tile t) {
        getMap().addTileFromGUI(l,t);
    }

    public void addRiverFromGUI(Location l, River r) {
        getMap().addRiverFromGUI(l,r);
    }

}