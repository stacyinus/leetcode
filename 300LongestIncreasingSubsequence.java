/*
300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, 
it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

public class Solution {
	//DP solution: T: O(n2)
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] maxs = new int[nums.length];
        maxs[nums.length-1] =1;
        int max = 1;
        for(int i=nums.length-2;i>=0;i--){
        	maxs[i] = 1;
        	for(int j=i+1;j<nums.length;j++){
        		if(nums[i]<nums[j])
        			maxs[i] = Math.max(maxs[i],1+maxs[j]);
        	}
        	max = Math.max(max,maxs[i]);
        }
        return max;
    }

    //DP Solution: T:O(nlogn)
    //http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
}