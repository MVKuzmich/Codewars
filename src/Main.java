import level_6.Tasks6;
import level_7.Tasks7;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] first = new int[]{1, 3, 4, 8, 9, 1 , 1, 3};
        int[] second = new int[]{1, 9};
        String input = "iiisdoso";
        System.out.println(Arrays.toString(new Tasks6().arrayDiff(first, second)));
        System.out.println(Arrays.toString(new Tasks6().parse(input)));
    }
}