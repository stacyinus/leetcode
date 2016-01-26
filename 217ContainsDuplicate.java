/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/

public class 217ContainsDuplicate {
	//T = o(n), S= O(n) 
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length==0)
            return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(set.contains(nums[i]))
        		return true;
        	set.add(nums[i]);
        }
        return false;
    }
}