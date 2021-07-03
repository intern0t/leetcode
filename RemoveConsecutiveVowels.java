import java.util.ArrayList;

class RemoveConsecutiveVowels {

  public static void main(String[] args) {
    //   Source: https://www.thewordfinder.com/3-vowels-together.php
    String tests[] = {
      "ACQUAINTANCE ACQUAINTANCES ADIEU ADIEUS ADIEUX AEON AEONIC AEONS",
      "ZOEA ZOEAE ZOEAL ZOEAS ZOOID ZOOIDS ZOUAVE",
    };

    for (String s : tests) {
      System.out.println(s + " => " + removeConsecutiveVowels(s));
    }
  }

  static String removeConsecutiveVowels(String str) {
    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < str.length(); i++) {
      if (i == 0) {
        list.add(str.charAt(i) + "");
      }

      //   Add only the ones that are not consecutive vowels. Ignore the 1st one, add the last one.
      if (i != 0 && (!isVowel(str.charAt(i - 1)) || !isVowel(str.charAt(i)))) {
        list.add(str.charAt(i) + "");
      }
    }
    return String.join("", list);
  }

  static boolean isVowel(char c) {
    if (
      c == 'a' ||
      c == 'e' ||
      c == 'i' ||
      c == 'o' ||
      c == 'u' ||
      c == 'A' ||
      c == 'E' ||
      c == 'I' ||
      c == 'O' ||
      c == 'U'
    ) {
      return true;
    }
    return false;
  }
}
