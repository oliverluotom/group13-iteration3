package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.model.map.*;
import com.iteration3.view.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class MapFileController {
    private Map map;
    private EventHandler<ActionEvent> mapFileImporter, mapFileExporter;
    private GameWindow gameWindow;
    private GameModel gameModel;

    private FileChooser fileChooser;
    private String directoryPath;
    private String fileName;

    MapFileController(GameModel model, GameWindow window){
        gameModel = model;
        gameWindow = window;
        map = model.getMap();
        String fileLocation = "~/"; // TODO: default user home directory?
        String fileName = "boatsAndRoadsMap.txt";
        createHandlers();
        setupFileChooser();
    }

    private void setupFileChooser(){
        fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Text File", "*.txt"));

        directoryPath = "/";
        fileChooser.setInitialDirectory(new File(directoryPath));

        fileName = "RoadsAndBoatsMap.txt";
        fileChooser.setInitialFileName(fileName);
    }

    public void saveMap(){
        fileChooser.setTitle("Select A File to Save To");
        File saveLocation = fileChooser.showSaveDialog(new Stage());
        if(saveLocation == null)
            return;
        gameModel.setPath(saveLocation.toString());
        try {
            gameModel.fillTextFileFromMap();
        } catch(IOException e){
            System.out.println("Error saving map!");
        }
    }

    public void loadMap(){
        fileChooser.setTitle("Select A Map File To Load");
        File fileLocation = fileChooser.showOpenDialog(new Stage());
        if(fileLocation == null)
            return;
        gameModel.setPath(fileLocation.toString());
        try {
            gameModel.fillMapFromTextFile();
        } catch(IOException e){
            System.out.println("Error loading map!");
        }
    }

    private void createHandlers(){
        mapFileImporter = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){

                loadMap();
            }
        };

       mapFileExporter = new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                saveMap();
            }
        };

       gameWindow.setOnClickExport(mapFileExporter);
       gameWindow.setOnClickImport(mapFileImporter);
    }
}
