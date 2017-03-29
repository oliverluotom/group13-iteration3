package com.iteration3.model.tile;

import com.iteration3.utilities.Visitable;
import com.iteration3.utilities.Visitor;

public class SeaTerrain extends Terrain implements iTerrainVisitable, Visitable {

    @Override
    public String getTerrainType(iTerrainVisitor visitor) {
        return visitor.getType(this);
    }

	@Override
	public void acceptVisitor(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
