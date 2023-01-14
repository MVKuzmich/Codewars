package level_5;

import java.math.BigInteger;
import java.util.Arrays;

public class SumSquarePerimeter {

    public BigInteger perimeter(BigInteger n) {
        BigInteger size = n.add(BigInteger.valueOf(2L));
        BigInteger multiplier4 = BigInteger.valueOf(4);

        BigInteger[] arr = new BigInteger[size.intValue()];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 1) {
                arr[i] = BigInteger.valueOf(i);
            } else {
                arr[i] = BigInteger.valueOf(0);
                for (int j = i - 2; j < i; j++) {
                    arr[i] = arr[i].add(arr[j]);
                }
            }
        }
        return Arrays.stream(arr).reduce(BigInteger::add).get().multiply(multiplier4);
    }
}
