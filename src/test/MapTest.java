import com.iteration3.model.map.Location;
import com.iteration3.model.map.Map;
import com.iteration3.model.map.MapFileManager;
import com.iteration3.model.tile.PastureTerrain;
import com.iteration3.model.tile.River;
import com.iteration3.model.tile.Tile;
import com.iteration3.model.tile.WoodsTerrain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Testing map functionality
 */
public class MapTest {

    // TODO: Get relative path, was not working for me
    @Test
    public void testFileToMap() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "/Users/acoverstone/Desktop/Skool/COP4331/group13-iteration3/src/com/iteration3/model/map/mapFileRead.txt");

        mapManager.fillMapFromTextFile();

        assertEquals(map.getTiles().size(), 7);
        assertEquals(map.getRivers().size(), 2);

        // need to print edges and tiles to check if they are correct
        map.printRivers();
        map.printTiles();
    }

    @Test
    public void testMapToFile() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "/Users/acoverstone/Desktop/Skool/COP4331/group13-iteration3/src/com/iteration3/model/map/mapFileWrite.txt");

        map.addTileToMapFromFile(new Location(0,0,0), new Tile(new PastureTerrain()));
        map.addTileToMapFromFile(new Location(0,0,1), new Tile(new WoodsTerrain()));
        map.addTileToMapFromFile(new Location(0,1,-1), new Tile(new WoodsTerrain()));

        map.addRiverToMapFromFile(new Location(0,0,0), new River(1));
        map.addRiverToMapFromFile(new Location(0,1,-1), new River(4, 1));

        mapManager.fillTextFileFromMap();

    }


}

