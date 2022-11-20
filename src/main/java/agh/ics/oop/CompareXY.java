package agh.ics.oop;

import java.util.Comparator;

public class CompareXY implements Comparator<Vector2d> {

    private boolean compareByX = false;

    public CompareXY(boolean comp){
        this.compareByX = comp;
    }
    @Override
    public int compare(Vector2d v1, Vector2d v2){
        if (compareByX){
            if ((v1.x< v2.x) || (v1.y < v2.y))
                return -1;
            else if ((v1.x > v2.x) || (v1.y > v2.y))
                return 1;
        }
        else{
            if ((v1.y< v2.y) || (v1.x < v2.x))
                return -1;
            else if ((v1.y > v2.y) || (v1.x > v2.x))
                return 1;
        }
        return 0;
    }
}

