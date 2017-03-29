package com.iteration3.model;

import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.model.map.MapFileManager;
import com.iteration3.model.tile.*;
import com.iteration3.utilities.Visitor;
import com.iteration3.view.GameWindow;

import java.io.IOException;

public class ModelViewAdapter implements Visitor {
    private GameModel gameModel;
    private GameWindow gameWindow;
    private Location currentLocation;


    public ModelViewAdapter(GameModel gm, GameWindow gw){
        gameModel = gm;
        gameWindow = gw;
    }

    public void update(){
        Map map = gameModel.getMap();
        drawTiles(map);
    }


    private void drawTiles(Map map) {

        try {
            MapFileManager fileManager = new MapFileManager(map, "src/com/iteration3/model/map/mapFileReadValid.txt");
            fileManager.fillMapFromTextFile();

            for(Location location : map.getTiles().keySet()) {
                currentLocation = location;
                Terrain t = map.getTiles().get(location).getTerrain();
                t.acceptVisitor(this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void visit(WoodsTerrain terrain) {
        gameWindow.drawTile("woods", currentLocation.getX(), currentLocation.getZ());
    }

    @Override
    public void visit(MountainTerrain terrain) {
        gameWindow.drawTile("mountains", currentLocation.getX(), currentLocation.getZ());
    }

    @Override
    public void visit(DesertTerrain terrain) {
        gameWindow.drawTile("desert", currentLocation.getX(), currentLocation.getZ());
    }

    @Override
    public void visit(PastureTerrain terrain) {
        gameWindow.drawTile("pasture", currentLocation.getX(), currentLocation.getZ());

    }

    @Override
    public void visit(RockTerrain terrain) {
        gameWindow.drawTile("rock", currentLocation.getX(), currentLocation.getZ());

    }

    @Override
    public void visit(SeaTerrain terrain) {
        gameWindow.drawTile("sea", currentLocation.getX(), currentLocation.getZ());
    }
}
