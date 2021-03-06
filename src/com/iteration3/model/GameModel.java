package com.iteration3.model;

import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.model.map.MapFileManager;
import com.iteration3.model.tile.River;
import com.iteration3.model.tile.Terrain;
import com.iteration3.model.tile.Tile;

import java.io.IOException;
import java.util.ArrayList;

public class GameModel {
    private Map map;
    private MapFileManager fileManager;
    private String path;

    public GameModel(){
        this.map = new Map();
    }

    public void setPath(String path){
        this.path=path;
        this.fileManager = new MapFileManager(this.map, path);
    }

    public Map getMap(){
        return map;
    }

    public void setMap(Map map){
        this.map=map;
    }

    public void addTileFromGUI(Location location, Terrain terrain) {
        Tile tile = new Tile(terrain);
        getMap().addTileFromFile(location,tile);
    }

    public void addRiverFromGUI(Location location, ArrayList<Integer> edges) {
        River river = new River(edges);

        getMap().addRiverFromGUI(location,river);
    }
    
    public void addRiverFromGUI(Location location, int edge1) {
        River river = new River(edge1);

        getMap().addRiverFromGUI(location,river);
    }

    public void addRiverFromGUI(Location location, int edge1, int edge2) {
        River river = new River(edge1, edge2);

        getMap().addRiverFromGUI(location,river);
    }

    public void addRiverFromGUI(Location location, int edge1, int edge2, int edge3) {
        River river = new River(edge1, edge2, edge3);

        getMap().addRiverFromGUI(location,river);
    }

    public void fillMapFromTextFile() throws IOException{
        fileManager.fillMapFromTextFile();
    }

    public void fillTextFileFromMap() throws IOException{
        fileManager.fillTextFileFromMap();
    }

    public boolean isValidPlacement(Location location, Terrain terrain, ArrayList<Integer> riverEdges) {
        
    	return map.isValidPlacement(location, terrain, riverEdges);
    }
    
public boolean isValidPlacement(Location location, Terrain terrain) {
        
    	return map.isValidPlacement(location, terrain);
    }

	public void clearMap() {
		map.clearMap();
	}
}