// https://leetcode.com/problems/string-to-integer-atoi/

class StringToInteger {

  public static void main(String[] args) {
    String testCases[] = {
      "42",
      "   -42",
      "4193 with words",
      "words and 987",
      "-91283472332",
      "2147483648",
    };

    for (String s : testCases) {
      print(myAtoi(s) + "", true);
    }
  }

  static int myAtoi(String s) {
    int final_integer = 0;
    int boundaries[] = { (-2 << 30), (2 << 30) - 1 }; // -2^31, 2^31 - 1
    int index = 0;
    boolean negative = false;

    // If the string has no characters, simply return 0.
    if (s.length() < 1) return 0;

    // If the characters are whitespace, skip forward.
    if (s.charAt(index) == ' ') {
      // Order matters because we need to check if the index is out of bounds before we operate with it.
      while (index < s.length() && s.charAt(index) == ' ') {
        index++;
      }
    }

    // Recheck for no remaining or empty strings.
    if (index == s.length()) return 0;

    // If the characters after whitespace is -/+.
    if (s.charAt(index) == '-' || s.charAt(index) == '+') {
      negative = s.charAt(index) == '-' ? true : false;
      index++;
    }

    // Parse the digits and check for overflow.
    while (index < s.length()) {
      int digit = s.charAt(index) - '0';
      if (digit < 0 || digit > 9) {
        break;
      }

      //   Just before the overflow.
      if ((boundaries[1] - digit) / 10 < final_integer) {
        return (negative == true) ? boundaries[0] : boundaries[1];
      }
      final_integer = final_integer * 10 + digit;
      index++;
    }
    return negative ? final_integer * -1 : final_integer;
  }

  static void print(String s, boolean newline) {
    if (newline) {
      System.out.println(s);
    } else {
      System.out.print(s);
    }
  }
}
