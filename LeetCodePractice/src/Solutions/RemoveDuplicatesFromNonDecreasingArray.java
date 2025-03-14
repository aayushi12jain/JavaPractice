package Solutions;

import java.util.Arrays;

public class RemoveDuplicatesFromNonDecreasingArray {
	public void removeDuplicates(int[] nums) {
		System.out.println(Arrays.toString(nums));
		System.out.println();
		int i =1;
		int cur = 1;
		int dup = nums[0];

		while(i<nums.length) {
			if(nums[i] != dup) {
				nums[cur] = nums[i];
				dup = nums[i];
				cur++;
				System.out.println("else : " + cur + "  :  " + dup);
			}
			
			i++;
			System.out.println(Arrays.toString(nums));
		}
		System.out.println(cur);
		System.out.println(Arrays.toString(nums));
	}
}
