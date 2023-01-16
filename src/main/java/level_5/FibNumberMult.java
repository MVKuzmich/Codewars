package level_5;

import java.util.ArrayList;
import java.util.List;

public class FibNumberMult {

    public long[] productFib(long prod) {
        List<Long> fibArr = getFibRangeIfNextGreater(prod);
        for (int i = 0; i < fibArr.size() - 1; i++) {
            if (fibArr.get(i) * fibArr.get(i + 1) == prod) {
                return new long[]{fibArr.get(i), fibArr.get(i + 1), 1};
            } else if (fibArr.get(i) * fibArr.get(i + 1) > prod) {
                return new long[]{fibArr.get(i), fibArr.get(i + 1), 0};
            }
        }
        return new long[0];
    }

        public List<Long> getFibRangeIfNextGreater ( long number){
            List<Long> fibArr = new ArrayList<>();
            fibArr.add(0L);
            fibArr.add(1L);
            long currentItem = 0;
            while (currentItem < number) {
                currentItem = fibArr.get(fibArr.size() - 1) + fibArr.get(fibArr.size() - 2);
                fibArr.add(currentItem);
            }
            return fibArr;


        }

    }
