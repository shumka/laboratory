public class Level1 {
    public static int Unmanned(int L, int N, int[][] track) {
        int time = 0;
        int position = 0;

        for (int i = 0; i < N; i++) {
            int arrivalTime = track[i][0];
            int redTime = track[i][1];
            int greenTime = track[i][2];

            if (arrivalTime > L) {
                break;
            }

            int distance = arrivalTime - position;

            time += distance;

            if (time % (redTime + greenTime) < redTime) {
                time += redTime - (time % (redTime + greenTime));
            }

            position = arrivalTime;
        }

        time += L - position;

        return Math.round(time);
    }
}
