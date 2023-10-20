import java.util.*;

public class Level1 {
    public static boolean SherlockValidString(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        Set<Integer> counts = new HashSet<>(charCount.values());

        if (counts.size() == 1) {
            return true;
        }

        if (counts.size() == 2) {
            int minCount = Integer.MAX_VALUE;
            int maxCount = Integer.MIN_VALUE;
            for (int count : counts) {
                minCount = Math.min(minCount, count);
                maxCount = Math.max(maxCount, count);
            }
            if ((minCount == 1 && Collections.frequency(charCount.values(), minCount) == 1) ||
                    (maxCount - minCount == 1 && Collections.frequency(charCount.values(), maxCount) == 1)) {
                return true;
            }
        }

        return false;
    }
}
