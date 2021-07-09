import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> kFrequent = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
            (a, b) ->
                a.getValue() == b.getValue()
                    ? a.getKey().compareTo(b.getKey())
                    : b.getValue() - a.getValue()
        );

        // There's no built-in heap in Java but PriorityQueue can be used to mimic heap.

        // O(n)
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        // O(logn)
        for (Map.Entry<String, Integer> key : map.entrySet()) {
            queue.offer(key);
        }

        // O(k) = ~O(n = k)
        while (!queue.isEmpty() && kFrequent.size() != k) {
            kFrequent.add(queue.poll().getKey());
        }

        return kFrequent;
    }

    public static void main(String[] args) {
        String testStrings[][] = {
            { "i", "love", "leetcode", "i", "love", "coding" },
            { "i", "love", "coding", "coding", "movies", "movies", "movies" },
        };

        System.out.println(topKFrequent(testStrings[0], 2)); // i, love
        System.out.println(topKFrequent(testStrings[1], 1)); // movies
    }
}
