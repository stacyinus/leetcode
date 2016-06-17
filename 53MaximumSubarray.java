/*
53. Maximum Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int i = 0, sum = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        while(i < nums.length){
            if(sum < 0)
                sum = Math.max(sum, nums[i]);
            else
                sum += nums[i];
            max = Math.max(sum,max);
            i++;
        }
        return max;
    }
    //DP Solution
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int sum = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            sum = sum+nums[i]>nums[i]?sum+nums[i]:nums[i];
            max = sum>max?sum:max;
        }
        return max;
    }

}