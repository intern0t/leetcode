// https://leetcode.com/problems/longest-common-prefix/

import java.util.Arrays;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String tests[][] = {
      { "flower", "flow", "flight" },
      { "dog", "racecar", "car" },
      { "abab", "aba", "abc" },
    };

    for (int i = 0; i < tests.length; i++) {
      for (int j = 0; j < tests[i].length; j++) {
        System.out.print(tests[i][j] + (j == tests[i].length - 1 ? "" : ", "));
      }
      System.out.println(" => " + longestCommonPrefix(tests[i]));
    }
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0 || strs == null) {
      return "";
    }

    // Sort by length, **lexicographical sort is necessary + important!
    Arrays.sort(strs);

    // Track the index of a smallest string.
    int index = 0;

    // Compare the characters at the same string with the last string.
    while (index < strs[0].length()) {
      if (strs[0].charAt(index) == strs[strs.length - 1].charAt(index)) {
        index++;
      } else {
        break;
      }
    }

    // If index did not move ( = 0), return empty else return the substring upto index - 1.
    return index == 0 ? "" : strs[0].substring(0, index);
  }
}
