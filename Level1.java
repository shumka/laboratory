public class Level1 {
    public static String [] TreeOfLife(int H, int W, int N, String [] tree)  {
        Integer[][] grid = new Integer[H][W];
        boolean isEvenYear = true;

        // Первичное состояние дерева
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (tree[i].charAt(j) == '+') {
                    grid[i][j] = 1;
                }
                if (tree[i].charAt(j) == '.') {
                    grid[i][j] = 0;
                }
            }
        }

        for (int year = 0; year < N; year++) {

            if (isEvenYear) {
                // Четный год, просто инкремент
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        grid[i][j]++;
                    }
                }
            }

            if (!isEvenYear){
                // Нечетный год
                boolean[][] tempGrid = new boolean[H][W];

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        grid[i][j]++;
                    }
                }

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (grid[i][j] >= 3) {
                            tempGrid[i][j] = true;
                            // Ячейка выше
                            if (i > 0) {
                                tempGrid[i-1][j] = true;
                            }
                            // Ячейка снизу
                            if (i < H-1) {
                                tempGrid[i+1][j] = true;
                            }
                            // Ячейка слева
                            if (j > 0) {
                                tempGrid[i][j-1] = true;
                            }
                            // Ячейа справа
                            if (j < W-1) {
                                tempGrid[i][j+1] = true;
                            }
                        }
                    }
                }

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (tempGrid[i][j]){
                            grid[i][j] = 0;
                        }
                    }
                }
            }

            // Меняем чет на нечет
            isEvenYear = !isEvenYear;

        }
        String[] result = new String[H];
        for (int i = 0; i < H; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < W; j++) {
                if (grid[i][j] > 0) {
                    sb.append('+');
                } else {
                    sb.append('.');
                }
            }
            result[i] = sb.toString();
        }

        return result;

    }
}

