public class Level1 {
    public static int[] UFO(int N, int[] data, Boolean octal) {
        int[] result = new int[N];
        if (octal) {
            for (int i = 0; i < N; i++) {
                result[i] = OctalToDecimal(data[i]);
            }
        } else {
            for (int i = 0; i < N; i++) {
                result[i] = HexToDecimal(data[i]);
            }
        }
        return result;
    }

    public static int OctalToDecimal(int octal) {
        int decimal = 0;
        int n = 0;
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, n);
                octal = octal / 10;
                n++;
            }
        }
        return decimal;
    }

    public static int HexToDecimal(int hex) {
        int decimal = 0;
        int power = 0;

        while (hex > 0) {
            int digit = hex % 10;
            decimal += digit * Math.pow(16, power);
            hex /= 10;
            power++;
        }

        return decimal;
    }
}
