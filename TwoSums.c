#include <stdio.h>
#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target) {
	int* answers = malloc(sizeof(int) * 2);
	answers[0] = answers[1] = -1;
	
	for (int i = 0, j = i + 1; i < numsSize - 1; i++) {
		int sum = nums[i] + nums[j];

		if (sum == target) {
			answers[0] = i;
			answers[1] = j;
			break;
		} else {
			j++;
		}
	}

	return answers;
}

int main(void) {
	int nums[]   = {3,2,3};
	int target   = 6;
	int numsSize = sizeof nums / sizeof *nums;
	int* sums    = twoSum(nums, numsSize, target);
	if (sums[0] == -1 && sums[1] == -1) {
		printf("not found!\n");
	} else {
		printf("found @ %d, %d = %d\n", sums[0], sums[1], target);
	}
	return 0;
}
