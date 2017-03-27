package main.model.tile;

public class Tile {

    private Terrain terrain;

    public Tile(Terrain t) {
        this.terrain = t;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
