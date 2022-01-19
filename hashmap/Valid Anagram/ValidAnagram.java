import java.util.*;

class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> mapped = new HashMap<>();

        // Mapping the characters into the Hash Map.
        for (char c : s.toCharArray()) {
            if (mapped.containsKey(c)) {
                mapped.put(c, mapped.get(c) + 1);
            } else {
                mapped.put(c, 1);
            }
        }
        // Calculate & map the characters from string t into the existing map.
        for (char c : t.toCharArray()) {
            if (mapped.containsKey(c)) {
                mapped.put(c, mapped.get(c) - 1);
            } else {
                mapped.put(c, 1);
            }
        }

        // The mapping part can definitely be optimized further by using 2 hash maps but
        // at the cost of increased space.

        for (char c : mapped.keySet()) {
            if (mapped.get(c) != 0) {
                return false;
            }
        }

        // ~ O(n) but average. because of 3 * O(1) + O(n) for .toCharArray()
        return true;
    }

    public static boolean isAnagramSorted(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // ~ 2 * O(nlog(n)) + 2 * O(n) + O(n) for .equals()
        return String.valueOf(sArray).equals(String.valueOf(tArray));
    }

    public static void main(String[] args) {
        String[] testCases = {
                "anagram:nagaram",
                "rat:cat",
                "tat:att"
        };

        for (String s : testCases) {
            System.out
                    .println(String.format("[isAnagram] %s & %s is an anagram? => %s", s.split(":")[0], s.split(":")[1],
                            isAnagram(s.split(":")[0], s.split(":")[1])));
            System.out
                    .println(String.format("[isAnagramSorted] %s & %s is an anagram? => %s", s.split(":")[0],
                            s.split(":")[1],
                            isAnagramSorted(s.split(":")[0], s.split(":")[1])));
        }
    }
}