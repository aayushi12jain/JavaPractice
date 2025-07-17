package SolutionsArrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {
        public int minSubArrayLen(int target, int[] nums) {
    
        if(nums.length==1 && nums[0]>=target) return 1;
        
        int minLen = Integer.MAX_VALUE;
        int j = 1;
        int sum = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>=target) return 1;
            j=i+1;
            sum = nums[i];
            while(j<nums.length){
                sum+=nums[j];
                if(sum >= target){
                    System.out.println("sum = " + sum);
                    if((j-i+1)<minLen){
                        minLen = j-i+1;
                        System.out.println("minlen = " + minLen);
                    } 
                    break;
                }else{
                    j++;
                }
            }
        }
        if(minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }
}
