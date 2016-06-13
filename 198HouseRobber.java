/*
198. House Robber

You are a professional robber planning to rob houses along a street. 

Each house has a certain amount of money stashed, 

the only constraint stopping you from robbing each of them is that adjacent houses have 

security system connected and it will automatically contact the police if two adjacent houses 

were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 

determine the maximum amount of money you can rob tonight without alerting the police.
*/
/*
    DP problem. 
    DP 数组 tmp[i] 表示，at house i, the max value robbed(it could include i or not) 
    so tmp[i] = Max(tmp[i-1], tmp[i-2] + nums[i])
    Time Complexity O(n)
    Space Complexity O(n), can optmize to O(1) use %2 method
*/

public class 198HouseRobber {
    //DP
    public int rob(int[] nums) {
        if( nums == null || nums.length == 0 )
            return 0;
        if( nums.length == 1 )
            return nums[0];
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        tmp[1] = Math.max(tmp[0], tmp[1]);
        for( int i = 2; i < nums.length; i++ )
            tmp[i] = Math.max(tmp[i-1], tmp[i-2] + nums[i]);
        return tmp[nums.length - 1];
    }
}