package com.iteration3.controller;

import com.iteration3.view.GameWindow;

public class SelectRiver implements StatusControllerState {

	GameWindow window;
	StatusController context; 
	
	public SelectRiver(StatusController context, GameWindow window) {
		this.context = context;
		this.window = window;
	}
	
	@Override
	public void cycleUp() {
		// TODO Auto-generated method stub
		window.highlightTerrainOption();
		context.setCurrentState(context.getSelectTerrainState());
	}

	@Override
	public void cycleDown() {
		// TODO Auto-generated method stub
		window.highlightRotateOption();
		context.setCurrentState(context.getRotateState());
	}

	@Override
	public void cycleLeft() {
		// TODO Auto-generated method stub
		context.decrementRiverIndex();
		window.setRiverType(context.getSelectedRiverType());
	}

	@Override
	public void cycleRight() {
		// TODO Auto-generated method stub
		context.incrementRiverIndex();
		window.setRiverType(context.getSelectedRiverType());
	}

	
}
