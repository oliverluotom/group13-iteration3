package com.iteration3;

import com.iteration3.view.GameWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameWindow gameWindow = new GameWindow(1221,726);

        //TODO: Make size equal to screen resolution
        Scene scene = new Scene(gameWindow, 1221, 726);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Map Editor");
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("Map Editor has started");
        launch(args);
    }
}
