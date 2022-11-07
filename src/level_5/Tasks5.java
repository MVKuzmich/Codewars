package level_5;

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
        StringBuilder builder = new StringBuilder();
        int[] array = {r, g, b};
        for(int i = 0; i < array.length; i++) {
            if(array[i] > 255) {
                array[i] = 255;
            }
            if(array[i] < 0) {
                array[i] = 0;
            }
        }
        for(int i : array) {
            String hex = Integer.toHexString(i);
            builder.append((hex.length() == 1) ? "0".concat(hex) : hex);
        }

        return builder.toString().toUpperCase();
    }
}
