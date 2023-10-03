import static java.lang.Math.sqrt;

public class Level1 {
    public static String PatternUnlock(int N, int[] hits) {
        String result = "";
        double distance = 0;
        for (int i = 0; i < N - 1; i++) {

            if (hits[i] == 1) {
                switch (hits[i + 1]) {
                    case 2:
                    case 6:
                    case 9:
                        distance += 1;
                        break;
                    case 5:
                    case 8:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }
            } else if (hits[i] == 2) {
                switch (hits[i + 1]) {
                    case 1:
                    case 3:
                    case 5:
                    case 8:
                        distance += 1;
                        break;
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }
            } else if (hits[i] == 3) {
                switch (hits[i + 1]) {
                    case 2:
                    case 4:
                    case 7:
                        distance += 1;
                        break;
                    case 5:
                    case 8:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }

            } else if (hits[i] == 4) {
                switch (hits[i + 1]) {
                    case 3:
                    case 5:
                        distance += 1;
                        break;
                    case 2:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }

            } else if (hits[i] == 5) {
                switch (hits[i + 1]) {
                    case 2:
                    case 4:
                    case 6:
                        distance += 1;
                        break;
                    case 1:
                    case 3:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }

            } else if (hits[i] == 6) {
                switch (hits[i + 1]) {
                    case 1:
                    case 5:
                        distance += 1;
                        break;
                    case 2:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }

            } else if (hits[i] == 7) {
                switch (hits[i + 1]) {
                    case 3:
                    case 8:
                        distance += 1;
                        break;
                    case 2:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }

            } else if (hits[i] == 8) {
                switch (hits[i + 1]) {
                    case 2:
                    case 7:
                    case 9:
                        distance += 1;
                        break;
                    case 1:
                    case 3:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }

            } else if (hits[i] == 9) {
                switch (hits[i + 1]) {
                    case 1:
                    case 8:
                        distance += 1;
                        break;
                    case 2:
                        distance += sqrt(2);
                        break;
                    default:
                        break;
                }

            }

        }
        result = String.format("%.5f", distance);
        result = result.replaceAll("0", "");
        result = result.replaceAll(",", "");

        return result;
    }
}
