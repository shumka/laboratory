public class Level1 {
    public static boolean LineAnalysis(String line) {
        int n = line.length();

        if (n == 1 && line.charAt(0) == '*') {
            return true;
        }

        if (!line.startsWith("*") || !line.endsWith("*")) {
            return false;
        }

        String[] patterns = line.split("\\*");
        int patternLength = patterns[1].length();

        for (int i = 1; i < patterns.length - 1; i++) {
            if (patterns[i].length() != patternLength) {
                return false;
            }
        }

        return true;

    }
}
