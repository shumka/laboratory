import java.util.*;

public class Level1 {
    public static String [] ShopOLAP(int N, String [] items) {
        HashMap<String, Integer> salesArray = new HashMap<>(N);

        for (String item : items) {
            String[] parts = item.split(" ");
            String name = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            if (salesArray.containsKey(name)) {
                int currentQuantity = salesArray.get(name);
                salesArray.put(name, currentQuantity + quantity);
            } else {
                salesArray.put(name, quantity);
            }

        }
        List<String> result = new ArrayList<>();
        salesArray.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> result.add(entry.getKey() + " " + entry.getValue()));

        return result.toArray(new String[0]);

    }
}
