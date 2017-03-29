package com.iteration3.controller;

import com.iteration3.view.GameWindow;

public class SelectTerrain implements StatusControllerState {

	GameWindow window;
	StatusController context; 
	
	public SelectTerrain(StatusController context, GameWindow window) {
		this.context = context;
		this.window = window;
	}
	
	@Override
	public void cycleUp() {
		// TODO Auto-generated method stub
		window.highlightRotateOption();
		context.setCurrentState(context.getRotateState());
	}

	@Override
	public void cycleDown() {
		// TODO Auto-generated method stub
		window.highlightRiverOption();
		context.setCurrentState(context.getSelectRiverState());
	}

	@Override
	public void cycleLeft() {
		// TODO Auto-generated method stub
		context.decrementTerrainIndex();
		window.setTerrainType(context.getSelectedTerrainType());
	}

	@Override
	public void cycleRight() {
		// TODO Auto-generated method stub
		context.incrementTerrainIndex();
		window.setTerrainType(context.getSelectedTerrainType());
	}

}
