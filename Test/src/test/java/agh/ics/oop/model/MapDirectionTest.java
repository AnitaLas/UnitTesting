package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MapDirectionTest {
    @Test
    void nextTest() {
        assertEquals(MapDirection.EAST, MapDirection.next(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.next(MapDirection.EAST));
        assertEquals(MapDirection.WEST, MapDirection.next(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.next(MapDirection.WEST));
    }

    @Test
    void previousTest() {
        assertEquals(MapDirection.EAST, MapDirection.previous(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.previous(MapDirection.EAST));
        assertEquals(MapDirection.WEST, MapDirection.previous(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.previous(MapDirection.WEST));
    }


    @Test
    void toStringTest() {
        assertEquals("Wschód", MapDirection.EAST.toString(MapDirection.EAST));
        assertEquals("Zachód", MapDirection.WEST.toString(MapDirection.WEST));
        assertEquals("Północ", MapDirection.NORTH.toString(MapDirection.NORTH));
        assertEquals("Południe", MapDirection.SOUTH.toString(MapDirection.SOUTH));

    }


    @Test
    void toUnitVectorTest() {

        assertEquals(new Vector2d(1, 0), MapDirection.toUnitVector(MapDirection.EAST));
        assertEquals(new Vector2d(-1, 0), MapDirection.toUnitVector(MapDirection.WEST));
        assertEquals(new Vector2d(0, 1), MapDirection.toUnitVector(MapDirection.NORTH));
        assertEquals(new Vector2d(0, -1), MapDirection.toUnitVector(MapDirection.SOUTH));

    }

}
