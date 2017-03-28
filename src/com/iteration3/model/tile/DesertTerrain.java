package com.iteration3.model.tile;

public class DesertTerrain extends Terrain implements iTerrainVisitable {

    @Override
    public String getTerrainType(iTerrainVisitor visitor) {
        return visitor.getType(this);
    }

}
