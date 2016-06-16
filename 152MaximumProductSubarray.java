/*
152. Maximum Product Subarray 

Find the contiguous subarray within an array (containing at least one number) 
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

*/
/*
    DP. Keep 2 DP arrays, DP1 tracks the Maximum Product Subarray including nums[i],
         DP2 tracks the Minimum Product Subarray including nums[i],
    Time: O(n)
    Space:O(1)

*/
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = nums[0], min = nums[0], result = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = Math.max(Math.max(nums[i], max*nums[i]), nums[i]*min);
            min = Math.min(Math.min(nums[i], max*nums[i]), nums[i]*min);
            max = tmp;
            result = Math.max(result, max);
        }
        return result;
    }
}