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
                    break;
                case "b", "backward":
                    MD[i] = MoveDirection.BACKWARD;
                    break;
                case "r", "right":
                    MD[i] = MoveDirection.RIGHT;
                    break;
                case "l", "left":
                    MD[i] = MoveDirection.LEFT;
                    break;
                default:
                    counter++;
                    break;
            }
        }
        MoveDirection[] result = new MoveDirection[len - counter];
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
