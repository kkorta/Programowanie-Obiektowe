package agh.ics.oop;

import java.util.LinkedList;

public class RectangularMap implements IWorldMap{
    private final Vector2d leftCorner;
    private final Vector2d rightCorner;
    MapVisualizer MV = new MapVisualizer(this);
    private LinkedList<Animal> animals = new LinkedList<>();


    RectangularMap(final int width, final int height){
        this.leftCorner = new Vector2d(0, 0);
        this.rightCorner = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(rightCorner) && position.follows(leftCorner) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getCoOrdinates())){return false;}
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.isAt(position)) return animal;
        }
        return null;
    }

    public String toString(){
        return MV.draw(leftCorner, rightCorner);
    }
}
