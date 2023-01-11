package level_6;

public class TranslateRobotPath {

    private static final String COMMAND_PATTERN = "Take %d step%s %s";

    public String walk(String path) {
        String command = "";
        String[] signs = path.split("");
        String start = signs[0];
        int counter = 1;
        if (path.isEmpty()) {
            command = "Paused";
        } else if (signs.length == 1) {
            command = addDirection(command, start, counter);
        } else {
            for (int i = 1; i < signs.length; i++) {
                if (signs[i].equals(start)) {
                    counter++;
                } else {
                    command = addDirection(command, start, counter).concat("\n");
                    start = signs[i];
                    counter = 1;
                }
            }
            if(counter >= 1) {
                command = addDirection(command, start, counter);
            }

        }
        return command.trim();
    }

    private String addDirection(String command, String start, int counter) {
        return command.concat(String.format(COMMAND_PATTERN, counter, (counter > 1) ? "s" : "", convertSignToDirectionName(start)));
    }

    private String convertSignToDirectionName(String sign) {
        return switch (sign) {
            case "^" -> "up";
            case ">" -> "right";
            case "v" -> "down";
            case "<" -> "left";
            default -> "";
        };
    }

}
