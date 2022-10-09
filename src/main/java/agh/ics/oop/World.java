package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartował");
        run(change(args));
        System.out.println("system zakończył działanie");

    }

    public static Direction[] change(String[] strings){
        Direction[] directions = new Direction[strings.length];
        for (int i = 0; i < strings.length; i++){
            switch (strings[i]){
                case "f": directions[i] = Direction.FORWARD; break;
                case "b": directions[i] = Direction.BACKWARD; break;
                case "l": directions[i] = Direction.LEFT; break;
                case "r": directions[i] = Direction.RIGHT; break;
                default: directions[i] = Direction.IGNORE; break;
            }
        }
        return directions;
    }

    public static void run(Direction[] direction){
        int len = direction.length;
        System.out.println("Start");
        for (int i = 0 ; i < len; i++){
            read_message(direction[i]);
            if (i < len - 1){
                System.out.print(", ");
            }
        }
        System.out.println("");
        System.out.println("Koniec");

    }

    public static void read_message(Direction direction){
        String message = switch (direction){
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tyłu";
            case LEFT ->"Zwierzak skręca w lewo";
            case RIGHT -> "Zwierzak skręca w prawo";
            default -> "unknown";
        };
        System.out.print(message);
    }
}