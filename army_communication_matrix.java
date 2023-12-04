public static String army_communication_matrix(int n, int [][] matrix){

        int maxSum = Integer.MIN_VALUE;
        int[][] maxSubArr = new int[0][0];
        int maxX = -1;
        int maxY = -1;
        int maxI = -1;
        int maxJ = -1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i == j && i == 1) continue;
                for (int k = 0; k <= n - i; k++) {
                    for (int l = 0; l <= n - j; l++) {
                        int[][] subArr = new int[i][j];
                        for (int m = k; m < k + i; m++) {
                            for (int z = l; z < l + j; z++) {
                                subArr[m - k][z - l] = matrix[m][z];
                            }
                        }
                        int subSum = getSum(subArr);
                        if (subSum > maxSum) {
                            maxSum = subSum;
                            maxSubArr = subArr;
                            maxX = l;
                            maxY = k;
                            maxI = l + j - 1;
                            maxJ = k + i - 1;
                        }
                    }
                }
            }
        }
        
        return maxX + " " + maxY + " " + maxSubArr.length;
    }

    public static int getSum(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }
