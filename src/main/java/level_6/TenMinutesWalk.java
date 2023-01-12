package level_6;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.List;

public class TenMinutesWalk {

    public boolean isValid(char[] walk) {
        long countS = 0;
        long countN = 0;
        long countW = 0;
        long countE = 0;

        for (int i = 0; i < walk.length; i++) {
            switch (walk[i]) {
                case 'n' -> countN++;
                case 's' -> countS++;

                case 'w' -> countW++;
                case 'e' -> countE++;
            }
        }
        return walk.length == 10 && countN == countS && countW == countE;
    }
}

