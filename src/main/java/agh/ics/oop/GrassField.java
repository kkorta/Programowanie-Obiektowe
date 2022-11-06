package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final int grassNum;
    private List<Grass> grassList;
    private final int maxGrassRange;
    private final int minGrassRange;
    public GrassField(int grassNum){
        this.grassNum = grassNum;
        this.maxGrassRange = (int) Math.sqrt(grassNum * 10);
        this.minGrassRange = 0;
        createGrass();
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

    private void createGrass(){
        int i = grassNum;
        grassList = new ArrayList<>();
        Random random = new Random();
        while (i > 0){
            int x = random.nextInt(maxGrassRange);
            int y = random.nextInt(maxGrassRange);
            if (objectAt(new Vector2d(x, y)) == null){
                grassList.add(new Grass(new Vector2d(x, y)));
                i -= 1;
            }
        }
    }


}
