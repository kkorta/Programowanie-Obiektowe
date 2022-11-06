package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d upperRight;
    protected Vector2d lowerLeft;

    public boolean canMoveTo(Vector2d position) {
        return position.precedes(lowerLeft) && position.follows(upperRight) && !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getCoOrdinates())) {
            animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    @Override
    public String toString() {return visualizer.draw(lowerLeft, upperRight);}

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }
}
