package com.iteration3.model.map;

import com.iteration3.model.tile.River;
import com.iteration3.model.tile.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

    //TODO: FIX LOD VIOLATION
    public boolean validateRiverLocation(Location l, River r){
        //Surrounding Check Center
        if (rivers.containsKey(l.getNorth())) {
            if(rivers.get(l.getNorth()).getRiverEdges().contains(4)){
                if(!r.getRiverEdges().contains(1)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getNorthEast())) {
            if(rivers.get(l.getNorthEast()).getRiverEdges().contains(5)){
                if(!r.getRiverEdges().contains(2)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getNorthWest())) {
            if(rivers.get(l.getNorthWest()).getRiverEdges().contains(3)){
                if(!r.getRiverEdges().contains(6)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getSouth())) {
            if(rivers.get(l.getSouth()).getRiverEdges().contains(1)){
                if(!r.getRiverEdges().contains(4)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getSouthEast())) {
            if(rivers.get(l.getSouthEast()).getRiverEdges().contains(6)){
                if(!r.getRiverEdges().contains(3)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getSouthWest())) {
            if(rivers.get(l.getSouthWest()).getRiverEdges().contains(2)){
                if(!r.getRiverEdges().contains(5)){
                    return false;
                }
            }
        }

        //Center Check Surrounding
        ArrayList<Integer> riv = r.getRiverEdges();
        Iterator<Integer> iterator = riv.iterator();
        while(iterator.hasNext()){
            int holder = iterator.next();
            if(holder == 1){
                if(rivers.containsKey(l.getNorth())){
                    if(!rivers.get(l.getNorth()).getRiverEdges().contains(4)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorth())){
                    return false;
                }
            }
            else if(holder == 2){
                if(rivers.containsKey(l.getNorthEast())){
                    if(!rivers.get(l.getNorthEast()).getRiverEdges().contains(5)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorthEast())){
                    return false;
                }
            }
            else if(holder == 3){
                if(rivers.containsKey(l.getSouthEast())){
                    if(!rivers.get(l.getSouthEast()).getRiverEdges().contains(6)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouthEast())){
                    return false;
                }
            }
            else if(holder == 4){
                if(rivers.containsKey(l.getSouth())){
                    if(!rivers.get(l.getSouth()).getRiverEdges().contains(1)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouth())){
                    return false;
                }
            }
            else if(holder == 5){
                if(rivers.containsKey(l.getSouthWest())){
                    if(!rivers.get(l.getSouthWest()).getRiverEdges().contains(2)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouthWest())){
                    return false;
                }
            }
            else if(holder == 6){
                if(rivers.containsKey(l.getNorthWest())){
                    if(!rivers.get(l.getNorthWest()).getRiverEdges().contains(3)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorthWest())){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean validateTileAdjacency(Location l){
        if(tiles.size()==0){
            return true;
        }
        if(!tiles.containsKey(l)) {
            if (tiles.containsKey(l.getNorth())) {
                return true;
            }
            if (tiles.containsKey(l.getNorthEast())) {
                return true;
            }
            if (tiles.containsKey(l.getNorthWest())) {
                return true;
            }
            if (tiles.containsKey(l.getSouth())) {
                return true;
            }
            if (tiles.containsKey(l.getSouthEast())) {
                return true;
            }
            if (tiles.containsKey(l.getSouthWest())) {
                return true;
            }
        }
        return false;
    }

}
