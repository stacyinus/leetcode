/*
213. House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 

This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 

Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
/*
    DP: Divide into two situations, one is to not rob the last house for sure, 
        the other one is to not rob the first house for sure.
    Time Complexity O(n)
    Space Complexity O(n), can optmize to O(1) use %2 method
*/
public class Solution {
    public int rob(int[] nums) {
        // write your code here
        if( nums == null || nums.length == 0 )
            return 0;
        if( nums.length == 1 )
            return nums[0];
        if( nums.length == 2 )
            return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[nums.length - 1];//when not rob the last house 
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        int[] dp2 = new int[nums.length - 1];//when not rob the first house 
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for(int i = 2; i < nums.length - 1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i+1]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }
}