package level_4;

import java.util.*;
import java.util.stream.Collectors;

public class SecretDetective {

    public String recoverSecret(char[][] triplets) {
        List<Character> result = new ArrayList<>();

        for (char[] triplet : triplets) {
            char firstCh = triplet[0];
            char secondCh = triplet[1];
            char thirdCh = triplet[2];

            if (!result.contains(firstCh)) {
                result.add(0, firstCh);
            }

            if (!result.contains(secondCh)) {
                result.add(result.indexOf(firstCh), secondCh);
            }

            if (result.contains(secondCh) && result.indexOf(secondCh) < result.indexOf(firstCh)) {
                int index = result.indexOf(secondCh);
                result.remove(index);
                result.add(result.indexOf(firstCh) + 1, secondCh);
            }

            if (!result.contains(thirdCh)) {
                result.add(result.indexOf(secondCh), thirdCh);
            }

            if (result.contains(thirdCh) && result.indexOf(thirdCh) < result.indexOf(secondCh)) {
                int index = result.indexOf(thirdCh);
                result.remove(index);
                result.add(result.indexOf(secondCh) + 1, thirdCh);
            }
        }
        return String.join("", result.stream().map(String::valueOf).collect(Collectors.toList()));
    }
}
