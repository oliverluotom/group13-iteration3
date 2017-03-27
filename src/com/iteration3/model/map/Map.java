package com.iteration3.model.map;

import com.iteration3.model.tile.River;
import com.iteration3.model.tile.TerrainTypeVisitor;
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

    public void addTileToMapFromFile(Location l, Tile t) {
        if(validateLocation(l)) {
            tiles.put(l,t);
        }
    }

    public void addRiverToMapFromFile(Location l, River r) {
        if(validateLocation(l) && !isSeaTile(l)) {
            rivers.put(l, r);
        }
    }

    public void addTileToMapFromGUI(Location l, Tile t) {
        if(validateLocation(l) && validateLocation(l)) {
            tiles.put(l,t);
        }
    }

    public void addRiverToMapFromGUI(Location l, River r) {
        if(validateLocation(l) && validateRiverLocation(l, r) && !isSeaTile(l)) {
            rivers.put(l, r);
        }
    }



    public boolean validateLocation(Location location) {
        if(location.getX() > Math.abs(10) || location.getY() > Math.abs(10) || location.getZ() > Math.abs(10)) {
            System.out.println("Invalid location type");
            return false;
        } else {
            return true;
        }
    }

    private boolean isSeaTile(Location l) {
        if(tiles.get(l).getTerrain().getTerrainType(new TerrainTypeVisitor()) == "sea") {
            return true;
        }
        return false;
    }

    //TODO: FIX LOD VIOLATION
    public boolean validateRiverLocation(Location l, River r){
        if(rivers.size() == 0) {
            return true;
        }

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
                else if(tiles.containsKey(l.getNorth()) && !isSeaTile(l.getNorth())){
                    return false;
                }
            }
            else if(holder == 2){
                if(rivers.containsKey(l.getNorthEast())){
                    if(!rivers.get(l.getNorthEast()).getRiverEdges().contains(5)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorthEast()) && !isSeaTile(l.getNorthEast())){
                    return false;
                }
            }
            else if(holder == 3){
                if(rivers.containsKey(l.getSouthEast())){
                    if(!rivers.get(l.getSouthEast()).getRiverEdges().contains(6)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouthEast()) && !isSeaTile(l.getSouthEast())){
                    return false;
                }
            }
            else if(holder == 4){
                if(rivers.containsKey(l.getSouth())){
                    if(!rivers.get(l.getSouth()).getRiverEdges().contains(1)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouth()) && !isSeaTile(l.getSouth())){
                    return false;
                }
            }
            else if(holder == 5){
                if(rivers.containsKey(l.getSouthWest())){
                    if(!rivers.get(l.getSouthWest()).getRiverEdges().contains(2)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouthWest()) && !isSeaTile(l.getSouthWest())){
                    return false;
                }
            }
            else if(holder == 6){
                if(rivers.containsKey(l.getNorthWest())){
                    if(!rivers.get(l.getNorthWest()).getRiverEdges().contains(3)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorthWest()) && !isSeaTile(l.getNorthWest())){
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

    public HashMap<Location, Tile> getTiles() {
        return tiles;
    }

    public HashMap<Location, River> getRivers() {
        return rivers;
    }

    public void printRivers() {
        for(Location location : rivers.keySet()) {
            System.out.println(rivers.get(location) + " " + Integer.toString(location.getX()) + " " +  Integer.toString(location.getY()) + " " + Integer.toString(location.getZ()));
            rivers.get(location).printRiverEdges();
        }
    }

    public void printTiles() {
        for(Location location : tiles.keySet()) {
            System.out.println(tiles.get(location) + " " + Integer.toString(location.getX()) + " " +  Integer.toString(location.getY()) + " " + Integer.toString(location.getZ()));
            System.out.println("Terrain: " + tiles.get(location).getTerrain());
        }
    }

}
