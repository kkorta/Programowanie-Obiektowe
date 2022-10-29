package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {
    @Test
    public void testMoves() {
        MoveDirection[] directions = OptionParser.parse("f b r l f f r r f f f f f f f f".split(" "));
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };


        ArrayList<Animal> animals = new ArrayList<>();
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            animals.add(animal);
            map.place(animal);
        }

    }
}
