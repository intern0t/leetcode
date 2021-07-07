import java.util.ArrayList;
import java.util.List;

public class HourglassSum {

    public static int calculateHourGlassSum(int matrix[][]) {
        if (matrix.length != matrix[0].length) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                if (row + 1 < matrix.length && col + 1 < matrix[0].length) {
                    /**
                            0 1 2
                          0 x x x
                          1   x
                          2 x x x
                     */
                    int sum =
                        matrix[row][col] +
                        matrix[row - 1][col - 1] +
                        matrix[row - 1][col] +
                        matrix[row - 1][col + 1] +
                        matrix[row + 1][col - 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                    max = Math.max(sum, max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int matrix1[][] = {
            { -9, -9, -9, 1, 1, 1 },
            { 0, -9, 0, 4, 3, 2 },
            { -9, -9, -9, 1, 2, 3 },
            { 0, 0, 8, 6, 6, 0 },
            { 0, 0, 0, -2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 },
        };
        int matrix2[][] = {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 9, 2, -4, -4, 0 },
            { 0, 0, 0, -2, 0, 0 },
            { 0, 0, -1, -2, -4, 0 },
        };
        int matrix3[][] = {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 },
        };

        System.out.println(
            "Max Hourglass sum => " + calculateHourGlassSum(matrix3)
        );
    }
}
