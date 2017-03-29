package com.iteration3;

import com.iteration3.model.GameModel;
import com.iteration3.model.ModelViewAdapter;
import com.iteration3.view.GameWindow;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameEngine extends Application{
    private int frameCounter = 0;
    private GameWindow gameWindow;
    private GameModel gameModel;
    private ModelViewAdapter MVA;
    @Override
    public void start(Stage primaryStage) throws Exception {
        gameWindow = new GameWindow(1221,726);
        gameModel = new GameModel();
        MVA = new ModelViewAdapter(gameModel, gameWindow);


        new AnimationTimer() {
            @Override
            public void handle(long currentPulse) {
                frameCounter++;
                if (frameCounter == 2) { //30 FPS
                    frameCounter = 0;
                    //TODO ADD CONTROLLER UPDATES AND VIEW RENDER UPDATES
                    MVA.update();
                    gameWindow.update();
                }

            }
        }.start();

        //TODO: Make size equal to screen resolution
        Scene scene = new Scene(gameWindow, 1221, 726);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Map Editor");
        primaryStage.show();
    }
}
