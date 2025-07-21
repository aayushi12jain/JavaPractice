package SolutionsArrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    //https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if (nums.length == 0)
            return result;
        if (nums.length == 1) 
            result.add(Integer.toString(nums[0]));

        int left = nums[0];
        int right = nums[0];
        for(int n = 0; n<nums.length; n++){
            if(nums[n] != ++right){
                if(nums[n] == left){
                    result.add(Integer.toString(left));
                }else{
                    result.add(Integer.toString(left)+"->"+Integer.toString(right-1));
                }
                left = nums[n];
                right = nums[n];
            }
        }
        if(nums[nums.length-1] == left){
            result.add(Integer.toString(left));
        }else{
            result.add(Integer.toString(left)+"->"+Integer.toString(right-1));
        }
        return result;
    }
}
