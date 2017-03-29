package com.iteration3.model.map;

import com.iteration3.model.tile.River;
import com.iteration3.model.tile.Terrain;
import com.iteration3.model.tile.TerrainTypeVisitor;
import com.iteration3.model.tile.Tile;
import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Map {

    private HashMap<Location, Tile> tiles;
    private HashMap<Location, River> rivers;
    // TODO: Add observers

    public Map() {
        tiles = new HashMap<>();
        rivers = new HashMap<>();
        // TODO: Initialize observers
    }

    public void addTileFromFile(Location l, Tile t) {
        if(validateLocationRange(l)) {
            tiles.put(l,t);
        }
    }

    public void addRiverFromFile(Location l, River r) {
        if(validateLocationRange(l)) {
            rivers.put(l, r);
        }
    }

    public void addTileFromGUI(Location l, Tile t) {
        if(validateLocationRange(l) && validateTileAdjacency(l) && validateTileLocation(l,t)) {
            tiles.put(l,t);
        }
    }

    public void addRiverFromGUI(Location l, River r) {
        if(validateLocationRange(l) && validateRiverLocation(l, r)) {
                rivers.put(l, r);
        }
    }


    public boolean validateAllRiverLocations() {
        for(Location location : rivers.keySet()) {
            if(!validateRiverLocation(location, rivers.get(location))) {
                return false;
            }
        }
        return true;
    }

    public void clearTiles() {
        tiles.clear();
    }

    public void clearRivers() {
        rivers.clear();
    }


    public boolean validateLocationRange(Location location) {
        if(location.getX() > Math.abs(10) || location.getY() > Math.abs(10) || location.getZ() > Math.abs(10)) {
            System.out.println("Invalid location type");
            return false;
        } else {
            return true;
        }
    }

    private boolean isSeaTile(Location l) {
        if(tiles.get(l).getTerrain(new TerrainTypeVisitor()).equals("sea")) {
            return true;
        }
        return false;
    }

    public boolean validateTileLocation(Location l , Tile t){
        if(!t.getTerrain(new TerrainTypeVisitor()).equals("sea")) {
            if (rivers.containsKey(l)) {
                return true;
            }
            else{
                if (rivers.containsKey(l.getNorth())) {
                    if(rivers.get(l.getNorth()).containsEdge(4)){
                        return false;
                    }
                }
                if (rivers.containsKey(l.getNorthEast())) {
                    if(rivers.get(l.getNorthEast()).containsEdge(5)){
                        return false;
                    }
                }
                if (rivers.containsKey(l.getNorthWest())) {
                    if(rivers.get(l.getNorthWest()).containsEdge(3)){
                        return false;
                    }
                }
                if (rivers.containsKey(l.getSouth())) {
                    if(rivers.get(l.getSouth()).containsEdge(1)){
                        return false;
                    }
                }
                if (rivers.containsKey(l.getSouthEast())) {
                    if(rivers.get(l.getSouthEast()).containsEdge(6)){
                        return false;
                    }
                }
                if (rivers.containsKey(l.getSouthWest())) {
                    if(rivers.get(l.getSouthWest()).containsEdge(2)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean validateRiverLocation(Location l, River r){
        //Surrounding Check Center
        if (rivers.containsKey(l.getNorth())) {
            if(rivers.get(l.getNorth()).containsEdge(4)){
                if(!r.containsEdge(1)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getNorthEast())) {
            if(rivers.get(l.getNorthEast()).containsEdge(5)){
                if(!r.containsEdge(2)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getNorthWest())) {
            if(rivers.get(l.getNorthWest()).containsEdge(3)){
                if(!r.containsEdge(6)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getSouth())) {
            if(rivers.get(l.getSouth()).containsEdge(1)){
                if(!r.containsEdge(4)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getSouthEast())) {
            if(rivers.get(l.getSouthEast()).containsEdge(6)){
                if(!r.containsEdge(3)){
                    return false;
                }
            }
        }
        if (rivers.containsKey(l.getSouthWest())) {
            if(rivers.get(l.getSouthWest()).containsEdge(2)){
                if(!r.containsEdge(5)){
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
                    if(!rivers.get(l.getNorth()).containsEdge(4)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorth())){
                    if(!isSeaTile(l.getNorth())){
                        return false;
                    }
                }
            }
            else if(holder == 2){
                if(rivers.containsKey(l.getNorthEast())){
                    if(!rivers.get(l.getNorthEast()).containsEdge(5)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorthEast())){
                    if(!isSeaTile(l.getNorthEast())) {
                        return false;
                    }
                }
            }
            else if(holder == 3){
                if(rivers.containsKey(l.getSouthEast())){
                    if(!rivers.get(l.getSouthEast()).containsEdge(6)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouthEast())){
                    if(!isSeaTile(l.getSouthEast())) {
                        return false;
                    }
                }
            }
            else if(holder == 4){
                if(rivers.containsKey(l.getSouth())){
                    if(!rivers.get(l.getSouth()).containsEdge(1)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouth())){
                    if(!isSeaTile(l.getSouth())) {
                        return false;
                    }
                }
            }
            else if(holder == 5){
                if(rivers.containsKey(l.getSouthWest())){
                    if(!rivers.get(l.getSouthWest()).containsEdge(2)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getSouthWest())){
                    if(!isSeaTile(l.getSouthWest())) {
                        return false;
                    }
                }
            }
            else if(holder == 6){
                if(rivers.containsKey(l.getNorthWest())){
                    if(!rivers.get(l.getNorthWest()).containsEdge(3)){
                        return false;
                    }
                }
                else if(tiles.containsKey(l.getNorthWest())){
                    if(!isSeaTile(l.getNorthWest())) {
                        return false;
                    }
                }
            }
        }
        if(!validateTileAdjacency(l) && !tiles.isEmpty()){
            if(tiles.size()==1){
                if(tiles.containsKey(l)){
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean validateTileAdjacency(Location l){
        if(tiles.size()==0){
            return true;
        }
        if(tiles.containsKey(l)){
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
            System.out.println("Terrain: " + tiles.get(location).getTerrain(new TerrainTypeVisitor()));
        }
    }

    public boolean isValidPlacement(Location location, Terrain terrain, ArrayList<Integer> riverEdges) {
        return( validateLocationRange(location) && validateRiverLocation(location, new River(riverEdges)) && validateTileAdjacency(location) && validateTileLocation(location, new Tile(terrain)));

    }
    
    public boolean isValidPlacement(Location location, Terrain terrain) {
        return( validateLocationRange(location) && validateTileAdjacency(location) && validateTileLocation(location, new Tile(terrain)));

    }

}
