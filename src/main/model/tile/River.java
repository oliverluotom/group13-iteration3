package main.model.tile;

import java.util.ArrayList;

public class River {

    // 1 is North, 2 is NorthEast, 3 is SouthEast, 4 is South, 5 is SouthWest, 6 is NorthWest
    private ArrayList<Integer> riverEdges;

    public River() {
        this.riverEdges = new ArrayList<Integer>();
    }

    // Constructors for river types with various number of edges
    public River(int edge1) {
        this.riverEdges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
    }

    public River(int edge1, int edge2) {
        this.riverEdges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
        this.riverEdges.add(edge2);
    }

    public River(int edge1, int edge2, int edge3) {
        this.riverEdges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
        this.riverEdges.add(edge2);
        this.riverEdges.add(edge3);
    }

    // add edge if that edge isn't already in the list and if size < 3
    public void addRiverEdge(int edge) {
        if(this.riverEdges.size() < 3 && !riverEdges.contains(Integer.valueOf(edge))) {
            this.riverEdges.add(edge);
        }
    }

    public void removeRiverEdge(int edge) {
        this.riverEdges.remove(Integer.valueOf(edge));
    }

    public ArrayList<Integer> getRiverEdges() {
        return riverEdges;
    }

    public void setRiverEdges(ArrayList<Integer> riverEdges) {
        this.riverEdges = riverEdges;
    }

    public void rotateCounterClockwise() {
        for(int i = 0; i < riverEdges.size(); i++) {
            if(riverEdges.get(i) == 1) {
                riverEdges.set(i, 6);
            }
            else if(riverEdges.get(i) == 6) {
                riverEdges.set(i, 5);
            }
            else if(riverEdges.get(i) == 5) {
                riverEdges.set(i, 4);
            }
            else if(riverEdges.get(i) == 4) {
                riverEdges.set(i, 3);
            }
            else if(riverEdges.get(i) == 3) {
                riverEdges.set(i, 2);
            }
            else if(riverEdges.get(i) == 2) {
                riverEdges.set(i, 1);
            }
        }
    }

    public void rotateClockwise() {
        for(int i = 0; i < riverEdges.size(); i++) {
            if(riverEdges.get(i) == 1) {
                riverEdges.set(i, 2);
            }
            else if(riverEdges.get(i) == 2) {
                riverEdges.set(i, 3);
            }
            else if(riverEdges.get(i) == 3) {
                riverEdges.set(i, 4);
            }
            else if(riverEdges.get(i) == 4) {
                riverEdges.set(i, 5);
            }
            else if(riverEdges.get(i) == 5) {
                riverEdges.set(i, 6);
            }
            else if(riverEdges.get(i) == 6) {
                riverEdges.set(i, 1);
            }
        }
    }

    public void printRiverEdges() {
        System.out.println("Edges: " + riverEdges);
    }

}
