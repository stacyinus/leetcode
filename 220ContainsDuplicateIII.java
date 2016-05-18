/*
220. Contains Duplicate III  

Given an array of integers, find out whether there are two distinct indices i and j in the array 

such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/

public class Solution {
	//|nums[j] - nums[i]| <= t    ====>     - t <= nums[j] - nums[i] <= t      ====> 	nums[i] - t <=	nums[j] <= t + nums[i]
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(nums == null || nums.length == 0)
    			return false;
    	TreeSet<Integer> set = new TreeSet<Integer>();
    	for(int i = 0; i < nums.length; i++){
    		/*
    			you can use floor instead of ceiling, however, when using floor, 
    			it has to be set.floor(nums[i] + t), and nums[i] + t could overflow,
    			so you need to conver to long... to save the problem, avoid having
    			nums[i] + t in your code.
    		*/
    		Integer ceiling = set.ceiling(nums[i] - t);//smallest num that is greater than nums[i]
    		if( ceiling != null && ceiling - t <= nums[i])
    			return true;
    		set.add(nums[i]);
    		if(i >= k)
    			set.remove(nums[i-k]);
    	}	
    	return false;        
    }
}	
