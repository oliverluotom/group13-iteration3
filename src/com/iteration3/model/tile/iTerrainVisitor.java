package com.iteration3.model.tile;

public interface iTerrainVisitor {

    String getType(DesertTerrain terrain);
    String getType(MountainTerrain terrain);
    String getType(PastureTerrain terrain);
    String getType(RockTerrain terrain);
    String getType(SeaTerrain terrain);
    String getType(WoodsTerrain terrain);

}
