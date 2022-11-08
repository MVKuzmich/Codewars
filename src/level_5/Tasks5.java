package level_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Tasks5 {
    /*
    The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal
    representation being returned. Valid decimal values for RGB are 0 - 255.
     Any values that fall out of that range must be rounded to the closest valid value.
     Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
    The following are examples of expected output values:
    RgbToHex.rgb(255, 255, 255) // returns FFFFFF
    RgbToHex.rgb(255, 255, 300) // returns FFFFFF
    RgbToHex.rgb(0, 0, 0)       // returns 000000
    RgbToHex.rgb(148, 0, 211)   // returns 9400D3
     */
    public String rgb(int r, int g, int b) {
        int[] array = {r, g, b};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 255) {
                array[i] = 255;
            }
            if (array[i] < 0) {
                array[i] = 0;
            }
        }
        return String.format("%02X%02X%02X", array[0], array[1], array[2]);
    }

    /*
    Other examples:
    In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.
    The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).
    In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite
    but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
     */
    public String[] dirReduc(String[] arr) {
        List<Integer> list = convertArrayToInteger(arr);
        List<Integer> buff = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i) + list.get(i + 1) != 0) {
                buff.add(list.get(i));
            } else if (i == list.size() - 1) {
                buff.add(list.get(i));
            } else {
                buff.addAll(list.subList(i + 2, list.size()));
                break;
            }
        }
        if (arr.length == buff.size() || buff.size() == 1) {
            return convertListToString(buff);
        }
        return dirReduc(convertListToString(buff));
    }

    private List<Integer> convertArrayToInteger(String[] array) {
        List<Integer> buffer = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case "NORTH":
                    buffer.add(-1);
                    break;
                case "SOUTH":
                    buffer.add(1);
                    break;
                case "EAST":
                    buffer.add(2);
                    break;
                case "WEST":
                    buffer.add(-2);
                    break;
                default:
                    System.out.println("Illegal value");
            }
        }
        return buffer;
    }

    private String[] convertListToString(List<Integer> list) {
        String[] buffer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case -1:
                    buffer[i] = "NORTH";
                    break;
                case 1:
                    buffer[i] = "SOUTH";
                    break;
                case 2:
                    buffer[i] = "EAST";
                    break;
                case -2:
                    buffer[i] = "WEST";
                    break;
                default:
                    System.out.println("Illegal value");
            }
        }
        return buffer;
    }


    /*
    The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
    Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    // should be 6: {4, -1, 2, 1}
    Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
    If the list is made up of only negative numbers, return 0 instead.

    Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
     */
    public int sequence(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        if (checkPositive(arr)) {
            return IntStream.range(0, arr.length).map(item -> arr[item]).reduce(0, Integer::sum);
        } else if (checkNegative(arr) || arr.length == 0) {
            return 0;
        } else {

            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                sum += arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    sum += arr[j];
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }

    private boolean checkPositive(int[] arr) {
        return Arrays.stream(arr).filter(item -> item > 0).toArray().length == arr.length;
    }

    private boolean checkNegative(int[] arr) {
        return Arrays.stream(arr).filter(item -> item < 0).toArray().length == arr.length;
    }

    public int sequence1(int[] arr) {

        int sum = 0;
        int max = 0;

        for(int a : arr) {
            sum += a;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
    /*
    For seconds = 62, your function should return
    "1 minute and 2 seconds"
    For seconds = 3662, your function should return
    "1 hour, 1 minute and 2 seconds"
     */

}