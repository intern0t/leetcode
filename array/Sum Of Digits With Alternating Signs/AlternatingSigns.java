import java.util.Arrays;
import java.util.Stack;

public class AlternatingSigns {
    static int sumOfAlternatingSigns(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                stack.push(-1 * array[i]);
            } else {
                stack.push(array[i]);
            }
        }

        int totalSum = 0;
        while (!stack.empty()) {
            totalSum += stack.pop();
        }

        return totalSum;
    }

    static int sumOfAlternatingSigns(int num) {
        Stack<Integer> stack = new Stack<>();

        boolean isPositive = true;
        while (num != 0) {
            stack.push(isPositive ? num % 10 : -1 * (num % 10));
            isPositive = !isPositive;
            num /= 10;
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        // int[][] testCases = {
        // new int[] { 4, 1, 3, 5 }
        // };

        int[] _testCases = {
                53178,
                1234567,
                182
        };

        // for (int[] tCase : testCases) {
        // System.out.println(String.format("Alternating sum of %s is %d.",
        // Arrays.toString(tCase),
        // sumOfAlternatingSigns(tCase)));
        // }

        for (int _tCase : _testCases) {
            System.out.println(String.format("Alternating sum of %d is %d.", _tCase,
                    sumOfAlternatingSigns(_tCase)));
        }
    }
}
