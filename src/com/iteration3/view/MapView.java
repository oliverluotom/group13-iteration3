package com.iteration3.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MapView extends Pane{
    private Canvas mapCanvas;

    public MapView() {
        initializePane();
    }

    public Canvas getMapCanvas() {
        return mapCanvas;
    }

    private void initializePane() {
        this.mapCanvas = new Canvas();
        this.getChildren().add(this.mapCanvas);
    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        MapView mapView = new MapView();
//        Pane mapViewPane = mapView.getMapPane();
//        Scene scene = new Scene(mapViewPane, 200, 200);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Test MapView");
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
}
