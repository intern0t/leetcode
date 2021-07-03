package sort;

import java.util.Arrays;

// https://en.wikipedia.org/wiki/Selection_sort

public class SelectionSort {

    public static void main(String[] args) {
        int testArray[] = { 5, 3, 5, 7, 1, 3, 9 };
        System.out.print("Before Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
        selectionSort(testArray); // Sort
        System.out.print("\nAfter Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
    }

    public static void selectionSort(int array[]) {
        /**
            Step 1 − Set MIN to location 0
            Step 2 − Search the minimum element in the list
            Step 3 − Swap with value at location MIN
            Step 4 − Increment MIN to point to next element
            Step 5 − Repeat until list is sorted
         */

        int length = array.length - 1;

        for (int i = 0; i < length; i++) {
            // Step 1 − Set MIN to location 0
            // Step 4 − Increment MIN to point to next element
            int minIndex = i;

            // Step 2 − Search the minimum element in the list
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Step 3 − Swap with value at location MIN
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
            // Step 5 − Repeat until list is sorted
        }
    }
}
