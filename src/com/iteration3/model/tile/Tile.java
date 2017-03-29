package com.iteration3.model.tile;

import com.iteration3.utilities.Visitable;
import com.iteration3.utilities.Visitor;

public class Tile {

    private Terrain terrain;

    public Tile(Terrain t) {
        this.terrain = t;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public String getTerrain(TerrainTypeVisitor v) {
        return terrain.getTerrainType(v);
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }


}
