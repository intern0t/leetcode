package sort;

import java.util.Arrays;

// https://en.wikipedia.org/wiki/Merge_sort

public class MergeSort {

    public static void main(String[] args) {
        int testArray[] = { 5, 3, 5, 7, 1, 3, 9 };
        System.out.print("Before Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
        mergeSort(testArray); // Sort
        System.out.print("\nAfter Sort: ");
        Arrays.stream(testArray).forEach(num -> System.out.print(num + ", "));
    }

    public static void mergeSort(int array[]) {
        
    }
}
