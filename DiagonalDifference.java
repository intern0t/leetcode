import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        Integer test[][] = { { 11, 2, 4 }, { 4, 5, 6 }, { 10, 8, -12 } };
        List<List<Integer>> testList = new ArrayList<>();

        for (Integer[] i : test) {
            testList.add(List.of(i));
        }
        System.out.println(
            "Diagonal difference = " + diagonalDifference(testList)
        );
    }

    public static int diagonalDifference(List<List<Integer>> array) {
        int dimension = array.size();
        int sums[] = { 0, 0 };

        int row = dimension - 1; // 2

        // O(n)
        for (int i = 0; i < dimension; i++) {
            // O(n)
            for (int j = 0; j < dimension; j++) {
                if (i == j) {
                    // For right diagonal \
                    sums[0] += array.get(i).get(j);
                }
                if (j == row) {
                    // For left diagonal / (Inefficient, needs further optimization)
                    sums[1] += array.get(i).get(row);
                }
            }
            row--;
        }

        return Math.abs(sums[0] - sums[1]);
    }
}
