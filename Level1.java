import java.util.*;

public class Level1 {
    public static boolean TransformTransform(int A[], int N) {
        List<Integer> B = doubleTransform(A, N);
        int sum = 0;
        for (int num : B) {
            sum += num;
        }
        return sum % 2 == 0;
    }

    public static List<Integer> doubleTransform(int A[], int N) {

        List<Integer> B = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            temp.clear();
            for (int j = 0; j < N - 1 - i; j++) {
                int k = i + j;
                int max = 0;
                for (int l = j; l <= k; l++) {
                    if (A[l] > max) {
                        max = A[l];
                    }
                }
                temp.add(max);
            }
            B.addAll(temp);
        }
        return B;
    }

}

