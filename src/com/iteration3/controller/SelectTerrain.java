package com.iteration3.controller;

import com.iteration3.model.GameModel;
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
		if(context.hasSelectedRiver()) {
			if(context.isValidSubmission())window.highlightRotateOption();
			else window.invalidateRotateOption();
			window.setRotateOption("Rotate Tile with Arrow Keys");
		}
		else {
			window.invalidateRotateOption();
			window.setRotateOption("Must Select River to Rotate with Arrow Keys");
		}
		context.setCurrentState(context.getRotateState());
	}

	@Override
	public void cycleDown() {
		// TODO Auto-generated method stub
		if(context.isValidSubmission())window.highlightRiverOption();
		else window.invalidateRiverOption();
		context.setCurrentState(context.getSelectRiverState());
	}

	@Override
	public void cycleLeft() {
		// TODO Auto-generated method stub
		context.decrementTerrainIndex();
		window.setTerrainType(context.getSelectedTerrainType());
		
		context.displayCurrentTerrain();
		if(context.hasSelectedRiver()) context.displayCurrentRiver();
		
		validateState();
	}

	@Override
	public void cycleRight() {
		// TODO Auto-generated method stub
		context.incrementTerrainIndex();
		window.setTerrainType(context.getSelectedTerrainType());
		
		context.displayCurrentTerrain();
		if(context.hasSelectedRiver()) context.displayCurrentRiver();
		
		validateState();
	}

	@Override
	public void validateState() {
		// TODO Auto-generated method stub
		if(context.isValidSubmission()) {
			window.highlightTerrainOption();
		}
		else {
			window.invalidateTerrainOption();
		}
	}

}
