package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected Vector2d upperRight;
    protected Vector2d lowerLeft;


    public AbstractWorldMap(int x1, int y1, int x2, int y2){
        this.upperRight = new Vector2d(x1, y1);
        this.lowerLeft = new Vector2d(x2, y2);

    }
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(lowerLeft) && position.follows(upperRight) && !(objectAt(position) instanceof Animal);
    }
    abstract Vector2d getDrawLowerLeft();

    abstract Vector2d getDrawUpperRight();



    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    @Override
    public String toString() {return visualizer.draw(getDrawLowerLeft(), getDrawUpperRight());}

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }
}
