/*
219. Contains Duplicate II

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that 
nums[i] = nums[j] and the difference between i and j is at most k.
*/

public class 219ContainsDuplicate {
	//use hashmap
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(nums[i])&&Math.abs(map.get(nums[i])-i)<=k)
        		return true;
       		map.push(nums[i],i);
        }
        return false;
    }
    //use hashset
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(set.contains(nums[i]))
    			return true;
    		set.add(nums[i]);
    		if(i>k-1)
    			set.remove(nums[i-k]);
    	}
    	return false;
    }
}