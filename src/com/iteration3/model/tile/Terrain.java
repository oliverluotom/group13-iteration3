package com.iteration3.model.tile;

import com.iteration3.utilities.Visitable;
import com.iteration3.utilities.Visitor;

public abstract class Terrain implements Visitable {

    public abstract String getTerrainType(iTerrainVisitor visitor);

    @Override
    public void acceptVisitor(Visitor visitor) {
        System.out.println("Here");
    }

}
