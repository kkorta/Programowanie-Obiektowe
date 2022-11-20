package agh.ics.oop;

public class OptionParser {
    public static MoveDirection[] parse(String[] strings){
        int len = strings.length;
        MoveDirection[] MD = new MoveDirection[len];
        int counter = 0;
        for (int i = 0; i < len; i++){
            switch (strings[i]){
                case "f", "forward":
                    MD[i] = MoveDirection.FORWARD;
                    counter++;
                    break;
                case "b", "backward":
                    MD[i] = MoveDirection.BACKWARD;
                    counter++;
                    break;
                case "r", "right":
                    MD[i] = MoveDirection.RIGHT;
                    counter++;
                    break;
                case "l", "left":
                    MD[i] = MoveDirection.LEFT;
                    counter++;
                    break;
                default:
                    throw new IllegalArgumentException(strings[i] + " is not a valid move keyword");
            }
        }
        MoveDirection[] result = new MoveDirection[counter];
        int j = 0;
        for (int i = 0; i < len; i++){
            if (MD[i] != null){
                result[j] = MD[i];
                j++;
            }
        }


        return result;
    }
}
