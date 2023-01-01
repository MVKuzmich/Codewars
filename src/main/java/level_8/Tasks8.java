package level_8;

import java.util.Arrays;

public class Tasks8 {
    public int countSheeps(Boolean[] arrayOfSheeps) {
        // TODO May the force be with you
       return (int) Arrays.stream(arrayOfSheeps).filter(item -> item != null).filter(item -> item.booleanValue()).count();
    }
}
