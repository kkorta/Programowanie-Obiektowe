package agh.ics.oop;

public class World {
    public static void main(String[] args){
        Animal animal = new Animal();
        OptionParser optionParser = new OptionParser();
        System.out.println(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.isAt(new Vector2d(2, 2));
        System.out.println(animal);
        String[] strings = {"l", "r", "c", "f", "a"};
        MoveDirection[] MD = optionParser.parse(strings);
         for (MoveDirection step: MD){
             animal.move(step);
         }
    }
    // Można zaimplemetowac inną klase która sprawdzała by czy w danym miejscu jest juz jakies zwierze i zwracalo wartosc true false

}