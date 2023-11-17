public static boolean EEC_help(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for (int num : arr1) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }

        System.out.println(freq1);
        System.out.println(freq2);

        for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (!freq2.containsKey(key) || freq2.get(key) != value) {
                return false;
            }
        }

        return true;
    }
