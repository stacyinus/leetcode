/*
259. 3Sum Smaller
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
that satisfy the condition nums[i] + nums[j] + nums[k] < target.
For example, given nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?
*/

public class 259ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i = 0;i<nums.length-1;i++){
    		for(int j=i+1;j<nums.length;j++){
    			if(!map.contains(nums[i]+nums[j]))
    				map.put(nums[i]+nums[j],1);
    			else
    				map.put(nums[i]+nums[j],map.get(nums[i]+nums[j])+1);
    		}
    	}
    	for(int i=0;i<nums.length;i++){
    		if(target-)
    	}
    }
}