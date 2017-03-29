package com.iteration3.model;

import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.model.map.MapFileManager;
import com.iteration3.model.tile.*;
import com.iteration3.utilities.Visitor;
import com.iteration3.view.GameWindow;

import java.io.IOException;
import java.util.ArrayList;

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
        try {
            MapFileManager fileManager = new MapFileManager(map, "src/com/iteration3/model/map/mapFileReadValid.txt");
            fileManager.fillMapFromTextFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        drawTiles(map);
        drawRivers(map);
    }


    private void drawTiles(Map map) {


        for(Location location : map.getTiles().keySet()) {
            currentLocation = location;
            map.getTiles().get(location).getTerrain().acceptVisitor(this);
        }


    }

    private void drawRivers(Map map) {

        for(Location location : map.getRivers().keySet()) {
            currentLocation = location;
            ArrayList<Integer> riverEdges = map.getRivers().get(location).getRiverEdges();

            // handle river sources
            if(riverEdges.size() == 1) {
                if(riverEdges.contains(1)) {
                    gameWindow.drawRiver("source1",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(2)) {
                    gameWindow.drawRiver("source2",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(3)) {
                    gameWindow.drawRiver("source3",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(4)) {
                    gameWindow.drawRiver("source4",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(5)) {
                    gameWindow.drawRiver("source5",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(6)) {
                    gameWindow.drawRiver("source6",  currentLocation.getX(), currentLocation.getZ());
                }
            }
            else if(riverEdges.size() == 2) {
                // handle adjacent rivers
                if(riverEdges.get(0) - riverEdges.get(1) == Math.abs(1)) {
                    if(riverEdges.contains(1) && riverEdges.contains(2)) {
                        gameWindow.drawRiver("adj1",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(2) && riverEdges.contains(3)) {
                        gameWindow.drawRiver("adj2",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(3) && riverEdges.contains(4)) {
                        gameWindow.drawRiver("adj3",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(4) && riverEdges.contains(5)) {
                        gameWindow.drawRiver("adj4",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(5) && riverEdges.contains(6)) {
                        gameWindow.drawRiver("adj5",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(6) && riverEdges.contains(1)) {
                        gameWindow.drawRiver("adj6",  currentLocation.getX(), currentLocation.getZ());
                    }
                }
                // handle angled rivers
                else if(riverEdges.get(0) - riverEdges.get(1) == Math.abs(2)) {
                    if(riverEdges.contains(1) && riverEdges.contains(3)) {
                        gameWindow.drawRiver("angled1",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(2) && riverEdges.contains(4)) {
                        gameWindow.drawRiver("angled2",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(3) && riverEdges.contains(5)) {
                        gameWindow.drawRiver("angled3",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(4) && riverEdges.contains(6)) {
                        gameWindow.drawRiver("angled4",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(5) && riverEdges.contains(1)) {
                        gameWindow.drawRiver("angled5",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(6) && riverEdges.contains(2)) {
                        gameWindow.drawRiver("angled6",  currentLocation.getX(), currentLocation.getZ());
                    }
                }
                else if(riverEdges.get(0) - riverEdges.get(1) == Math.abs(3)) {
                    if(riverEdges.contains(1) && riverEdges.contains(4)) {
                        gameWindow.drawRiver("straight1",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(2) && riverEdges.contains(5)) {
                        gameWindow.drawRiver("straight2",  currentLocation.getX(), currentLocation.getZ());
                    }
                    else if(riverEdges.contains(3) && riverEdges.contains(6)) {
                        gameWindow.drawRiver("straight3",  currentLocation.getX(), currentLocation.getZ());
                    }
                }
            }
            // handle triple rivers
            else if(riverEdges.size() == 3) {
                if(riverEdges.contains(1)) {
                    gameWindow.drawRiver("tri1",  currentLocation.getX(), currentLocation.getZ());
                }
                else {
                    gameWindow.drawRiver("tri2",  currentLocation.getX(), currentLocation.getZ());
                }
            }

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
