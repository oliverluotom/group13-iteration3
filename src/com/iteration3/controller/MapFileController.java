package iteration3.controller;

import com.iteration3.model.map.*;
import javafx.event.EventHandler;

import java.awt.event.ActionEvent;

public class MapFileController {
    Map map;
    String fileDirectory;
    String fileName;
    MapFileManager fileManager;

    MapFileController(Map map){
        this.map = map;
        fileLocation = "default"; // TODO: default user home directory?
    }

    saveMap(String directory, String name){

    }

    loadMap(String directory, String name){

    }

    EventHandler<ActionEvent> fileImportHandler = new EventHandler<ActionEvent>();
           handle(ActionEvent e);
}
