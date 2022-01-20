import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> list = new Stack<>();
        // REF: https://www.baeldung.com/java-initialize-hashmap#1mapof
        Map<Character, Character> pMap = Map.of(']', '[', ')', '(', '}', '{');

        for (char c : s.toCharArray()) {
            if (list.size() != 0 && list.peek() == pMap.get(c)) {
                list.pop();
            } else {
                list.add(c);
            }
        }

        return list.size() == 0;
    }

    public static void main(String[] args) {
        String testCases[] = new String[] {
                "()",
                "()[]{}",
                "(]",
                "[][{}]()",
                "[][{}]()]"
        };

        for (String testCase : testCases) {
            System.out.println(String.format("%s is valid? : %s", testCase, isValid(testCase)));
        }

        /*
         * Prints Out:
         * 
         * () is valid? : true
         * ()[]{} is valid? : true
         * (] is valid? : false
         * [][{}]() is valid? : true
         * [][{}]()] is valid? : false
         */
    }
}
