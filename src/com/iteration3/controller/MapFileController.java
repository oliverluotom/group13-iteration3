package com.iteration3.controller;

import com.iteration3.model.map.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

public class MapFileController {
    Map map;
    String fileDirectory;
    String fileName;
    MapFileManager fileManager;

    MapFileController(Map map){
        this.map = map;
        String fileLocation = "~/"; // TODO: default user home directory?
        String fileName = "boatsAndRoadsMap.txt";

        // TODO: verify that this is implemented as needed
        EventHandler<ActionEvent> mapFileImporter = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                // TODO
            }
        };
        EventHandler<ActionEvent> mapFileExporter = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                // TODO
            }
        };
    }

    public void saveMap(String directory, String name){
        try {
            fileManager.fillTextFileFromMap();
        } catch(IOException e){
            System.out.println("Error saving map!");
        }
    }

    public void loadMap(String directory, String name) throws IOException {
        try {
            fileManager.fillMapFromTextFile();
        } catch(IOException e){
            System.out.println("Error loading map!");
        }
    }
}
