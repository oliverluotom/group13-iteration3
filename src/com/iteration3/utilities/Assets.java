package com.iteration3.utilities;

import javafx.scene.image.Image;

import java.util.HashMap;

/**
 * Created by LesliesLaptop on 3/27/17.
 */
public class Assets {
    private HashMap<String, Image> images;

    public Assets() {
        images = new HashMap<String, Image>();
        initializeImages();
    }

    public void initializeImages() {
        // TODO: Consider making these values enums?
        images.put("desert", new Image("desert.png"));
        images.put("mountains", new Image("mountains.png"));
        images.put("pasture", new Image("pasture.png"));
        images.put("rock", new Image("rock.png"));
        images.put("sea", new Image("sea.png"));
        images.put("woods", new Image("woods.png"));
        images.put("empty", new Image("empty.png"));
    }

    public Image getImage(String imageName) {
        return images.get(imageName);
    }

}
