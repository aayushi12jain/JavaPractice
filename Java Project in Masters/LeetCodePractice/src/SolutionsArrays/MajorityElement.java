package SolutionsArrays;

import java.util.Arrays;

public class MajorityElement {
	
	public void majority(int[] nums) {
		Arrays.sort(nums);
		
	}
	public void majority_notBest(int[] nums) {
		int majLen = Math.ceilDivExact(nums.length,2);
		Arrays.sort(nums);
		int temp = nums[0],c=0;
		for(int i : nums) {

			if(i==temp) {
				c++;
				System.out.println("c : " +c + "   i : " + i);
			}else {
				c=1;
				temp = i;
			}
			if(c>=majLen) {
				System.out.println("Result : "+ i);
				break;
			}

		}
	}

	public void majority_timeLimitExceeded(int[] nums) {
		int majLen = Math.ceilDivExact(nums.length,2);
		System.out.println("majLen : " + majLen);
		bubbleSort(nums);
		int temp = nums[0],c=0;
		for(int i : nums) {
			if(i==temp) {
				c++;
				System.out.println("c : " +c + "   i : " + i);
			}else {
				c=1;
				temp = i;
			}
			if(c>=majLen) {
				System.out.println("Result : "+ i);
				break;
			}

		}

	}

	private void bubbleSort(int[] nums) {
		for(int j=nums.length-1; j>=0; j--) {
			for(int i=0; i<j; i++) {
				if(nums[i]>nums[j]) {
					int temp = nums[j];
					nums[j]=nums[i];
					nums[i] = temp;
				}
			}
		}
		System.out.println("Sorted Array : " + Arrays.toString(nums));

	}
}
