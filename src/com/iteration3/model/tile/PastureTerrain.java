package com.iteration3.model.tile;

import com.iteration3.utilities.Visitable;
import com.iteration3.utilities.Visitor;

public class PastureTerrain extends Terrain implements iTerrainVisitable {

    @Override
    public String getTerrainType(iTerrainVisitor visitor) {
        return visitor.getType(this);
    }

	public void acceptVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
        visitor.visit(this);
	}

}
