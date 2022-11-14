package agh.ics.oop;

import java.util.HashSet;

import java.util.Set;

public class Animal implements IMapElement{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d coOrdinates;
    private final Set<IPositionChangeObserver> observers = new HashSet<>(){};
    private final IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
        coOrdinates = new Vector2d(2, 2);
        addObserver((IPositionChangeObserver) map);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        addObserver((IPositionChangeObserver) map);
        this.coOrdinates = initialPosition;
    }

    @Override
    public String toString() {
        return switch (this.orientation){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }
    public Vector2d getPosition() {
        return coOrdinates;
    }
    public MapDirection getOrientation(){
        return orientation;
    }
    public boolean isAt(Vector2d position){
        return (position.x == coOrdinates.x) && (position.y == coOrdinates.y);
    }

    public void move(MoveDirection direction){


        Vector2d newPos = orientation.toUnitVector();
        switch (direction){
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                newPos = coOrdinates.add(orientation.toUnitVector());
                if (map.canMoveTo(newPos))
                {
                    coOrdinates = newPos;
                }
                break;
            case BACKWARD:
                newPos = coOrdinates.subtract(orientation.toUnitVector());
                if (map.canMoveTo(newPos))
                {
                    coOrdinates = newPos;
                }
                break;
        }

    }

    void changePosition(Vector2d oldPosition, Vector2d newPosition) {
        coOrdinates = newPosition;
        positionChanged(oldPosition, newPosition);
    }

    void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
