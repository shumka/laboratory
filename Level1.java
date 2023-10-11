import java.util.*;

public class Level1 {
    public static boolean LineAnalysis(String line) {
        int n = line.length();

        if (n == 1 && line.charAt(0) == '*') {
            return true;
        }

        if (line.charAt(0) == '*' && line.charAt(1) == '*') {
            return true;
        }

        if (!line.startsWith("*") || !line.endsWith("*")) {
            return false;
        }

        List<String> list = new ArrayList<>(Arrays.asList(line.split("\\*")));
        list.removeIf(String::isEmpty);
        String[] patterns = list.toArray(new String[0]);

        int patternLength = patterns[0].length();

        System.out.println(Arrays.toString(patterns));
        for (int i = 0; i < patterns.length; i++) {
            if (patterns[i].length() != patternLength) {
                return false;
            }
        }

        return true;

    }
}
