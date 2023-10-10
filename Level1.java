import java.util.Arrays;

public class Level1 {
    public static int MaximumDiscount(int N, int[] price) {
        Arrays.sort(price);
        int discount = 0;

        for (int i = N - 3; i >= 0; i -= 3) {
            discount += price[i];
        }

        return discount;
    }
}
