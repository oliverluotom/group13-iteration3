package com.iteration3.controller;

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
		
	}

	@Override
	public void cycleRight() {
		// TODO Auto-generated method stub
		
	}

	
}
