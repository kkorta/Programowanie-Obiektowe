package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d coOrdinates = new Vector2d(2, 2);


    @Override
    public String toString() {
        return "(" + coOrdinates.x + ", " + coOrdinates.y + ", " + orientation + ")";
    }

    public MapDirection getOrientation(){
        return orientation;
    }
    public boolean isAt(Vector2d position){
        return (position.x == coOrdinates.x) && (position.y == coOrdinates.y);
    }

    public void move(MoveDirection direction){

        switch (direction){
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                Vector2d caseF = orientation.toUnitVector();
                coOrdinates.x += caseF.x;
                coOrdinates.y += caseF.y;
                coOrdinates.x = Math.max(coOrdinates.x, 0);
                coOrdinates.y = Math.max(coOrdinates.y, 0);
                coOrdinates.x = Math.min(coOrdinates.x, 4);
                coOrdinates.y = Math.min(coOrdinates.y, 4);
                break;
            case BACKWARD:
                Vector2d caseB = orientation.toUnitVector();
                coOrdinates.x -= caseB.x;
                coOrdinates.y -= caseB.y;
                coOrdinates.x = Math.max(coOrdinates.x, 0);
                coOrdinates.y = Math.max(coOrdinates.y, 0);
                coOrdinates.x = Math.min(coOrdinates.x, 4);
                coOrdinates.y = Math.min(coOrdinates.y, 4);
                break;
        }

    }
}
