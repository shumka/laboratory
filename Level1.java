public class Level1 {
    public static int SumOfThe(int N, int[] data) {
        for (int i = 0; i < data.length; i++) {
            int currentNumber = data[i];
            int sum = 0;
            for (int j = 0; j < data.length; j++) {
                if (i != j) {
                    sum += data[j];
                }
            }
            if (currentNumber == sum) {
                return currentNumber;
            }
        }
        return -1;
    }

}
