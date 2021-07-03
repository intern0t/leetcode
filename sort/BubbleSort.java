package sort;

import java.util.Arrays;

// https://en.wikipedia.org/wiki/Bubble_sort

public class BubbleSort {

    public static void main(String[] args) {
        int testArray[] = { 5, 3, 5, 7, 1, 3, 9 };
        System.out.print("Before Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
        bubbleSort(testArray); // Sort
        System.out.print("\nAfter Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
    }

    public static void bubbleSort(int array[]) {
        int length = array.length - 1;
        boolean sorted = false;

        // O(n)
        while (!sorted) {
            sorted = true;

            // O(n)
            for (int i = 1; i < length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    sorted = false;
                }
            }
            // For optimization because the last element is already sorted.
            length--;
        }
        // O(n^2)
    }
}
