package array;

import java.util.*;

public class MedianofTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>(); // TreeMap retains the ordering.
        int sortedArray[] = new int[nums1.length + nums2.length];

        // Keys = values.
        for (int i : nums1) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        for (int i : nums2) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }

        // Initialize our merged + sorted array.
        int sortedArray_index = 0;
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            int count = mapEntry.getValue();
            if (count > 1) {
                // Increased complexity if repetitive integers are available.
                for (int i = 0; i < count; i++) {
                    sortedArray[sortedArray_index++] = mapEntry.getKey();
                }
            } else {
                sortedArray[sortedArray_index++] = mapEntry.getKey();
            }
        }

        // Calculate median & return
        int totalLength = nums1.length + nums2.length;
        double median = 0;

        if (totalLength % 2 != 0) {
            median = sortedArray[totalLength / 2];
        } else {
            median =
                sortedArray[totalLength / 2] +
                sortedArray[(totalLength / 2) - 1];
            median /= 2;
        }

        // System.out.println(Arrays.toString(sortedArray));
        return median;
    }

    public static void main(String[] args) {
        int testArray[][] = { { 2, 2, 4, 4 }, { 2, 2, 4, 4 } };

        System.out.println(
            String.format(
                "Median of 2 sorted arrays => %f.",
                findMedianSortedArrays(testArray[0], testArray[1])
            )
        );
    }
}
