import java.util.*;

public class CheckPairSumExists {

    public static void main(String[] args) {
        int[][] test = { { 0, 1 }, { 2, 3 }, { 4, 5 }, { 6, 7 } };

        System.out.println(checkPairSumExists(4, 2, test, 100) + ".");
    }

    static boolean checkPairSumExists(
        int rows,
        int cols,
        int[][] arr,
        int sum
    ) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (set.contains(sum - arr[i][j])) {
                    return true;
                } else {
                    set.add(arr[i][j]);
                }
            }
        }
        return false;
    }
}
