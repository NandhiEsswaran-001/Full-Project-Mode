import java.util.*;

class DistanceVectorRouting {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> dist = new HashMap<>();
        
        // Initialize the distance vectors
        dist.put("A", Map.of("A", 0, "B", 1, "C", Integer.MAX_VALUE, "D", Integer.MAX_VALUE));
        dist.put("B", Map.of("A", 1, "B", 0, "C", 1, "D", Integer.MAX_VALUE));
        dist.put("C", Map.of("A", Integer.MAX_VALUE, "B", 1, "C", 0, "D", 1));
        dist.put("D", Map.of("A", Integer.MAX_VALUE, "B", Integer.MAX_VALUE, "C", 1, "D", 0));

        // Distance vector algorithm iteration (1 step)
        for (String node : dist.keySet()) {
            for (String dest : dist.get(node).keySet()) {
                int minDist = dist.get(node).get(dest);
                for (String neighbor : dist.keySet()) {
                    if (!neighbor.equals(node)) {
                        int newDist = dist.get(node).get(neighbor) + dist.get(neighbor).get(dest);
                        if (newDist < minDist) minDist = newDist;
                    }
                }
                dist.get(node).put(dest, minDist);  // Update distance
            }
        }

        // Print the updated distance vectors
        dist.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
}
