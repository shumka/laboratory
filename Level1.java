import java.util.ArrayList;
import java.util.List;

public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {

        String[] lines = splitString(s, len);


        int[] result = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = containsWord(lines[i], subs) ? 1 : 0;
        }

        return result;
    }

    private static String[] splitString(String s, int len) {
        List<String> lines = new ArrayList<>();
        String[] words = s.split(" ");
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            if (line.length() + word.length() <= len) {
                line.append(word).append(" ");
            } else {
                lines.add(line.toString().trim());
                line = new StringBuilder(word + " ");
            }
        }

        if (line.length() > 0) {
            lines.add(line.toString().trim());
        }

        return lines.toArray(new String[0]);
    }

    private static boolean containsWord(String line, String word) {
        return line.matches(".*\\b" + word + "\\b.*");
    }

}
