public class Level1 {
    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {

        int[][] intMatrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                intMatrix[i][j] = Character.getNumericValue(Matrix[i].charAt(j));
            }
        }

        for(int i = 0; i < T; i++){

            int rw = 0, cl = 0;
            int n = N, m = M;
            int previous, current;

            while (rw < m && cl < n) {

                if (rw + 1 == m || cl + 1 == n)
                    break;

                previous = intMatrix[rw + 1][cl];

                for (int x = cl; x < n; x++) {
                    current = intMatrix[rw][x];
                    intMatrix[rw][x] = previous;
                    previous = current;
                }
                rw++;

                for (int x = rw; x < m; x++) {
                    current = intMatrix[x][n - 1];
                    intMatrix[x][n - 1] = previous;
                    previous = current;
                }
                n--;

                if (rw < m) {
                    for (int x = n - 1; x >= cl; x--) {
                        current = intMatrix[m - 1][x];
                        intMatrix[m - 1][x] = previous;
                        previous = current;
                    }
                }
                m--;

                if (cl < n) {
                    for (int x = m - 1; x >= rw; x--) {
                        current = intMatrix[x][cl];
                        intMatrix[x][cl] = previous;
                        previous = current;
                    }
                }
                cl++;
            }
        }
        for(int i = 0; i < M; i++){
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < N; j++){
                temp.append(intMatrix[i][j]);
            }
            Matrix[i] = temp.toString();
        }

    }
}
