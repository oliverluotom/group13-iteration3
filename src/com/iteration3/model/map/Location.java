package com.iteration3.model.map;

public class Location {
    private int x;
    private int y;
    private int z;

    public Location(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getZ() {
        return this.z;
    }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setZ(int z) { this.z = z; }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location loc = (Location) o;
        return x == loc.getX() && y == loc.getY() && z == loc.getZ();
    }

    public int hashCode(){
        int result = x ^ (x >>> 32);
        result = 31 * result + y ^ (y >>> 32);
        result = 31 * result + z ^ (z >>> 32);
        return result;
    }

    public Location getNorth(){
        return new Location(this.x, this.y+1, this.z-1);
    }

    public Location getNorthEast(){
        return new Location(this.x+1, this.y, this.z-1);
    }

    public Location getNorthWest(){
        return new Location(this.x-1, this.y+1, this.z);
    }

    public Location getSouth(){
        return new Location(this.x, this.y-1, this.z+1);
    }

    public Location getSouthEast(){
        return new Location(this.x+1, this.y-1, this.z);
    }

    public Location getSouthWest(){
        return new Location(this.x-1, this.y, this.z+1);
    }

}

