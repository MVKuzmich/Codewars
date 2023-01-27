package level_5;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeDecomp {

    public String factors(int n) {
        List<String> l = new ArrayList<String>();
        for (int i = 2; i <= n; i++) {
            int times = 0;
            while (n % i == 0) {
                n /= i;
                times++;
            }
            if (times == 1) l.add(Integer.toString(i));
            else if (times > 1) l.add(String.format("%d**%d", i, times));
        }
        return l.stream().collect(Collectors.joining(")(", "(", ")"));
    }
}
