package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void orientationTest(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertEquals("Północ", animal.getOrientation().toString());
        animal.move(MoveDirection.BACKWARD);
        assertEquals("Północ", animal.getOrientation().toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("Zachód", animal.getOrientation().toString());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        assertEquals("Wschód", animal.getOrientation().toString());
    }

    @Test
    public void positionTest(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,3)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2,2)));
    }

    @Test
    public void BoundariesTest(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,4)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0,4)));
    }
}