public class Level1 {
    public static int SumOfThe(int N, int[] data) {
        int totalSum = 0;

        for (int i = 0; i < N; i++) {
            totalSum += data[i];
        }

        int currentSum = 0;
        for (int i = 0; i < N; i++) {
            currentSum += data[i];
            if (currentSum == totalSum) {
                return data[i];
            }
            totalSum -= data[i];
        }

        return -1;
    }

}
