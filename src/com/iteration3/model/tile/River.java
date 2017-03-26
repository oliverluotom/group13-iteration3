package com.iteration3.model.tile;

import java.util.ArrayList;

public class River {

    // 7 is NorthWest, 8 is North, 9 is NorthEast, 1 is SouthWest, 2 is South, 3 is SouthEast
    ArrayList<Integer> riverEdges;

    // Constructors for river types with various number of edges
    River(int edge1) {
        this.riverEdges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
    }

    River(int edge1, int edge2) {
        this.riverEdges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
        this.riverEdges.add(edge2);
    }

    River(int edge1, int edge2, int edge3) {
        this.riverEdges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
        this.riverEdges.add(edge2);
        this.riverEdges.add(edge3);
    }

}
