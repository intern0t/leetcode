package string;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int trail = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                trail = Math.max(trail, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - trail + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String strings[] = { "abcabcbb", "bbbbb", "pwwkew", "" };
        for (String testString : strings) {
            System.out.println(
                String.format(
                    "Longest substring without repeating characters => %d in '%s'.",
                    lengthOfLongestSubstring(testString),
                    testString
                )
            );
        }
    }
}
