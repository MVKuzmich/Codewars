package level_4;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Tasks4 {

    /*
    For seconds = 62, your function should return
    "1 minute and 2 seconds"
    For seconds = 3662, your function should return
    "1 hour, 1 minute and 2 seconds"
     */
    public String formatDuration(int seconds) {
        String result = "";
        if (seconds == 0) {
            return "now";
        } else {
            int oneMinute = 60;
            int oneHour = oneMinute * 60;
            int oneDay = oneHour * 24;
            int oneYear = oneDay * 365;

            Map<String, Integer> time = new LinkedHashMap<>();
            time.put("year", seconds / oneYear);
            time.put("day", seconds % oneYear / oneDay);
            time.put("hour", seconds % oneDay / oneHour);
            time.put("minute", seconds % oneHour / oneMinute);
            time.put("second", seconds % oneMinute);
            List<String> timeParts = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : time.entrySet()) {
                if (time.get(entry.getKey()) > 0) {
                    timeParts.add(String.valueOf(entry.getValue()).concat(" ").concat((entry.getValue() > 1) ? entry.getKey().concat("s") : entry.getKey()));
                }
            }
            if (timeParts.size() == 1) {
                result = timeParts.get(0);
            } else if (timeParts.size() == 2) {
                result = String.join(" and ", timeParts);
            } else {
                String lastPart = " and " + timeParts.remove(timeParts.size() - 1);
                result = String.join(", ", timeParts).concat(lastPart);
            }
        }
        return result;
    }
}
