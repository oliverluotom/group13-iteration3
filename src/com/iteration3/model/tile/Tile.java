package com.iteration3.model.tile;

public class Tile {

    private Terrain terrain;

    public Tile(Terrain t) {
        this.terrain = t;
    }

    public String getTerrain(TerrainTypeVisitor v) {
        return terrain.getTerrainType(v);
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
