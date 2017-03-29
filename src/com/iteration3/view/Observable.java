package com.iteration3.view;

public interface Observable {

	public void addObserver(Observer obs);
	public void removeObserver(Observer obs);
	public void notifyObserver(Observer obs);
	public void notifyAllObservers();
}
