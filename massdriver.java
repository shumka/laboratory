public static int massdriver(int[] activate) {
        Map<Integer, Integer> counts = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < activate.length; i++) {
            int num = activate[i];
            if (counts.containsKey(num) && result > counts.get(num)) {
                result = counts.get(num);
            } else {
                counts.put(num, i);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
