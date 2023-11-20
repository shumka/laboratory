public static int artificialMuscleFibers(int[] arr) {
        int[] count = new int[32000];
        int result = 0;

        for (int num : arr) {
            count[num - 1]++;
        }

        for (int c : count) {
            if (c > 1) {
                result++;
            }
        }

        return result;
}
