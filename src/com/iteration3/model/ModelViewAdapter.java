package com.iteration3.model;

import com.iteration3.model.map.Map;
import com.iteration3.view.GameWindow;

public class ModelViewAdapter {
    private GameModel gameModel;
    private GameWindow gameWindow;

    public ModelViewAdapter(GameModel gm, GameWindow gw){
        gameModel = gm;
        gameWindow = gw;
    }

    public void update(){
        Map map = gameModel.getMap();

    }

}
