package com.iteration3.model.tile;

public class WoodsTerrain extends Terrain implements iTerrainVisitable {

    @Override
    public String getTerrainType(iTerrainVisitor visitor) {
        return visitor.getType(this);
    }

}
