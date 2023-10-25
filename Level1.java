import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Level1 {
    public static boolean TransformTransform(int[] A, int N) {
        List<Integer> B = IntStream.of(A)
                .boxed()
                .collect(Collectors.toList());
        B = S(B);
        B = S(B);
        int sum = 0;
        for (int num : B) {
            sum += num;
        }
        return sum % 2 == 0;
    }
    
    public static List<Integer> S(List<Integer> A) {
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < A.size() - i; j++) {
                int k = i + j;
                int max = 0;
                for (int l = j; l <= k; l++) {
                    if (A.get(l) > max) {
                        max = A.get(l);
                    }
                }
                temp.add(max);
            }
            B.addAll(temp);
        }
        return B;
    }
}

