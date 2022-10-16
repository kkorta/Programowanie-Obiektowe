package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        Vector2d vector1 = new Vector2d(1,3);
        Vector2d vector2 = new Vector2d(1,3);
        Vector2d vector3 = new Vector2d(-1,0);
        assertTrue(vector1.equals(vector2));
        assertFalse(vector1.equals(vector3));
    }

    @Test
    public void toStringTest(){
        assertEquals(new Vector2d(-1,-1).toString(), "(-1,-1)");
    }

    @Test
    public void precedesTest() {
        assertFalse(new Vector2d(7, 7).precedes(new Vector2d(3, 4)));
        assertFalse(new Vector2d(2, 5).precedes(new Vector2d(7, 4)));
        assertTrue(new Vector2d(-5, -2).precedes(new Vector2d(1, 2)));
        assertFalse(new Vector2d(10, 2).precedes(new Vector2d(4, 6)));
    }

    @Test
    public void followsTest(){
        assertFalse(new Vector2d(4,4).follows(new Vector2d(7,3)));
        assertFalse(new Vector2d(4,4).follows(new Vector2d(3,7)));
        assertTrue(new Vector2d(10,5).follows(new Vector2d(3,4)));
        assertFalse(new Vector2d(-1,-2).follows(new Vector2d(0,0)));
    }

    @Test
    public void lowerLeftTest(){
        assertEquals(new Vector2d(4, 6).lowerLeft(new Vector2d(5,4)), new Vector2d(4,4));
    }

    @Test
    public void upperRightTest(){
        assertEquals(new Vector2d(4, 6).upperRight(new Vector2d(5,4)), new Vector2d(5,6));
    }

    @Test
    public void addTest(){
        assertEquals(new Vector2d(4, 6).add(new Vector2d(5, 4)), new Vector2d(9, 10));
    }

    @Test
    public void subtractTest(){
        assertEquals(new Vector2d(4, 6).subtract(new Vector2d(5, 4)), new Vector2d(-1, 2));
    }

    @Test
    public void oppositeTest(){
        assertEquals(new Vector2d(3, 4).opposite(), new Vector2d(-3, -4));
    }
}