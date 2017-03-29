package com.iteration3.view;

import com.iteration3.model.map.Location;
import com.iteration3.utilities.Assets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MapView extends Pane{
    private final int MAX_CAMERA_X_BOUND = 660;
    private final int MIN_CAMERA_X_BOUND = -660;
    private final int MAX_CAMERA_Y_BOUND = 660;
    private final int MIN_CAMERA_Y_BOUND = -660;

    private final int MAX_MAP_X_BOUND = 850;
    private final int MAX_MAP_Y_BOUND = 300;
    private final int MIN_MAP_X_BOUND = 350;
    private final int MIN_MAP_Y_BOUND = 100;

    private final int X_OFFSET = 11;
    private final int X_PIXEL_OFFSET = 52;
    private final int Y_OFFSET = 3;
    private final int Y_PIXEL_OFFSET = 60;
    private final int X_OFFSET2 = 30;

    private double cameraX = -200, cameraY = -200;
    private int cameraSpeed = 16;
    private Assets images;
    private Canvas mapCanvas;
    private Location cursorLocation;
    private GraphicsContext gc;
    private int mapSizeRadius;

    public MapView(double width, double height) {
        this.mapSizeRadius = 10;
        this.images = new Assets();
        cursorLocation = new Location(0,0,0);
        this.setWidth(width);
        this.setHeight(height);
        this.mapCanvas = new Canvas(this.getWidth(),this.getHeight());
        this.gc = getMapCanvas().getGraphicsContext2D();
        initializePane();
    }

    public Canvas getMapCanvas() {
        return mapCanvas;
    }

    private void initializePane() {
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
        clearCanvas();
        drawCursor();
        drawEmptyHexGrid();
    }

    private void drawEmptyHexGrid() {
        // Draw Empty Hex Grid
        int size = getMapSizeRadius();
        for(int x = -size; x <= size; x++){
            for(int y = -size; y <= size; y++){
                if(x+y<=size && x+y>=-size) {
                    gc.drawImage(images.getImage("empty"), (x + getXOffset()) * getXPixelOffset() + getCameraX(), (y + getYOffset()) * getYPixelOffset() + (getXOffset2() * x) + getCameraY());
                }
            }
        }
    }

    public void drawCursor(){
        gc.drawImage(images.getImage("cursor"),(cursorLocation.getX()+getXOffset())*getXPixelOffset() + getCameraX(), (cursorLocation.getZ()+getYOffset())*getYPixelOffset() + (getXOffset2() * cursorLocation.getX()) + getCameraY());
    }

    public void update(){
        clearCanvas();
        drawEmptyHexGrid();
        drawCursor();
    }

    public Location getCursorLocation(){
        return cursorLocation;
    }

    //TODO FIX LOD VIOLATIONS
    public void moveCursorNW(){
        if(cursorLocation.getNorthWest().outOfBounds(getMapSizeRadius())) {
            cursorLocation = cursorLocation.getNorthWest();
        }
    }
    public void moveCursorNE(){
        if(cursorLocation.getNorthEast().outOfBounds(getMapSizeRadius())) {
            cursorLocation = cursorLocation.getNorthEast();
        }
    }
    public void moveCursorSW(){
        if(cursorLocation.getSouthWest().outOfBounds(getMapSizeRadius())) {
            cursorLocation = cursorLocation.getSouthWest();
        }
    }
    public void moveCursorSE(){
        if(cursorLocation.getSouthEast().outOfBounds(getMapSizeRadius())) {
            cursorLocation = cursorLocation.getSouthEast();
        }
    }
    public void moveCursorNorth(){
        if(cursorLocation.getNorth().outOfBounds(getMapSizeRadius())) {
            cursorLocation = cursorLocation.getNorth();
        }
    }
    public void moveCursorSouth(){
        if(cursorLocation.getSouth().outOfBounds(getMapSizeRadius())) {
            cursorLocation = cursorLocation.getSouth();
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
        if (getCameraY() - getCameraSpeed() < getMinCameraYBound()) {
            setCameraY(getMinCameraYBound());
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

    public int getXOffset() {
        return X_OFFSET;
    }
    public int getXOffset2() {
        return X_OFFSET2;
    }
    public int getYOffset() {
        return Y_OFFSET;
    }
    public int getXPixelOffset() {
        return X_PIXEL_OFFSET;
    }
    public int getYPixelOffset() {
        return Y_PIXEL_OFFSET;
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

    public GraphicsContext getGc() {
        return gc;
    }

    private void clearCanvas() {
        getGc().setFill(Color.TRANSPARENT);
        getGc().fillRect(0,0,getMapCanvas().getWidth(),getMapCanvas().getHeight());
        getGc().setFill(Color.BLACK);
        getGc().fillRect(0,0,getMapCanvas().getWidth(),getMapCanvas().getHeight());
        getGc().setFill(Color.WHITE);
    }

    public void drawTile(String imageURL, int x, int y) {
        getGc().drawImage(images.getImage(imageURL), (x + getXOffset()) * getXPixelOffset() + getCameraX(), (y + getYOffset()) * getYPixelOffset() + (getXOffset2() * x) + getCameraY());
    }

    public void drawRiver(String imageURL, int x, int y) {
        gc.drawImage(images.getImage(imageURL), (x + 11) * 52 + getCameraX(), (y + 3) * 60 + (30 * x) + getCameraY());
    }

    public int getMapSizeRadius() {
        return mapSizeRadius;
    }

}
