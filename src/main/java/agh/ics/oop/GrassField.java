package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final int grassNum;
    public List<Grass> grassList;
    private final int maxGrassRange;
    private final int minGrassRange;

    public GrassField(int grassNum){
        super(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1);
        this.grassNum = grassNum;
        this.maxGrassRange = (int) Math.sqrt(grassNum * 10);
        this.minGrassRange = 0;
        grassList = new ArrayList<>();
        for (int i = 0; i < grassNum; i++) {
            while (true) {
                if (spawnGrass())
                    break;
            }
        }

    }


    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position))
            return true;
        for (Grass grass : grassList) {
            if (position.equals(grass.getPosition()))
                return true;
        }

        return false;
    }

    public Vector2d getDrawLowerLeft() {
        Vector2d drawLowerLeft = upperRight;
        for (Vector2d pos : animals.keySet()) {
            drawLowerLeft = drawLowerLeft.lowerLeft(pos);
        }
        for (Grass grass : grassList) {
            drawLowerLeft = drawLowerLeft.lowerLeft(grass.getPosition());
        }
        return drawLowerLeft;
    }

    public Vector2d getDrawUpperRight() {
        Vector2d drawUpperRight = lowerLeft;
        for (Vector2d pos : animals.keySet()) {
            drawUpperRight = drawUpperRight.lowerLeft(pos);
        }
        for (Grass grass : grassList) {
            drawUpperRight = drawUpperRight.upperRight(grass.getPosition());
        }
        return drawUpperRight;
    }
    public boolean spawnGrass() {
        int randomX = (int) (Math.random() * maxGrassRange) + minGrassRange;
        int randomY = (int) (Math.random() * maxGrassRange) + minGrassRange;
        Vector2d randomPos = new Vector2d(randomX, randomY);
        if (objectAt(randomPos) == null) {
            grassList.add(new Grass(randomPos));
            return true;
        }
        return false;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

    }
}
