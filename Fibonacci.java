import java.util.HashMap;

// https://en.wikipedia.org/wiki/Fibonacci_number

public class Fibonacci {

    public static int memoizedFibonacci(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(
                n,
                memoizedFibonacci(n - 1, map) + memoizedFibonacci(n - 2, map)
            );
            return map.get(n);
        }
    }

    public static void iterativeFibonacci(int limit) {
        int sequence[] = { 0, 1 };
        int counter = 0;

        System.out.print("Iterative Fibonacci: ");
        while (counter < limit) {
            // To print in sequence, print the previous digits first.
            System.out.print(sequence[0] + (counter + 1 < limit ? ", " : "\n"));

            int num = sequence[0] + sequence[1];
            sequence[0] = sequence[1];
            sequence[1] = num;
            counter++;
        }
    }

    public static int recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (recursiveFibonacci(n - 2) + recursiveFibonacci(n - 1));
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        iterativeFibonacci(10);

        for (int i = 0; i < 10; i++) {
            System.out.print(recursiveFibonacci(i) + (i < 10 ? ", " : "\n"));
            System.out.print(
                memoizedFibonacci(i, map) + (i < 10 ? ", " : "\n")
            );
        }
    }
}
