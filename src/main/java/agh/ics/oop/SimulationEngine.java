package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final IWorldMap map;
    private final Vector2d[] positions;
    private final MoveDirection[] MD;



    public SimulationEngine(MoveDirection[] MD, IWorldMap map, Vector2d[] positions){
        this.MD = MD;
        this.positions = positions;
        this.map = map;
    }

    public void addAnimals(){
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            boolean isPlaced = map.place(animal);
            if (isPlaced) animals.add(animal);
        }
    }


    @Override
    public void run() {
        int n = animals.size();
        for (int i = 0; i < MD.length; i++){
            if (n != 0){
            animals.get(i % n).move(MD[i]);}
        }

    }
}
