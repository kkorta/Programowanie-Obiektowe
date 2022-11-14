package agh.ics.oop;

public class World {
    public static void main(String[] args){

        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {
                new Vector2d(2,2),
                new Vector2d(3,4),
                new Vector2d(10, 4),
                new Vector2d(5, 7),
                new Vector2d(3, 4),
                new Vector2d(-5, 3)
        };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
    }


}