/*
45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

Subscribe to see which companies asked this question
*/
/*
    Greedy is the best solution here:
    2 indices, start and end, both start from 0;
    from start to end, find the farthest index you can reach, this will be the new end, and new start will be end + 1;
    

*/
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0, s = 0, e = 0;
        while (s <= e && e < nums.length - 1) {
            count++;
            int farthest = e; 
            for (int i = s; i <= e; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            s = e + 1;
            e = farthest;
        }
        return count;
    }
}

public class Solution {
	//DP: this is not the fastest approach
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i -- ){
            dp[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j <= nums[i] + i && j < nums.length; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[0];
    }
}