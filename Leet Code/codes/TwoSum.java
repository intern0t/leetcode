class TwoSum {
	static void Print(String toPrint){
		System.out.println(toPrint);
	}

	public static void main(String[] args){
		int target = 9;
		int nums[] = { 2, 7, 11, 15 };
		
		// O(n)
		for(int i = 0; i < nums.length; i++){
			// O(n)
			for(int j = (i + 1); j < nums.length; j++){
				// ~O(1)
				if(nums[j] + nums[i] == target){
					Print(String.format("[%d, %d] adds up to %d.", nums[i], nums[j], target));
				}
			}
		}

		// Total of O(n^2), not the most efficient.
	}
}
