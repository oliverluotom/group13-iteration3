package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.model.map.*;
import com.iteration3.view.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class MapFileController {
    private Map map;
    private MapFileManager fileManager;
    private EventHandler<ActionEvent> mapFileImporter, mapFileExporter;
    private GameWindow gameWindow;
    private GameModel gameModel;

    private FileChooser fileChooser;
    private String directoryPath;
    private String fileName;

    MapFileController(GameModel model, GameWindow window){
        gameModel = model;
        gameWindow = window;
        String fileLocation = "~/"; // TODO: default user home directory?
        String fileName = "boatsAndRoadsMap.txt";
        createHandlers();
    }

    private void setupFileChooser(){
        fileChooser = new FileChooser();
        fileChooser.setTitle("Select A Map File");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Text File", "*.txt"));

        directoryPath = "~/";
        fileChooser.setInitialDirectory(new File(directoryPath));

        fileName = "RoadsAndBoatsMap.txt";
        fileChooser.setInitialFileName(fileName);
    }

    public void saveMap(String directory, String name){
        try {
            fileManager.fillTextFileFromMap();
        } catch(IOException e){
            System.out.println("Error saving map!");
        }
    }

    public void loadMap(String directory, String name){
        try {
            fileManager.fillMapFromTextFile();
        } catch(IOException e){
            System.out.println("Error loading map!");
        }
    }

    private void createHandlers(){
        mapFileImporter = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){

                loadMap(directoryPath, fileName);
            }
        };

       mapFileExporter = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                saveMap(directoryPath, fileName);
            }
        };

       gameWindow.setOnClickExport(mapFileExporter);
       gameWindow.setOnClickImport(mapFileImporter);
    }
}
