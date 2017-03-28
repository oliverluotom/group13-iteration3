package com.iteration3.controller;

import com.iteration3.model.map.Map;

public class UpModeAction implements Action {

    StatusController controller;
    Map map;

    public UpModeAction(StatusController statusController, Map map) {
        controller = statusController;
        this.map = map;
    }

    public void execute() {
        controller.nextMode();
    }
}
