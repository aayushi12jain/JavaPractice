package Solutions;

import java.util.Arrays;

public class RemoveDuplicatesFromNonDecreasingArray2 {
	public void removeDuplicates2(int[] nums) {
		System.out.println(Arrays.toString(nums));
		System.out.println();
		
		int i =1;
		int count = 0;
		int cur = 1;
		int repeat = nums[0];

		while(i<nums.length) {
			if(nums[i] == repeat ) {
				count++;
				if(count==1) {
					//occurring more than twice
					nums[cur] = nums[i];
					cur++;
					
				}
			}else {
				nums[cur] = nums[i];
				repeat = nums[i];
				cur++;
				count=0;
				//System.out.println("else : " + cur + "  :  " + dup);
			}
			
			i++;
			//System.out.println(Arrays.toString(nums));
		}
		System.out.println(cur);
		System.out.println(Arrays.toString(nums));
        
	}
}
