// https://leetcode.com/problems/container-with-most-water/
// https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation

public class ContainerWithMostWater {

  public static void main(String[] args) {
    int testCases[][] = {
      { 1, 8, 6, 2, 5, 4, 8, 3, 7 },
      { 1, 1 },
      { 4, 3, 2, 1, 4 },
      { 1, 2, 1 },
    };

    for (int i = 0; i < testCases.length; i++) {
      for (int j = 0; j < testCases[i].length; j++) {
        System.out.print(
          testCases[i][j] + (j == testCases[i].length - 1 ? "" : ", ")
        );
      }
      System.out.println(" => MAX = " + maxArea(testCases[i]));
    }
  }

  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int volume = 0;

    // Left and right delimeters (pivots)
    while (left < right) {
      volume =
        Math.max(
          volume,
          (right - left) * Math.min(height[left], height[right])
        );
      if (height[left] < height[right]) left++; else right--;
    }

    return volume;
  }
}
