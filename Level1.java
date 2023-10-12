public class Level1 {
    public static boolean MisterRobot(int N, int[] data) {
        int limit = N * N;
        int count = 0;

        while (count < limit) {
            boolean sorted = true;

            for (int i = 0; i < N - 2; i++) {
                if (data[i] > data[i + 1] || data[i + 1] > data[i + 2]) {
                    for (int x = 0; x < 3; x++) {
                        int temp = data[i];
                        data[i] = data[i + 1];
                        data[i + 1] = data[i + 2];
                        data[i + 2] = temp;
                        if (data[i] < data[i + 1] && data[i + 1] < data[i + 2]) {
                            break;
                        }
                    }
                    sorted = false;
                }
            }
            if (sorted) {
                return true;
            }
            count++;
        }

        return false;

    }
}
