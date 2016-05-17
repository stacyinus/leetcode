/*
213. House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 

This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 

Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if(nums.length == 3)
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        tmp[1] = nums[0];
        tmp[2] = nums[0] + nums[2];
        for(int i = 3; i< tmp.length - 1; i++)
            tmp[i] = ( tmp[i-2] + nums[i] >= tmp[i-1] )? tmp[i-2] + nums[i]:tmp[i-1];

        int[] tmp2 = new int[nums.length];
        tmp2[1] = nums[1];
        tmp2[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < tmp2.length; i++)
            tmp2[i] = ( tmp2[i-2] + nums[i] >= tmp2[i-1] )? tmp2[i-2] + nums[i]:tmp2[i-1];
        return Math.max(tmp[tmp.length - 2],tmp2[tmp2.length - 1] );
    }
}