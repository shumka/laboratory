public class Level1 {
    public static boolean Football(int[] F, int N) {

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                swapElements(F, i, j);
                if (isSorted(F, N)) {
                    return true;
                }
                swapElements(F, i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                reverseSubarray(F, i, j);
                if (isSorted(F, N)) {
                    return true;
                }
                reverseSubarray(F, i, j);
            }
        }
        return false;
    }
    public static boolean isSorted(int[] F, int N) {
        for (int i = 1; i < N; i++) {
            if (F[i] < F[i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void swapElements(int[] F, int i, int j) {
        int temp = F[i];
        F[i] = F[j];
        F[j] = temp;
    }

    public static void reverseSubarray(int[] F, int i, int j) {
        while (i < j) {
            swapElements(F, i, j);
            i++;
            j--;
        }
    }
}
