package com.iteration3.model.tile;

public class TerrainTypeVisitor implements iTerrainVisitor {

    @Override
    public String getType(DesertTerrain terrain) {
        return "desert";
    }

    @Override
    public String getType(MountainTerrain terrain) {
        return "mountains";
    }

    @Override
    public String getType(PastureTerrain terrain) {
        return "pasture";
    }

    @Override
    public String getType(RockTerrain terrain) {
        return "rock";
    }

    @Override
    public String getType(SeaTerrain terrain) {
        return "sea";
    }

    @Override
    public String getType(WoodsTerrain terrain) {
        return "woods";
    }
}
