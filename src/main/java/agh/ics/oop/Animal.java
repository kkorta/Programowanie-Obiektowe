package agh.ics.oop;

public class Animal{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d coOrdinates;
    private final IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
        coOrdinates = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
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
    public Vector2d getCoOrdinates() {
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
}
