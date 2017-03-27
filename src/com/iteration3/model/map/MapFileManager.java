package com.iteration3.model.map;

import com.iteration3.model.tile.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapFileManager {

    private String pathToTextFile;
    private Map map;

    public MapFileManager(Map m, String path) {
        this.map = m;
        this.pathToTextFile = path;
    }

    // TODO: Methods to move map to text file and text file to map

    // Reads file line by line, extracts info and creates a map out of it
    public void fillMapFromTextFile() {

        try (BufferedReader br = new BufferedReader(new FileReader(this.pathToTextFile))) {
            String line;
            // divide line and create Tile/Rivers
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("\\s+");

                // handle location
                int x = Integer.parseInt(splitLine[2]);
                int y = Integer.parseInt(splitLine[3]);
                int z = Integer.parseInt(splitLine[4]);

                if(x > Math.abs(10) || y > Math.abs(10) || z > Math.abs(10)) {
                    System.out.println("Invalid location type");
                    return;
                }

                Location location = new Location(x, y, z);

                // handle terrain
                String terrainString = splitLine[5];
                Terrain terrain = new PastureTerrain();

                if(terrainString.equals("pasture")) {
                    terrain = new PastureTerrain();
                }
                else if(terrainString.equals("woods")) {
                    terrain = new WoodsTerrain();
                }
                else if(terrainString.equals("rock")) {
                    terrain = new RockTerrain();
                }
                else if(terrainString.equals("mountains")) {
                    terrain = new MountainTerrain();
                }
                else if(terrainString.equals("desert")) {
                    terrain = new DesertTerrain();
                }
                else if(terrainString.equals("sea")){
                    terrain = new SeaTerrain();
                }
                else {
                    System.out.println("Invalid terrain type");
                    return;
                }

                Tile tile = new Tile(terrain);
                map.addTileToMap(location, tile);

                // handle rivers if they exist
                if(splitLine.length > 6) {
                    River river = new River();
                    for(int i = 6; i < splitLine.length; i++) {
                        river.addRiverEdge(Integer.parseInt(splitLine[i]));
                    }
                    map.addRiverToMap(location,river);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
