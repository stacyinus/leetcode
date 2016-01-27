/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/
public class 325MaximumSubarraySum{
	public int maxSubArrayLen(int[] nums, int k) {	
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0,-1);
		int sum = 0;
		int maxL = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			sum += nums[i];
			if(!map.contains(sum))
				map.put(sum,i);
			if(map.contains(sum-k))
				maxL = Math.max(maxL,i-map.get(sum-k));
		}
		return maxL==Integer.MIN_VALUE?0:maxL;
	}
}