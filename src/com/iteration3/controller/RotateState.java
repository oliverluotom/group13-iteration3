package com.iteration3.controller;

import java.util.ArrayList;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;

public class RotateState implements StatusControllerState {

	GameWindow window;
	StatusController context; 
	
	public RotateState(StatusController context, GameWindow window) {
		this.context = context;
		this.window = window;
		
	}
	
	@Override
	public void cycleUp() {
		// TODO Auto-generated method stub
		window.highlightRiverOption();
		context.setCurrentState(context.getSelectRiverState());
	}

	@Override
	public void cycleDown() {
		// TODO Auto-generated method stub
		window.highlightTerrainOption();
		context.setCurrentState(context.getSelectTerrainState());
	}

	@Override
	public void cycleLeft() {
		// TODO Auto-generated method stub
		if(context.hasSelectedRiver()) {
			ArrayList<Integer> edges = context.getCurrentRiverEdges();
			edges = context.rotateEdgesCounterClockWise(edges);
			context.setCurrentlySelectedRiverEdges(edges);
			
			context.displayCurrentTerrain();
			if(context.hasSelectedRiver()) context.displayCurrentRiver();
			
			if(context.isValidSubmission()) window.enableSubmit();
			else window.disableSubmit();
		}
		
	}

	@Override
	public void cycleRight() {
		// TODO Auto-generated method stub
		if(context.hasSelectedRiver()) {
			ArrayList<Integer> edges = context.getCurrentRiverEdges();
			edges = context.rotateEdgesClockWise(edges);
			context.setCurrentlySelectedRiverEdges(edges);
			
			context.displayCurrentTerrain();
			if(context.hasSelectedRiver()) context.displayCurrentRiver();
			
			if(context.isValidSubmission()) window.enableSubmit();
			else window.disableSubmit();
		}
	}

	
}
