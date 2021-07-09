import java.util.HashMap;

// https://en.wikipedia.org/wiki/Factorial

public class Factorial {

    public static int factorial(int n) {
        if (n <= 1) return (n == 1) ? 1 : 0;
        return n * factorial(n - 1);
    }

    public static int _factorial(int n, HashMap<Integer, Integer> map) {
        if (n <= 1) return 1;
        if (!map.containsKey(n - 1)) {
            map.put(n - 1, _factorial(n - 1, map));
        }
        return n * map.get(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(
                String.format("Factorial of %d is %d.", i, factorial(i))
            );
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 17; i++) {
            System.out.println(
                String.format("Factorial of %d is %d.", i, _factorial(i, map))
            );
        }
    }
}
