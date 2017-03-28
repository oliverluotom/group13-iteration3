package com.iteration3.utilities;

import com.iteration3.model.tile.*;

public interface Visitor {

	public void visit(WoodsTerrain terrain);
	public void visit(MountainTerrain terrain);
	public void visit(DesertTerrain terrain);
	public void visit(PastureTerrain terrain);
	public void visit(RockTerrain terrain);
	public void visit(SeaTerrain terrain);
}
