public static int[] TRC_sort(int[] trc) {
        if (trc.length <= 1) {
            return trc;
        }

        int pivot = trc[0];
        int lowerCount = 0;
        int equalCount = 0;
        int higherCount = 0;

        for (int i : trc) {
            if (i < pivot) {
                lowerCount++;
            } else if (i == pivot) {
                equalCount++;
            } else {
                higherCount++;
            }
        }

        int[] lower = new int[lowerCount];
        int[] equal = new int[equalCount];
        int[] higher = new int[higherCount];

        int i = 0;
        int j = 0;
        int k = 0;

        for (int value : trc) {
            if (value < pivot) {
                lower[i++] = value;
            } else if (value == pivot) {
                equal[j++] = value;
            } else {
                higher[k++] = value;
            }
        }

        lower = TRC_sort(lower); 
        higher = TRC_sort(higher); 

        int[] sorted = new int[trc.length];
        System.arraycopy(lower, 0, sorted, 0, lower.length);
        System.arraycopy(equal, 0, sorted, lower.length, equal.length);
        System.arraycopy(higher, 0, sorted, lower.length + equal.length, higher.length);

        return sorted;
    }
