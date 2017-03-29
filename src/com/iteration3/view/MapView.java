package com.iteration3.view;

import com.iteration3.utilities.Assets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MapView extends Pane{
    private int MAX_CAMERA_X_BOUND;
    private int MIN_CAMERA_X_BOUND;
    private int MAX_CAMERA_Y_BOUND;
    private int MIN_CAMERA_Y_BOUND;

    private int MAX_MAP_X_BOUND;
    private int MAX_MAP_Y_BOUND;
    private int MIN_MAP_X_BOUND;
    private int MIN_MAP_Y_BOUND;

    private Assets images;
    private double cameraX, cameraY;
    private int cameraSpeed;
    private Canvas mapCanvas;

    public MapView(double width, double height) {
        this.images = new Assets();

        this.setWidth(width);
        this.setHeight(height);
        initializePane();
    }

    public Canvas getMapCanvas() {
        return mapCanvas;
    }

    private void initializePane() {

        this.mapCanvas = new Canvas(this.getWidth(),this.getHeight());
        this.mapCanvas.addEventFilter(MouseEvent.MOUSE_MOVED,
                event -> {
                    if (canMoveCameraRight(event.getSceneX())) {
                        moveCameraRight();
                    }
                    if (canMoveCameraLeft(event.getSceneX())) {
                        moveCameraLeft();
                    }
                    if (canMoveCameraUp(event.getSceneY())) {
                        moveCameraUp();
                    }
                    if (canMoveCameraDown(event.getSceneY())) {
                        moveCameraDown();
                    }
                });
        this.getChildren().add(getMapCanvas());
        GraphicsContext gc = getMapCanvas().getGraphicsContext2D(); // Clears whatever is currently on the canvas
        gc.setFill(Color.TRANSPARENT);
        gc.fillRect(0,0,getMapCanvas().getWidth(),getMapCanvas().getHeight());
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,getMapCanvas().getWidth(),getMapCanvas().getHeight());
        gc.setFill(Color.WHITE);
        gc.drawImage(images.getImage("cursor"), 200, 200);

        //gc.drawImage(images.getImage("desert"), 200, 200);

        int numTiles = 21;
        for(int x = 0; x <= 11; x++){
            for(int y = 0; y <= numTiles; y++){
                if(x%2!=0){
                    gc.drawImage(images.getImage("desert"), (x) * 52, (y) * 60 + 30 * x);
                    gc.drawImage(images.getImage("desert"), (-x) * 52, (y) * 60 + 30 * x);
                }
                else {
                    gc.drawImage(images.getImage("desert"), (x) * 52, (y) * 60 + 30 * x);
                    gc.drawImage(images.getImage("desert"), (-x) * 52, (y) * 60 + 30 * x);
                }
            }
            numTiles--;
        }
    }

    // Camera Navigation Methods
    public void moveCameraRight() {
        if (getCameraX() - getCameraSpeed() < getMinCameraXBound()) {
            setCameraX(getMinCameraXBound());
        }
        else {
            setCameraX(getCameraX() - getCameraSpeed());
        }
    }
    public void moveCameraLeft() {
        if (getCameraX() + getCameraSpeed() > getMaxCameraXBound()) {
            setCameraX(getMaxCameraXBound());
        }
        else {
            setCameraX(getCameraX() + getCameraSpeed());
        }
    }
    public void moveCameraUp() {
        if (getCameraY() + getCameraSpeed() > getMaxCameraYBound()) {
            setCameraY(getMaxCameraYBound());
        }
        else {
            setCameraY(getCameraY() + getCameraSpeed());
        }
    }
    public void moveCameraDown() {
        if (getCameraY() - getCameraSpeed() < getMaxCameraYBound()) {
            setCameraY(getMaxCameraYBound());
        }
        else {
            setCameraY(getCameraY() - getCameraSpeed());
        }
    }

    public void setCameraX(double cameraX) {
        this.cameraX = cameraX;
    }
    private double getCameraX() {
        return cameraX;
    }
    public void setCameraY(double cameraY) {
        this.cameraY = cameraY;
    }
    private double getCameraY() {
        return cameraY;
    }
    private int getCameraSpeed() {
        return cameraSpeed;
    }

    public int getMaxCameraXBound() {
        return MAX_CAMERA_X_BOUND;
    }
    public int getMaxCameraYBound() {
        return MAX_CAMERA_Y_BOUND;
    }
    public int getMinCameraXBound() {
        return MIN_CAMERA_X_BOUND;
    }
    public int getMinCameraYBound() {
        return MIN_CAMERA_Y_BOUND;
    }
    public int getMaxMapXBound() {
        return MAX_MAP_X_BOUND;
    }
    public int getMaxMapYBound() {
        return MAX_MAP_Y_BOUND;
    }
    public int getMinMapXBound() {
        return MIN_MAP_X_BOUND;
    }
    public int getMinMapYBound() {
        return MIN_MAP_Y_BOUND;
    }

    private boolean canMoveCameraRight(double mousePositionX) {
        if (mousePositionX > getMaxMapXBound()) {
            return true;
        }
        return false;
    }
    private boolean canMoveCameraLeft(double mousePositionX) {
        if (mousePositionX < getMinMapXBound()) {
            return true;
        }
        return false;
    }
    private boolean canMoveCameraUp(double mousePositionY) {
        if (mousePositionY < getMinMapYBound()) {
            return true;
        }
        return false;
    }
    private boolean canMoveCameraDown(double mousePositionY) {
        if (mousePositionY > getMaxMapYBound()) {
            return true;
        }
        return false;
    }

}
