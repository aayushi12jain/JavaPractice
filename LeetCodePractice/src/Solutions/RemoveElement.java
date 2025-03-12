package Solutions;

import java.util.Arrays;

public class RemoveElement {
	public void removeElements(int[] nums,int val) {
		System.out.println("Original Array: " + Arrays.toString(nums));
		System.out.println("Value to be found : " + val);
		int j=-1;
		for(int i=nums.length-1; i>=0; i--){
			if(nums[i]!=val){
				if(j>i) {
					break;
				}
				while(j<=i){
					j++;
					if(nums[j]==val){
						nums[j] = nums[i];
						nums[i]=val;
						break;
					}
				}

			}

			for(int n:nums) {
				System.out.print(n + "  ");
			}
			System.out.println();
		}

		if(j==-1) {
			nums= new int[0];
		}else {
			nums=Arrays.copyOfRange(nums,0,j);
		}
		System.out.println("nums: " + Arrays.toString(nums));
		System.out.println("result : " + j);
	}
}
