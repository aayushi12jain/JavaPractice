package twoPointers;

public class SortArrayByParity {
	public void sortArrayByParity() {
		int[] nums = {2,3,4,6,20};
		int i = 0;
		int j = nums.length - 1;
		while (i < nums.length && j >= 0 && i < j) {
			if (nums[i] % 2 == 0) {
				i++;
			} else {
				if (nums[j] % 2 == 0) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
					j--;
					i++;
				} else {
					j--;
				}
			}
		}
		for (int n : nums) {
			System.out.println(n + "  ");
		}

	}

}
