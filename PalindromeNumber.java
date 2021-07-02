class PalindromeNumber {

  public static void main(String[] args) {
    int testCases[] = { 121, -121, 10, -101, 0 };

    for (int i = 0; i < testCases.length; i++) {
      System.out.println(
        testCases[i] +
        " is palindrome? : " +
        (isPalindrome(testCases[i]) ? "true" : "false")
      );
    }
  }

  public static boolean isPalindrome(int x) {
    // Valid integers would not allow anything in format of -123-
    // Therefore, if anything is negative, it's not a plaindrome.
    if (x < 0 || (x != 0 && x % 10 == 0)) return false;
    int half_of_x = 0;

    while (half_of_x < x) {
      half_of_x = half_of_x * 10 + x % 10;
      x /= 10;
    }

    return (x == half_of_x || half_of_x / 10 == x);
  }
}
