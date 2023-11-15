public static String digital_rain(String col) {
        int n = col.length();
        int[] count = new int[2];
        int maxLen = 0;
        String result = "";

        for (int i = n - 1; i >= 0; i--) {
            count[col.charAt(i) - '0']++;
            if (count[0] == count[1]) { 
                if (i + count[0] + count[1] > maxLen) {
                    maxLen = count[0] + count[1];
                    result = col.substring(i, i + count[0] + count[1]);
                }
            }
        }

        return result;
    }
