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

        List<String> listDot = new ArrayList<>(Arrays.asList(line.split("\\*")));
        List<String> listStars = new ArrayList<>(Arrays.asList(line.split("\\.")));
        listDot.removeIf(String::isEmpty);
        listStars.removeIf(String::isEmpty);
        String[] patternsDot = listDot.toArray(new String[0]);
        String[] patternsStars = listStars.toArray(new String[0]);

        int patternDotLength = patternsDot[0].length();
        int patternStarsLength = patternsStars[0].length();

        for (String patternsStar : patternsStars) {
        if (patternsStar.length() != patternStarsLength) {
        return false;
        }
        }
        for (String s : patternsDot) {
        if (s.length() != patternDotLength) {
        return false;
        }
        }

        return true;

        }
}
