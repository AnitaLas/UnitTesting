package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {


    @Test
    void precedesTest() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 7);
        Vector2d p2 = new Vector2d(2, 7);
        Vector2d p3 = new Vector2d(10, 3);


        assertTrue(p0.precedes(p1));
        //assertEquals(true, p0.precedes(p1)); to samo co  assertTrue(p0.precedes(p1))
        assertTrue(p0.precedes(p2));
        assertTrue(p0.precedes(p3));
        assertTrue(p0.precedes(p0));

        assertFalse(p1.precedes(p0));
        assertFalse(p1.precedes(p2));
        assertFalse(p1.precedes(p3));
        assertTrue(p1.precedes(p1));

        assertFalse(p2.precedes(p3));
        assertTrue(p2.precedes(p2));
        assertTrue(p2.precedes(p1));
        assertFalse(p2.precedes(p0));

        assertFalse(p3.precedes(p2));
        assertTrue(p3.precedes(p1));
        assertFalse(p3.precedes(p0));
        assertTrue(p3.precedes(p3));

        //assertFalse(p1.precedes(p2));
    }
    @Test
    void addTest(){

        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 7);
        Vector2d p2 = new Vector2d(2, 7);

        assertEquals(p1, p0.add(p1));
        assertEquals(new Vector2d(20,14), p1.add(p1));
        assertEquals(p1, p1.add(p0));
        assertEquals(new Vector2d(12,14), p1.add(p2));

    }

    @Test
    void subtractTest(){

        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 7);
        Vector2d p2 = new Vector2d(2, 7);

        assertEquals(new Vector2d(-10,-7), p0.subtract(p1));
        assertEquals(new Vector2d(0,0), p1.subtract(p1));
        assertEquals(new Vector2d(10,7), p1.subtract(p0));
        assertEquals(new Vector2d(8,0), p1.subtract(p2));

    }

    @Test
    void equalsTest(){


    }



}
