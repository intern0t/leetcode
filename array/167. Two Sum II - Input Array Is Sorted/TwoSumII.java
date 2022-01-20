import java.util.Arrays;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        // Sliding window method.
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] { left + 1, right + 1 };
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int testCases[][] = new int[3][];
        testCases[0] = new int[] { 2, 7, 11, 15 };
        testCases[1] = new int[] { 2, 3, 4 };
        testCases[2] = new int[] { -1, 0 };

        int target[] = { 9, 6, -1 };

        int answers[][] = new int[3][];
        answers[0] = new int[] { 1, 2 };
        answers[1] = new int[] { 1, 3 };
        answers[2] = new int[] { 1, 2 };

        for (int i = 0; i < testCases.length; i++) {
            System.out
                    .println(String.format("Array: %s, Target: %d, Two Sum Indexes (non-zero): %s, Correct Answer: %s",
                            Arrays.toString(testCases[i]), target[i], Arrays.toString(twoSum(testCases[i], target[i])),
                            Arrays.toString(answers[i])));
        }
    }
}
