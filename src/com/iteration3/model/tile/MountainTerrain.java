package com.iteration3.model.tile;

public class MountainTerrain extends Terrain implements TerrainVisitable {

    @Override
    public String getTerrainType(TerrainVisitor visitor) {
        return visitor.getType(this);
    }

}
