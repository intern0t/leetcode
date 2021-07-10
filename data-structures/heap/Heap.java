import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {

    public static void maxHeap(Integer[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(Arrays.asList(array));

        System.out.print("Max Heap: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        System.out.println();
    }

    public static void minHeap(Integer[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(Arrays.asList(array));

        System.out.print("Min Heap: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer testCases[][] = { { 6, 7, 83, 5, 6, 8, 9, 11, 3 } };
        maxHeap(testCases[0]);
        minHeap(testCases[0]);
    }
}
