import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.model.map.MapFileManager;
import com.iteration3.model.tile.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing map functionality
 */
public class MapTest {

    @Test
    public void testContains(){
        Map map = new Map();
        map.getTiles().put(new Location(0,0,0), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(1,-1,1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(-1,1,1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(-1,1,-1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(1,1,1), new Tile(new SeaTerrain()));
        assertEquals(map.getTiles().containsKey(new Location(0,0,0)), true);
        assertEquals(map.getTiles().containsKey(new Location(1,-1,1)), true);
        assertEquals(map.getTiles().containsKey(new Location(-1,1,1)), true);
        assertEquals(map.getTiles().containsKey(new Location(-1,1,-1)), true);
        assertEquals(map.getTiles().containsKey(new Location(1,1,1)), true);
        assertEquals(map.getTiles().size(),5);
        map.printTiles();
    }

    @Test
    public void testAdjacencyValidation(){
        Map map = new Map();
        assertEquals(map.validateTileAdjacency(new Location(0,0,0)), true);
        map.addTileFromFile(new Location(0,0,0), new Tile(new PastureTerrain()));
        assertEquals(map.validateTileAdjacency(new Location(0,1,-1)),true);
        assertEquals(map.validateTileAdjacency(new Location(-1,1,0)),true);
        assertEquals(map.validateTileAdjacency(new Location(-1,0,1)),true);
        assertEquals(map.validateTileAdjacency(new Location(0,-1,1)),true);
        assertEquals(map.validateTileAdjacency(new Location(1,-1,0)),true);
        assertEquals(map.validateTileAdjacency(new Location(1,0,-1)),true);
        assertEquals(map.validateTileAdjacency(new Location(2,1,-1)),false);
        assertEquals(map.validateTileAdjacency(new Location(-1,2,5)),false);
        assertEquals(map.validateTileAdjacency(new Location(-1,13,2)),false);
        assertEquals(map.validateTileAdjacency(new Location(10,-1,7)),false);
        assertEquals(map.validateTileAdjacency(new Location(12,-8,10)),false);
        assertEquals(map.validateTileAdjacency(new Location(10,5,-6)),false);
    }

    @Test
    public void testRiverValidation(){
        Map map = new Map();
        map.addTileFromFile(new Location(0,0,0), new Tile(new SeaTerrain()));
        assertEquals(map.validateRiverLocation(new Location(0,1,-1), new River(1)),true);
        map.addRiverFromFile(new Location(0,1,-1), new River(1));
        map.addTileFromFile(new Location(0,1,-1), new Tile(new WoodsTerrain()));
        assertEquals(map.validateRiverLocation(new Location(1,0,-1), new River(6)), false);
        map.addTileFromFile(new Location(1,0,-1), new Tile(new WoodsTerrain()));
        assertEquals(map.validateRiverLocation(new Location(1,-1,0), new River(1)), false);
        assertEquals(map.validateRiverLocation(new Location(1,-1,0), new River(6)), true);
        map.addTileFromFile(new Location(1,-1,0), new Tile(new PastureTerrain()));
        map.addRiverFromFile(new Location(1,-1,0), new River(6));
        assertEquals(map.validateRiverLocation(new Location(1,10,0), new River(1)), false);
        assertEquals(map.validateTileLocation(new Location(0,2,-2),new Tile(new WoodsTerrain())),false);
        map.addTileFromGUI(new Location(0,2,-2),new Tile(new WoodsTerrain()));
        assertEquals(map.getTiles().containsKey(new Location(0,2,-2)), false);
        assertEquals(map.validateRiverLocation(new Location(0,2,-2),new River(4)),true);
        map.addRiverFromGUI(new Location(0,2,-2),new River(4));
        assertEquals(map.validateTileLocation(new Location(0,2,-2),new Tile(new WoodsTerrain())),true);
        map.addTileFromGUI(new Location(0,2,-2),new Tile(new WoodsTerrain()));
        assertEquals(map.getTiles().containsKey(new Location(0,2,-2)), true);
    }

    @Test
    public void testInvalidFileToMap() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/model/map/mapFileReadInvalid.txt");

        mapManager.fillMapFromTextFile();

        assertEquals(map.getTiles().size(), 0);
        assertEquals(map.getRivers().size(), 0);

        // need to print edges and tiles to check if they are correct
        map.printRivers();
        map.printTiles();
    }

    // TODO: create better valid map text file
    @Test
    public void testValidFileToMap() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/model/map/mapFileReadValid.txt");

        mapManager.fillMapFromTextFile();

        assertEquals(map.getTiles().size(), 7);
        assertEquals(map.getRivers().size(), 0);

        // need to print edges and tiles to check if they are correct
        map.printRivers();
        map.printTiles();
    }

    @Test
    public void testMapToFile() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/model/map/mapFileWrite.txt");

        map.addTileFromFile(new Location(0,0,0), new Tile(new PastureTerrain()));
        map.addTileFromFile(new Location(0,0,1), new Tile(new WoodsTerrain()));
        map.addTileFromFile(new Location(0,1,-1), new Tile(new WoodsTerrain()));

        map.addRiverFromFile(new Location(0,0,0), new River(1));
        map.addRiverFromFile(new Location(0,1,-1), new River(4, 1));

        mapManager.fillTextFileFromMap();

    }



}

