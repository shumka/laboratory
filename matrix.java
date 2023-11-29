public static int[] matrix(int n, int m, int[][] matrix) {
        int[] result = new int[n * m];
        int index = 0;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        while (index < n * m) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;

            if (index < n * m) {
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--;
            }

            if (index < n * m) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }
        }

        return result;
    }
