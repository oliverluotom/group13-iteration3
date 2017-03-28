package com.iteration3.model.tile;

public class PastureTerrain extends Terrain implements TerrainVisitable {

    @Override
    public String getTerrainType(TerrainVisitor visitor) {
        return visitor.getType(this);
    }

}