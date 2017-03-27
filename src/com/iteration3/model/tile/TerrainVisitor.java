package com.iteration3.model.tile;

public interface TerrainVisitor {

    abstract String getType(DesertTerrain terrain);
    abstract String getType(MountainTerrain terrain);
    abstract String getType(PastureTerrain terrain);
    abstract String getType(RockTerrain terrain);
    abstract String getType(SeaTerrain terrain);
    abstract String getType(WoodsTerrain terrain);

}
