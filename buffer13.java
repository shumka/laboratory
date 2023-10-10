public class Level1 {
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        char[][] map1 = convertToMatrix(H1, W1, S1);
        char[][] map2 = convertToMatrix(H2, W2, S2);

        for (int i = 0; i <= H1 - H2; i++) {
            for (int j = 0; j <= W1 - W2; j++) {
                boolean match = true;

                for (int k = 0; k < H2; k++) {
                    for (int l = 0; l < W2; l++) {
                        if (map1[i + k][j + l] != map2[k][l]) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) {
                        break;
                    }
                }

                if (match) {
                    return true;
                }
            }
        }

        return false;
    }

    private static char[][] convertToMatrix(int rows, int cols, String str) {
        char[][] matrix = new char[rows][cols];
        String[] rowsArray = str.split(" ");

        for (int i = 0; i < rows; i++) {
            matrix[i] = rowsArray[i].toCharArray();
        }

        return matrix;
    }
}
