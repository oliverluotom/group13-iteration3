package model;

import com.iteration3.model.map.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Philip on 3/29/2017.
 */
public class LocationTest {
    Location testLocation;

    @Before
    public void setUp() throws Exception {
        testLocation = new Location(0, 0, 0);
    }

    @After
    public void tearDown() throws Exception {
        testLocation = null;
    }

    @Test
    public void creationTest() throws Exception {
        assertNotNull(testLocation);
    }

    @Test
    public void setX() throws Exception {
    }

    @Test
    public void setY() throws Exception {
    }

    @Test
    public void setZ() throws Exception {
    }

    @Test
    public void equals() throws Exception {
    }

    @Test
    public void getNorth() throws Exception {
    }

    @Test
    public void getNorthEast() throws Exception {
    }

    @Test
    public void getNorthWest() throws Exception {
    }

    @Test
    public void getSouth() throws Exception {
    }

    @Test
    public void getSouthEast() throws Exception {
    }

    @Test
    public void getSouthWest() throws Exception {
    }

    @Test
    public void outOfBounds() throws Exception {
    }

}