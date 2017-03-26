package com.iteration3.model.map;

import com.iteration3.model.tile.River;
import com.iteration3.model.tile.Tile;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {

    private HashMap<Location, Tile> tiles;
    private HashMap<Location, River> rivers;
    // TODO: Add observers

    public Map() {
        tiles = new HashMap<Location, Tile>();
        rivers = new HashMap<Location, River>();
        // TODO: Initialize observers
    }

    public void addTileToMap(Location l, Tile t) {
        tiles.put(l,t);
    }

    public void addRiverToMap(Location l, River r) {
        // TODO: validate
        rivers.put(l,r);
    }



}
