package hashmapLeetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;

public class TopKFreq {
	    public void topKFrequent() {
	    	
	    	int[] nums = {5,5,5,6,6,7};
	    	int k =2;
	    	Map<Integer, Integer> map = new HashMap<>();
	        

	        for(int i=0;i<nums.length; i++){
	            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
	        }
	        System.out.println(map);
	        List<Integer> counts = new ArrayList<>(map.keySet());
	        counts.sort((a,b)-> map.get(b)-map.get(a));
	        System.out.println(counts.subList(0, k));
	        
	        int[] arr = counts.stream().mapToInt(i->i).toArray();
	        
	        
	        
	    }
}
