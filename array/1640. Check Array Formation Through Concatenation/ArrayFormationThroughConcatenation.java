import java.util.HashMap;
import java.util.Map;

public class ArrayFormationThroughConcatenation {

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> mapped = new HashMap<>();

        // Storing the positions of all the elements.
        for (int i = 0; i < arr.length; i++) {
            mapped.put(arr[i], i);
        }

        for (int piece[] : pieces) {
            if (mapped.containsKey(piece[0])) {
                for (int i = 1; i < piece.length; i++) {
                    if (!mapped.containsKey(piece[i])) {
                        return false;
                    } else {
                        if (mapped.get(piece[i]) - mapped.get(piece[i - 1]) != 1) {
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}