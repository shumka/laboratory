import java.util.Arrays;

public class Level1 {
    public static String Keymaker(int k) {
        char[] doors = new char[k];
        Arrays.fill(doors, '1');

        for (int n = 2; n <= k; n++) {
            for (int i = n-1; i < k; i += n) {
                if (doors[i] == '1') {
                    doors[i] = '0';  // Close door
                } else {
                    doors[i] = '1'; // Open door
                }
            }
        }
        return new String(doors);

    }
}

