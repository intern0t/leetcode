package sort;

import java.util.Arrays;

// https://en.wikipedia.org/wiki/Insertion_sort

public class InsertionSort {

    public static void main(String[] args) {
        int testArray[] = { 5, 3, 5, 7, 1, 3, 9 };
        System.out.print("Before Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
        insertionSort(testArray); // Sort
        System.out.print("\nAfter Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
    }

    public static void insertionSort(int array[]) {
        int length = array.length - 1;

        for (int i = 1; i < length; i++) {
            int currentValue = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > currentValue) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentValue;
        }
    }
}
