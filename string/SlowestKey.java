package string;

// https://leetcode.com/problems/slowest-key/

public class SlowestKey {

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int longestDuration = releaseTimes[0];
        char key = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int difference = Math.abs(releaseTimes[i] - releaseTimes[i - 1]);

            if (
                longestDuration < difference ||
                (longestDuration == difference && key < keysPressed.charAt(i))
            ) {
                longestDuration = difference;
                key = keysPressed.charAt(i);
            }
        }
        return key;
    }

    public static void main(String[] args) {
        int durations[][] = {
            { 9, 29, 49, 50 },
            { 12, 23, 36, 46, 62 },
            { 23, 34, 43, 59, 62, 80, 83, 92, 97 },
        };
        String testStrings[] = { "cbcd", "spuda", "qgkzzihfc" };

        for (int i = 0; i < durations.length; i++) {
            System.out.println(
                String.format(
                    "Slowest key was => %c.",
                    slowestKey(durations[i], testStrings[i])
                )
            );
        }
    }
}
