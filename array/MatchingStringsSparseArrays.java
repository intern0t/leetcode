package array;
import java.util.*;

public class MatchingStringsSparseArrays {

    public static List<Integer> matchingStrings(
        List<String> strings,
        List<String> queries
    ) {
        // HashMap initialization.
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.size(); i++) {
            map.put(queries.get(i), 0);
        }

        // Actual mapping & counting.
        for (int j = 0; j < strings.size(); j++) {
            if (map.containsKey(strings.get(j))) {
                map.put(strings.get(j), map.get(strings.get(j)) + 1);
            }
        }

        // Re-collect the data.
        Integer count[] = new Integer[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            count[i] = map.get(queries.get(i));
        }

        // Return the data.
        return (List<Integer>) Arrays.asList(count);
        // 3 * O(n) = ~O(n)
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");
        matchingStrings(strings, queries).forEach(item -> System.out.print(item + ","));
    }
}
