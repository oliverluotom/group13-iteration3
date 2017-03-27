package com.iteration3.controller;

import com.iteration3.model.map.Map;

/**
 * Created by Clay on 3/27/2017.
 */
public class LeftElementAction implements StatusAction {

    StatusController controller;
    Map map;
    public LeftElementAction(StatusController statusController, Map map) {
        controller = statusController;
        this.map = map;
    }

    public void execute(StatusController controller, Map map) {
        controller.nextElement();
    }
}
