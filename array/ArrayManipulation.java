package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/crush/problem

public class ArrayManipulation {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n => Number of elements in the resultant array.
     *  2. 2D_INTEGER_ARRAY queries
     */
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int resultantArray[][] = new int[queries.size() + 1][n + 1];
        long maximum = Long.MIN_VALUE;

        // Initialize the resultant array
        for (int array[] : resultantArray) {
            Arrays.fill(array, 0);
        }

        // Loop over 'em and initialize the values as per the query criteria.
        for (int i = 1; i < resultantArray.length; i++) {
            List<Integer> query = queries.get(i - 1);

            for (int j = 0; j < resultantArray[i].length; j++) {
                if (j >= query.get(0) && j <= query.get(1) && i > 0) {
                    resultantArray[i][j] =
                        resultantArray[i - 1][j] + query.get(2);
                } else {
                    if (i - 1 >= 0) {
                        resultantArray[i][j] = resultantArray[i - 1][j];
                    } else {
                        resultantArray[i][j] = 0;
                    }
                }
                maximum = Math.max(maximum, resultantArray[i][j]);
            }
        }

        printMatrix(resultantArray);
        return maximum;
    }

    public static void printMatrix(int resultantArray[][]) {
        for (int array[] : resultantArray) {
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int n = 10;
        List<List<Integer>> query = new ArrayList<>();
        query.add(Arrays.asList(1, 5, 3));
        query.add(Arrays.asList(4, 8, 7));
        query.add(Arrays.asList(6, 9, 1));

        System.out.println(
            String.format(
                "The maximum value in the resultant array: %d%n",
                arrayManipulation(n, query)
            )
        );
    }
}
