package level_6;

public class NumberUtils {

    public boolean isNarcissistic(int number) {
        int result = 0;
        String input = String.valueOf(number);
        int degree = input.length();
        for(int i = 0; i < input.length(); i++) {
            result += (int) Math.pow(Double.parseDouble(String.valueOf(input.charAt(i))), degree);
        }
        return result == number;
    }

}
